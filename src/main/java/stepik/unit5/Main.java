package stepik.unit5;


public class Main {
    public static void main(String[] args) {
        String[] tests = new String[8];
        tests[0] = "This comment is so good.";                            // OK
        tests[1] = "This comment is so Loooooooooooooooooooooooooooong."; // TOO_LONG
        tests[2] = "Very negative comment !!!!=(!!!!;";                   // NEGATIVE_TEXT
        tests[3] = "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;";    // NEGATIVE_TEXT or TOO_LONG
        tests[4] = "This comment is so bad....";                          // SPAM
        tests[5] = "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!";  // SPAM or TOO_LONG
        tests[6] = "Negative bad :( spam.";                               // SPAM or NEGATIVE_TEXT
        tests[7] = "Very bad, very neg =(, very ..................";      // SPAM or NEGATIVE_TEXT or TOO_LONG
        TextAnalyzer [] analyzers = {
                new NegativeTextAnalyzer(),
                new SpamAnalyzer("=(",":("),
                new TooLongTextAnalyzer(50)
        };

        System.out.println(checkLabels(analyzers,tests[4]));
    }
    // Первое не ОК решение
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label label = Label.OK;
        for(TextAnalyzer a: analyzers){
            label = a.processText(text);
        }

       return label;
    }
}
