public class Main {
    // Входные данные
    public static String[] x = {"Нажатие кнопки ВКЛ/ВЫКЛ",
            "Нажатие кнопки Кофе",
            "Нажатие кнопки Молоко",
            "Контроль объёма жидкости (250 мл)"};

    // Выходные данные
    public static String[] y = { "Машинка выключается",
            "Машинка включается - режим ожидания",
            "Наливание определённого объёма жидкости (Сигнал СТОП)",
            "Машинка льет кофе",
            "Машина льет молоко"};

    // Состояния
    public static String[] z = {"Машинка выключена",
            "Машинка включена - режим ожидания",
            "Машина наливает жидкость"};

    // Таблица состояний
    public static String[][] Conditions = {
            {z[1], z[0], z[2]},
            {z[0], z[2], z[1]},
            {z[0], z[2], z[1]},
            {z[0], z[1], z[1]}
    };
    //z2	z1	z3     - по старому
    //z1	z3	z2
    //z1	z3	z2
    //z1	z2	z2

    // Таблица выходных сигналов

    public static String[][] Output = {
            {y[1], y[0], y[1]},
            {y[0], y[3], y[1]},
            {y[0], y[4], y[1]},
            {y[0], y[1], y[2]}
    };
    //y2	y1	y2     - по старому
    //y1	y4	y2
    //y1	y5	y2
    //y1	y2	y3

    public static void main(String[] args) {
        System.out.println(Output[2][2]);
    }
}
