import javax.swing.JOptionPane;

public class Survey {
    // set some default values
    int minQuestions = 1;
    int maxQuestions = 10;
    int minRespondents = 1;
    int maxRespondents = 10;
    int minResponse = 1;
    int maxResponse = 5;
    static int respondentID = 0;
    String surveyTitle = "";
    int surveyQuestionGrid[][] = new int[maxQuestions][maxRespondents];
    String surveyQuestions[] = new String[maxQuestions];

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
        surveyQuestions[i] = JOptionPane.showInputDialog(null, "Please enter question: " + (i + 1));
    }

    int getQuestionAnswer(int questionID, int r) {
        // to demonstrate overloading a method
        if (r == 0) {
            presentQuestion(questionID);
        } else {
            presentQuestion(questionID, r);
        }

        int value = 0;
        while(!validateAnswerBetweenMinAndMaxResponse(value, maxResponse)) {
            String sText = JOptionPane.showInputDialog(null, "Respondent " + (r + 1) + "\nQuestion " + (questionID + 1) + ": " + surveyQuestions[questionID] + "\n(please answer with [" + minResponse + " - " + maxResponse + "])");
            value = textToDigit(sText);
        }
        return value;
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

    int textToDigit(String sText) {
        if(sText.matches("\\d+")) {
            return Integer.parseInt(sText);
        }
        return 0;
    }

    int getNumberOfQuestions() {
        int value = 0;
        while(!validateAnswerBetweenMinAndMaxResponse(value, minQuestions, maxQuestions)) {
            String sText = JOptionPane.showInputDialog(null, "How many questions do you want in the survey? [" + minQuestions + "-" + maxQuestions + "]");
            value = textToDigit(sText);
        }
        return value;
    }

    int getNumberOfRespondents() {
        int value = 0;
        while(!validateAnswerBetweenMinAndMaxResponse(value, minRespondents, maxRespondents)) {
            String sText = JOptionPane.showInputDialog(null, "How many respondents do you want to take the survey? [" + minRespondents + "-" + maxRespondents + "]");
            value = textToDigit(sText);
        }
        return value;
    }

    int getNumberToStat(int questions) {
        int value = 0;
        if (questions == 1) {
            value = questions;
        }
        while(!validateAnswerBetweenMinAndMaxResponse(value, questions)) {
            String sText = JOptionPane.showInputDialog(null, "Which question to stat? (" + minQuestions + " - " + questions + ")");
            value = textToDigit(sText);
        }
        return value - 1;
    }

    boolean validateAnswerBetweenMinAndMaxResponse(int answer, int max) {
        // System.out.println(answer);
        // System.out.println(max);
        if(answer > 0 && answer <= max) {
            // System.out.println("return true");
            return true;
        }
        // System.out.println("return false");
        return false;
    }

    boolean validateAnswerBetweenMinAndMaxResponse(int answer, int min, int max) {
        // System.out.println(answer);
        if(answer >= min && answer <= max) {
            // System.out.println("return true");
            return true;
        }
        // System.out.println("return false");
        return false;
    }

}
