package com.junyang.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class ListSuijiUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List createRandomList(List list, int n) {
		Map map = new HashMap();
		List listNew = new ArrayList();
		if(list.size()<=n){
			return list;
		}else{
			while(map.size()<n){
				int random = (int) (Math.random() * list.size());
				if (!map.containsKey(random)) {
					map.put(random, "");
					listNew.add(list.get(random));
				}
			}
			return listNew;
		}
	}
	
	
	public static <T> List<List<T>> averageAssign(List<T> source, int n) {
	    List<List<T>> result = new ArrayList<List<T>>();
	    int remainder = source.size() % n;  //(先计算出余数)
	    int number = source.size() / n;  //然后是商
	    int offset = 0;//偏移量
	    for (int i = 0; i < n; i++) {
	        List<T> value = null;
	        if (remainder > 0) {
	            value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
	            remainder--;
	            offset++;
	        } else {
	            value = source.subList(i * number + offset, (i + 1) * number + offset);
	        }
	        result.add(value);
	    }
	    return result;
	}
	
}
