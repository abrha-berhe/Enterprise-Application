/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miu.edu.abrha.HW05_Callback;

 import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
 

/**
 *
 * @author Mabshura
 */
public class StudentListner {
//    @PostPersist
//    @PostUpdate
//    private void afterAnyUpdate(Student_5 student) {
//        System.out.println("Add/Update complete for Student: " + student.getId());
//    }

    @PostPersist
    private void onPostPersist(Student_5 student) {
        System.out.println("Add complete for Student: " + student.getId());
    }

    @PostUpdate
    private void onPostUpdate(Student_5 student) {
        System.out.println("Update complete for Student: " + student.getId());
    }

}
