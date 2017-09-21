package wyszukiwarka_najpopularniejszych_słów;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 * not finished
 */
public class Wyszukiwarka {

	public static void main(String[] args) throws IOException {

		Path path = Paths.get("popular_words.txt");
		Files.createFile(path);
		FileWriter out = new FileWriter("popular_words.txt");

		Connection connect = Jsoup.connect("http://www.onet.pl/");
		try {
			Document document = connect.get();
			Elements links = document.select("span.title");
			for (Element elem : links) {
				// System.out.println(elem.text());
				out.append(elem.text() + "\n");
			} // -------------------------------- Przykład pobrania tytułów z tagu html span z
				// atrybutem class o wartości title
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Path path1 = Paths.get("popular_words.txt");
		ArrayList<String> words = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		try {
			for (String line : Files.readAllLines(path1)) {
				sb.append(line);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// System.out.println(words.toString());
		System.out.println(sb.toString());
		String word = sb.toString();
		String word1 = word.replaceAll("\"", "").replaceAll(",", "").replaceAll(".", "");
		System.out.println(word1);
		String[] tab = word1.split(" ");
		System.out.println(Arrays.toString(tab));
		ArrayList<String> exc = new ArrayList<>();
		ArrayList<String> frequent = new ArrayList<>();
		ArrayList<Integer> howManyT = new ArrayList<>();
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].length() < 3) {
				exc.add(tab[i]);
			} else {
				words.add(tab[i]);
			}
		}
		boolean war = true;
		int i = 0;
		while (war) {
			String single = words.get(i);
			System.out.println(single);
			frequent.add(single);
			int count = 0;
			while (words.contains(single)) {
				words.remove(single);
				System.out.println("single "+single);
				System.out.println("count "+count);
				count++;
			}
			String coun = count + "";
			frequent.add(coun);
			i++;
			if (i == words.size() - 1) {
				war = false;
			}

		}
		System.out.println(words);
		System.out.println(frequent);

		//
		// System.out.println("za krótkie "+exc.toString());
		// words.sort(null);
		// int i = 0;
		// int howMany = 0;
		// while (i < words.size() - 1) {
		// if (words.get(i).equals(words.get(i + 1))) {
		// frequent.add(words.get(i));
		// words.remove(words.get(i + 1));
		// howMany++;
		//
		// } else {
		// i++;
		// }
		//
		// howManyT.add(howMany);
		// }
		//
		// ArrayList <Integer>sorted=howManyT;
		// sorted.sort(null);
		// for(int j=0;j<sorted.size()-10;j++) {
		// sorted.remove(j);
		// // System.out.println("sorted "+sorted.toString());
		// }
		// for(int k=0;k<10;k++) {
		// int num=sorted.get(k);
		// System.out.println("num "+num);
		// String word2=frequent.get(howManyT.indexOf(num));
		// System.out.println(word2);
		// }
		// System.out.println(words.toString());
		// System.out.println(howManyT.toString());

	}

}
