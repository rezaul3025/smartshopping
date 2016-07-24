/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.smart.shoping.persistence.services;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import org.smart.shoping.core.domain.Business;
import org.smart.shoping.core.domain.Category;
import org.smart.shoping.core.domain.Item;
import org.smart.shoping.core.domain.ItemCategory;
import org.smart.shoping.core.domain.ItemImageMeta;
import org.smart.shoping.persistence.repositories.BusinessRepository;
import org.smart.shoping.persistence.repositories.ItemCategoryRepository;
import org.smart.shoping.persistence.repositories.ItemImageMetaRepository;
import org.smart.shoping.persistence.repositories.ItemRepository;
import org.smart.shoping.web.domain.ItemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author rkarim
 */
@Service
@Transactional
public class ItemServiceHandler implements ItemService {

    private static final String IMAGE_MIME_TYPE_INDICATOR = "image";

    private static final String IMAGE_TYPE_ITEM = "ITEM";

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BusinessRepository businessRepo;

    @Autowired
    private ItemImageMetaRepository itemImageMetaRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Autowired
    private Environment env;

    @Override
    public Item addShopingItem(Item item, Long businessId) {

        Business business = businessRepo.findOne(businessId);
        item.setBusiness(business);
        item.setCreatedDate(new Date());

        return itemRepository.save(item);
    }

    @Override
    public void addItemImage(MultipartHttpServletRequest request, Long id) {
        Iterator<String> itr = request.getFileNames();
        //String rootPath = System.getProperty("catalina.home");
        String imageUploadPath = env.getProperty("business_image_path");
        Set<ItemImageMeta> itemImageMetaList = new HashSet<ItemImageMeta>();
        Item item = itemRepository.findOne(id);

        while (itr.hasNext()) {
            String uploadedFile = itr.next();
            MultipartFile file = request.getFile(uploadedFile);
            String mimeType = file.getContentType();
            String filename = file.getOriginalFilename();

            try {
                byte[] bytes = file.getBytes();

                File dir = new File(imageUploadPath + "/" + id + "/" + IMAGE_TYPE_ITEM);
                if (!dir.exists()) {
                    dir.mkdirs();
                }

                if (dir.exists()) {
                    UUID randomuuId = UUID.randomUUID();
                    String originalPath = dir.getAbsolutePath() + "/" + randomuuId + "_" + filename;
                    String webPath = "/static/" + id + "/" + IMAGE_TYPE_ITEM + "/" + randomuuId + "_" + filename;

                    // Create the file on server
                    File serverFile = new File(originalPath);

                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(bytes);
                    stream.close();

                    String savePath = serverFile.getPath();
                    Integer width = null;
                    Integer height = null;

                    if (mimeType.startsWith(IMAGE_MIME_TYPE_INDICATOR)) {
                        BufferedImage image = ImageIO.read(file.getInputStream());
                        width = image.getWidth();
                        height = image.getHeight();
                    }

                    ItemImageMeta imageMeta = new ItemImageMeta(null, item, webPath, originalPath, IMAGE_TYPE_ITEM, height, width, file.getSize(), mimeType, filename);

                    itemImageMetaRepository.save(imageMeta);
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //item.setItemImageMeta(itemImageMetaList);
        //itemRepository.save(item);
    }

    @Override
    public List<String> getItemCategory() {
        List<String> categoryList = new ArrayList<String>();

        for (ItemCategory category : itemCategoryRepository.findAll()) {
            categoryList.add(category.getName());
        }

        return categoryList;
    }

    /**
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<ItemInfo> getItemByCategory(int page, int pageSize) {

        List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();

        Pageable pageRequest = createPageRequest(page, pageSize);

        List<ItemCategory> categoryList = itemCategoryRepository.findAll();

        for (ItemCategory category : categoryList) {
            Page<Item> items = itemRepository.findByItemCategory(category, pageRequest);
            itemInfoList.add(new ItemInfo(category, items.getContent(), items.getTotalElements()));
        }

        return itemInfoList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Pageable createPageRequest(int page, int pageSize) {
        return new PageRequest(page, pageSize, Sort.Direction.ASC, "createdDate");
    }
}
