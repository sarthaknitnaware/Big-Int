# BigInt Operations Project

## Overview

This project implements basic arithmetic operations on large integers (BigInt) in Java. It provides functionality for initialization, addition, subtraction, and multiplication of BigInt values. The project simulates handling integers much larger than Java's primitive data types by breaking them down into 9-digit chunks stored in arrays.

## Features

The project supports the following operations:

1. **Initialization**: BigInt arrays are initialized to represent large integers.
2. **Addition**: Add two BigInt numbers and store the result.
3. **Subtraction**: Subtract one BigInt from another, handling borrow scenarios.
4. **Multiplication**: Multiply two BigInt numbers and store the result.

## Code Structure

The project contains three main parts, each representing a different arithmetic operation on BigInt numbers.

### 1. **Addition of BigInt Numbers**

- Adds two BigInt numbers and handles overflow by storing carry-over values.
- Uses 32-bit unsigned integer operations to ensure large numbers can be added.

### 2. **Subtraction of BigInt Numbers**

- Subtracts one BigInt number from another, ensuring the result is non-negative.
- If necessary, it uses the 2's complement method to handle cases where borrowing is needed.

### 3. **Multiplication of BigInt Numbers**

- Multiplies two BigInt numbers by iterating over each digit and calculating partial products.
- Uses shift-and-add technique, similar to how manual multiplication is performed with large numbers.

## Files

The project is divided into the following files:

1. `BigIntAddition.java`
   - Contains code for adding two BigInt numbers.
   - Supports initializing a BigInt, inputting a number, and adding it to another BigInt.

2. `BigIntSubtraction.java`
   - Contains code for subtracting two BigInt numbers.
   - Handles borrowing and implements the 2's complement method if required.

3. `BigIntMultiplication.java`
   - Contains code for multiplying two BigInt numbers.
   - Uses partial products and sums them to get the final result.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or higher
- A basic understanding of Java programming and handling large integers.

### How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/BigIntOperations.git
   cd BigIntOperations
   ```

2. **Compile the Java files**:
   Compile each file individually using the following command:
   ```bash
   javac BigIntAddition.java
   javac BigIntSubtraction.java
   javac BigIntMultiplication.java
   ```

3. **Run the individual Java files**:
   You can run any of the files based on the operation you'd like to test:
   
   For **Addition**:
   ```bash
   java BigIntAddition
   ```

   For **Subtraction**:
   ```bash
   java BigIntSubtraction
   ```

   For **Multiplication**:
   ```bash
   java BigIntMultiplication
   ```

4. **Input and Output**:
   Each program will prompt for input, such as the size of the number and the number itself. It will then print the result of the corresponding arithmetic operation.

## Example Usage

### Addition Example
```
Enter the size of a you are about to insert: 18
Enter first 9 digits: 123456789
Enter next 9 digits: 987654321
Enter the size of b you are about to insert: 9
Enter first 9 digits: 111111111
Result: 000000000000000000123456900987654432
```

### Subtraction Example
```
Enter the size of a you are about to insert: 18
Enter first 9 digits: 123456789
Enter next 9 digits: 987654321
Enter the size of b you are about to insert: 9
Enter first 9 digits: 111111111
Subtracting b from a:
Result: 000000000000000000012345667987654210
```

### Multiplication Example
```
Enter the size of a you are about to insert: 9
Enter first 9 digits: 123456789
Enter the size of b you are about to insert: 9
Enter first 9 digits: 987654321
Multiplying...
Result: 000000000000000000121932631112635269
```

## Future Improvements

- **Division**: Implement division of BigInt numbers.
- **Modulus**: Implement modulus operation for BigInt numbers.
- **Optimization**: Improve the efficiency of the multiplication algorithm.

---

**Enjoy working with BigInt Operations!**

