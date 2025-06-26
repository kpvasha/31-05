/*
Задача про сонячні панелі
Умова: Встановити якнайбільше панелей, які вміщуються на даху довжиною L.
 */
import java.util.Arrays;

public class SolarPanels {
    public static void main(String[] args) {
        int[] panels = {3, 2, 5, 1};
        int L = 7;

        for (int i = 0; i < panels.length - 1; i++) {
            for (int j = i + 1; j < panels.length; j++) {
                if (panels[i] > panels[j]) {
                    int temp = panels[i];
                    panels[i] = panels[j];
                    panels[j] = temp;
                }
            }
        }

        int total = 0;
        int count = 0;
        for (int i = 0; i < panels.length; i++) {
            if (total + panels[i] <= L) {
                total += panels[i];
                count++;
            }
        }

        System.out.println("Установлено панелей: " + count);
    }
}