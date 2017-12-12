package Exce5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main1 {
	
	public static void main(String[] args) {
		
		
		getRank();
	}

	
	
	static <V> void getRank () {
		Map <String, Integer> rankingMap = new HashMap <>();
//		String tempStr = new String();
		String splitReg = new String("[/.,?!\"'-:;+=\\s]");
		String[] popularSites = {"http://www.onet.pl/","http://www.wp.pl/","http://www.interia.pl/"};
		Connection connect = Jsoup.connect("http://www.onet.pl/");
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    for (Element elem : links) {
		    	System.out.println(elem.text());
//		    	String strTemp = elem.text().replaceAll(splitReg, " ");
		    	String[] tempStr = elem.text().split("[/.,?!\"'-:;+=\\s]");
		    	//eliminating "" 
		    	for (int i = 0; i < tempStr.length; i++) {
		    		if (!rankingMap.containsKey(tempStr[i]) && tempStr[i].length() > 0) {
		    			rankingMap.put(tempStr[i], 1);
		    		} else 	if ( rankingMap.containsKey(tempStr[i]) ){
		    			rankingMap.put(tempStr[i], rankingMap.get(tempStr[i]) + 1);
		    		}
		    	}
//		        System.out.println(Arrays.toString(tempStr));
		    
		    	

		        List<Entry<String, Integer>> list = new LinkedList<>(rankingMap.entrySet());
		        
		        Collections.sort(list, new Comparator<Entry<String, Integer>>() {
		        	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		        		return (o1.getValue()) - ( o2.getValue());
		        	}
		        });
		        
//		        for(Map.Entry<String, Integer> entry:list){
//		            System.out.println(entry.getKey()+" ==== "+entry.getValue());
//		        }
		    
		
		    	
		    	
		    	
		        
		    }
	    	System.out.println(Arrays.toString(rankingMap.entrySet().toArray()));

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
	}
	
//	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
//		Comparator<String> comparator = new ValueComparator(map);
//		//TreeMap is a map sorted by its keys. 
//		//The comparator is used to sort the TreeMap by keys. 
//		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
//		result.putAll(map);
//		return result;
//	}
	
	
	
	
	
	
}
