package pl.srslycpp.Quiz.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.srslycpp.Quiz.Entity.Questions;

@Repository
public interface QuestionRepository extends CrudRepository<Questions, Long> {
}
