import java.util.Scanner;

class BigInt {
    static final int ARRAY_SIZE = 32;
    int[] data = new int[ARRAY_SIZE];

    // Initialize BigInt with all elements as 0
    void initializeBigInt() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data[i] = 0;
        }
    }

    // Print the BigInt number
    void printNum() {
        for (int j = 0; j < ARRAY_SIZE; j++) {
            System.out.printf("%09d", data[j]);
        }
        System.out.println();
    }

    // Input BigInt from user
    void inputNum(int n) {
        Scanner sc = new Scanner(System.in);
        int g = (n % 9 == 0) ? n / 9 : (n / 9) + 1;
        int i = ARRAY_SIZE - g;

        // Input first portion that may not be a full 9 digits
        if (n % 9 != 0) {
            System.out.printf("Enter first %d digits: ", (n % 9));
            data[i] = sc.nextInt();
        } else {
            System.out.printf("Enter first 9 digits: ");
            data[i] = sc.nextInt();
        }

        // Input subsequent 9-digit chunks
        i++;
        while (i < ARRAY_SIZE) {
            System.out.printf("Enter next 9 digits: ");
            data[i] = sc.nextInt();
            i++;
        }

        // Print the number after input
        printNum();
    }

    // Subtract BigInt B from BigInt A and store result in result BigInt
    static void subtractBigInt(BigInt A, BigInt B, BigInt result) {
        long borrow = 0;

        for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
            long diff;
            if (A.data[i] >= B.data[i] + borrow) {
                diff = (long) A.data[i] - B.data[i] - borrow;
                result.data[i] = (int) diff;
                borrow = 0;
            } else {
                // Convert A into 2's complement and handle the borrow case
                long x = 999_999_999L - A.data[i];
                diff = x + B.data[i];
                if (diff / 1_000_000_000L == 1) {
                    diff = 999_999_999L - (diff % 1_000_000_000L);
                    result.data[i] = (int) diff;
                }
                borrow = 1;
            }
        }
        result.printNum();
    }

    // Compare two BigInt numbers and determine which one is greater to subtract
    static void compare(BigInt a, BigInt b, int n, BigInt result) {
        int g = (n % 9 == 0) ? n / 9 : (n / 9) + 1;
        int i = ARRAY_SIZE - g;
        boolean flag = false;

        while (i < ARRAY_SIZE && !flag) {
            if (a.data[i] > b.data[i]) {
                System.out.println("Subtracting b from a: ");
                subtractBigInt(a, b, result);
                flag = true;
            } else if (a.data[i] < b.data[i]) {
                System.out.println("Subtracting a from b: ");
                subtractBigInt(b, a, result);
                flag = true;
            } else {
                i++;
            }
        }
    }
}

public class BigIntMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create BigInt instances for a, b, and result
        BigInt a = new BigInt();
        BigInt b = new BigInt();
        BigInt result = new BigInt();

        // Initialize all BigInt instances
        a.initializeBigInt();
        b.initializeBigInt();
        result.initializeBigInt();

        // Input the sizes of numbers to be inserted
        System.out.print("Enter the size of a you are about to insert: ");
        int n1 = sc.nextInt();
        System.out.print("Enter the size of b you are about to insert: ");
        int n2 = sc.nextInt();

        // Input the actual numbers
        a.inputNum(n1);
        b.inputNum(n2);

        // Perform subtraction based on the size comparison
        if (n1 > n2) {
            System.out.println("Subtracting b from a:");
            BigInt.subtractBigInt(a, b, result);
        } else if (n2 > n1) {
            System.out.println("Subtracting a from b:");
            BigInt.subtractBigInt(b, a, result);
        } else {
            BigInt.compare(a, b, n1, result);
        }
    }
}
