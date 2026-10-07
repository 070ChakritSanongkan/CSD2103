import java.util.LinkedList;
import java.util.Queue;

public class QueueCaseStudy {
    public static void main(String[] args) {
        Queue<String> patients = new LinkedList<>();

        patients.add("P001");
        patients.add("P002");
        patients.add("P003");
        patients.add("P004");
        patients.add("P005");

        if (!patients.isEmpty()) {
            System.out.println("เรียกผู้ป่วย: " + patients.remove());
        }

        if (!patients.isEmpty()) {
            System.out.println("เรียกผู้ป่วย: " + patients.remove());
        }

        patients.add("P006");
        patients.add("P007");

        System.out.println("ผู้ป่วยคนถัดไป = " + patients.peek());
        System.out.println("จำนวนผู้ป่วยที่ยังรอ = " + patients.size());
        System.out.println("สถานะของ Queue = " + patients);

        System.out.println("หลักการที่ใช้: FIFO (มาก่อน ออกก่อน)");
    }
}
