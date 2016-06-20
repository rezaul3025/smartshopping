package org.smart.shoping.persistence.services;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.smart.shoping.core.domain.Business;
import org.smart.shoping.core.domain.BusinessImageMeta;
import org.smart.shoping.persistence.repositories.BusinessImageMetaRepository;
import org.smart.shoping.persistence.repositories.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@Transactional
public class BusinessServiceHandlar implements BusinessService {

	private static final String IMAGE_MIME_TYPE_INDICATOR = "image";

	private static final String IMAGE_TYPE_COVER = "BANNER";

	private static final String IMAGE_TYPE_LOGO = "LOGO";

	@Autowired
	private BusinessRepository businessRepo;
	
	@Autowired
	private BusinessImageMetaRepository businessImageMetaRepo;
	
	@Autowired
	private Environment env;
	
	@Override
	public Business addBusiness(Business business) {
		
		return businessRepo.save(business);
		
	}
	

	@Override
	public void imageUpload(MultipartHttpServletRequest request, Long id) {
		Iterator<String> itr = request.getFileNames();
		//String rootPath = System.getProperty("catalina.home");
		String imageUploadPath = env.getProperty("business_image_path");
		
		
		while (itr.hasNext())
		{
			String uploadedFile = itr.next();
			MultipartFile file = request.getFile(uploadedFile);
			String mimeType = file.getContentType();
			String filename = file.getOriginalFilename();
			
			try
			{
				byte[] bytes = file.getBytes();

				File dir = new File(imageUploadPath+"/"+id);
				if (!dir.exists())
				{
					dir.mkdirs();
				}

				if (dir.exists())
				{
					UUID randomuuId = UUID.randomUUID();
					String originalPath = dir.getAbsolutePath() + "/" + randomuuId +"_"+ filename;
					String webPath = "/static/" + id+"/"+randomuuId +"_"+ filename;
					/*
					if(!servletContextPath.isEmpty())
					{
						if(servletContextPath.startsWith("/"))
						{
							webPath=servletContextPath+webPath;
						}
						else
						{
							webPath="/"+servletContextPath+webPath;
						}
					}*/
					
					// Create the file on server
					File serverFile = new File(originalPath);

					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					stream.write(bytes);
					stream.close();

					String savePath = serverFile.getPath();
					Integer width = null;
					Integer height = null;
					
					if(mimeType.startsWith(IMAGE_MIME_TYPE_INDICATOR))
					{
						BufferedImage image = ImageIO.read(file.getInputStream());
						width = image.getWidth();
						height = image.getHeight();
					}
					
					String imageType = IMAGE_TYPE_COVER;
					
					if(uploadedFile.contains("logo"))
					{
						imageType = IMAGE_TYPE_LOGO;
					}
					
					BusinessImageMeta imageMeta = new BusinessImageMeta(null, new Business(id), webPath, originalPath, "BUS",imageType, height, width, file.getSize(), mimeType, filename);
					//DocumentMetadata docMeta = new DocumentMetadata(null, docOwnerId, filename, mimeType,savePath,webPath,file.getSize(),width,height, getDocIcon(mimeType));
					
					businessImageMetaRepo.save(imageMeta);
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public List<BusinessImageMeta> getImageByBusiness(Long id) {
		return businessImageMetaRepo.findByBusiness(new Business(id));
	}
	
	@Override
	public Page<Business> getAll(Pageable pageArg)
	{
		return businessRepo.findAll(pageArg);
	}

}
