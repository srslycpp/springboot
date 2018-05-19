package pl.srslycpp.Quiz.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.srslycpp.Quiz.Entity.Questions;
import pl.srslycpp.Quiz.Repository.QuestionsRepository;

import java.util.ArrayList;
import java.util.List;



@Service
public class QuestionService {

    @Autowired
    private QuestionsRepository questionsRepository;

//    private List<Questions> questions1 = Arrays.asList(new Questions(1L, "1", "1", "1", "1", "1", "1", "1", 1),
//            new Questions(2L, "1", "1", "1", "1", "1", "1", "1", 1),
//            new Questions(3L, "1", "1", "1", "1", "1", "1", "1", 1),
//            new Questions(4L, "1", "1", "1", "1", "1", "1", "1", 1));

    public List<Questions> allQuestions(){
        List<Questions> questions = new ArrayList<>(questionsRepository.findAll());
        return questions;
    }

    public Questions getQuestion(Long id) {
        Questions oneQuestion = questionsRepository.findById(id).get();
        return oneQuestion;
    }

    public boolean check(String ok, Long id) {

        if (questionsRepository.findById(id).get().getGoodA().equals(ok)) {
            return true;
        }
        return false;
    }

    public Questions addQuestion(Questions questions) {
           return questionsRepository.save(questions);
    }

    public Questions editQuestion (Long id){
        Questions question = questionsRepository.findById(id).get();
        return question;

    }

}
