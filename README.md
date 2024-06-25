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

:bulb: [Link to code example using a loop](src/main/java/com/abach42/etude/fibonacci/FibonacciLoopGenerator.java). 

:bulb: [Link to code example using stream](src/main/java/com/abach42/etude/fibonacci/FibonacciStreamGenerator.java).

:pill: [Link to test](src/test/java/com/abach42/etude/fibonacci/FibonacciGeneratorTest.java)

## 3 DnaEncoder
Compress nucleotides (A, C, G, T), being able to decompress this again. 

:bulb: [Link to code example](src/main/java/com/abach42/etude/dnaencoding/DnaEncoder.java)

:pill: [Link to test](src/test/java/com/abach42/etude/dnaencoding/DnaEncoderTest.java)

## 4 tbd. 
