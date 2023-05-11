package ru.testingapplication.MainTestingApplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.testingapplication.MainTestingApplication.models.AnswerOption;

@Repository
public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Integer> {

}
