
package com.project.thrifting.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "sizes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sizes.findAll", query = "SELECT s FROM Sizes s")})
public class Sizes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sizeid")
    private Integer sizeid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "size")
    private String size;


    public Sizes() {
    }

    public Sizes(Integer sizeid) {
        this.sizeid = sizeid;
    }

    public Sizes(Integer sizeid, String size) {
        this.sizeid = sizeid;
        this.size = size;
    }

    public Integer getSizeid() {
        return sizeid;
    }

    public void setSizeid(Integer sizeid) {
        this.sizeid = sizeid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sizeid != null ? sizeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sizes)) {
            return false;
        }
        Sizes other = (Sizes) object;
        if ((this.sizeid == null && other.sizeid != null) || (this.sizeid != null && !this.sizeid.equals(other.sizeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.thrifting.models.Sizes[ sizeid=" + sizeid + " ]";
    }
    
}
