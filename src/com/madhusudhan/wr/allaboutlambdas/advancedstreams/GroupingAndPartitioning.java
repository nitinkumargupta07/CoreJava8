package com.madhusudhan.wr.allaboutlambdas.advancedstreams;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.madhusudhan.wr.allaboutlambdas.domain.Employee;
import com.madhusudhan.wr.allaboutlambdas.util.EmployeeUtil;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;


/**
 * This class demonstrates the usage of groupingBy function
 * 
 * @author mkonda
 *
 */
public class GroupingAndPartitioning {

	List<Employee> employees = EmployeeUtil.createDetailedEmployees();

	/**
	 * Grouping by department function
	 */
	private void groupingByDepartment() {
		Map<String, List<Employee>> deptEmployees = employees.stream().collect(groupingBy(e -> e.getDepartment() ));
		Map<String,Long> dfggf=employees.stream().collect(groupingBy(e -> e.getDepartment() ,Collectors.counting() ));
		System.out.println(dfggf);
		System.out.println(deptEmployees);
	}

	/**
	 * Grouping by city
	 */
	private void groupingByCity() {
		Map<String, List<Employee>> cityEmployees = employees.stream()
				.collect(Collectors.groupingBy(Employee::getCity));
		System.out.println(cityEmployees);
	}

	/**
	 * Multi-level grouping usage: group employees by department and city
	 */
	private void groupingByDeptAndCity() {
		Map<String, Map<String, List<Employee>>> deptAndCityEmployees = employees.stream()
				.collect(groupingBy((Employee::getDepartment), groupingBy(Employee::getCity)));
		System.out.println(deptAndCityEmployees);
	}
	
	private void groupingByCityAndDept() {
		Map<String, Map<String, List<Employee>>> deptAndCityEmployees = employees.stream()
				.collect(groupingBy((Employee::getCity), groupingBy(Employee::getDepartment)));
		System.out.println(deptAndCityEmployees);
	}
	
	private void groupingByDeptAndCityAndRating() {
		Map<String, Map<String, Map<Integer, List<Employee>>>> deptAndCityAndRatingEmployees=employees.stream()
				.collect(groupingBy((Employee::getCity), groupingBy((Employee::getDepartment) ,groupingBy(Employee::getRatings))));
		
		Map<String, Map<String, Map<Integer, Map<Boolean, List<Employee>>>>> deptAndCityAndRatingEmployeesSenior = employees.stream()
				.collect(groupingBy((Employee::getCity), groupingBy((Employee::getDepartment) ,groupingBy((Employee::getRatings),groupingBy(Employee::isSenior)))));
		
		System.out.println(deptAndCityAndRatingEmployees);
		
	}

	private void partitionByExecutives() {
		Map<Boolean, List<Employee>> empPartition = employees.stream()
				.collect(Collectors.partitioningBy(Employee::isExecutive));

		System.out.println(empPartition);
	}

	private void partitioningAndGrouping() {
		Map<Boolean, Map<String, List<Employee>>> execEmployees = employees.stream()
				.collect(partitioningBy((Employee::isExecutive), groupingBy(Employee::getDepartment)));

		for (Boolean b : execEmployees.keySet()) {
			System.out.println(b + " --> " + execEmployees.get(b));
		}	
			
			Map<String, Map<Boolean, List<Employee>>> execEmployees11 = employees.stream()
					.collect(groupingBy((Employee::getDepartment), partitioningBy(Employee::isExecutive)));
			for(String d:execEmployees11.keySet()) {
				System.out.println(d + " --> " + execEmployees.get(d));
		}
	}

	private void multiLevelPartitioning() {
		Map<Boolean, Map<Boolean, List<Employee>>> execEmployees = employees.stream()
				.collect(partitioningBy((Employee::isExecutive), partitioningBy(Employee::isSenior)));
		
		 Set<Entry<Boolean, Map<Boolean, List<Employee>>>> fdgdf = execEmployees.entrySet();
		
		Map<Boolean, Map<Boolean, Map<Boolean, List<Employee>>>>dsfsfsd=employees.stream()
				.collect(partitioningBy((Employee::isExecutive), partitioningBy((Employee::isSenior),partitioningBy(Employee::isExecutive))));

		for (Boolean b : execEmployees.keySet()) {
			System.out.println(b + ":" + execEmployees.get(b));
		}

	}
	
	private void multiLevel2Partitioning() {
		Map<Boolean, Map<Boolean, Map<Boolean, List<Employee>>>> execEmployees =
				employees.stream()
				.collect(partitioningBy((Employee::isExecutive), partitioningBy((Employee::isSenior),partitioningBy(Employee::isExecutive))));

		for (Boolean b : execEmployees.keySet()) {
			System.out.println(b + ":" + execEmployees.get(b));
		}

	}

	public static void main(String[] args) {
		GroupingAndPartitioning groupingAndPartitioning=new GroupingAndPartitioning();
		
		groupingAndPartitioning.groupingByDepartment();
		groupingAndPartitioning.groupingByCity();
		groupingAndPartitioning.groupingByDeptAndCity();
		groupingAndPartitioning.groupingByCityAndDept();
		groupingAndPartitioning.groupingByDeptAndCityAndRating();
		groupingAndPartitioning.partitionByExecutives();
		groupingAndPartitioning.partitioningAndGrouping();
		groupingAndPartitioning.multiLevelPartitioning();
		groupingAndPartitioning.multiLevel2Partitioning();
	}

	
}
