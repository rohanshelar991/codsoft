package com.codsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/**
 * CODSOFT Task 2: Student Grade Calculator
 * 
 * Features:
 * 1. Input marks for multiple subjects (out of 100)
 * 2. Calculate total marks
 * 3. Calculate average percentage
 * 4. Assign grades based on percentage
 * 5. Display detailed results
 * 6. Input validation
 */
public class StudentGradeCalculator {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String[] DEFAULT_SUBJECTS = {
        "Mathematics", "Science", "English", "History", "Geography"
    };
    
    // Performance tracking
    private int totalStudents = 0;
    private double classAverage = 0.0;
    private String bestStudent = "";
    private double bestAverage = 0.0;
    private List<String> topPerformers = new ArrayList<>();
    private Map<String, Integer> subjectStats = new HashMap<>();
    
    public static void main(String[] args) {
        StudentGradeCalculator calculator = new StudentGradeCalculator();
        calculator.displayWelcomeMessage();
        
        boolean continueCalculating = true;
        while (continueCalculating) {
            calculator.calculateGrades();
            continueCalculating = calculator.askToContinue();
        }
        
        calculator.displayClassSummary();
        
        System.out.println("Thank you for using Student Grade Calculator! 📚");
        System.out.println("#codsoft #internship #javadevelopment");
        scanner.close();
    }
    
    private void displayWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                 STUDENT GRADE CALCULATOR                    ║");
        System.out.println("║                       CODSOFT Task 2                        ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.println("║  Features:                                                   ║");
        System.out.println("║  • Calculate total marks from multiple subjects             ║");
        System.out.println("║  • Compute average percentage                               ║");
        System.out.println("║  • Assign grades based on performance                       ║");
        System.out.println("║  • Detailed performance analysis                            ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private void calculateGrades() {
        System.out.println("📝 STUDENT GRADE CALCULATION");
        System.out.println("=" .repeat(50));
        
        // Get student information
        String studentName = getStudentName();
        int numSubjects = getNumberOfSubjects();
        
        // Get marks for each subject
        List<Subject> subjects = getSubjectMarks(numSubjects);
        
        // Calculate results
        GradeResult result = calculateResults(subjects);
        
        // Update class statistics
        updateClassStats(studentName, result);
        
        // Display results
        displayResults(studentName, subjects, result);
    }
    
    private String getStudentName() {
        System.out.print("👤 Enter student name: ");
        String name = scanner.nextLine().trim();
        return name.isEmpty() ? "Student" : name;
    }
    
    private int getNumberOfSubjects() {
        while (true) {
            System.out.print("📚 Enter number of subjects (1-10): ");
            try {
                int numSubjects = Integer.parseInt(scanner.nextLine().trim());
                if (numSubjects >= 1 && numSubjects <= 10) {
                    return numSubjects;
                } else {
                    System.out.println("❌ Please enter a number between 1 and 10!");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private List<Subject> getSubjectMarks(int numSubjects) {
        List<Subject> subjects = new ArrayList<>();
        
        System.out.println("\n📊 Enter marks for each subject (out of 100):");
        System.out.println("-" .repeat(50));
        
        for (int i = 0; i < numSubjects; i++) {
            String subjectName = getSubjectName(i);
            int marks = getSubjectMarks(subjectName);
            subjects.add(new Subject(subjectName, marks));
        }
        
        return subjects;
    }
    
    private String getSubjectName(int index) {
        if (index < DEFAULT_SUBJECTS.length) {
            System.out.print("📖 Subject " + (index + 1) + " (" + DEFAULT_SUBJECTS[index] + "): ");
            String input = scanner.nextLine().trim();
            return input.isEmpty() ? DEFAULT_SUBJECTS[index] : input;
        } else {
            System.out.print("📖 Subject " + (index + 1) + ": ");
            return scanner.nextLine().trim();
        }
    }
    
    private int getSubjectMarks(String subjectName) {
        while (true) {
            System.out.print("   Enter marks for " + subjectName + " (0-100): ");
            try {
                int marks = Integer.parseInt(scanner.nextLine().trim());
                if (marks >= 0 && marks <= 100) {
                    return marks;
                } else {
                    System.out.println("   ❌ Marks must be between 0 and 100!");
                }
            } catch (NumberFormatException e) {
                System.out.println("   ❌ Invalid input! Please enter a valid number.");
            }
        }
    }
    
    private GradeResult calculateResults(List<Subject> subjects) {
        int totalMarks = 0;
        int maxPossibleMarks = subjects.size() * 100;
        
        for (Subject subject : subjects) {
            totalMarks += subject.getMarks();
        }
        
        double averagePercentage = (double) totalMarks / maxPossibleMarks * 100;
        String grade = calculateGrade(averagePercentage);
        
        return new GradeResult(totalMarks, maxPossibleMarks, averagePercentage, grade);
    }
    
    private String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B+";
        else if (percentage >= 60) return "B";
        else if (percentage >= 50) return "C+";
        else if (percentage >= 40) return "C";
        else if (percentage >= 35) return "D";
        else return "F";
    }
    
    private void displayResults(String studentName, List<Subject> subjects, GradeResult result) {
        System.out.println("\n" + "=" .repeat(60));
        System.out.println("📊 GRADE REPORT");
        System.out.println("=" .repeat(60));
        System.out.println("👤 Student Name: " + studentName);
        System.out.println("📚 Number of Subjects: " + subjects.size());
        System.out.println();
        
        // Display individual subject marks
        System.out.println("📖 SUBJECT-WISE MARKS:");
        System.out.println("-" .repeat(40));
        for (Subject subject : subjects) {
            String status = subject.getMarks() >= 40 ? "✅" : "❌";
            System.out.printf("   %-15s: %3d/100 %s%n", 
                subject.getName(), subject.getMarks(), status);
        }
        System.out.println();
        
        // Display summary
        System.out.println("📈 PERFORMANCE SUMMARY:");
        System.out.println("-" .repeat(40));
        System.out.printf("   Total Marks Obtained: %d/%d%n", 
            result.getTotalMarks(), result.getMaxPossibleMarks());
        System.out.printf("   Average Percentage: %.2f%%%n", result.getAveragePercentage());
        System.out.printf("   Grade: %s%n", result.getGrade());
        System.out.println();
        
        // Display grade interpretation
        displayGradeInterpretation(result.getGrade(), result.getAveragePercentage());
        
        // Display performance analysis
        displayPerformanceAnalysis(subjects, result);
    }
    
    private void displayGradeInterpretation(String grade, double percentage) {
        System.out.println("🎯 GRADE INTERPRETATION:");
        System.out.println("-" .repeat(40));
        
        String interpretation;
        switch (grade) {
            case "A+":
                interpretation = "Outstanding Performance! Excellent work! 🌟";
                break;
            case "A":
                interpretation = "Very Good Performance! Keep it up! 👍";
                break;
            case "B+":
                interpretation = "Good Performance! Room for improvement. 📈";
                break;
            case "B":
                interpretation = "Above Average Performance! 📊";
                break;
            case "C+":
                interpretation = "Average Performance. Need more effort. 💪";
                break;
            case "C":
                interpretation = "Below Average. Requires attention. ⚠️";
                break;
            case "D":
                interpretation = "Poor Performance. Needs significant improvement. 🔴";
                break;
            case "F":
                interpretation = "Fail. Requires immediate attention and support. 🚨";
                break;
            default:
                interpretation = "Grade not available.";
                break;
        }
        
        System.out.println("   " + interpretation);
        System.out.println();
    }
    
    private void displayPerformanceAnalysis(List<Subject> subjects, GradeResult result) {
        System.out.println("📊 DETAILED ANALYSIS:");
        System.out.println("-" .repeat(40));
        
        // Find best and worst subjects
        Subject bestSubject = subjects.get(0);
        Subject worstSubject = subjects.get(0);
        
        for (Subject subject : subjects) {
            if (subject.getMarks() > bestSubject.getMarks()) {
                bestSubject = subject;
            }
            if (subject.getMarks() < worstSubject.getMarks()) {
                worstSubject = subject;
            }
        }
        
        System.out.printf("   🏆 Best Subject: %s (%d/100)%n", 
            bestSubject.getName(), bestSubject.getMarks());
        System.out.printf("   📉 Needs Improvement: %s (%d/100)%n", 
            worstSubject.getName(), worstSubject.getMarks());
        
        // Calculate subjects passed/failed
        long subjectsPassed = subjects.stream()
            .filter(s -> s.getMarks() >= 40)
            .count();
        long subjectsFailed = subjects.size() - subjectsPassed;
        
        System.out.printf("   ✅ Subjects Passed: %d%n", subjectsPassed);
        System.out.printf("   ❌ Subjects Failed: %d%n", subjectsFailed);
        
        // Performance level
        String performanceLevel = getPerformanceLevel(result.getAveragePercentage());
        System.out.printf("   📊 Overall Performance: %s%n", performanceLevel);
        
        System.out.println("=" .repeat(60));
    }
    
    private String getPerformanceLevel(double percentage) {
        if (percentage >= 90) return "Exceptional 🌟";
        else if (percentage >= 80) return "Excellent ⭐";
        else if (percentage >= 70) return "Very Good 👍";
        else if (percentage >= 60) return "Good 📈";
        else if (percentage >= 50) return "Average 📊";
        else if (percentage >= 40) return "Below Average ⚠️";
        else if (percentage >= 35) return "Poor 🔴";
        else return "Very Poor 🚨";
    }
    
    private boolean askToContinue() {
        while (true) {
            System.out.print("\n🔄 Calculate grades for another student? (y/n): ");
            String response = scanner.nextLine().trim().toLowerCase();
            
            if (response.equals("y") || response.equals("yes")) {
                System.out.println();
                return true;
            } else if (response.equals("n") || response.equals("no")) {
                return false;
            } else {
                System.out.println("❌ Please enter 'y' for yes or 'n' for no.");
            }
        }
    }
    
    // Inner classes for data organization
    private static class Subject {
        private final String name;
        private final int marks;
        
        public Subject(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
        
        public String getName() { return name; }
        public int getMarks() { return marks; }
    }
    
    private static class GradeResult {
        private final int totalMarks;
        private final int maxPossibleMarks;
        private final double averagePercentage;
        private final String grade;
        
        public GradeResult(int totalMarks, int maxPossibleMarks, 
                          double averagePercentage, String grade) {
            this.totalMarks = totalMarks;
            this.maxPossibleMarks = maxPossibleMarks;
            this.averagePercentage = averagePercentage;
            this.grade = grade;
        }
        
        public int getTotalMarks() { return totalMarks; }
        public int getMaxPossibleMarks() { return maxPossibleMarks; }
        public double getAveragePercentage() { return averagePercentage; }
        public String getGrade() { return grade; }
    }
    
    private void updateClassStats(String studentName, GradeResult result) {
        totalStudents++;
        
        // Update class average
        classAverage = ((classAverage * (totalStudents - 1)) + result.getAveragePercentage()) / totalStudents;
        
        // Update best student
        if (result.getAveragePercentage() > bestAverage) {
            bestAverage = result.getAveragePercentage();
            bestStudent = studentName;
        }
        
        // Add to top performers if grade is A or A+
        if (result.getGrade().equals("A") || result.getGrade().equals("A+")) {
            if (!topPerformers.contains(studentName)) {
                topPerformers.add(studentName);
            }
        }
    }
    
    private void displayClassSummary() {
        System.out.println("\n📊 CLASS SUMMARY:");
        System.out.println("=" .repeat(50));
        System.out.println("Total Students Processed: " + totalStudents);
        System.out.println("Class Average: " + String.format("%.2f%%", classAverage));
        if (!bestStudent.isEmpty()) {
            System.out.println("Best Student: " + bestStudent + " (" + String.format("%.2f%%", bestAverage) + ")");
        }
        System.out.println("Top Performers (A/A+): " + topPerformers.size());
        
        if (!topPerformers.isEmpty()) {
            System.out.println("\n🏆 TOP PERFORMERS:");
            for (String performer : topPerformers) {
                System.out.println("   • " + performer);
            }
        }
        System.out.println("=" .repeat(50));
    }
} 