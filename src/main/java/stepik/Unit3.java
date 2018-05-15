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
               "Лука Лукич: Господи боже! еще и с секретным предписаньем!}"};
    public static void main(String[] args) {
        List<Role> rolesList = new ArrayList<>();
        for(String r: roles){
            rolesList.add(new Role(r));
        }
        for(int i=0; i<textLines.length; i++){
            for(int j=0; j<roles.length; j++){
                if(textLines[i].startsWith(roles[j])){
                    rolesList.get(j).addReplic(new Replic(i+1,textLines[i].substring(roles[j].length()+1)));
                }
            }
        }
        rolesList.forEach(role -> {
            System.out.println(role.toString());
        });
    }
    public static class Replic {
        private int id;
        private String text;

        public Replic(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public int getId() {
            return id;
        }

        public String getText() {
            return text;
        }


    }
    public static class Role{
        private String name;
        private List<Replic> replics = new ArrayList<>();

        public Role(String name) {
            this.name = name;
        }

        private void addReplic(Replic replic){
            replics.add(replic);
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(name);
            sb.append("\n");
            replics.forEach(r->{
                sb.append(r.getId())
                        .append(") ")
                        .append(r.getText()).append("\n");
            });
            return  sb.toString();
        }
    }
}
