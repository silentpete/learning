import javax.swing.JOptionPane;

public class SurveyConductor {

    public static void main(String[] args) {

        // Create a new questionnaire with overloadable class constructor
        Survey questionnaire = new Survey("Peters Custom Survey");

        // Display the greeting
        questionnaire.displayGreeting();

        // Ask and set number of questions in survey
        int questions = questionnaire.getNumberOfQuestions();

        // Ask and set number of respondents taking survey
        int respondents = questionnaire.getNumberOfRespondents();

        // Set the questions that will be asked
        for(int index = 0; index < questions; index++) {
            questionnaire.setQuestion(index);
        }

        // get answers to each question from each respondent
        for(int rindex = 0; rindex < respondents; rindex++) {
            for(int qindex = 0; qindex < questions; qindex++) {
                // while not true, do something
                int respondentAnswer = questionnaire.getQuestionAnswer(qindex, rindex);
                questionnaire.logResponse(qindex, rindex, respondentAnswer);
            }
        }

        // print to CLI survey title
        System.out.println("Survey Title: " + questionnaire.surveyTitle);

        // print the survey results to a CLI grid
        questionnaire.displaySurveyResults(questions, respondents);

        // ask for which question to give it stats
        // if there is only 1 question, don't ask
        int qstat = questionnaire.getNumberToStat(questions);
        questionnaire.displayQuestionStats(qstat, respondents);
        questionnaire.displaySurveyQuestions(questions);

        // print to CLI and Screen, question with the top accumulated value
        int topQuestion = questionnaire.topRatedQuestion(questions, respondents);
        JOptionPane.showMessageDialog(null, "Top Rated Question\n\tQuestion " + (topQuestion + 1) + ": " + questionnaire.displaySurveyQuestion(topQuestion));
        System.out.println("Top Rated Question\n\tID: " + topQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(topQuestion));

        // print to CLI and Screen, question with the lowest accumulated value
        int lowQuestion = questionnaire.lowRatedQuestion(questions, respondents);
        JOptionPane.showMessageDialog(null, "Lowest Rated Question\n\tQuestion " + lowQuestion + ": " + questionnaire.displaySurveyQuestion(lowQuestion));
        System.out.println("Lowest Rated Question\n\tID: " + lowQuestion + "\n\tQuestion: " + questionnaire.displaySurveyQuestion(lowQuestion));
    }
}
