package org.dci.studentmanagementapi.repositories;

import org.dci.studentmanagementapi.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentRepository extends CrudRepository<Student, UUID> {
    List<Student> findByMajorIgnoreCase(String major);
}
