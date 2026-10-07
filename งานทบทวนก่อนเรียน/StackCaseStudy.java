import java.util.Stack;

public class StackCaseStudy {
    public static void main(String[] args) {
        Stack<String> actions = new Stack<>();

        actions.push("Type Data");
        actions.push("Type Structure");
        actions.push("Delete Structure");
        actions.push("Type Algorithm");
        actions.push("Type Java");

        System.out.println("คำสั่งทั้งหมดใน Stack:");
        System.out.println(actions);

        System.out.println("\nทำ Undo 2 ครั้ง:");
        for (int i = 0; i < 2; i++) {
            if (!actions.isEmpty()) {
                System.out.println("Undo: " + actions.pop());
            } else {
                System.out.println("Stack ว่าง ไม่สามารถ Undo ได้");
            }
        }

        System.out.println("\nสถานะของ Stack หลังจาก Undo:");
        System.out.println(actions);

        System.out.println("หลักการที่ใช้: LIFO (เข้าทีหลัง ออกก่อน)");
    }
}
