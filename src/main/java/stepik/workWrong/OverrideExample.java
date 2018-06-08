package stepik.workWrong;

public class OverrideExample extends ProFinal {
    private final String name = "test";

    @Override
    //Не final метод можно переопределить, а final нельзя
    public void ff() {
        super.ff();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return super.equals(obj);
    }

    public static void main(String[] args) {

    }
    @Override
    public String toString() {
        return "OverrideExample{" +
                "name='" + name + '\'' +
                '}';
    }


}
