package pl.srslycpp.Quiz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.srslycpp.Quiz.Entity.Questions;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Long> {


}
