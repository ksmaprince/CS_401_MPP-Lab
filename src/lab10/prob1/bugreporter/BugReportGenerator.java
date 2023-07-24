package lab10.prob1.bugreporter;

import lab10.prob1.classfinder.ClassFinder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.logging.Logger;

/**
 * This class scans the package lesson10.labs.prob2.javapackage
 * for classes with annotation @BugReport. It then generates a bug report, formatted like this:
 * 
 * Joe Smith
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 * Tom Jones
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 *     
 *     reportedBy:
 *     classname:
 *     description:
 *     severity:
 * 
 *
 */
public class BugReportGenerator {
	private static final Logger LOG = Logger.getLogger(BugReportGenerator.class.getName());
	private static final String PACKAGE_TO_SCAN = "lab10.prob1.javapackage";
	private static final String REPORT_NAME = "bug_report.txt";
	private static final String REPORTED_BY = "reportedBy: ";
	private static final String CLASS_NAME = "classname: ";
	private static final String DESCRIPTION = "description: ";
	private static final String SEVERITY = "severity: ";
	public void reportGenerator() {
		List<Class<?>> classes = ClassFinder.find(PACKAGE_TO_SCAN);
		
		//sample code for reading annotations -- you will need to change
		//this quite a bit to solve the problem
		//Sample code below obtains a list of names of developers assigned to bugs
		/*List<String> names = new ArrayList<String>();
		for(Class<?> cl : classes) {
			if(cl.isAnnotationPresent(BugReport.class)) {
				BugReport annotation = (BugReport)cl.getAnnotation(BugReport.class);
				String name = annotation.assignedTo();
				names.add(name);
			}
		}
		System.out.println(names);*/

		StringBuilder str = new StringBuilder();
		for (Class<?> aClass : classes) {
			if (aClass.isAnnotationPresent(BugReport.class)){
				BugReport anntonation = aClass.getAnnotation(BugReport.class);
				str.append(anntonation.assignedTo()+"\n");
				str.append("\t"+REPORTED_BY+anntonation.reportedBy()+"\n");
				str.append("\t"+CLASS_NAME+aClass+"\n");
				str.append("\t"+DESCRIPTION+anntonation.description()+"\n");
				str.append("\t"+SEVERITY+anntonation.severity()+"\n");
			}
		}


		try {
			String OUTPUT_DIR = System.getProperty("user.dir") + "/src/lab10/prob1/";
			FileWriter myWriter = new FileWriter(OUTPUT_DIR+"bug_report.txt");
			myWriter.write(str.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file. PLEASE check the file bug_report.txt in project directory");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	
	
}
