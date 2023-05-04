package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.QuestionType;
@Repository
public interface QuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
