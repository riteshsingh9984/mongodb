package com.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class Server {

	public static void main(String...strin){
		
		/*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		
		System.out.println(strings.size());
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println(filtered.size());*/
		
		Emp emp1 = new Emp();
		emp1.setName("OPL");
		emp1.setSalary(43643);
		
		Emp emp2 = new Emp();
		emp2.setName("OPS");
		emp2.setSalary(75665);
		
		Emp emp3 = new Emp();
		emp3.setName("AKL");
		emp3.setSalary(7657);
		
		Emp emp4 = new Emp();
		emp4.setName("OPL");
		emp4.setSalary(5344);
		
		Emp emp5 = new Emp();
		emp5.setName("ASS");
		emp5.setSalary(34324);
		
		Emp emp6 = new Emp();
		emp6.setName("ALK");
		emp6.setSalary(2349);
		
		Emp emp7 = new Emp();
		emp7.setName("UIO");
		emp7.setSalary(34563);
		
		List<Emp> emps = new ArrayList<Emp>();
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp5);
		emps.add(emp6);
		emps.add(emp7);
		
		Gson g = new Gson();
		System.out.println(g.toJson(emps));
		System.out.println(emps.size());
		List<Emp> efiltered = emps.stream().filter(emp -> (emp.getSalary() > 100)).collect(Collectors.toList());
		
		
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
		    UUID uuid = UUID.randomUUID();
		    values.add(uuid.toString());
		}
		
		/*for (int i = 0; i < max; i++) {
			emps.add(emp5);
		}*/
		
		long t0 = System.nanoTime();	
		System.out.println("t0="+t0);
		//long count = emps.stream().filter(emp -> (emp.getSalary() > 100)).count();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		System.out.println("t1="+t1);
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		
		long t2 = System.nanoTime();
		System.out.println("t2="+t2);
		//long count2 = emps.parallelStream().filter(emp -> (emp.getSalary() > 100)).count();
		long count2 = values.parallelStream().sorted().count();
		System.out.println(count2);
		long t3 = System.nanoTime();
		System.out.println("t3="+t3);
		long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
		System.out.println(String.format("Parallel sort took: %d ms", millis1));
		
		System.out.println(efiltered.size());
		System.out.println(g.toJson(efiltered));
	}
}

class Emp{

	private String name;
	private int salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
