package com.dzenang.springboottesting.repository;

import com.dzenang.springboottesting.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByName(String name);

    Department findByCode(String code);

    // this is doing the same as findByName, just demonstrating usage of custom query
    @Query(value = "select * from department d where d.name = :name", nativeQuery = true)
    Department findByNameCustomQuery(@Param("name") String departmentName);
}
