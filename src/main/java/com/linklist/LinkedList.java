package com.linklist;

class LinkedList {
    private Node head;
    private int length;

    void add(int data) {
        if (isEmpty()) {
            head = new Node(data, null);
            length++;
        } else {
            Node tempNode = this.head;
            Node previous = null;
            while (tempNode != null) {
                previous = tempNode;
                tempNode = tempNode.getNext();
            }
            Node newNode = new Node(data, null);
            previous.setNext(newNode);
            length++;
        }
    }

    void printList() {
        if (isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Node tempNode = this.head;
            while (tempNode != null) {
                System.out.println(tempNode.getData());
                tempNode = tempNode.getNext();
            }
        }
    }

    int getHeadOfList() {
        if (!isEmpty()) {
            return head.getData();
        } else {
            return -1;
        }
    }

    int length() {
        return length;
    }

    private boolean isEmpty() {
        return head == null;
    }

    int get(int index) {
        if (isEmpty()) {
            return -1;
        } else if (index < 0 || index > length - 1) {
            throw new IndexOutOfBoundsException("Index out of bound: " + index);
        } else {
            Node tempNode = this.head;
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            return tempNode.getData();
        }
    }

    private static class Node {
        private int data;
        private Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        int getData() {
            return data;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node next) {
            this.next = next;
        }
    }
}
