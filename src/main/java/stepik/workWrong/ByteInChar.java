package stepik.workWrong;

public class ByteInChar {
    public static void main(String[] args) {
        //что относится к сигнатуре метода?
        //calculateAnswer(double, int, double, double)
        //К сигнатуре метода относится его название
        //тип возвращаемого значения порядок переменных тип переменных
        byte t = -50;
        char f = (char)t;
        System.out.println(f);
        // Пример перегрузки, переопределения, сигнатура -> main(String[] args)
        // Overload
        // Часто пользуемся перегрузкой конструктора

        //public double summa(double x1, double x2) {
        //    return x1 + x2;
        //}
        //
        //public double summa(double x1, int x2) {
        //    return x1 + x2;
        //}
        //Перегрузка это когда метод с одинаковым названием принимает разные параметры
        // Можно менять тип передаваемого значения
        // Количество переменных
        //Если названия у переменных поменять и тип передаваемого значения оставить тот же
        //Тогда компилятор выдаст ошибку
        //
    }
}
