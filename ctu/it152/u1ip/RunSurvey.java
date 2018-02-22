public class RunSurvey {

    public static void main(String[] args) {

        Survey questionnaire = new Survey("custom");

        System.out.println("Survey Title: " + questionnaire.surveyTitle);

        for(int i = 0; i<10; i++) {
            System.out.println("Respondent ID: " + questionnaire.respondentID);
            questionnaire.incrementRespondentID();
        }

    }
}
