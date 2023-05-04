package ru.testingapplication.MainTestingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.testingapplication.MainTestingApplication.models.Department;
import ru.testingapplication.MainTestingApplication.repositories.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll(){
        return departmentRepository.findAll();
    }

    public Department findOne(int id){
        Optional<Department> foundDepartment = departmentRepository.findById(id);
        return foundDepartment.orElse(null);
    }

    @Transactional
    public void save(Department department){
        departmentRepository.save(department);
    }

    @Transactional
    public void update(int id, Department updatedDepartment){
        //updatedPerson.setId(id);
        departmentRepository.save(updatedDepartment);
    }

    @Transactional
    public void delete(int id){
        departmentRepository.deleteById(id);
    }

}
