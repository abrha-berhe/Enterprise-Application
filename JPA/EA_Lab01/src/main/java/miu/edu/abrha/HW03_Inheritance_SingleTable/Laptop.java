/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW03_Inheritance_SingleTable;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mabshura
 */
@Entity
public class Laptop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private float price;
    private int RAM_Size;
    private int HD_Size;
    
    public Laptop(){}

    public Laptop(float price, int RAM_Size, int HD_Size) {
        this.price = price;
        this.RAM_Size = RAM_Size;
        this.HD_Size = HD_Size;
    }
    


    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRAM_Size() {
        return RAM_Size;
    }

    public void setRAM_Size(int RAM_Size) {
        this.RAM_Size = RAM_Size;
    }

    public int getHD_Size() {
        return HD_Size;
    }

    public void setHD_Size(int HD_Size) {
        this.HD_Size = HD_Size;
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
        if (!(object instanceof Laptop)) {
            return false;
        }
        Laptop other = (Laptop) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miu.edu.abrha.Inheritance_SingleTable.Laptop[ id=" + id + " ]";
    }
    
}
