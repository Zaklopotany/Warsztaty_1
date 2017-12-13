package Exce5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.org.apache.xml.internal.utils.Hashtree2Node;
import com.sun.xml.internal.fastinfoset.sax.Properties;

public class Main1 {

	public static void main(String[] args) {

		getRank();
	}

	static <V> void getRank() {
		Map<String, Integer> rankingMap = new HashMap<>();

		String splitReg = new String("[/.,?!\"'-:;+=\\s]");
		String[] popularSites = { "http://www.interia.pl/", "http://www.onet.pl/", "http://www.o2.pl/",
				"http://www.gazeta.pl/" };
		File file = new File("popular_words.txt");

		try {
			
			for (String strSites : popularSites) {
				
				Connection connect = Jsoup.connect(strSites);
				FileWriter fw1 = new FileWriter(file, true);
				Document document = connect.get();
				Elements links = document.select("span.title");

				for (Element elem : links) {
					String[] tempStr = elem.text().split("[/.,?!\"'-:;+=\\s]");
					// eliminating "" and short words
					for (String strWords : tempStr) {
						if (!strWords.equals("") && strWords.length() > 3) {
							fw1.append(strWords).append("\n");
						}
					}

				}

				fw1.close();
			}
			
			//count words
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String str = scan.next();
				if (!rankingMap.containsKey(str)) {
					rankingMap.put(str, 1);
				} else if (rankingMap.containsKey(str)) {
					rankingMap.put(str, rankingMap.get(str) + 1);
				}

			}

			// Sort and save to list
			List<Entry<String, Integer>> list = new LinkedList<>(rankingMap.entrySet());

			Collections.sort(list, new Comparator<Entry<String, Integer>>() {
				public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
					// sorting condition - descending
					return (o2.getValue()) - (o1.getValue());

				}
			});
			//select and write to new file 10 most popular words
			File fileRank = new File("most_popular_words.txt");
			FileWriter fwRank = new FileWriter(fileRank, true);

			for (int i = 0; i < 10; i++) {
				int endOfString = list.get(i).toString().indexOf("=");
				fwRank.append(list.get(i).toString().substring(0, endOfString)).append("\n");
			}
			fwRank.close();

			scan.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}

	}



}
