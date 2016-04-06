package com.asdco.nas.client;

import java.util.HashMap;
import java.util.Map;



public class Test {

	
	public static void main(String[] args) {
		Map map = new Test().createPeramiterMap("45",67,"78",23,"46",67,"76",23);
		System.out.println("Hello world");
	}

		private Map<String, Object> createPeramiterMap(Object... listOfPram) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			//Object[] newArray = { "id", 23 };
			for (int i = 0; i < listOfPram.length/2; i++) {
				map.put((String) listOfPram[i*2], listOfPram[i*2+1]);
				
			}
			System.out.println(map);
			
			/**
			 * Get thet first object, write it to the map pos1[stringof][pram1]
			 * pos2[][pram2] pos3[][pram3]
			 * 
			 **/
			return map;
		}
}
