public class Survey {
    static int respondentID = 0;
    String surveyTitle = "";

    int incrementRespondentID() {
        respondentID++;
        return respondentID;
    }

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

}
