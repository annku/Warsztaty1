package gra_w_zgadywanie_liczb_2;

import java.util.Scanner;

public class Zgadywanie {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.out.println("Pomysl liczbę od 0 do 1000 a ja ją zgadnę w maksymalnie 10 próbach");
		Scanner sc = new Scanner(System.in);
		int min = 0;
		int max = 1000;
		boolean guessed = false;
		int i = 0;
		while (!false && i < 10) {
			int guess = (max - min) / 2 + min;
			Thread.sleep(1500);                     //opóźnia wyświetlanie
			System.out.println("Zgaduję: " + guess);
			String answer = sc.nextLine();
		
			if (answer.equals("za dużo")) {
				max = guess;
			} else if (answer.equals("za mało")) {
				min = guess;
			} else {
				guessed = true;
				System.out.println("wygrałem!");
				break;
			}
			i++;

		}

	}

}
