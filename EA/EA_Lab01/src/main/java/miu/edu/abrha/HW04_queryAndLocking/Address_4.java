/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW04_queryAndLocking;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Mabshura
 */
@Embeddable
public class Address_4 implements Serializable {

  
    private String street;
    private String city;
    private String state;
    private int zip;

    public Address_4() {
    }

    public Address_4(String street, String city, String state, int zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

  

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address_4)) {
            return false;
        }
        Address_4 other = (Address_4) object;
       
        return true;
    }

    @Override
    public String toString() {
        return "miu.edu.abrha.queryAndLocking.Address_4[ zip=" + zip + " ]";
    }

}
