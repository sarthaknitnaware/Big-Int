import java.util.Scanner;

class BigInt {
    static final int ARRAY_SIZE = 32;
    int[] data = new int[ARRAY_SIZE];  // Store the big integer in chunks

    // Initialize BigInt with all elements as 0
    void initializeBigInt() {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            data[i] = 0;
        }
    }

    // Add a long long value to BigInt
    void addLongLongToBigInt(long value) {
        long carry = 0;
        for (int i = ARRAY_SIZE - 1; i >= 0 || carry > 0; i--) {
            long sum = (long) data[i] + (i == ARRAY_SIZE - 1 ? value : 0) + carry;
            data[i] = (int) sum;
            carry = sum >> 32;
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

    // Multiply two BigInt numbers
    static void multiplyBigInt(BigInt a, BigInt b, BigInt result) {
        BigInt temp = new BigInt();
        result.initializeBigInt();
        temp.initializeBigInt();
        
        int k = 0;  // Position multiplier
        System.out.println("\nresult=");

        for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
            int q = b.data[i];
            int p = ARRAY_SIZE - 1 - i;  // Start position in the result

            // Multiply each digit of b with the whole of a
            while (q > 0) {
                int x = q % 10;
                q /= 10;

                long product;
                for (int j = ARRAY_SIZE - 1; j >= 0; j--) {
                    product = (long) a.data[j] * x * Math.pow(10, k);
                    if (product != 0) {
                        System.out.printf("%d+", product);
                    }
                    temp.data[p] = (int) product;
                    result.addLongLongToBigInt(product);
                }

                k++;
            }
        }
    }

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

        // Multiply the two BigInt numbers
        multiplyBigInt(a, b, result);

        System.out.println("\nFinal result:");
        result.printNum();
    }
}
