package id.jexpress.util;

import java.util.ArrayList;
import java.util.List;

public class PaginationUtil {

	public static Integer setShowingDataFrom(int pageSize, int page) {

		if (page == 1) {
			return 1;
		} else {
			return (pageSize * (page - 1)) + 1;
		}

	}
	
	public static Integer setShowingDataTo(int pageSize, int page, int totalData) {
		
		int max = page * pageSize;
		if (totalData > max) {
			return max;
		} else {
			return totalData;
		}
		
		
	}
	
	public static List<Integer> setPageArray(int totalPage, int page){
		
		if(totalPage==0){
			return null;
		}
		
		List<Integer> pageArray = new ArrayList<Integer>();
		List<Integer> pageArrayResult = new ArrayList<Integer>();
		for(int i=0; i<totalPage;){
			++i;
			pageArray.add(i);
		}
		
		int firstArray = pageArray.get(0);
		int lastArray = pageArray.get(totalPage-1);
		
		if(totalPage>2){
			if(page == firstArray){
				for(int i=0; i<3;){
					++i;
					pageArrayResult.add(i);
				}
			} else if(page == lastArray){
				for(int i=page-3; i<page;){
					++i;
					pageArrayResult.add(i);
				}
			} else {
				for(int i=page-2; i<page+1;){
					++i;
					pageArrayResult.add(i);
				}
			}
		} else if(totalPage==2) {
			if(page == firstArray){
				for(int i=0; i<2;){
					++i;
					pageArrayResult.add(i);
				}
			} else {
				for(int i=page-2; i<page;){
					++i;
					pageArrayResult.add(i);
				}
			}
		} else {
			for(int i=0; i<1;){
				++i;
				pageArrayResult.add(i);
			} 
		}
		
		return pageArrayResult;
		
	}

}
