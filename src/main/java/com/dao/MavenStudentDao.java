package com.dao;

import com.student.MavenStudent;

import java.util.List;

/**
 * @author XXHH
 */
public interface MavenStudentDao {

    List<MavenStudent>getAll();

    int insterStudent(MavenStudent student);

}
