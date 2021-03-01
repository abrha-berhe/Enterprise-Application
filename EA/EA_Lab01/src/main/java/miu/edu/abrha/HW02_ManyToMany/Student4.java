/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW02_ManyToMany;

  import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
 
/**
 *
 * @author 611519
 */
@Entity
public class Student4 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String Name;
    private float GPA;
    @ManyToMany()
    private List<Course> coursesAssigned;

    public Student4() {}
    public Student4(String Name, float GPA) {
        this.Name = Name;
        this.GPA = GPA;
        this.coursesAssigned = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return coursesAssigned;
    }

    public void setCourses(List<Course> courses) {
        this.coursesAssigned = courses;
    }
 
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
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
        if (!(object instanceof Student4)) {
            return false;
        }
        Student4 other = (Student4) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "miu.edu.abrha.ee_project.Student[ id=" + id + " ]";
    }

}
