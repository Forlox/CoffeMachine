import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

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

    public static String condition, output;
    public static int input = 99;
    public static TimerTask STOP_signal = new TimerTask() {
        @Override
        public void run() {
            input=4;
            System.out.println("STOP signal");
            machine(input);
        }
    };


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for (int i=0;i<x.length-1;i++){
            System.out.println((i+1) + ": " + x[i]);
        }

        while (1==1) {
            input = in.nextInt();
            while (input<0 || input>3){
                System.out.println("Не верный ввод");
                input = in.nextInt();
            }
            machine(input);
        }
    }

    public static void machine(int input){
        Timer timer = new Timer();
        int condid = 0;
        condition = Conditions[input-1][condid];
        output = Output[input-1][condid];
        System.out.println("Output: " + output);
        System.out.println("Condition: " + condition);

        if (condition == z[2]){
            timer.schedule(STOP_signal, 2000);
        }

        for (int i = 0; i<z.length; i++){ // тут меняем id у состояния
            if (z[i] == condition){
                condid = i;
                break;
            }
        }
    }
}
