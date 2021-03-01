/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW03_Inheritance_SingleTable;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author 611519
 */
@Entity
@DiscriminatorValue("Job_Search")
public class Student_JobSearch1 extends Student_Parent1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String CV ;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date StartJobSearchDate;

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public Date getStartJobSearchDate() {
        return StartJobSearchDate;
    }

    public void setStartJobSearchDate(Date StartJobSearchDate) {
        this.StartJobSearchDate = StartJobSearchDate;
    }

     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student_JobSearch1)) {
            return false;
        }
        Student_JobSearch1 other = (Student_JobSearch1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miu.edu.abrha.inheritance_singleTable.Student_OnCampus1[ id=" + id + " ]";
    }
    
}
