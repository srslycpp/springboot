package pl.srslycpp.Quiz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.srslycpp.Quiz.Entity.Questions;
import pl.srslycpp.Quiz.Service.QuestionService;

@Controller
public class QuizController {

	@Autowired
	private QuestionService questionService;

	public long getRandom() {
		return random;
	}

	public void setRandom() {
		this.random = 1L + (long) (Math.random() * (20L - 1L));
	}

	private long random;

	//public long random = new RandomDataGenerator().nextLong(1L, 10L);



	Questions questions = new Questions();

	public static long random() {

		return (long) Math.random();
	}

//	@GetMapping("/")
//	public String index2(@ModelAttribute("questions") Questions questions, ModelMap model) {
//		model.put("a", questions.getGoodAnswer());
//		System.out.println(random +" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//		return "index";
//	}

	@GetMapping("/projects")
	public String showProjects(){
		return "projects";
	}
	@GetMapping("/projects/quiz/allQuestions")
	public String allQuestions( Model model){
		model.addAttribute("questions", questionService.allQuestions());
		return "allQuestions";
	}

	@GetMapping({"/projects/quiz/oneQuestion"})
	public String startUpPage(@ModelAttribute("question") Questions questions, Model model) {
		setRandom();
		model.addAttribute("question", questionService.getQuestion(getRandom()).getQuestion());
		model.addAttribute("odpA", questionService.getQuestion(getRandom()).getOdpA());
		model.addAttribute("odpB", questionService.getQuestion(getRandom()).getOdpB());
		model.addAttribute("odpC", questionService.getQuestion(getRandom()).getOdpC());
		model.addAttribute("odpD", questionService.getQuestion(getRandom()).getOdpD());
		System.out.println(getRandom() +" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		//model.addAttribute("result", questionService.check(null, null));
		// model.addAttribute(questionsService.check(questions.getGoodAnswer()));
		// Service service = new Service();
		// service.questionsGenerator();
		return "oneQuestion";
	}

	@PostMapping("/projects/quiz/addQuestion")
	public String addNewQuestion (Questions question){
		//model.addAttribute(question.setQuestion();)
		questionService.addQuestion(question);
		return "addQuestion";
	}

	@GetMapping("/editQuestion")
	public String editQuestion (@RequestParam("id") Long id){
		Questions questions = questionService.editQuestion(id);

		return "editQuestion";

	}
}