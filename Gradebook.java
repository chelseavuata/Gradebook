// Chelsea Vuata
// COMP 163
// This program is an interactive gradebook that will give you your average grade for the class.
import java.util.Scanner;
import java.text.DecimalFormat;

class Gradebook {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    DecimalFormat f = new DecimalFormat("#.##");
    double project1;
    double project2;
    double midterm1;
    double midterm2;
    double midterm3;
    double finalExam;
    int participScore;
    double projectScore;
    double midtermScore;
    double totalScore;

    // Obtains input of the student's name and grade.
    System.out.println("Welcome to the interactive notebook. What is the student name?");
    String studentName = scan.nextLine();
    System.out.println("Did student receive participation credit? (yes/no)");
    String participationCredit = scan.nextLine();
    System.out.println("Enter grade for Project 1.");
    project1 = scan.nextDouble();
    System.out.println("Enter grade for Project 2.");
    project2 = scan.nextDouble();
    System.out.println("Enter grade for Midterm 1.");
    midterm1 = scan.nextDouble();
    System.out.println("Enter grade for Midterm 2.");
    midterm2 = scan.nextDouble();
    System.out.println("Enter grade for Midterm 3.");
    midterm3 = scan.nextDouble();
    System.out.println("Enter grade for Final Exam.");
    finalExam = scan.nextDouble();

    // Summary for the student's grade based on input.
    System.out.println("* * * * *");
    System.out.println("Here is the grade summary for " + studentName + ".");

    // Participation score
    if (participationCredit.equals("yes")) {
      participScore = 100;
    } else {
      participScore = 0;
    }
    System.out.println("Participation score: " + participScore);
    
    // Project score
    projectScore = ((project1 + project2) / 2);
    System.out.println("Project score: " + projectScore);

    // If Midterm 1 is lowest midterm grade.
    if ((midterm1 <= midterm2) && (midterm1 <= midterm3) && (midterm1 < finalExam)) {
      midtermScore = ((midterm2 + midterm3 + finalExam) / 3);
      System.out.println("Midterm score: " + (f.format(midtermScore)));
      System.out.println("A midterm grade was replaced by the final exam grade.");
    }
    // If Midterm 2 is the lowest midterm grade.
    else if ((midterm2 <= midterm1) && (midterm2 <= midterm3) && (midterm2 < finalExam)) {
      midtermScore = ((midterm1 + midterm3 + finalExam) / 3);
      System.out.println("Midterm score: " + (f.format(midtermScore)));
      System.out.println("A midterm grade was replaced by the final exam grade.");
    }
    // If Midterm 3 is the lowest midterm grade.
    else if ((midterm3 <= midterm1) && (midterm3 <= midterm2) && (midterm3 < finalExam)) {
      midtermScore = ((midterm1 + midterm2 + finalExam) / 3);
      System.out.println("Midterm score: " + (f.format(midtermScore)));
      System.out.println("A midterm grade was replaced by the final exam grade.");
    } else { // If final exam grade is lower than all midterms.
      midtermScore = ((midterm1 + midterm2 + midterm3) / 3);
      System.out.println("Midterm score: " + (f.format(midtermScore)));
    }
    // Final Exam score
    System.out.println("Final Exam score: " + finalExam);

    // Total score
    totalScore = ((participScore * 0.1) + (projectScore * 0.35) + (midtermScore * 0.3) + (finalExam * 0.25));
    System.out.println("Total score: " + (f.format(totalScore)));

    // Final Grade
    if (totalScore >= 90) {
      System.out.println("Final grade: A");
    } else if ((totalScore >= 80) && (totalScore < 90)) {
      System.out.println("Final grade: B");
    } else if ((totalScore >= 70) && (totalScore < 80)) {
      System.out.println("Final grade: C");
    } else if ((totalScore >= 60) && (totalScore < 70)) {
      System.out.println("Final grade: D");
    } else if (totalScore < 60) {
      System.out.println("Final grade: F");
    }
    System.out.println("* * * * *");
  }
}