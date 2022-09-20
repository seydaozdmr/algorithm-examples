package algorithms.datastructures;
import algorithms.Queue;
import algorithms.StdOut;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import algorithms.In;

public class readAllDatesExerc {
	private static Date[] readAllDates (String fileName) {
		Queue<Date> kuyruk=new Queue<>();
		/*
		File file=new File(fileName);
		
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			
			String line;
			while((line=br.readLine())!=null) {
				kuyruk.enqueue(new Date(line));
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		In in=new In(fileName);
		
		
		while(!in.isEmpty()) {
			kuyruk.enqueue(new Date(in.readString()));			
		}
		
		int n=kuyruk.size();
		
		Date[] dates=new Date[n];
		for(int i=0;i<n;i++) {
			dates[i]=kuyruk.dequeue();
		}
		return dates;
		
		
	}
	public static void main(String[] args) {
		
		String dateFilePath="dates.txt";
		
		Date[] dates=readAllDates(dateFilePath);
		
		for(Date i:dates) {
			StdOut.println(i);
		}

	}

}
