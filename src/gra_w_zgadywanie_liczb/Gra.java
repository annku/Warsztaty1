package gra_w_zgadywanie_liczb;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Gra {

	public static void main(String[] args) {
		
		Random r = new Random();
		int number = r.nextInt(100);
		boolean quessed = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Zgadnij liczbę");
		while (!sc.hasNextInt()) {
			sc.next();
		System.out.println("To nie jest liczba");
		}
		
	try {
		while (!quessed) {
			
				int quess = sc.nextInt();
		//		System.out.println("quess: " + quess + " number: " + number);

			
				if (quess == number) {
					quessed = true;
					System.out.println("Zgadłeś");
				} else if (quess > number) {
					System.out.println("Za dużo!");
					System.out.println("Zgadnij liczbę");
				} else {
					System.out.println("Za mało!");
					System.out.println("Zgadnij liczbę");
				}
				
		}
		} catch (InputMismatchException e) {
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.println("To nie jest liczba");
			}
		}
	
		sc.close();
	}
}

// "Napisz prostą grę w zgadywanie liczb. Komputer musi wylosować liczbę w"
// zakresie od 1 do 100. Następnie:
//
// Zadać pytanie: "Zgadnij liczbę" i pobrać liczbę z klawiatury.
// Sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu
// wyświetlić komunikat "To nie jest liczba", po czym wrócić do pkt. 1
// Jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana,
// wyświetlić komunikat "Za mało!", po czym wrócić do pkt. 1.
// Jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić
// komunikat "Za dużo!", po czym wrócić do pkt. 1.
// Jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić
// komunikat "Zgadłeś!", po czym zakończyć działanie programu.
// Przykład:
//
// Zgadnij liczbę: cześć
// To nie jest liczba.
// Zgadnij liczbę: 50
// Za mało!
// Zgadnij liczbę: 75
// Za dużo!
// Zgadnij liczbę: 63
// Zgadłeś!