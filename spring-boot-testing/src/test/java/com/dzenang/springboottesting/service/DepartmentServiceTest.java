package com.dzenang.springboottesting.service;

import com.dzenang.springboottesting.entity.Department;
import com.dzenang.springboottesting.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class DepartmentServiceTest {
    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveDepartment_ShouldReturnSavedDepartment() {
        // given
        Department department = new Department(1L, "HR", "Main building, blok A", "HR01");
        Mockito.when(departmentRepository.save(department)).thenReturn(department);

        // when
        Department savedDepartment = departmentService.saveDepartment(department);

        // then
        assertNotNull(savedDepartment);
        assertEquals(department.getId(), savedDepartment.getId());
        assertEquals(department.getName(), savedDepartment.getName());
        assertEquals(department.getAddress(), savedDepartment.getAddress());
        assertEquals(department, savedDepartment);
        Mockito.verify(departmentRepository, Mockito.times(1)).save(department);
    }

    @Test
    void updateDepartment_ShouldReturnUpdatedDepartment() {
        // given
        Long departmentInDbId = 1L;
        Department departmentInDb = new Department(departmentInDbId, "HR", "Main building, blok A", "HR01");
        Department newDepartment = new Department(10L, "R&D", "Main building, block A", "RD01");
        Mockito.when(departmentRepository.findById(departmentInDbId)).thenReturn(Optional.of(departmentInDb));
        Mockito.when(departmentRepository.save(departmentInDb)).thenReturn(departmentInDb);

        // when
        Department updatedDepartment = departmentService.updateDepartment(departmentInDbId, newDepartment);

        // then
        assertNotNull(updatedDepartment);
        assertEquals(departmentInDbId, updatedDepartment.getId());
        assertEquals(newDepartment.getName(), updatedDepartment.getName());
        assertEquals(newDepartment.getAddress(), updatedDepartment.getAddress());
        assertEquals(newDepartment.getCode(), updatedDepartment.getCode());
        Mockito.verify(departmentRepository, Mockito.times(1)).findById(departmentInDbId);
        Mockito.verify(departmentRepository, Mockito.times(1)).save(departmentInDb);
    }

    @Test
    void updateDepartment_ShouldReturnNullWhenDepartmentNotFound() {
        // given
        Long departmentInDbId = 1L;
        Department newDepartment = new Department(10L, "R&D", "Main building, block A", "RD01");
        Mockito.when(departmentRepository.findById(departmentInDbId)).thenReturn(Optional.empty());

        // when
        Department updatedDepartment = departmentService.updateDepartment(departmentInDbId, newDepartment);

        // then
        assertNull(updatedDepartment);
        Mockito.verify(departmentRepository, Mockito.times(1)).findById(departmentInDbId);
        Mockito.verify(departmentRepository, Mockito.times(0)).save(any());
    }
}