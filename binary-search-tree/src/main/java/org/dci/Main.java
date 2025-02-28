package org.dci;

public class Main {
    public static void main(String[] args) {
        MyLinkedList sortedList = new MyLinkedList(new Node("4"));
        sortedList.addItem(new Node("8"));
        System.out.println("Tree looks like: ");
        sortedList.traverse(sortedList.getRoot());

        sortedList.addItem(new Node("6"));
        sortedList.addItem(new Node("9"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());

        sortedList.addItem(new Node("2"));
        sortedList.addItem(new Node("1"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());


        sortedList.removeItem(new Node("9"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());

        sortedList.removeItem(new Node("4"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());

        sortedList.removeItem(new Node("1"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());

        sortedList.removeItem(new Node("9"));
        sortedList.removeItem(new Node("4"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());


        sortedList.addItem(new Node("0"));
        sortedList.addItem(new Node("3"));
        sortedList.removeItem(new Node("1"));
        System.out.println("\nNoe tree looks like: ");
        sortedList.traverse(sortedList.getRoot());



        MyLinkedList myLinkedList = new MyLinkedList(new Node("4"));
        myLinkedList.addItem(new Node("5"));
        myLinkedList.addItem(new Node("6"));
        myLinkedList.addItem(new Node("8"));
        myLinkedList.removeItem(new Node("4"));
        myLinkedList.addItem(new Node("1"));
        myLinkedList.removeItem(new Node("4"));
        System.out.println("\nMy New Tree looks like:");
        myLinkedList.traverse(myLinkedList.getRoot());

        myLinkedList.addItem(new Node("11"));
        myLinkedList.addItem(new Node("10"));
        System.out.println("\nNow tree looks like:");
        myLinkedList.traverse(myLinkedList.getRoot());
    }
}