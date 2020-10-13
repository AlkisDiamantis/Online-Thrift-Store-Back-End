package com.project.thrifting.Dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class SaleDto {

    @NotNull(message = "You should choose a Condition")
    @Min(value = 1, message = "You should choose a Condition")
    private Integer condid;

    @NotNull(message = "You should choose a Gender")
    @Min(value = 1, message = "You should choose a Gender")
    private Integer genderid;

    @NotNull(message = "You should choose a Size")
    @Min(value = 1, message = "You should choose a Size")
    private Integer sizeid;

    @NotNull(message = "You should choose a Category")
    @Min(value = 1, message = "You should choose a Category")
    private Integer categoryid;

    @NotBlank(message = "You should Enter a Title")
    @Size(min = 2, max = 40, message = "Title should be between 2-40 letters")
    private String title;

    @NotNull(message = "You should Enter a Comment")
    @Size(min = 2, max = 100, message = "Title should be between 2-100 letters")
    private String comment;

    private String datestart;

    @NotNull(message = "You should Enter a Price")
    @Max(value = 99999999, message = "Price should be bellow 99999999")
    private Double price;

    private String photoname;

    private String phototype;

    private String photosize;
    @NotNull(message = "You should Enter a Photo")
    private String photoBase64;

    private Long userid;

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public String getPhototype() {
        return phototype;
    }

    public void setPhototype(String phototype) {
        this.phototype = phototype;
    }

    public String getPhotosize() {
        return photosize;
    }

    public void setPhotosize(String photosize) {
        this.photosize = photosize;
    }

    public String getPhotoBase64() {
        return photoBase64;
    }

    public void setPhotoBase64(String photoBase64) {
        this.photoBase64 = photoBase64;
    }

    public SaleDto() {
    }

    public Integer getCondid() {
        return condid;
    }

    public void setCondid(Integer condid) {
        this.condid = condid;
    }

    public Integer getGenderid() {
        return genderid;
    }

    public void setGenderid(Integer genderid) {
        this.genderid = genderid;
    }

    public Integer getSizeid() {
        return sizeid;
    }

    public void setSizeid(Integer sizeid) {
        this.sizeid = sizeid;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

}
