# Coding Kata
Collection of coding kata, one beginning, more to follow...

`mvn test`

## 1 Longest Peak

Find longest peak chain in array of integers and give count of elements. 
Peak chain stops, if following is equal or has a valley (goes down and up).

Working example would be: 0, 1, 2, 3, 3, 4, 0, 6, 10, 8, 5, 2, 3, 4

```

 10  |                              *                                         
     |                                             
  8  |                                   *        
     |                                             
  6  |                          *                        
     |                                       *
  4  |                  *                                *
     |          *   *                                *          
  2  |      *                                    *
     |  *       
     *--+---+---+---+---+----*---+---+---+---+---+---+---+
     0   1   2   3   4   5   6   7   8   9  10  11  12   13
```

TV series was boring, so I painted it for you to see it clearly. 
Chain starts at x=0 but stops at x=3, because follower is equal (y=3, y=3). 
So it restarts and ends on x=6. Newly restarts x=6, goes up top peak at x=8 (enjoys the view), slides all the way down to x=11. 
Then it stops, because follower goes up again. x=11 is a valley - inverted peak. 

So we climb from x=6 to peak and slide down x=11, that counts 6 elements, would be longest peak. 
Code of working example should result count 6. 

:bulb: [Link to code example using index](src/main/java/com/abach42/etude/longestpeak/LongestPeakPointer.java)

:bulb: [Link to code example using spaceship strategy](src/main/java/com/abach42/etude/longestpeak/LongestPeakSpaceship.java)



:pill: [Link to test](src/test/java/com/abach42/etude/longestpeak/LongestChainFinderTest.java)
Both are working... 

## 2 Fibonacci
Generate fibonacci list of integers on given maximum of mathematical operations. 

List begins mathematically correct with 0, e.g. 
`0, 1, 1, 2, 3, 5, 8, 13, 21` 
appears on 8 operations.

:bulb: [Link to code example using a loop](src/main/java/com/abach42/etude/fibonacci/FibonacciLoopGenerator.java)

:bulb: [Link to code example using stream](src/main/java/com/abach42/etude/fibonacci/FibonacciStreamGenerator.java)

:pill: [Link to test](src/test/java/com/abach42/etude/fibonacci/FibonacciGeneratorTest.java)

## 3 DnaEncoder
Compress nucleotides `(A, C, G, T)`, being able to decompress this again. 

:bulb: [Link to code example](src/main/java/com/abach42/etude/dnaencoding/DnaEncoder.java)

:pill: [Link to test](src/test/java/com/abach42/etude/dnaencoding/DnaEncoderTest.java)

### compress()

The [compress](src/main/java/com/abach42/etude/dnaencoding/DnaEncoder.java)  method transforms the input nucleotide string `"ACGT"` into an array of Byte values `[0, 1, 2, 3]`, where each byte represents a nucleotide according to the `Nucleotide` enum mapping.

1. **Input String**:
   ```java
   nucleoideString = "ACGT";
   ```

2. **Convert to IntStream of Characters**:
   ```java
   nucleoideString.chars();
   ```
   This converts the string `"ACGT"` into an `IntStream` where each integer represents the Unicode code point of the characters.
   ```
   "ACGT" -> [65, 67, 71, 84]
   ```

   🔸Stream at this stage:
   ```
   [65, 67, 71, 84]  // Unicode code points for 'A', 'C', 'G', 'T'
   ```

3. **Map IntStream to Byte Stream using Nucleotide Enum**:
   ```java
   .mapToObj(nucleotideChar -> Nucleotide.tryFromChar((char) nucleotideChar).value)
   ```
   This converts each Unicode code point to its corresponding `Nucleotide` enum value and then to the byte value. Object Wrapping: Since primitive streams (IntStream, LongStream, DoubleStream) cannot directly handle object types,
   .mapToObj is necessary to transform the primitive int values into Byte objects.
   
    - Converting the integer character code to a `char`.  
    - Using the `Nucleotide.tryFromChar` method to get the corresponding `Nucleotide` enum value.
    - Calling `getValue()` on the `Nucleotide` enum to get the corresponding byte value.
    - Wrapping the primitive byte value in a `Byte` object.
    
   That is what happens for each character:

    - `'A'` (65) -> `Nucleotide.A` -> `0b00` (0)
    - `'C'` (67) -> `Nucleotide.C` -> `0b01` (1)
    - `'G'` (71) -> `Nucleotide.G` -> `0b10` (2)
    - `'T'` (84) -> `Nucleotide.T` -> `0b11` (3)

   🔸Stream at this stage:
   ```
   [(byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11] // Corresponding byte values of the nucleotides
   ```

4. **Collect into an Array of Bytes**:
   ```java
   .toArray(Byte[]::new);
   ```
   This collects the stream of bytes into an array of `Byte` objects.

   Final output:
   ```
   new Byte[] { (byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11 }  // Byte array
   ```

### inflate()

The [inflate](src/main/java/com/abach42/etude/dnaencoding/DnaEncoder.java) method transforms the input Byte array
`new Byte[] { (byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11 }` back into the nucleotide string `"ACGT"`, 
where each byte is converted to its corresponding nucleotide character.

1. **Input Byte Array**:
   ```java
   Byte[] compressedBytes = new Byte[] { (byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11 };
   ```

2. **Convert to Stream of Bytes**:
   ```java
   Arrays.stream(compressedBytes);
   ```
   This converts the array `{ (byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11 }` into a `Stream<Byte>`.

   🔸Stream at this stage:
   ```
   [(byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11]
   ```

3. **Map Byte Stream to Nucleotide Characters**:
   ```java
   .map(valueByte -> Nucleotide.tryFromValue(valueByte).toString())
   ```
   This converts each byte value back to its corresponding `Nucleotide` enum value and then to 
the string representation of the nucleotide, the `String enum:name`.

   That is what happens for each byte:

    - `(byte) 0b00` -> `Nucleotide.A` -> `"A"`
    - `(byte) 0b01` -> `Nucleotide.C` -> `"C"`
    - `(byte) 0b10` -> `Nucleotide.G` -> `"G"`
    - `(byte) 0b11` -> `Nucleotide.T` -> `"T"`

   🔸Stream at this stage:
   ```
   ["A", "C", "G", "T"]
   ```

4. **Collect to a Single String**:
   ```java
   .collect(Collectors.joining());
   ```
   This joins all the strings in the stream into a single string.

   Final output:
   ```
   "ACGT"
   ```

## 4 tbd. 
