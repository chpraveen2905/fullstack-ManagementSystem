package com.management.ems.controller;

import com.management.ems.dto.DepartmentDto;
import com.management.ems.entity.Department;
import com.management.ems.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentdDto){
        DepartmentDto departmentDto = departmentService.createDepartment(departmentdDto);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> fetchDepartment(@PathVariable("id") Long departmentId) {
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> fetchAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto> modifyDepartment(
            @PathVariable("id") Long departmentId,
            @RequestBody DepartmentDto departmentDto
    )
    {
        return ResponseEntity.ok(departmentService.updateDepartment(departmentId,departmentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> removeDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department was deleted successfully");
    }

}
