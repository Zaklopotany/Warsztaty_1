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

		for (String strSites : popularSites) {
			Connection connect = Jsoup.connect(strSites);

			try {
				FileWriter fw1 = new FileWriter(file, true);
				Document document = connect.get();
				Elements links = document.select("span.title");

				for (Element elem : links) {
					String[] tempStr = elem.text().split("[/.,?!\"'-:;+=\\s]");
					// eliminating ""

					for (String strWords : tempStr) {
						if (!strWords.equals("") && strWords.length() > 3) {
							fw1.append(strWords).append("\n");
						}
					}

				}

				// sortowanie

//				 for (int i = 0; i < tempStr.length; i++) {
//				 if (!rankingMap.containsKey(tempStr[i]) &&
//				 tempStr[i].length() > 0) {
//				 rankingMap.put(tempStr[i], 1);
//				 } else if ( rankingMap.containsKey(tempStr[i]) ){
//				 rankingMap.put(tempStr[i], rankingMap.get(tempStr[i]) + 1);
//				 }
//				 }

				// List<Entry<String, Integer>> list = new
				// LinkedList<>(rankingMap.entrySet());
				//
				// Collections.sort(list, new Comparator<Entry<String,
				// Integer>>() {
				// public int compare(Entry<String, Integer> o1, Entry<String,
				// Integer> o2) {
				// return (o1.getValue()) - ( o2.getValue());
				// }
				// });

				// Iterator<Entry<String, Integer>> iter =
				// rankingMap.entrySet().iterator();
				//
				//
				//
				// // the key/value pair is stored here in pairs
				// Map.Entry<String, Integer> pairs = iter.next();
				//
				// FileWriter fw = new FileWriter("exce5.txt");
				// fw.append(pairs);

				fw1.close();
				// System.out.println(Arrays.toString(rankingMap.entrySet().toArray()));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				String str = scan.next();
				 if (!rankingMap.containsKey(str)) {
				 rankingMap.put(str, 1);
				 } else if ( rankingMap.containsKey(str) ){
				 rankingMap.put(str, rankingMap.get(str) + 1);
				 }
				 
			
		}

	}

	// public static TreeMap<String, Integer> sortMapByValue(HashMap<String,
	// Integer> map){
	// Comparator<String> comparator = new ValueComparator(map);
	// //TreeMap is a map sorted by its keys.
	// //The comparator is used to sort the TreeMap by keys.
	// TreeMap<String, Integer> result = new TreeMap<String,
	// Integer>(comparator);
	// result.putAll(map);
	// return result;
	// }

}
