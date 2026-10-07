import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            scores[i] = sc.nextInt();
            total = total + scores[i];
        }

        double average = total / 5.0;

        System.out.println("Total score = " + total);
        System.out.println("Average score = " + average);
    }
}
