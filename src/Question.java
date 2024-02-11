import java.util.ArrayList;

public class Question {
	private String _question, _rightAnswer, _wrongAnswer1, _wrongAnswer2, _wrongAnswer3;
	private ArrayList<String> _answers = new ArrayList<String>();
	
	public Question(String[] arr) {
		if (arr.length < 5)
			return;
		_question = arr[0];
		_rightAnswer = arr[1];
		_wrongAnswer1 = arr[2];
		_wrongAnswer2 = arr[3];
		_wrongAnswer3 = arr[4];
		buildArray();
	}
	
	public String getQuestion() {
		return _question;
	}
		
	public String getRightAnswer() {
		return _rightAnswer;
	}
	
	public ArrayList<String> getAnswers() {
		return _answers;
	}
	
	private void buildArray() {
		_answers.add(_rightAnswer);
		_answers.add(_wrongAnswer1);
		_answers.add(_wrongAnswer2);
		_answers.add(_wrongAnswer3);
	}
}
