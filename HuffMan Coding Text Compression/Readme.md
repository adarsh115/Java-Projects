# HuffMan Coding Algorithm


In this project I have implemented huffman coding algorithm in java.

## Table of contents

- [Overview](#overview)
  - [Theory](#thoery)
- [My process](#my-process)
  - [Original File](#original-file)
  - [Reducing File Size](#reducing-file-size)
  - [Huffman Encoding](#huffman-encoding)
  - [What I learned](#what-i-learned)
  - [Useful resources](#useful-resources)
  - [Output](#output)
- [Author](#author)



## Overview
<br/>

### What is Huffman Coding Algorithm

Huffman Coding is a technique of compressing data to reduce its size without losing any of the details. It was first developed by David Huffman.
Huffman Coding is generally useful to compress the data in which there are frequently occurring characters. Most frequent characters have the smallest codes and longer codes for least frequent characters.

There are mainly two parts. First one to create a Huffman tree, and another one to traverse the tree to find codes.

For an example, consider some strings “YYYZXXYYX”, the frequency of character Y is larger than X and the character Z has the least frequency. So the length of the code for Y is smaller than X, and code for X will be smaller than Z.


![](https://github.com/adarsh115/Java-Projects/blob/main/HuffMan%20Coding%20Text%20Compression/hqdefault.jpg)

<br/>

## My process

<br/>

### Original File
Consider The String : BCCABBDDAECCBBAEDDCC

So this is our input string, if we were to calculate its size, it would come out to be 160bits. As alphabets are stored in ASCII form hence one character/letter will take 8bits. And the give string contains 20 alphabets. Hence total size of the file would be 160 bits. 

| Letters | Ascii Value | Binary Codes  | Count  |  Size  |
| :---    |     :---:   |    :---:      |  :---: |  ---:  |
|     A   |       65    | 01000001      | 3      |24 bits |
|     B   |       66    | 01000010      | 5      |40 bits |
|     C   |       67    | 01000011      | 6      |48 bits |
|     D   |       68    | 01000100      | 4      |32 bits |
|     E   |       69    | 01000101      | 2      |16 bits |
|         |             |               | 20     |160 bits|

It is not very large but still it can be reduced to significatly smaller size using Huffman coding.

<br/>

### Reducing File size
Consider The String : BCCABBDDAECCBBAEDDCC

There are two methods to compress the message
- Fixed Size Encoding
- Huffman Encoding 

First lets looks at fixed size encoding-
As we know message "BCCABBDDAECCBBAEDDCC" only contains letter A to E. Hence we can use our own three bit codes for these letters.

| Letters | Ascii Value | Binary Codes  | Count  |  Size  |
| :---    |     :---:   |    :---:      |  :---: |  ---:  |
|     A   |       65    |     000       | 3      |9 bits |
|     B   |       66    |     001       | 5      |15 bits |
|     C   |       67    |     010       | 6      |18 bits |
|     D   |       68    |     011       | 4      |12 bits |
|     E   |       69    |     100       | 2      |8 bits |
|         |             |               | 20     | 60 bits|

Hence we can see that for the given message size is 60bits

- Total size = size of table + size of message

- Size of table = character size + codes = 8*5 + 3*5 = 55bits

- Total size = 55 + 60 = 115 bits

So using fixed sized encoding we obtained a encoded message size of 115bits which is far less as compared to 160 bits

Now, we will see how it can be further reduced using huffman codes.

<br/>

### Huffman Encoding
Consider The String : BCCABBDDAECCBBAEDDCC

Huffman says that we don't have to tkae fixed size codes for characters. Some characters may be appearing less no of times while others amy be apperaing more no of times. If your give small size code for more appearing character then the size of entire message will definately be reduceds. Huffman propsed a method for genearting our own variable size codes.

APPROACH:
- All characters should be arranged in increading order of thier count(ascending)

| Letters |       |  Count  |
| :---    | :---: |    ---: |
|     A   |       |  3      |
|     B   |       |  5      |
|     C   |       |  6      |
|     D   |       |  4      |
|     E   |       |  2      |

- Arranged in increasing order [E(2) , A(3) , D(4) , B(5) , C(6)]
- Take two characters with smallest frequency and merge them into one single node
- E(2) + A(3) = newnode1(5)
- Keep repaeting this step until only one element is left
- newnode1(5) + D(4) = newnode2(9)
- B(5) + c(6) = newnode3(11);
- newnnode2(9) + newnode3(11) = newnode4(20)

![](https://github.com/adarsh115/Java-Projects/blob/main/HuffMan%20Coding%20Text%20Compression/tree1.jpeg)

- Now with the help of this tree we will generate codes.
- Start from top most node, start moving down and mark left edges (0) and right edges (1)

![](https://github.com/adarsh115/Java-Projects/blob/main/HuffMan%20Coding%20Text%20Compression/tree2.jpeg)

- Now, to generate code for each character follow a path from root onwards(top most node) till the character. The path formed by marked edges will the code for respective alphabets.

| Letters | Ascii Value |     Codes     | Count  |  Size  |
| :---    |     :---:   |    :---:      |  :---: |  ---:  |
|     A   |       65    |     001       | 3      |9 bits |
|     B   |       66    |     10        | 5      |10 bits |
|     C   |       67    |     11        | 6      |12 bits |
|     D   |       68    |     01        | 4      |8 bits |
|     E   |       69    |     000       | 2      |6 bits |
|         |             |               | 20     | 45 bits|

Hence we can see that for the given message size is 45 bits which is less than 60 bits that generated by fixed size encoding

- Total size = size of table + size of message

- Size of table = character size + codes = 8*5 + 12 = 52 bits

- Total size = 52 + 45 = 97 bits


So using Huffman encoding we obtained a encoded message size of 97 bits which is less as compared to 115 bits that generated by fixed size encoding and almost 45% less than size of original message.


<br/>

### Output

![](https://github.com/adarsh115/Java-Projects/blob/main/HuffMan%20Coding%20Text%20Compression/OUTPUT.PNG)

### What I learned
- Encoding & Decoding
- Fixed size encoding
- HUffman Encoding
- How messages are compressed
- Data Structures application in real life.

### Useful resources

- Abul Bari youtube video has an excellent explanation video on huffman coding.


## Author

- Website - [Adarsh](https://meadarshkumar.netlify.app/)
- Twitter - [@kadarsh115](https://www.twitter.com/kadarsh115)

