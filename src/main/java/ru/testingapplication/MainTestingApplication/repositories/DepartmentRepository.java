package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
