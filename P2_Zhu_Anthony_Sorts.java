/*
 * Anthony Zhu, 1/16/18, Period 2

 * 1 hour
 * 
 * This lab was a good review of all of the different sorts. I rewrote them all from scratch and then double checked with my work sheets to make sure
 * they were right and didn't take needless steps. Counting the steps took me a while and I am still not entirely sure if I did them correctly.
 * It was really cool graphing out the different step numbers and seeing how each sort compared to one another from relatively smaller numbers to
 * relatively bigger numbers.
 * 
 * 
 * Anthony Zhu, 1/22/18, Period 2
 * 
 * 1 hour 30 minutes
 * 
 * This lab was quite challenging because the instructions were not very specific so I had to figure out how the merge method needed to work
 * and how to code it. The merge sort method was relatively easy and so was counting steps because we had received very clear instructions
 * on how to do that. After my first draft of code, my results were all over the place so I messed around in the debugging perspective and I realized
 * that something was off with my merge method. It turns out, I replaced the entire a array with temp instead of only the neccesary section, and I fixed that issue
 * by writing a for loop. Overall, this lab took a lot more thinking than the previous labs.
 */



/*Anthony Zhu, 2/6/19, Period 2
 * 4 hours
 * 
 * Reflection:
 * Overall, this lab was very interesting and I learned a lot from it. When I first started looking at QuickSort, 
 * I had no idea how I was going to code it, but after I picked through the videos I found and studied them, I got a firm grasp 
 * of the general structure. After that, I attempted to put my understanding of how QuickSort worked into code although I ran into 
 * many errors with indexes and no-base-case recursions. I had to spent a lot of time and effort fixing these errors but once I did 
 * that, adding a modified version of InsertionSort in to QuickSort was very easy. This has definitely been one of the more 
 * challenging labs but I enjoyed doing it.
 */


import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class P2_Zhu_Anthony_Sorts{
  private long steps;

  /**
   *  Description of Constructor
   *
   * @param  list  Description of Parameter
   */
  public P2_Zhu_Anthony_Sorts(){
    steps = 0;
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void bubbleSort(ArrayList <Comparable> list){
	//int i = list.size()-2
	steps += 4;
	//checking i >= 0;
	steps += 1;
	for(int i = list.size()-2; i >= 0; i --) {
		//initializing/setting j and checking condition
		steps += 3;
		for(int j = 0; j <= i; j++) {
			//if statement
			steps += 5;
			if (list.get(j).compareTo(list.get(j+1)) > 0) {
				steps +=1;
				swap(list, j, j+1);
			}
			//incrementing and checking condition
			steps += 2;
		}
		//incrementing and checking condition
		steps += 2;
	}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void selectionSort(ArrayList <Comparable> list){
	//int i = list.size()-1
	steps += 4;
	//checking condition
	steps += 1;
	for(int i = list.size()-1; i >= 1; i --) {
		steps += 2;
		int max = 0;
		//initializing j and checking condition
		steps += 3;
		for(int j = 1; j <= i; j++) {
			steps += 4;
			if(list.get(j).compareTo(list.get(max)) > 0) {
				steps += 2;
				max = j;
			}
			//incrementing and checking condition
			steps += 2;
		}
		steps += 1;
		swap(list, max, i);
		//incrementing and checking condition
		steps += 2;
	}
  }

  /**
   *  Description of the Method
   *
   * @param  list  reference to an array of integers to be sorted
   */
  public void insertionSort(ArrayList <Comparable> list){
	//initializing i
	steps += 2;
	//checking condition
	steps += 3;
	for (int i = 1; i < list.size(); i ++) {
		//initializing temp and index
		steps += 5;
		Comparable temp = list.get(i);
		int index = i;
		//checking conditions
		steps += 4;
		while(index > 0 && temp.compareTo(list.get(index-1)) < 0) {
			steps += 4;
			list.set(index,  list.get(index-1));
			index--;
			//check condition
			steps += 4;
		}
		
		list.set(index, temp);
		//check condition and increment
		steps += 4;
	}
  }


 /**
   *  Takes in entire vector, but will merge the following sections
   *  together:  Left sublist from a[first]..a[mid], right sublist from
   *  a[mid+1]..a[last].  Precondition:  each sublist is already in
   *  ascending order
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  mid    midpoint index of range of values to be sorted
   * @param  last   last index of range of values to be sorted
   */
  private void merge(ArrayList <Comparable> a, int first, int mid, int last){
	//intialize counters
	steps += 5;
	int aIndex = first;
	int bIndex = mid+1;
	ArrayList<Comparable> temp = new ArrayList<Comparable>();
	//checking conditions: steps +=2
	while (aIndex <= mid || bIndex <= last) {
		if(aIndex > mid) {
			steps += 1;
			//only checked one condition
			steps += 3;
			temp.add(a.get(bIndex));
			bIndex++;
		}
		else if(bIndex > last) {
			steps += 2;
			//checked two conditions
			steps += 3;
			temp.add(a.get(aIndex));
			aIndex++;
		}
		else if(a.get(aIndex).compareTo(a.get(bIndex)) < 0) {
			steps += 6;
			//checked three conditions
			steps += 3;
			temp.add(a.get(aIndex));
			aIndex++;
		}
		else {
			steps += 6;
			//checked three conditions
			steps += 3;
			temp.add(a.get(bIndex));
			bIndex++;
		}
		//checking conditions: 
		steps +=2;
	}
	//put temp back into a
	//initializing variables and checking condition
	steps +=3;
	for(int i = first; i <= last; i++) {
		steps += 3;
		a.set(i ,temp.get(i-first));
		//incrementing and checking condition:
		steps += 2;
	}
  }

  /**
   *  Recursive mergesort of an array of integers
   *
   * @param  a      reference to an array of integers to be sorted
   * @param  first  starting index of range of values to be sorted
   * @param  last   ending index of range of values to be sorted
   */
  public void mergeSort(ArrayList <Comparable> a, int first, int last){
	if (first==last) {
		steps += 1;
		//checked one condition
	}
	else if (last-first == 1) {
		//checked two conditions 
		steps += 3;
		//checking second if statement
		steps += 4;
		if(a.get(last).compareTo(a.get(first)) < 0) {
			steps += 1;
			swap(a, first, last);
		}
	}
	else {
		//checked two conditions 
		steps += 3;
		steps += 8;
		int midpoint = (first+last)/2;
		mergeSort(a, first, midpoint);
		mergeSort(a, midpoint+1, last);
		merge(a, first, midpoint, last);
	}
  }
  
  public void quickSort(ArrayList<Comparable> a, int first, int last) {
	  //check the conditions:
	  steps += 2;
	  if(last-first <= 9) {
		 steps += 2;
		 modInsertionSort(a, first, last);
	  }
	  else {
		  steps += 3;
		  int pivotLocation = partition(a, first, last);
		  steps += 2;
		  quickSort(a, first, pivotLocation-1);
		  steps += 2;
		  quickSort(a, pivotLocation+1, last);
	  }
	  
  }
  
  
  private void modInsertionSort(ArrayList<Comparable> a, int first, int last) {
	 //initialize and check condition
	 steps += 4;
	 for(int i = first + 1; i <= last; i++) {
		steps += 3;
		Comparable temp = a.get(i);
		steps += 2;
		int index = i;
		steps += 5;
		while(index > first && a.get(index-1).compareTo(temp) > 0) {
			steps += 3;
			a.set(index, a.get(index-1));
			steps += 1;
			index--;
			steps += 5;
		}
		steps += 1;
		a.set(index, temp);
		//increment and check condition
		steps += 2;
	}
  }

private int partition(ArrayList<Comparable> a, int first, int last) {
	 steps += 4;
	 ArrayList<Comparable> high = new ArrayList<Comparable>();
	 ArrayList<Comparable> low = new ArrayList<Comparable>();
	 steps += 3;
	 Comparable pivot = a.get(first);
	 steps += 5;
	 for(int i = first+1; i < last + 1; i++) {
		 steps += 3;
		 if(a.get(i).compareTo(pivot) > 0) {
			 steps += 1;
			 high.add(a.get(i));
		 }
		 else {
			 steps += 1;
			 low.add(a.get(i));
		 }
		 steps += 3;
	 }
	 steps += 4;
	 int pivotLocation = first + low.size();
	 steps += 2;
	 low.add(pivot);
	 low.addAll(high);
	 //replaces the a array with the right values
	 steps += 3;
	 for(int j = first; j <= last; j++) {
		 steps += 3;
		 a.set(j, low.get(j-first));
		 steps += 2;
	 }
	 steps += 1;
	 return pivotLocation;
  }

 
  /**
   *  Accessor method to return the current value of steps
   *
   */
  public long getStepCount(){
    return steps;
  }

  /**
   *  Modifier method to set or reset the step count. Usually called
   *  prior to invocation of a sort method.
   *
   * @param  stepCount   value assigned to steps
   */
  public void setStepCount(long stepCount){
    steps = stepCount;
  }
  
   /**
   *  Interchanges two elements in an ArrayList
   *
   * @param  list  reference to an array of integers
   * @param  a     index of integer to be swapped
   * @param  b     index of integer to be swapped
   */
  public void swap(ArrayList <Comparable> list, int a, int b){
	steps += 6;
	Comparable temp = list.get(a);
	list.set(a, list.get(b));
	list.set(b, temp);
  }
}