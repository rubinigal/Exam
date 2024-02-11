import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Exam extends Application{
	private static int _rightAnswers = 0;

	public void start(Stage stage) throws Exception{
		Parent root = (Parent)
		FXMLLoader.load(getClass().getResource("Exam.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Exam");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
		System.out.println();		
	}
	
	public static void resetCounter() {
		_rightAnswers = 0;
	}

	public static boolean checkAnswer(Question question, String answer) {
		boolean ans = false;
		if (question.getRightAnswer().equals(answer)) {
			ans = true;
			_rightAnswers++;
		}
		return ans;
	}
	// Calculating end score
	public static int score(int numOfQuestions) {
		return (int) ((_rightAnswers / (double) numOfQuestions) * 100);
	}
}
