import java.util.Scanner;

public class Main {
    // Входные данные
    public static String[] x = {"Нажатие кнопки ВКЛ/ВЫКЛ",
            "Нажатие кнопки Кофе",
            "Нажатие кнопки Молоко",
            "Контроль объёма жидкости (250 мл)"};

    // Выходные данные
    public static String[] y = {"Индикатор горит красным",
            "Индикатор горит зелёным",
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

    public static String condition, output;
    public static int condid = 0;
    public static int input = 99;
    public static boolean pouring = false; // Флаг, чтобы следить за состоянием льющейся жидкости

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < x.length - 1; i++) {
            System.out.println((i + 1) + ": " + x[i]);
        }

        while (true) {
            input = in.nextInt();
            while (input < 0 || input > 3) {
                System.out.println("Не верный ввод");
                input = in.nextInt();
            }
            machine(input);
        }
    }

    public static void machine(int input) {
        condition = Conditions[input - 1][condid];
        output = Output[input - 1][condid];
        System.out.println("Output: " + output);
        System.out.println("Condition: " + condition);

        if (condition.equals(z[2])) {
            pouring = true;
            Thread pouringThread = new Thread(() -> {
                try {
                    Thread.sleep(4000);
                    if (pouring) {
                        System.out.println("STOP signal");
                        machine(4);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            pouringThread.start();
        } else {
            pouring = false;
        }

        for (int i = 0; i < z.length; i++) { // тут меняем id у состояния
            if (z[i].equals(condition)) {
                condid = i;
                break;
            }
        }
    }
}
