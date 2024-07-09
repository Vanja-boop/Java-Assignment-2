import java.util.Scanner;

public class ExamProgram {
     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> viewCourseworkResults();
                case 2 -> viewExamResults();
                case 3 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    public static void viewCourseworkResults() {
        int assessments = countCourseworkAssessments();
        System.out.println("Number of coursework assessments done in DIT409: " + assessments);
        if (checkCourseworkCompletion(assessments)) {
            System.out.println("The student has completed 2/3 of the coursework.");
        } else {
            System.out.println("The student has not completed 2/3 of the coursework and needs to repeat the unit.");
        }
    }

    public static void viewExamResults() {
        System.out.print("Enter the final exam score: ");
        double finalExam = scanner.nextDouble();
        System.out.print("Enter the coursework score: ");
        double courseworkScore = scanner.nextDouble();
        double totalScore = finalExam + courseworkScore;
        System.out.println("Total score: " + totalScore);
    }

    public static int countCourseworkAssessments() {
        String[] assessments = {"ass1", "ass2", "ass3", "cat1", "cat2"};
        int count = 0;
        for (String assessment : assessments) {
            System.out.print("Enter the score for " + assessment + ": ");
            double score = scanner.nextDouble();
            if (score > 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkCourseworkCompletion(int count) {
        int totalAssessments = 5;
        double requiredAssessments = (2.0 / 3.0) * totalAssessments;
        return count >= requiredAssessments;
    }

}
