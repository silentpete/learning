import javax.swing.JOptionPane;

public class Survey {
    static int respondentID = 0;
    String surveyTitle = "";
    int surveyQuestionGrid[][] = new int[10][10];
    String surveyQuestions[] = new String[10];

    // this seems clever
    // if no arg is passed into the default constructor is calls the overloading constructor with a default
    // default constructor
    Survey() {
        this("Customer Survey");
    }

    // this is an overloaded constructor
    Survey(String title) {
        surveyTitle = title;
        respondentID = 0;
    }

    int incrementRespondentID() {
        respondentID++;
        return respondentID;
    }

    String getQuestion(int i) {
        return JOptionPane.showInputDialog(null, "Please enter the question for ID: " + i);
    }

    int getQuestionAnswer(int questionID, int r) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Respondent "+ r + "\nQuestion "+ questionID +": " + surveyQuestions[questionID] +"\nPlease answer with 1 - 5"));
    }

    void logResponse(int qID, int rID, int answer) {
        surveyQuestionGrid[qID][rID] = answer;
    }

    void enterQuestions(int index) {
        surveyQuestions[index] = getQuestion(index);
    }

    void displaySurveyResults(int q, int r) {
        System.out.println("Display Grid:");
        for(int rindex = 0; rindex < r; rindex++) {
            System.out.print("Respondent " + rindex + ":");
            for(int qindex = 0; qindex < q; qindex++) {
                System.out.print(" q" + qindex + ": " + surveyQuestionGrid[qindex][rindex]);
            }
            System.out.println("");
        }
    }

    void displayQuestionStats(int qindex, int r) {
        System.out.println("Display question " + qindex + " current stat");
        for(int rindex = 0; rindex < r; rindex++) {
            System.out.println("\tr" + rindex + ": " + surveyQuestionGrid[qindex][rindex]);
        }
    }
}
