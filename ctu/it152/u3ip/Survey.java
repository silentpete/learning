import javax.swing.JOptionPane;

public class Survey {
    int maxQuestions = 10;
    int maxRespondents = 10;
    int minResponse = 1;
    int maxResponse = 5;
    static int respondentID = 0;
    String surveyTitle = "";
    int surveyQuestionGrid[][] = new int[maxQuestions][maxRespondents];
    String surveyQuestions[] = new String[maxQuestions];

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

    void displayGreeting() {
        JOptionPane.showMessageDialog(null, "Welcome to the \"" + surveyTitle + "\"");
    }

    int incrementRespondentID() {
        respondentID++;
        return respondentID;
    }

    void setQuestion(int i) {
        surveyQuestions[i] = JOptionPane.showInputDialog(null, "Please enter the question for ID " + i);
    }

    int getQuestionAnswer(int questionID, int r) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "Respondent "+ (r + 1) + "\nQuestion "+ (questionID + 1) +": " + surveyQuestions[questionID] +"\n(please answer with [1-5])"));
    }

    void logResponse(int qID, int rID, int answer) {
        surveyQuestionGrid[qID][rID] = answer;
    }

    void presentQuestion(int index) {
        System.out.println("question " + index + ", please answer the following: " + surveyQuestions[index]);
    }

    void presentQuestion(int index, int rindex) {
        System.out.println("respondent " + rindex + ", question " + index + ", please answer the following: " + surveyQuestions[index]);
    }

    int topRatedQuestion(int questions, int respondents) {
        int topIndex = -1;
        int topResult = minResponse - 1;
        int qResult;

        for(int qIndex = 0; qIndex < questions; qIndex++) {
            qResult = 0;
            for(int rIndex = 0; rIndex < respondents; rIndex++) {
                qResult = qResult + surveyQuestionGrid[qIndex][rIndex];

            }
            if (topResult < qResult) {
                topResult = qResult;
                topIndex = qIndex;
            }
        }
        return topIndex;
    }

    int lowRatedQuestion(int questions, int respondents) {
        int lowIndex = -1;
        int lowResult = maxRespondents * maxResponse;
        int qResult;

        for(int qIndex = 0; qIndex < questions; qIndex++) {
            qResult = 0;
            for(int rIndex = 0; rIndex < respondents; rIndex++) {
                qResult = qResult + surveyQuestionGrid[qIndex][rIndex];

            }
            if (lowResult > qResult) {
                lowResult = qResult;
                lowIndex = qIndex;
            }
        }
        return lowIndex;
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
        System.out.println("Display question " + qindex + " current stat:");
        for(int rindex = 0; rindex < r; rindex++) {
            System.out.println("\tr" + rindex + ": " + surveyQuestionGrid[qindex][rindex]);
        }
    }

    String displaySurveyQuestion(int question) {
        return surveyQuestions[question];
    }

    void displaySurveyQuestions(int questions) {
        System.out.println("Display Survey Questions:");
        for(int i = 0; i < questions; i++) {
            System.out.println("\tq"+ i + " = " + displaySurveyQuestion(i));
        }
    }
}
