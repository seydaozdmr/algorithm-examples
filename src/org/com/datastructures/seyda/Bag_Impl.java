package org.com.datastructures.seyda;

import algorithms.StdIn;
import algorithms.StdOut;

public class Bag_Impl {

	public static void main(String[] args) {
		Bag<Double> canta=new Bag<Double>();
		while(!StdIn.isEmpty()) {
			canta.add(StdIn.readDouble());
			int N=canta.size();
			double sum=0.0;
			for(double x:canta) {
				System.out.println("x: "+x);
				sum+=x;
			}
			double mean=sum/N;
			sum=0.0;
			for(double x: canta) {
				sum+=(x-mean)*(x-mean);
			}
			double std=Math.sqrt(sum/N-1);
			
			StdOut.printf("Mean: %.2f\n", mean);
			StdOut.printf("Std dev: %.2f\n", std);
		}

	}

}
