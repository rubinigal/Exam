import java.util.ArrayList;

public class questionRepository {
	private static String[][] _allQuestions = {
            {"What is the largest planet in our solar system?", "Jupiter", "Saturn", "Neptune", "Uranus"},
            {"Which element has the chemical symbol 'O'?", "Oxygen", "Osmium", "Ozone", "Osmosis"},
            {"Who wrote 'Romeo and Juliet'?", "William Shakespeare", "Charles Dickens", "Jane Austen", "Mark Twain"},
            {"In what year did the Titanic sink?", "1912", "1905", "1920", "1915"},
            {"What is the capital of Japan?", "Tokyo", "Seoul", "Beijing", "Osaka"},
            {"Which programming language is known for its use in web development?", "JavaScript", "Python", "Java", "C++"},
            {"What is the largest ocean on Earth?", "Pacific Ocean", "Atlantic Ocean", "Indian Ocean", "Arctic Ocean"},
            {"Who developed the theory of relativity?", "Albert Einstein", "Isaac Newton", "Galileo Galilei", "Stephen Hawking"},
            {"What is the powerhouse of the cell?", "Mitochondria", "Nucleus", "Endoplasmic reticulum", "Golgi apparatus"},
            {"Which artist painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"}
    };
	
	public static ArrayList<String[]> getAllQuestions() {
		ArrayList<String[]> arr = new ArrayList<String[]>();
		for (int i = 0; i <  _allQuestions.length; i++) {
			arr.add(_allQuestions[i]);
		}
		return arr; // Returned array is a shallow copy, we will shuffle _allQuestions many times and the order id not important
	}
}
