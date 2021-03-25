package com.controller;

import com.service.MavenStudentService;
import com.student.MavenStudent;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author Li jq
 * @Date 2021/3/24 21:06
 **/
@RequestMapping()
public class MavenStudentController {
    private MavenStudentService studentService;
     public void getAll(){
         studentService.getAll();

     }


     public void  AddStudent(MavenStudent student){

         studentService.insterStudent(student);

     }


}
