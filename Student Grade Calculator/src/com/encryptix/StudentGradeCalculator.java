package com.encryptix;
import java.util.Scanner;

class Student {
    private int[] marks;
    private int total;
    private double average;
    private char grade;

    public Student(int numSubjects) {
        marks = new int[numSubjects];
    }

    public void inputMarks() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < marks.length; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            int m = sc.nextInt();
            if (m < 0 || m > 100) {
                System.out.println("Marks should be between 0 and 100. Try again.");
                i--; // redo this iteration
            } else {
                marks[i] = m;
            }
        }
    }

    public void calculateResults() {
        for (int mark : marks) {
            total += mark;
        }
        average = (double) total / marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 80) grade = 'B';
        else if (average >= 70) grade = 'C';
        else if (average >= 60) grade = 'D';
        else if (average >= 50) grade = 'E';
        else grade = 'F';
    }

    public void displayResults() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Total Marks: " + total);
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);
    }
}

public class StudentGradeCalculator  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        Student student = new Student(numSubjects);
        student.inputMarks();
        student.calculateResults();
        student.displayResults();
    }
}
