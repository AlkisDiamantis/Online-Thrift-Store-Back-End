package com.project.thrifting.models;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT s FROM Sale s")})
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "saleid")
    private Integer saleid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datestart")

    private String datestart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private Double price;

    @JoinColumn(name = "categoryid", referencedColumnName = "categoryid")
    @ManyToOne(optional = false)
    private Categories categoryid;
    @JoinColumn(name = "condid", referencedColumnName = "conditionid")
    @ManyToOne(optional = false)
    private Conditions condid;
    @JoinColumn(name = "genderid", referencedColumnName = "genderid")
    @ManyToOne(optional = false)
    private Genders genderid;
    @JoinColumn(name = "sizeid", referencedColumnName = "sizeid")
    @ManyToOne(optional = false)
    private Sizes sizeid;
    @JoinColumn(name = "userid", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private User userid;

    @Size(min = 1, max = 100)
    @Column(name = "photoUrl")
    private String photoUrl;

    public Sale(String title, String comment, String datestart, Double price, Categories categoryid, Conditions condid, Genders genderid, Sizes sizeid, User userid, String photoUrl) {
        this.title = title;
        this.comment = comment;
        this.datestart = datestart;
        this.price = price;
        this.categoryid = categoryid;
        this.condid = condid;
        this.genderid = genderid;
        this.sizeid = sizeid;
        this.userid = userid;
        this.photoUrl = photoUrl;
    }




    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Categories getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Categories categoryid) {
        this.categoryid = categoryid;
    }

    public Conditions getCondid() {
        return condid;
    }

    public void setCondid(Conditions condid) {
        this.condid = condid;
    }

    public Genders getGenderid() {
        return genderid;
    }

    public void setGenderid(Genders genderid) {
        this.genderid = genderid;
    }

    public Sizes getSizeid() {
        return sizeid;
    }

    public void setSizeid(Sizes sizeid) {
        this.sizeid = sizeid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Sale() {
    }

    public Sale(Integer saleid) {
        this.saleid = saleid;
    }

    public Integer getSaleid() {
        return saleid;
    }

    public void setSaleid(Integer saleid) {
        this.saleid = saleid;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleid != null ? saleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        if ((this.saleid == null && other.saleid != null) || (this.saleid != null && !this.saleid.equals(other.saleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.thrifting.models.Sale[ saleid=" + saleid + " ]";
    }

}
