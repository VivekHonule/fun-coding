package com.linklist;

public class Main {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(5);
        linkedList.printList();
        System.out.println("Head is pointing to: " + linkedList.getHeadOfList());
        System.out.println("Length of the string is: " + linkedList.length());
        int index = 1;
        System.out.println("Node present at index " + index + " is: " + linkedList.get(index));
        linkedList.add(6);
        int index2 = 2;
        System.out.println("Node present at index " + index2 + " is: " + linkedList.get(index2));
    }
}
