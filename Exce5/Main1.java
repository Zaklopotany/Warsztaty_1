package Exce5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main1 {
	
	public static void main(String[] args) {
		
		
		getRank();
	}

	
	
	static void getRank () {
		Map <String, Integer> rankingMap = new HashMap <>();

		
		
		Connection connect = Jsoup.connect("http://www.onet.pl/");
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    for (Element elem : links) {
		    	
		        System.out.println(elem.text());
		        
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
}
