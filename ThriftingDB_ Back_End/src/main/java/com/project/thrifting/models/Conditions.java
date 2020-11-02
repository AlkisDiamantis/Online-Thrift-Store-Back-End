
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "conditions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conditions.findAll", query = "SELECT c FROM Conditions c")})
public class Conditions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conditionid")
    private Integer conditionid;
    @Size(max = 45)
    @Column(name = "condition")
    private String condition;


    public Conditions() {
    }

    public Conditions(Integer conditionid) {
        this.conditionid = conditionid;
    }

    public Integer getConditionid() {
        return conditionid;
    }

    public void setConditionid(Integer conditionid) {
        this.conditionid = conditionid;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conditionid != null ? conditionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conditions)) {
            return false;
        }
        Conditions other = (Conditions) object;
        if ((this.conditionid == null && other.conditionid != null) || (this.conditionid != null && !this.conditionid.equals(other.conditionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.thrifting.models.Conditions[ conditionid=" + conditionid + " ]";
    }
    
}
