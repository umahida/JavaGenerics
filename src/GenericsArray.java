import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class GenericsArray {
	public static <E extends Comparable<E>> List<E> mergeSort(List<E> m) {
		if (m.size() <= 1) return m;

		int middle = m.size() / 2;
		List<E> left = m.subList(0, middle);
		List<E> right = m.subList(middle, m.size());

		right = mergeSort(right);
		left = mergeSort(left);
		List<E> result = merge(left, right);

		return result;
	}

	public static <E extends Comparable<E>> List<E> merge(List<E> left, List<E> right) {
		List<E> result = new ArrayList<E>();
		Iterator<E> it1 = left.iterator();
		Iterator<E> it2 = right.iterator();

		E x = it1.next();
		E y = it2.next();
		while (true) {
			//change the direction of this comparison to change the direction of the sort
			if (x.compareTo(y) <= 0) {
				result.add(x);
				if (it1.hasNext())
					x = it1.next();
				else {
					result.add(y);
					while (it2.hasNext())
						result.add(it2.next());
					break;
				}
			} else {
				result.add(y);
				if (it2.hasNext())
					y = it2.next();
				else {
					result.add(x);
					while (it1.hasNext())
						result.add(it1.next());
					break;
				}
			}
		}
		return result;
	}

	public static <T extends Comparable<? super T>> T returnMax(List<T> numbers){
		T max;

		if (numbers.size() > 0){
			max = numbers.get(0);
		}
		else{
			return null;
		}

		for (T number : numbers){
			if(number.compareTo(max)>0){
				max = number;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		ArrayList<Integer> list = new ArrayList<Integer>(); 

		try {
			while(!(line = bufferRead.readLine()).equals("END")) {
			    list.add(Integer.parseInt(line));
			}
			List<Integer> result = mergeSort(list);
			System.out.println("Sorted Array:" + result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
