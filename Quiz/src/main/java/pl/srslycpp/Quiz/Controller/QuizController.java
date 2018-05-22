package pl.srslycpp.Quiz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping({"/", "/index"})
	public String index() {
		return "index";
	}

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

	@GetMapping("/projects/quiz/addQuestion")
	public String addNewQuestion (Model model){
		model.addAttribute("addQuestion", new Questions());

		return "addQuestion";
	}
	@PostMapping("/projects/quiz/addQuestion")
	public String addingNewQuestion(@ModelAttribute("addQuestion") Questions addQuestion){
		System.out.println(addQuestion.getCategory()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(addQuestion.getGoodA()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(addQuestion.getOdpA()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		questionService.addQuestion(addQuestion);
		return "addQuestion";
	}

//in progress
	@GetMapping("/projects/quiz/editQuestion/{id}")
	public String editQuestion (@PathVariable("id") Long id, Model model){
		System.out.println("<<<<<<<<<<<"+id);
		model.addAttribute("editQuestion",questionService.editQuestion(id));
		return "editQuestion";
	}
	@PostMapping("/project/quiz/editQuestion/editQuestion")
	public String edittQuestion (@ModelAttribute("editQuestion")Questions editQuestion){
		questionService.edittQuestion(editQuestion);
		return "editQuestion";
	}
}