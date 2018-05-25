package stepik.workWrong;

public class OverrideExample extends ProFinal {
    private String name;

    @Override
    //Не final метод можно переопределить, а final нельзя
    public void ff() {
        super.ff();
    }

    @Override
    public String toString() {
        return "OverrideExample{" +
                "name='" + name + '\'' +
                '}';
    }
}
