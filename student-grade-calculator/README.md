# Student Grade Calculator 📚

**CODSOFT Task 2: Java Development Internship**

A comprehensive student grade calculation system that computes total marks, average percentage, and assigns grades based on performance. Features detailed analysis and performance insights.

## 🎯 Features

### Core Features
- **Multi-Subject Input**: Accept marks for multiple subjects (1-10 subjects)
- **Total Marks Calculation**: Sum up all subject marks
- **Average Percentage**: Calculate overall performance percentage
- **Grade Assignment**: Automatic grade assignment based on percentage
- **Input Validation**: Robust validation for marks (0-100 range)
- **Multiple Students**: Process grades for multiple students

### Advanced Features
- **Detailed Analysis**: Best/worst subject identification
- **Performance Insights**: Pass/fail statistics per subject
- **Grade Interpretation**: Meaningful feedback for each grade
- **Beautiful Reports**: Formatted output with emojis and borders
- **Flexible Subjects**: Custom subject names or use defaults

## 🚀 Installation & Setup

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

### Build Instructions

1. **Clone or download the project**
   ```bash
   cd student-grade-calculator
   ```

2. **Compile the project**
   ```bash
   mvn clean compile
   ```

3. **Run the calculator**
   ```bash
   mvn exec:java -Dexec.mainClass="com.codsoft.StudentGradeCalculator"
   ```

   Or build and run the JAR:
   ```bash
   mvn clean package
   java -jar target/student-grade-calculator-1.0.0.jar
   ```

## 📊 How to Use

1. **Start the Application**: Run the program
2. **Enter Student Name**: Provide student's name
3. **Specify Subjects**: Choose number of subjects (1-10)
4. **Input Marks**: Enter marks for each subject (0-100)
5. **View Results**: See comprehensive grade report
6. **Continue**: Process more students or exit

## 📈 Grading System

| Percentage Range | Grade | Performance Level |
|------------------|-------|-------------------|
| 90-100%          | A+    | Outstanding 🌟    |
| 80-89%           | A     | Very Good 👍      |
| 70-79%           | B+    | Good 📈           |
| 60-69%           | B     | Above Average 📊  |
| 50-59%           | C+    | Average 💪       |
| 40-49%           | C     | Below Average ⚠️  |
| 35-39%           | D     | Poor 🔴           |
| 0-34%            | F     | Fail 🚨           |

## 📋 Sample Output

```
╔══════════════════════════════════════════════════════════════╗
║                 STUDENT GRADE CALCULATOR                    ║
║                       CODSOFT Task 2                        ║
╠══════════════════════════════════════════════════════════════╣
║  Features:                                                   ║
║  • Calculate total marks from multiple subjects             ║
║  • Compute average percentage                               ║
║  • Assign grades based on performance                       ║
║  • Detailed performance analysis                            ║
╚══════════════════════════════════════════════════════════════╝

📝 STUDENT GRADE CALCULATION
==================================================
👤 Enter student name: John Doe
📚 Enter number of subjects (1-10): 5

📊 Enter marks for each subject (out of 100):
--------------------------------------------------
📖 Subject 1 (Mathematics): 
   Enter marks for Mathematics (0-100): 85
📖 Subject 2 (Science): 
   Enter marks for Science (0-100): 92
📖 Subject 3 (English): 
   Enter marks for English (0-100): 78
📖 Subject 4 (History): 
   Enter marks for History (0-100): 88
📖 Subject 5 (Geography): 
   Enter marks for Geography (0-100): 95

============================================================
📊 GRADE REPORT
============================================================
👤 Student Name: John Doe
📚 Number of Subjects: 5

📖 SUBJECT-WISE MARKS:
----------------------------------------
   Mathematics    :  85/100 ✅
   Science        :  92/100 ✅
   English        :  78/100 ✅
   History        :  88/100 ✅
   Geography      :  95/100 ✅

📈 PERFORMANCE SUMMARY:
----------------------------------------
   Total Marks Obtained: 438/500
   Average Percentage: 87.60%
   Grade: A

🎯 GRADE INTERPRETATION:
----------------------------------------
   Very Good Performance! Keep it up! 👍

📊 DETAILED ANALYSIS:
----------------------------------------
   🏆 Best Subject: Geography (95/100)
   📉 Needs Improvement: English (78/100)
   ✅ Subjects Passed: 5
   ❌ Subjects Failed: 0
   📊 Overall Performance: Excellent ⭐
============================================================
```

## 🛠️ Technical Details

### Project Structure
```
student-grade-calculator/
├── pom.xml                          # Maven configuration
├── README.md                        # This file
└── src/
    └── main/
        └── java/
            └── com/
                └── codsoft/
                    └── StudentGradeCalculator.java  # Main calculator class
```

### Key Classes
- **StudentGradeCalculator**: Main application logic
- **Subject**: Inner class for subject data
- **GradeResult**: Inner class for calculation results

### Design Patterns
- **Data Encapsulation**: Private fields with getter methods
- **Input Validation**: Comprehensive error handling
- **Modular Methods**: Single responsibility principle
- **Switch Expressions**: Modern Java 11+ features

## 🎯 Learning Objectives

This project demonstrates:
- **Java Fundamentals**: Variables, arrays, loops, conditionals
- **Object-Oriented Programming**: Classes, encapsulation, inheritance
- **Data Structures**: Lists, arrays, custom objects
- **Input/Output**: Scanner class, formatted output
- **Error Handling**: Try-catch blocks, input validation
- **String Manipulation**: Formatting, concatenation
- **Mathematical Operations**: Percentage calculations, averages

## 📊 Analysis Features

### Performance Metrics
- **Total Marks**: Sum of all subject marks
- **Average Percentage**: Overall performance indicator
- **Grade Assignment**: Letter grade based on percentage
- **Subject Analysis**: Best and worst performing subjects
- **Pass/Fail Statistics**: Count of passed and failed subjects

### Default Subjects
The calculator provides default subject names:
1. Mathematics
2. Science
3. English
4. History
5. Geography

Users can customize subject names or use the defaults.

## 📝 CODSOFT Internship Requirements

✅ **Task Completion**: Complete grade calculator with all required features  
✅ **Input Validation**: Robust handling of user input  
✅ **Calculations**: Accurate total marks and percentage computation  
✅ **Grade Assignment**: Proper grade assignment based on percentage  
✅ **Results Display**: Clear and formatted output  
✅ **Advanced Features**: Detailed analysis and multiple student support  

## 🏷️ Tags

#codsoft #internship #javadevelopment #gradecalculator #education

## 📞 Support

For questions or issues related to this CODSOFT task, please refer to the internship guidelines or contact your mentor.

---

**Developed for CODSOFT Java Development Internship**  
**Task 2: Student Grade Calculator**  
**Author: [Your Name]**  
**Date: [Current Date]** 