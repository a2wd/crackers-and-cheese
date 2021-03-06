# 2.2  Linked Lists

The second set of problems are focused on linked lists

## 2.2.1 RemoveDuplicates.java

i) Write code to remove duplicates from an unsorted linked list.
ii) How would you solve this problem if a temporary buffer is not allowed?

## 2.2.2 FindKthElement.java

Implement an algorithm to find the kth to last element of a singly linked list.

## 2.2.3 DeleteNode.java

Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

eg:
Input: the node c from the linked list `a->b->c->d->e`
Result: nothing is returned, but the new linked list looks like `a->b->d->e`

## 2.2.4 PartitionLinkedList.java

Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

## 2.2.5 SumLinkedLists.java

i) You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the Ts digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

eg:
Input:`(7-> 1 -> 6) + (5 -> 9 -> 2)`. That is, 617 + 295.
Output: `2 -> 1 -> 9`. That is, 912.


ii) Suppose the digits are stored in forward order. Repeat the above problem.

eg:
Input:`(6 -> 1 -> 7) + (2 -> 9 -> 5)`. That is, 617 + 295.
Output: `9 -> 1 -> 2`. That is, 912.

## 2.2.6 IsCircular.java

Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.

eg: 
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
Input:`A->B->C->D->E->C`
Output: `C`

## 2.2.7 IsPalindrome.java

Implement a function to check if a linked list is a palindrome.
