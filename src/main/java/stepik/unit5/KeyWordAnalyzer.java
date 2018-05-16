package stepik.unit5;


import java.util.List;

public abstract class KeyWordAnalyzer implements TextAnalyzer {

   protected abstract List<String > getKeyWords();
   protected abstract Label getLabel();

    @Override
    public Label processText(String text) {
        boolean hasCheck = false;
        List<String> checkList = getKeyWords();

        for(String s: checkList){
            if(text.contains(s)){
                hasCheck = true;
            }
        }
        if(hasCheck){
            return getLabel();
        }else{
            return Label.OK;
        }
      }
}
