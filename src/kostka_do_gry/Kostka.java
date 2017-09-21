package kostka_do_gry;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Kostka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		int result = 0;
		int type;
		System.out.println("podaj kod rzutu");
		String str = sc.nextLine();
		if (str.charAt(0) == 'D') {
			if (!(str.contains("+") || str.contains("-"))) {
				type = Integer.parseInt(str.substring(1, str.length()));
				result = rand.nextInt(type);
			} else if (str.contains("+")) {
				int index = str.indexOf('+');
				type = Integer.parseInt(str.substring(1, index));
				int change = Integer.parseInt(str.substring(index + 1, str.length()));
				result = rand.nextInt(type) + change;
			} else if (str.contains("-")) {
				int index = str.indexOf('-');
				type = Integer.parseInt(str.substring(1, index));
				int change = Integer.parseInt(str.substring(index + 1, str.length()));
				result = rand.nextInt(type) - change;
			}

		} else {
			int indexD = str.indexOf('D');
			int times = Integer.parseInt(str.substring(0, indexD));
			if (!(str.contains("+") || str.contains("-"))) {
				type = Integer.parseInt(str.substring(2, str.length()));
				for (int i = 0; i < times; i++) {
					result += rand.nextInt(type);
				}
			} else if (str.contains("+")) {
				int index = str.indexOf('+');
				type = Integer.parseInt(str.substring(2, index));
				int change = Integer.parseInt(str.substring(index + 1, str.length()));
				for (int i = 0; i < times; i++) {
					result += rand.nextInt(type);
				}
				result = result + change;
			} else if (str.contains("-")) {
				int index = str.indexOf('-');
				type = Integer.parseInt(str.substring(2, index));
				int change = Integer.parseInt(str.substring(index + 1, str.length()));
				for (int i = 0; i < times; i++) {
					result += rand.nextInt(type);
				}
				result = result - change;
			}

		}
		System.out.println(result);

	}
}

// xDy+z
//
// gdzie:
//
// y – rodzaj kostek, których należy użyć (np. D6, D10),
// x – liczba rzutów kośćmi; jeśli rzucamy raz, ten parametr jest pomijalny,
// z – liczba, którą należy dodać (lub odjąć) do wyniku rzutów (opcjonalnie).