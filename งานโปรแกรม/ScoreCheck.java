import java.util.Scanner;

public class ScoreCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter midterm score: ");
        int midterm = sc.nextInt();

        System.out.print("Enter final score: ");
        int finalScore = sc.nextInt();

        int total = midterm + finalScore;

        System.out.println("Total score = " + total);

        if (total >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
