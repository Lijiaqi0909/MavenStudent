package com.service;

import com.student.MavenStudent;

import java.util.List;

/**
 * @Description TODO
 * @Author Li jq
 * @Date 2021/3/24 21:07
 **/

public interface MavenStudentService {

    List<MavenStudent> getAll();

    int insterStudent(MavenStudent student);
}
