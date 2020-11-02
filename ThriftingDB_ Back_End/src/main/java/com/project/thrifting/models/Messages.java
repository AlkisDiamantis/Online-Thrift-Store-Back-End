/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Alkis
 */
@Entity
@Table(name = "messages")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Messages.findAll", query = "SELECT m FROM Messages m")})
public class Messages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_messages")
    private Integer idMessages;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "msgtext")
    private String msgtext;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userreceiveid")
    private int userreceiveid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usersendid")
    private int usersendid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "saletitle")
    private String saletitle;
    @Size(max = 45)
    @Column(name = "msgdate")
    private String msgdate;

    public Messages() {
    }

    public Messages(Integer idMessages) {
        this.idMessages = idMessages;
    }

    public Messages(Integer idMessages, String msgtext, int userreceiveid, int usersendid, String saletitle) {
        this.idMessages = idMessages;
        this.msgtext = msgtext;
        this.userreceiveid = userreceiveid;
        this.usersendid = usersendid;
        this.saletitle = saletitle;
    }

    public Integer getIdMessages() {
        return idMessages;
    }

    public void setIdMessages(Integer idMessages) {
        this.idMessages = idMessages;
    }

    public String getMsgtext() {
        return msgtext;
    }

    public void setMsgtext(String msgtext) {
        this.msgtext = msgtext;
    }

    public int getUserreceiveid() {
        return userreceiveid;
    }

    public void setUserreceiveid(int userreceiveid) {
        this.userreceiveid = userreceiveid;
    }

    public int getUsersendid() {
        return usersendid;
    }

    public void setUsersendid(int usersendid) {
        this.usersendid = usersendid;
    }

    public String getSaletitle() {
        return saletitle;
    }

    public void setSaletitle(String saletitle) {
        this.saletitle = saletitle;
    }

    public String getMsgdate() {
        return msgdate;
    }

    public void setMsgdate(String msgdate) {
        this.msgdate = msgdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMessages != null ? idMessages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Messages)) {
            return false;
        }
        Messages other = (Messages) object;
        if ((this.idMessages == null && other.idMessages != null) || (this.idMessages != null && !this.idMessages.equals(other.idMessages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.project.thrifting.models.Messages[ idMessages=" + idMessages + " ]";
    }
    
}
