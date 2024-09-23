import java.util.Scanner;

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
            "Машинка в режиме ожидания",
            "Машинка наливает жидкость"};

    // Таблица состояний
    public static String[][] Conditions = {
            {z[1], z[0], z[2]},
            {z[0], z[2], z[1]},
            {z[0], z[2], z[1]},
            {z[0], z[1], z[1]}
    };

    public static String[][] Output = {
            {y[1], y[0], y[1]},
            {y[0], y[3], y[1]},
            {y[0], y[4], y[1]},
            {y[0], y[1], y[2]}
    };


    public static void main(String[] args) {
        int condid = 0;
        Scanner in = new Scanner(System.in);

        for (int i=0;i<x.length;i++){
            System.out.println((i+1) + ": " + x[i]);
        }

        while (1==1) {
            int input = in.nextInt();
            String condition = Conditions[input-1][condid];
            String output = Output[input-1][condid];
            System.out.println("Output: " + output);
            System.out.println("Condition: " + condition); // Надо добавить таймер для контроля налитой жидкости

            for (int i = 0; i<z.length; i++){ // тут меняем id у состояния
                if (z[i] == condition){
                    condid = i;
                    break;
                }
            }
        }
    }
}
