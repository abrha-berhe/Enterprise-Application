package miu.edu.Spring_Hibernate_ORM_TX.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
 public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private float GPA;

    public Student() {
    }

    public Student(String name, float GPA) {
        this.name = name;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
