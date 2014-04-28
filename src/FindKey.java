import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FindKey {

	public <T extends Comparable<T>> boolean findKey(List<T> list, T key){
		System.out.println("Input array:" + list);
		return findKeyRecur(list , key);
	}

	public <T extends Comparable<T>> boolean findKeyRecur(List<T> list, T key){
		System.out.println("Input List " + list);
		boolean result = false;
		if (list.size() == 1)
			if (list.get(0).compareTo(key) == 0)
				return true;
			else 
				return false;
		if(list.size()==0)
			return false;

		int middle = list.size()/2 ;
		System.out.println("Comparing key " + key + " with " + list.get(middle));
		System.out.println("Comparing key " + key + " with " + list.get(0));
		System.out.println( list.get(0).compareTo(key) );
		if (list.get(middle).compareTo(key) == 0){
			System.out.println("Return true");
			return true;
		}

		System.out.println("sort check " + list.get(0) + " " + list.get(middle));
		if (list.get(middle).compareTo(list.get(0)) > 0){
			//Left side is sorted
			System.out.println("Left is sorted");
			if((list.get(middle).compareTo(key) >= 0) && (list.get(0).compareTo(key) <= 0)){
				//Key is in Left sub list.
				System.out.println("Searching L in" + list.subList(0, middle));
				result = findKeyRecur(list.subList(0, middle), key);
			}
			else{
				System.out.println("Searching R in" + list.subList(middle + 1, list.size()));
				result = findKeyRecur(list.subList(middle + 1, list.size()), key);
			}
		}
		System.out.println("sort check " + list.get(middle) + " " + list.get(list.size()-1));
		if(list.get(middle).compareTo(list.get(list.size()-1)) < 0){
			//Right side is sorted
			System.out.println("Right is sorted");
			if ((list.get(middle).compareTo(key) <= 0) && (list.get(list.size()-1).compareTo(key) >= 0)){
				System.out.println("Searching R in" + list.subList(middle + 1, list.size()));
				result = findKeyRecur(list.subList(middle + 1, list.size()), key);
			}
			else{
				System.out.println("Searching L in" + list.subList(0, middle));
				result = findKeyRecur(list.subList(0, middle), key);

			}
		}
		return result;
	}
	public int rotatedSearch(int[] values, int start, int end, 
			int x){
		if(values[start] == x){
			return start;
		} else if(values[end] == x){
			return end;
		} else if(end - start == 1) {
			return -1;
		}
		int middle = (start + end) / 2;

		if(values[start] <= values[middle]){
			if(x <= values[middle] && x >= values[start]){
				return rotatedSearch(values, start, middle, x);
			} else {
				return rotatedSearch(values, middle, end, x);
			}
		} else if(values[middle] <= values[end]){
			if(x >= values[middle] && x <= values[end] ){
				return rotatedSearch(values, middle, end, x);
			} else {
				return rotatedSearch(values, start, middle, x);
			}
		} else {
			return -1;
		}
	}
	public static void main(String[] args) {
//		Scanner scnr = new Scanner(System.in);
//		String s = null;
//		ArrayList<Double> list = new ArrayList<Double>();
//		while (!(s = scnr.nextLine()).equals("END")){
//			list.add(Double.parseDouble(s));
//		}
//		System.out.println("Enter key:");
//		s = scnr.nextLine();
//		Double d = Double.parseDouble(s);
//		System.out.println((new FindKey()).findKey(list, d));
		int[] array = {6,5,4,3,2,1};
		System.out.println((new FindKey()).rotatedSearch(array, 0, 5, 5));
	}
}
