package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
