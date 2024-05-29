# Coding Kata
Collection of coding kata, one beginning, more to follow...

`mvn test`

## 1 Longest Peak

Find longest peak chain in array of integers and give count. 
Peak chain stops, if following is equal or has a valley (goes down and up).

Working example would be: 0, 1, 2, 3, 3, 4, 0, 6, 10, 8, 5, 2, 3, 4

 10  |                          *                                    
     |                                        
  8  |                              *        
     |                                        
  6  |                                         
     |                                  *
  4  |                  *                           *
     |          *   *                           *          
  2  |      *                               *
     |  *
     *--+---+---+---+---+----*---+---+---+---+---+---+
     0   1   2   3   4   5   6   7   8   9  10  11  12

TV series was boring, so I painted it for you to see it clearly. 
Chain start at x=0 but stops at x=3, because follower is equal (y=3, y=3). 
So it retards, goes up top peak at x=7, slides all the way down to x=10. 
Then it stops, because follower goes up again, x=10 is a valley - inverted peak. 

So we climb from x=4 to peak and slide down x=10, that counts 6, would be longest peak. 
Code of working example should result 6. 

:bulb: [Link to code example](src/main/java/com/abach42/etude/number_chain/LongestPeakFinder.java)
You will find two of multiple solutions.

:pill: [Link to test](src/test/java/com/abach42/etude/number_chain/LongestChainFinderTest.java)
Both are working... 

## 2 Coding Kata

tbd...
