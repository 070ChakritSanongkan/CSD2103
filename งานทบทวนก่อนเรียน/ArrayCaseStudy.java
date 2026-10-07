import java.util.Arrays;

public class ArrayCaseStudy {
    public static void main(String[] args) {
        int[] scores = {6, 8, 4, 9, 7, 5, 10, 3, 8, 2};

        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        int countPass = 0;

        for (int score : scores) {
            sum += score;

            if (score > max) {
                max = score;
            }

            if (score < min) {
                min = score;
            }

            if (score >= 7) {
                countPass++;
            }
        }

        double average = (double) sum / scores.length;

        System.out.println("คะแนนของนักศึกษา: " + Arrays.toString(scores));
        System.out.println("คะแนนรวม = " + sum);
        System.out.println("คะแนนเฉลี่ย = " + average);
        System.out.println("คะแนนสูงสุด = " + max);
        System.out.println("คะแนนต่ำสุด = " + min);
        System.out.println("จำนวนนักศึกษาที่ได้ตั้งแต่ 7 คะแนนขึ้นไป = " + countPass);

        System.out.println("นักศึกษาที่ควรทบทวนเพิ่มเติม:");
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 5) {
                System.out.println("Student " + (i + 1) + " ได้ " + scores[i] + " คะแนน");
            }
        }
    }
}

