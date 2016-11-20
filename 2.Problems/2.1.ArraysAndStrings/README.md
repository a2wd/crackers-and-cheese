# 2.1 Arrays & Strings

The first set of problems are focused on arrays & string manipulation.

## 1.1 UniqueChars.java

Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

## 1.2 Reverse.c

Implement a function void `reverse(char* str)` in C or C++ which reverses a nullterminated
string.

##  1.3 IsPermutation.java

Given two strings, write a method to decide if one is a permutation of the other.

## 1.4 ReplaceSpaces.java

Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string. (Note: if implementing in Java, please use a character array so that you can perform this operation in place).

```
EXAMPLE
Input:  "Mr John Smith    "
Output: "Mr%20Dohn%20Smith"
```

## 1.5 StringCompression.java

Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become
a2blc5a3. If the "compressed" string would not become smaller than the original
string, your method should return the original string.

## 1.6 RotateMatrix.java

Given an image represented by an NxN matrix, where each pixel in the image is
4 bytes, write a method to rotate the image by 90 degrees. Can you do this in
place?

* The files in `/MatrixInput/Xn.txt` can be used to test the matrix
* eg: `> java RotateMatrix > MatrixInput/4n.txt` or `type MatrixInput/3n.txt | java RotateMatrix`
* The client accepts a command line argument `-w` to perform the rotation without the additional data structure
* The client accepts the command line argument `-i` to negate the rotation and indirectly access the array through a wrapper.

## 1.7 ZeroMatrix.java

Write an algorithm such that if an element in an MxN matrix is 0, its entire row
and column are set to 0.

* The files in `/MatrixInput/Xz.txt` can be used to test the matrix
* eg: `> java ZeroMatrix > MatrixInput/2z.txt` or `type MatrixInput/5z.txt | java ZeroMatrix`

## 1.8 IsRotation.java

Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (e.g.,"waterbottle"is a rotation of "erbottlewat").