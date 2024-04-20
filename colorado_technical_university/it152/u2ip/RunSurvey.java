import javax.swing.JOptionPane;

public class RunSurvey {

    public static void main(String[] args) {

        int questions, respondents;

        questions=Integer.parseInt(JOptionPane.showInputDialog(null, "How many questions?"));
        respondents=Integer.parseInt(JOptionPane.showInputDialog(null, "How many respondents?"));

        Survey questionnaire = new Survey();

        for(int index = 0; index < questions; index++) {
            questionnaire.enterQuestions(index);
        }

        for(int rindex = 0; rindex < respondents; rindex++) {
            for(int qindex = 0; qindex < questions; qindex++) {
                questionnaire.logResponse(qindex, rindex, questionnaire.getQuestionAnswer(qindex, rindex));
            }
        }

        System.out.println("Survey Title: " + questionnaire.surveyTitle);

        questionnaire.displaySurveyResults(questions, respondents);

        int qstat=Integer.parseInt(JOptionPane.showInputDialog(null, "Which question to stat? (0 - " + (questions - 1) + ")"));
        questionnaire.displayQuestionStats(qstat, respondents);
    }
}
