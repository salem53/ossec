package com.sip.ams.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
