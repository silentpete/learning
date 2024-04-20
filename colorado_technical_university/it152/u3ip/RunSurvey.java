import javax.swing.JOptionPane;

public class RunSurvey {

    public static void main(String[] args) {

        int questions, respondents;

        Survey questionnaire = new Survey();
        questionnaire.displayGreeting();
        questions=Integer.parseInt(JOptionPane.showInputDialog(null, "How many questions do you want in the survey? [1-10]"));
        respondents=Integer.parseInt(JOptionPane.showInputDialog(null, "How many respondents do you want to take the survey? [1-10]"));

        for(int index = 0; index < questions; index++) {
            questionnaire.setQuestion(index);
        }

        for(int rindex = 0; rindex < respondents; rindex++) {
            for(int qindex = 0; qindex < questions; qindex++) {
                // to demonstrate overloading a method
                if (rindex == 0) {
                    questionnaire.presentQuestion(qindex);
                } else {
                    questionnaire.presentQuestion(qindex, rindex);
                }
                questionnaire.logResponse(qindex, rindex, questionnaire.getQuestionAnswer(qindex, rindex));
            }
        }

        System.out.println("Survey Title: " + questionnaire.surveyTitle);

        questionnaire.displaySurveyResults(questions, respondents);

        int qstat=Integer.parseInt(JOptionPane.showInputDialog(null, "Which question to stat? (0 - " + (questions - 1) + ")"));
        questionnaire.displayQuestionStats(qstat, respondents);
        questionnaire.displaySurveyQuestions(questions);

        int topQuestion = questionnaire.topRatedQuestion(questions, respondents);
        JOptionPane.showMessageDialog(null, "Top Rated Question\n\tID: " + topQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(topQuestion));
        System.out.println("Top Rated Question\n\tID: " + topQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(topQuestion));

        int lowQuestion = questionnaire.lowRatedQuestion(questions, respondents);
        JOptionPane.showMessageDialog(null, "Lowest Rated Question\n\tID: " + lowQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(lowQuestion));
        System.out.println("Lowest Rated Question\n\tID: " + lowQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(lowQuestion));
    }
}
