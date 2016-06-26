package org.smart.shoping.core.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ImageMeta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", length = Integer.MAX_VALUE, nullable = false)
    private Long id;

    /*@Column(name="owner_id", length=Integer.MAX_VALUE, nullable=false)
	private Long ownerId;*/

    @Column(name = "image_type", length = 10, nullable = false)
    private String imageType;

    @Column(name = "web_path", length = 255, nullable = false)
    private String webPath;

    @Column(name = "original_path", length = 255, nullable = true)
    private String originalPath;

    @Column(name = "height", length = 10, nullable = false)
    private Integer height;

    @Column(name = "width", length = 10, nullable = false)
    private Integer width;

    @Column(name = "format", length = 50, nullable = true)
    private String format;

    @Column(name = "size", length = 10, nullable = false)
    private Long size;

    @Column(name = "name", length = 126, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getWebPath() {
        return webPath;
    }

    public void setWebPath(String webPath) {
        this.webPath = webPath;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
