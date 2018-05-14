package pl.srslycpp.Quiz.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pytania")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tresc")
	private String question;
	@Column(name = "answer")
	private String goodAnswer;
	@Column(name = "odpa")
	private String odpA;
	@Column(name = "odpb")
	private String odpB;
	@Column(name = "odpc")
	private String odpC;
	@Column(name = "odpd")
	private String odpD;
	@Column(name = "kategoria")
	private String category;
	@Column(name = "rok")
	private int year;

	public Questions() {
	}

	public Questions(Long id, String question, String goodAnswer, String odpA, String odpB, String odpC, String odpD,
					 String category, int year) {
		super();
		this.id = id;
		this.question = question;
		this.goodAnswer = goodAnswer;
		this.odpA = odpA;
		this.odpB = odpB;
		this.odpC = odpC;
		this.odpD = odpD;
		this.category = category;
		this.year = year;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getGoodAnswer() {
		return goodAnswer;
	}

	public void setGoodAnswer(String goodAnswer) {
		goodAnswer = goodAnswer;
	}

	public String getOdpA() {
		return odpA;
	}

	public void setOdpA(String odpA) {
		this.odpA = odpA;
	}

	public String getOdpB() {
		return odpB;
	}

	public void setOdpB(String odpB) {
		this.odpB = odpB;
	}

	public String getOdpC() {
		return odpC;
	}

	public void setOdpC(String odpC) {
		this.odpC = odpC;
	}

	public String getOdpD() {
		return odpD;
	}

	public void setOdpD(String odpD) {
		this.odpD = odpD;
	}

	public String getCategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}

	public int getYear() {
		return year;
	}

	public void setDate(int year) {
		this.year = year;
	}

}
