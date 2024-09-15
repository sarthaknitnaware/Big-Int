import java.util.Scanner;

class BigInt {
    static final int ARRAY_SIZE = 32;
    int[] data = new int[ARRAY_SIZE];  // Store the big integer

    // Initialize BigInt with all elements as 0
    void initializeBigInt() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data[i] = 0;
        }
    }

    // Add two BigInt numbers
    static void addBigInt(BigInt a, BigInt b, BigInt result) {
        long carry = 0;
        for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
            long sum = (long) a.data[i] + b.data[i] + carry;
            result.data[i] = (int) sum;
            carry = sum >> 32;  // Extract the carry by shifting 32 bits to the right
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

        // Add the two BigInt numbers
        BigInt.addBigInt(a, b, result);

        // Print the result
        System.out.print("Result: ");
        result.printNum();
    }
}
