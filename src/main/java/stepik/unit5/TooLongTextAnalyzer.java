package stepik.unit5;

public class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if(text.length() >= maxLength){
            return Label.TOO_LONG;
        }else{
            return Label.OK;
        }
   }
}
