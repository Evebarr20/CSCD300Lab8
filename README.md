# CSCD300Lab8
Queue Class: Merge, MergeSort

To turn in: please wrap up all your java source files (.java files) into a zip file, then turn in 
the  single  zip  file  on  the  EWU  Canvas  by  going  to  CSCD300-01  course  page  on  Canvas,  then 
clicking  AssignmentsHW8->submit.  Please  name  your  zip  file  with  your  last  name,  followed 
by the first initial of your first name, followed by hw8. For example, if you are John Smith, name 
you file as smithjhw8.zip
Specifics
1) You have to implement your own LinkedList class in this homework (either Doubly or 
Singly is acceptable). And, you have to implement your own Queue class. Your 
LinkedList class and Queue class must be separate.
2) Please implement the MergeSort() method in your LinkedList class, which is designed for 
sorting a LinkedList with the merge sort algorithm, as we learned in the classroom. The 
logic idea is shown below, which is entirely different from the logic idea of the 
MergeSort on an array. If you fail to follow the logic idea as described below, you could 
get a zero in this project.
1, Create a Queue object q, then enqueue each data object in the linked list to be sorted, as a 
single-node LinkedList. The following piece of pseudo code illustrates this step.
    {    
             Queue q = new Queue()      
For each data object D in the linked list to be sorted
          first create a new linked list object, newList = new LinkedList(), 
          perform newList.addFirst(D), 
          q.enqueue(newList)
End For
   }
2, while there is more than one items in the Queue q {
a. dequeue and assign to a LinkedList  reference sublist1, (already sorted)
b. dequeue again and assign to another LinkedList reference sublist2, (already sorted)
c. walk through sorted sublist1 and sorted sublist2 and merge them into a larger sorted 
list tempList, with tempList = merge(sublist1, sublist2 )
d.    q.enqueue( tempList )
    }
3, dequeue your sorted linked list. Here think about how to make this list sorted, because the 
dequeued list and this list are different object. Hint: we learned this technique when we used 
addOrdered() method to sort an linked list.
3) The logic idea of the merge() method in the step 2.c above is also provided in the below.
 
Algorithm merge(A, B)
Input sorted SubList A and sorted SubList B
Output sorted sequence C as Union A and B
S <--create an empty list with size equal to size(A) + size(B)
while (A is not Empty and B is not Empty ) {
            fa = A.getFirst(); //return the first piece of data element in A, but not delete
            fb = B.getFirst();
if   fa <  fb {
A.removeFirst() //A becomes shorter
S.addLast(fa) // supposed to have O(1) time complexity 
           }
else {
                        B.removeFirst()  //B becomes shorter
S.addLast(fb) // supposed to have O(1) time complexity
           }
}
while A is not Empty {
      fa = A.getFirst();
      S.addLast( fa)// supposed to have O(1) time complexity
      A.removeFirst();
}
while B is not Empty() {
      fb = B.getFirst();
      S.addLast(fb) // supposed to have O(1) time complexity
      B.removeFirst();
}
return S;
4) Please implement the InsertionSort() method in your LinkedList class that is designed for 
sorting a LinkedList object with InsertionSort Algorithm, as we learned in the classroom.
5) Please write a method boolean isSorted() in your LinkedList class to verify whether this 
LinkedList is correctly sorted in an ascending order or not. 
boolean isSorted()
Note: isSorted() returns true, if this list has been sorted in ascending order. Otherwise it 
returns false.
Note: your isSorted() has to run in the time complexity of O(n), where n is the size of the 
input LinkedList. In other words, you scan this input list once, you should know whether 
it is sorted or not.
6) In your main() method in a source file named Tester.java, please create an empty 
LinkedList A, then please use the Java Random class to generate a sequence of 20,000 
random integers, which range between 0 and 3,000,000. And you have to save all the 
random numbers into the LinkedList A, with each list node of A holding one integer. 
NOTE PLEASE READ: For those who have an old and slow machine, sorting two 
20,000 integers maybe too time-consuming. You can generate 2000 integers and sort 
them, instead of 20,000.
7) In your main() method of the Tester.java file, please create another separate LinkedList 
object A2, which contains the same set of random integers as A does.
8) Please invoke your MergeSort() method on the input list A in the java file Tester.java. 
Then call A.isSorted() to verify whether A is correctly sorted. You should expect that 
A.isSorted() returns true.
9) Please invoke your InsertionSort() method on the input list A2 in the  java file 
Tester.java. Then call A2.isSorted() to verify whether A2 is correctly sorted. You should 
expect that A2.isSorted() returns true.
10) Your main() method of your Tester class should perform the operations described in the 
below. The method calls in your main() may differs from mine syntactically, with a 
different method interface. But, your main() should generally performs the operations that 
are listed below.
11)  In the below is the correct output of your program. Note that the time cost may varies on 
different machines, however, generally mergesort should be much quicker than 
insertionsort.
12) Please organize your source code so that I can compile all your source files in one folder 
using command, javac *.java, and run your program using command on command line, 
java Tester. 
13) In this project, you have to implement three separate java classes of your own: Queue, 
LinkedList, Tester.
14) You can have your own design for any details that have NOT been specified in this 
document.
