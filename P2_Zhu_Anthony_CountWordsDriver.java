/*Anthony Zhu, Period 2, 2/10/19
 * 3 hours
 * 
 * I expected this lab and in fact it did take a very long time. I did have a pretty good idea of how to convert the general logic 
 * of the lab into code but a lot of nitty-gritty details such as hyphenated words vs hyphens took me quite a while to fix. I used a lot 
 * of the techniques we learned in class and previous labs to help me with this lab, especially the Store lab. I decided to use Word objects
 * to store each string and its count so I could very easily mmanipulate the objects and sort them both by count and then alphabetically.
 * Overall, this was a more challenging lab because it required quite a bit of thinking but it was not the most challenging lab I have done.
 * 
 */


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class P2_Zhu_Anthony_CountWordsDriver {
	public static void main(String[] args) {
		Counter lincoln = new Counter("dream.txt");
		lincoln.sort();
		lincoln.displayCounter();
	}
}

class Word implements Comparable<Word> {
	private String name;
	private int count;

	public Word(String name) {
		this.name = name;
		count = 1;
	}

	public void addCount(int a) {
		count += a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int compareTo(Word other) {
		if (this.count != other.count) {
			return other.getCount() - this.getCount();
		} else {
			return this.getName().compareTo(other.getName());
		}
	}
}

class Counter {
	private ArrayList<Word> myCounter = new ArrayList<Word>();
	private int wordCount = 0;

	public Counter(String fName) {
		loadFile(fName);
	}

	private void loadFile(String fName) {
		Scanner input = new Scanner(System.in);
		try {
			input = new Scanner(new File(fName));
		} catch (IOException e) {
			System.out.println("Oops! File does not exist.");
		}
		while (input.hasNext()) {
			String name = input.next();
			if (!Character.isLetter(name.charAt(0)) && name.length()==1) {
				//to account for special characters and carriage returns
			} else {
				wordCount++;
				//remove punctuation
				for (int i = 0; i < name.length(); i++) {
					if (Character.isLetter(name.charAt(i)) || name.charAt(i) == 39 || name.charAt(i) == 45) {
						// keep it
					} else {
						name = name.substring(0, i) + name.substring(i + 1, name.length());
						i--;
					}
				}
				if (doesExist(name)) {
					myCounter.get(findWord(name)).addCount(1);
				} else {
					myCounter.add(new Word(name.toLowerCase()));
				}
			}
		}
	}

	public void sort() {
		mergeSort(myCounter, 0, myCounter.size() - 1);
	}

	public void displayCounter() {
		for (int i = 0; i< 30 && i < myCounter.size(); i++) {
			System.out.printf("%2d%4d  %s", i + 1, myCounter.get(i).getCount(), myCounter.get(i).getName());
			System.out.println();
		}
		System.out.println("Number of Unique Words used: = " + myCounter.size());
		System.out.println("Total # of Words = " + wordCount);
	}

	private void mergeSort(ArrayList<Word> a, int first, int last) {
		if (first == last) {
		} else if (last - first == 1) {
			if (a.get(last).compareTo(a.get(first)) < 0) {
				swap(a, first, last);
			}
		} else {
			// checked two conditions
			int midpoint = (first + last) / 2;
			mergeSort(a, first, midpoint);
			mergeSort(a, midpoint + 1, last);
			merge(a, first, midpoint, last);
		}
	}

	private void merge(ArrayList<Word> a, int first, int mid, int last) {
		int aIndex = first;
		int bIndex = mid + 1;
		ArrayList<Word> temp = new ArrayList<Word>();
		// checking conditions: steps +=2
		while (aIndex <= mid || bIndex <= last) {
			if (aIndex > mid) {
				temp.add(a.get(bIndex));
				bIndex++;
			} else if (bIndex > last) {
				temp.add(a.get(aIndex));
				aIndex++;
			} else if (a.get(aIndex).compareTo(a.get(bIndex)) < 0) {
				temp.add(a.get(aIndex));
				aIndex++;
			} else {
				temp.add(a.get(bIndex));
				bIndex++;
			}
		}
		for (int i = first; i <= last; i++) {
			a.set(i, temp.get(i - first));
		}
	}

	private void swap(ArrayList<Word> list, int a, int b) {
		Word temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}

	private boolean doesExist(String name) {
		for (int i = 0; i < myCounter.size(); i++) {
			if (myCounter.get(i).getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}

	private int findWord(String name) {
		for (int i = 0; i < myCounter.size(); i++) {
			if (myCounter.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		return -1;
	}
}