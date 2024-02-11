import java.util.ArrayList;
import java.util.Collections;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ExamController {
	private static final int NUM_QUESTIONS = 5;
	private static ArrayList<Question> _pickedQuestions;
	private static Question _question;
	private static int _pageNumber;

    @FXML
    private Text questionText;

    @FXML
    private RadioButton answer1;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private Text answerText;

    @FXML
    private Button button;

    @FXML
    void buttonPress(ActionEvent event) {
    	if (button.getText().equals("Answer")) { // Button text is Answer
    		RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
    		if (selectedRadioButton != null && Exam.checkAnswer(_question, selectedRadioButton.getText())) { // Right answer
    			answerText.setText("Right Answer");
    			answerText.setFill(Color.GREEN);
    		}
    		else { // Wrong answer
    			answerText.setText("Wrong Answer");
    			answerText.setFill(Color.RED);
    		}
    		button.setText("Next");
    	}
    	else if (button.getText().equals("Next")) { // Button text is Next
    		button.setText("Answer");
    		loadQuestion();
    	}
    	else { // Button text is New Exam
    		startNew();
    	}
    }
       
    public void initialize() {
    	startNew();
    }
    
    private void startNew() {
    	resetExam();
		_pageNumber = 0;
		button.setText("Answer");
    	Exam.resetCounter();
    	toggleDisable(false);
		loadQuestion();
    }
    // Loading new questions and shuffle them for new exam
    public static void resetExam() {		
		ArrayList<String[]> allQuestions = questionRepository.getAllQuestions();
		ArrayList<Question> pickedQuestions = new ArrayList<Question>();
		
		Collections.shuffle(allQuestions);
		
		for (int i = 0; i < NUM_QUESTIONS && i < allQuestions.size(); i++) {
			pickedQuestions.add(new Question(allQuestions.get(i)));
		}
		_pickedQuestions = pickedQuestions;
    }
    
    private void loadQuestion() {
    	if (_pageNumber >= _pickedQuestions.size()) { // We finished with the exam
    		toggleDisable(true);
    		button.setText("New Exam");
    		answerText.setText("Your score is: " + Exam.score(NUM_QUESTIONS));
			answerText.setFill(Color.BLACK);
			return;
    	}
    	// Loading the questions to JavaFX panel
    	_question = _pickedQuestions.get(_pageNumber);
    	questionText.setText(_question.getQuestion());
    	ArrayList<String> answers = _question.getAnswers();
    	Collections.shuffle(answers); // shuffle the answers order
    	answer1.setText(answers.get(0));
    	answer2.setText(answers.get(1));
    	answer3.setText(answers.get(2));
    	answer4.setText(answers.get(3));
    	// Preparations for next question
    	toggleGroup.selectToggle(null);
    	answerText.setText("");
    	_pageNumber++;
    }
    // Enable and disable some functions from users upon start and end of exam
    private void toggleDisable(boolean state) {
    	questionText.setDisable(state);
    	answer1.setDisable(state);
        answer2.setDisable(state);
        answer3.setDisable(state);
        answer4.setDisable(state);
        
        questionText.setVisible(!state);
    	answer1.setVisible(!state);
        answer2.setVisible(!state);
        answer3.setVisible(!state);
        answer4.setVisible(!state);
    }
}
