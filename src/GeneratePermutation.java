import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GeneratePermutation {

	public void printPermutation(ArrayList<Integer> aList){
		System.out.println("Starting");
		List<ArrayList<Integer>> results = recursiveInt(aList);
		System.out.println("END");
		for (Iterator iterator = results.iterator(); iterator.hasNext();) {
			ArrayList<Integer> arrayList = (ArrayList<Integer>) iterator.next();
			System.out.println(aL2String(arrayList));
		}
	}
	
	public List<ArrayList<Integer>> recursiveInt(ArrayList<Integer> aList){
		System.out.println("Input to recursive:" + aL2String(aList));
		if (aList.size() <= 1){
			List l = new ArrayList<ArrayList<Integer>>();
			l.add(aList);
			System.out.println("Border case" + aL2String(aList));
			return l;
		}
		else{
			ArrayList<Integer> subList = new ArrayList<Integer>();
			System.out.println("Size " + aList.size());
			for (int i = 0; i < aList.size() - 1; i++) {
				System.out.println(aList.get(i));
				subList.add(aList.get(i));
			}
			System.out.println("Passing " + aL2String(subList));
			List<ArrayList<Integer>> rLists = (List<ArrayList<Integer>>) recursiveInt(subList);
			Integer i = aList.get(aList.size()-1);
			System.out.println("Last element " + i);
			List<ArrayList<Integer>> rrLists = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> rList : rLists){
				rrLists.add(rList);
				for (int j = 0; j <= rList.size(); j++) {
					ArrayList<Integer> rrList = new ArrayList<Integer>();
					for (int k = 0; k < rList.size(); k++) {
						rrList.add(rList.get(k));
					}
					rrList.add(j, i);
					System.out.println("adding " + aL2String(rList));
					rrLists.add(rrList);
				}
			}
			return rrLists;
		}
	}
	
	public String aL2String(ArrayList<Integer> s){
		String listString = "";

		for (Integer i : s)
		{
		    listString += i + ",";
		}
		return listString;
	}
	
	public static void main(String[] args) {
		GeneratePermutation cp = new GeneratePermutation();
		ArrayList<Integer> ip = new ArrayList<Integer>();
		ip.add(1);
		ip.add(2);
		ip.add(3);
		cp.printPermutation(ip);
	}
	
}
