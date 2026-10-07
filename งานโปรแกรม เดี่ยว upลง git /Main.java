import java.util.Arrays;

public class Main {

    // ==================== ข้อ 1 ====================

    // Recursive Algorithm
    static String reverseRecursive(String s) {
        if (s == null || s.length() <= 1) {
            return s == null ? "" : s;
        }
        return s.charAt(s.length() - 1)
                + reverseRecursive(s.substring(0, s.length() - 1));
    }

    // Iterative Algorithm (ใช้ StringBuilder)
    static String reverseIterative(String s) {
        if (s == null || s.length() <= 1) {
            return s == null ? "" : s;
        }
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }

    // วิธีเสริมสำหรับทดลองผลของการต่อ String ด้วย +
    static String reverseIterativePlus(String s) {
        if (s == null || s.length() <= 1) {
            return s == null ? "" : s;
        }
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result = result + s.charAt(i);
        }
        return result;
    }

    // ==================== ข้อ 2 ====================

    // ตัดช่องว่างและเครื่องหมายต่าง ๆ และไม่แยกตัวพิมพ์ใหญ่/เล็ก
    static String normalize(String s) {
        if (s == null) {
            return "";
        }
        StringBuilder clean = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }
        return clean.toString();
    }

    static boolean isPalindromeByReverse(String s) {
        String clean = normalize(s);
        String reversed = reverseIterative(clean);
        return clean.equals(reversed);
    }

    static boolean isPalindromeRecursive(String s, int left, int right) {
        String clean = normalize(s);
        if (clean.length() == 0) {
            return true;
        }
        // รองรับการส่งตำแหน่งจากสตริงเดิมที่ยังมีช่องว่างหรือเครื่องหมายอยู่
        left = Math.max(0, left);
        right = Math.min(right, clean.length() - 1);
        if (left > right) {
            return true;
        }
        return isPalindromeRecursiveClean(clean, left, right);
    }

    private static boolean isPalindromeRecursiveClean(String s, int left, int right) {
        // Base Case
        if (left >= right) {
            return true;
        }

        // Recursive Case
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeRecursiveClean(s, left + 1, right - 1);
    }

    // ==================== ข้อ 3 ====================

    static boolean hasMoreVowelsRecursive(String s) {
        if (s == null) {
            return false;
        }
        return hasMoreVowelsRecursiveHelper(s, 0, 0, 0);
    }

    private static boolean hasMoreVowelsRecursiveHelper(String s, int index,
                                                         int vowels, int consonants) {
        // Base Case
        if (index == s.length()) {
            return vowels > consonants;
        }

        char c = Character.toLowerCase(s.charAt(index));
        if (isEnglishLetter(c)) {
            if (isVowel(c)) {
                vowels++;
            } else {
                consonants++;
            }
        }

        // Recursive Case
        return hasMoreVowelsRecursiveHelper(s, index + 1, vowels, consonants);
    }

    static boolean hasMoreVowelsIterative(String s) {
        if (s == null) {
            return false;
        }
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (isEnglishLetter(c)) {
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return vowels > consonants;
    }

    private static boolean isEnglishLetter(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    // ==================== ข้อ 4 ====================

    static void rearrangeRecursive(int[] a, int left, int right) {
        if (a == null || left >= right) {
            return;
        }

        if (a[left] % 2 == 0) {
            rearrangeRecursive(a, left + 1, right);
        } else if (a[right] % 2 != 0) {
            rearrangeRecursive(a, left, right - 1);
        } else {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            rearrangeRecursive(a, left + 1, right - 1);
        }
    }

    static void rearrangeTwoPointer(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            if (a[left] % 2 == 0) {
                left++;
            } else if (a[right] % 2 != 0) {
                right--;
            } else {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    static int[] rearrangeExtraArray(int[] a) {
        if (a == null) {
            return new int[0];
        }

        int[] result = new int[a.length];
        int index = 0;

        // ใส่เลขคู่ก่อน
        for (int value : a) {
            if (value % 2 == 0) {
                result[index++] = value;
            }
        }

        // แล้วใส่เลขคี่
        for (int value : a) {
            if (value % 2 != 0) {
                result[index++] = value;
            }
        }

        return result;
    }

    // ==================== ข้อ 5 ====================

    static void partitionRecursive(int[] a, int k, int left, int right) {
        if (a == null || left >= right) {
            return;
        }

        while (left < right && a[left] <= k) {
            left++;
        }

        while (left < right && a[right] > k) {
            right--;
        }

        if (left < right) {
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }

        partitionRecursive(a, k, left, right);
    }

    static void partitionIterative(int[] a, int k) {
        if (a == null || a.length <= 1) {
            return;
        }

        int left = 0;
        int right = a.length - 1;

        while (left < right) {
            while (left < right && a[left] <= k) {
                left++;
            }

            while (left < right && a[right] > k) {
                right--;
            }

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
                left++;
                right--;
            }
        }
    }

    static void partitionBySorting(int[] a, int k) {
        if (a == null || a.length <= 1) {
            return;
        }
        Arrays.sort(a);
    }

    // ==================== ข้อ 6 ====================

    static boolean findPairBruteForce(int[] a, int k) {
        if (a == null || a.length < 2) {
            return false;
        }

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean findPairRecursive(int[] a, int k, int left, int right) {
        if (a == null || left >= right) {
            return false;
        }

        int sum = a[left] + a[right];
        if (sum == k) {
            return true;
        }

        if (sum < k) {
            return findPairRecursive(a, k, left + 1, right);
        }

        return findPairRecursive(a, k, left, right - 1);
    }

    static boolean findPairBinarySearch(int[] a, int k) {
        if (a == null || a.length < 2) {
            return false;
        }

        for (int i = 0; i < a.length - 1; i++) {
            int target = k - a[i];
            int index = binarySearch(a, target, i + 1, a.length - 1);
            if (index != -1) {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch(int[] a, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return mid;
            }
            if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // ==================== แสดงตัวอย่าง ====================

    static void showExamples() {
        System.out.println("===== ตัวอย่างการทำงาน =====");

        String s1 = "pots&pans";
        System.out.println("ข้อ 1 Recursive: " + reverseRecursive(s1));
        System.out.println("ข้อ 1 Iterative: " + reverseIterative(s1));

        String s2 = "A man, a plan, a canal: Panama";
        System.out.println("ข้อ 2 Reverse and Compare: " + isPalindromeByReverse(s2));
        System.out.println("ข้อ 2 Recursive Two-Pointer: " +
                isPalindromeRecursive(s2, 0, s2.length() - 1));

        String s3 = "education";
        System.out.println("ข้อ 3 Recursive: " + hasMoreVowelsRecursive(s3));
        System.out.println("ข้อ 3 Iterative: " + hasMoreVowelsIterative(s3));

        int[] a4 = {7, 2, 9, 4, 1, 6, 3, 8};
        int[] a4r = a4.clone();
        int[] a4i = a4.clone();
        System.out.println("ข้อ 4 Input: " + Arrays.toString(a4));
        rearrangeRecursive(a4r, 0, a4r.length - 1);
        rearrangeTwoPointer(a4i);
        System.out.println("ข้อ 4 Recursive: " + Arrays.toString(a4r));
        System.out.println("ข้อ 4 Iterative: " + Arrays.toString(a4i));
        System.out.println("ข้อ 4 Extra Array: " +
                Arrays.toString(rearrangeExtraArray(a4)));

        int[] a5 = {12, 4, 7, 15, 3, 10, 8};
        int k5 = 8;
        int[] a5r = a5.clone();
        int[] a5i = a5.clone();
        int[] a5s = a5.clone();
        partitionRecursive(a5r, k5, 0, a5r.length - 1);
        partitionIterative(a5i, k5);
        partitionBySorting(a5s, k5);
        System.out.println("ข้อ 5 Input: " + Arrays.toString(a5) + ", k = " + k5);
        System.out.println("ข้อ 5 Recursive: " + Arrays.toString(a5r));
        System.out.println("ข้อ 5 Iterative: " + Arrays.toString(a5i));
        System.out.println("ข้อ 5 Sorting: " + Arrays.toString(a5s));

        int[] a6 = {2, 4, 7, 11, 15, 20};
        int k6 = 18;
        System.out.println("ข้อ 6 Input: " + Arrays.toString(a6) + ", k = " + k6);
        System.out.println("ข้อ 6 Brute Force: " + findPairBruteForce(a6, k6));
        System.out.println("ข้อ 6 Recursive Two-Pointer: " +
                findPairRecursive(a6, k6, 0, a6.length - 1));
        System.out.println("ข้อ 6 Binary Search: " + findPairBinarySearch(a6, k6));
    }

    // ==================== ทดลองจับเวลา ====================

    static long measureQ3Recursive(String s) {
        long start = System.nanoTime();
        hasMoreVowelsRecursive(s);
        long end = System.nanoTime();
        return end - start;
    }

    static long measureQ3Iterative(String s) {
        long start = System.nanoTime();
        hasMoreVowelsIterative(s);
        long end = System.nanoTime();
        return end - start;
    }

    static long measureQ5Recursive(int[] input, int k) {
        int[] a = input.clone();
        long start = System.nanoTime();
        partitionRecursive(a, k, 0, a.length - 1);
        long end = System.nanoTime();
        return end - start;
    }

    static long measureQ5Iterative(int[] input, int k) {
        int[] a = input.clone();
        long start = System.nanoTime();
        partitionIterative(a, k);
        long end = System.nanoTime();
        return end - start;
    }

    static long measureQ5Sorting(int[] input, int k) {
        int[] a = input.clone();
        long start = System.nanoTime();
        partitionBySorting(a, k);
        long end = System.nanoTime();
        return end - start;
    }

    static String makeTestString(int n) {
        StringBuilder s = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s.append('a');
            } else {
                s.append('b');
            }
        }
        return s.toString();
    }

    static int[] makePartitionTestArray(int n, int k) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i] = k + 1;
            } else {
                a[i] = k - 1;
            }
        }
        return a;
    }

    static String averageQ3Recursive(String s) {
        long total = 0;
        int success = 0;
        for (int t = 1; t <= 5; t++) {
            try {
                total += measureQ3Recursive(s);
                success++;
            } catch (StackOverflowError e) {
                return "StackOverflowError";
            }
        }
        return String.valueOf(total / success);
    }

    static String averageQ3Iterative(String s) {
        long total = 0;
        for (int t = 1; t <= 5; t++) {
            total += measureQ3Iterative(s);
        }
        return String.valueOf(total / 5);
    }

    static String averageQ5Recursive(int[] a, int k) {
        long total = 0;
        int success = 0;
        for (int t = 1; t <= 5; t++) {
            try {
                total += measureQ5Recursive(a, k);
                success++;
            } catch (StackOverflowError e) {
                return "StackOverflowError";
            }
        }
        return String.valueOf(total / success);
    }

    static String averageQ5Iterative(int[] a, int k) {
        long total = 0;
        for (int t = 1; t <= 5; t++) {
            total += measureQ5Iterative(a, k);
        }
        return String.valueOf(total / 5);
    }

    static String averageQ5Sorting(int[] a, int k) {
        long total = 0;
        for (int t = 1; t <= 5; t++) {
            total += measureQ5Sorting(a, k);
        }
        return String.valueOf(total / 5);
    }

    static void runExperiment() {
        int[] sizes = {100, 1000, 10000, 100000};

        System.out.println();
        System.out.println("===== Experiment ข้อ 3 =====");
        System.out.println("n\tRecursive(ns)\tIterative(ns)");
        for (int n : sizes) {
            String s = makeTestString(n);
            System.out.println(n + "\t" + averageQ3Recursive(s) + "\t" + averageQ3Iterative(s));
        }

        System.out.println();
        System.out.println("===== Experiment ข้อ 5 =====");
        System.out.println("n\tRecursive(ns)\tIterative(ns)\tSorting(ns)");
        for (int n : sizes) {
            int k = 500000;
            int[] a = makePartitionTestArray(n, k);
            System.out.println(n + "\t" + averageQ5Recursive(a, k) + "\t"
                    + averageQ5Iterative(a, k) + "\t" + averageQ5Sorting(a, k));
        }
    }

    public static void main(String[] args) {
        showExamples();
        runExperiment();
    }
}

