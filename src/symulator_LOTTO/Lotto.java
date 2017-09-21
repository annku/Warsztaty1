package symulator_LOTTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		check(getNumbers(), getWinningNumbers());

	}

	public static ArrayList<Integer> getNumbers() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		System.out.println("podaj liczbę z zakresu 1-49");
		do {
			String str = sc.nextLine();
			if (str.matches("[0-9]{0,1}[0-9]{1}")) {

				int num = Integer.parseInt(str);
				if (num > 0 && num < 50) {
					if (!numbers.contains(num)) {
						numbers.add(num);
						if (numbers.size() < 6) {
							System.out.println("podaj liczbę z zakresu 1-49");
						} else {
							sc.close();
							break;
						}
					} else {
						System.out.println("ta liczba już była, podaj inną liczbę");
					}
				} else {
					System.out.println("liczba wykracza z zakresu 1-49, podaj liczbę");
				}
			} else {
				System.out.println("to nie jest liczba, podaj liczbę z zakresu 1-49");
			}
		} while (numbers.size() < 7);

		numbers.sort(null);
		System.out.println(numbers.toString());
		sc.close();
		return numbers;

	}

	public static ArrayList<Integer> getWinningNumbers() {
		Random r = new Random();
		ArrayList<Integer> win = new ArrayList<>();
		while (win.size() < 6) {
			int num = r.nextInt(49) + 1;
			if (!win.contains(num)) {
				win.add(num);
			}
		}
		win.sort(null);
		System.out.println(win.toString());
		return win;
	}

	public static String check(ArrayList<Integer> numbers, ArrayList<Integer> win) {
		int hits = 0;
		for (int i = 0; i < 6; i++) {
			if (win.contains(numbers.get(i))) {
				hits++;
			}
		}
		String winning = "";
		if (hits == 3) {
			winning = "trafiłeś trójkę";
		} else if (hits == 4) {
			winning = "trafiłeś czwórkę";
		} else if (hits == 5) {
			winning = "trafiłeś piątkę";
		} else if (hits == 6) {
			winning = "trafiłeś szóstkę";
		} else
			winning = "nie trafiłeś";
		System.out.println(winning);
		return winning;

	}
}
