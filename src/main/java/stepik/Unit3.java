package stepik;

import java.util.ArrayList;
import java.util.List;

public class Unit3 {
    public static String[] roles = {"Городничий","Аммос Федорович","Артемий Филиппович","Лука Лукич"};
    public static String[] textLines =
              {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
               "Аммос Федорович: Как ревизор?",
               "Артемий Филиппович: Как ревизор?",
               "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
               "Аммос Федорович: Вот те на!",
               "Артемий Филиппович: Вот не было заботы, так подай!",
               "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

    public static void main(String[] args) {
        Unit3 unit3 = new Unit3();
        System.out.println(unit3.printTextPerRole(roles, textLines));
    }
    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        for (String role : roles) {
            sb.append(role).append(":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(role)) {
                    int c = j + 1;
                    sb.append(c).append(")").append(textLines[j].substring(role.length() + 1)).append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
