package com.billing.service;

import java.util.*;

class Node<E> {
    Node<E> next;
    Node<E> prev;
    E data;

    public Node() {
        this.data = null;
        this.next = null;
        this.prev = null;
    }

    public Node(E data) {
        this.data = data;
    }

}
public class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    public int size;

    public MyLinkedList() {
        size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public void addFront(E data) {
        Node newNode = new Node(data);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;

        size++;
    }

    public void add(E data) {
        Node newNode = new Node(data);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;

        size++;
    }

    public void add(E data, int position) {
        if(position > size) {
            System.out.println("Position greater than size!");
        }

        else {
            Node newNode = new Node(data);
            Node currentNode = head;
            int count = 1;

            while(count < position) {
                currentNode = currentNode.next;
                count++;
            }

            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;

            size++;

        }
    }

    public void search(E data) {
        if(size == 0)
            System.out.println("Empty List!");

        else {
            Node currentNode = head.next;
            int position = 1;

            do {
                if(currentNode.data == data) {
                    System.out.println("Node found at position " + position);
                    break;
                }

                else {
                    currentNode = currentNode.next;
                    position++;
                }
            } while(currentNode != tail);

            if(position > size)
                System.out.println("Node not found.");
        }

    }

    public void delete(E data) {
        if(size == 0)
            System.out.println("Empty List!");

        else {
            Node currentNode = head.next;
            int position = 1;

            do {
                if(currentNode.data == data) {
                    currentNode.prev.next = currentNode.next;
                    currentNode.next.prev = currentNode.prev;
                    delete((E) currentNode);
                    System.out.println("Node deleted successfully!");
                    break;
                }

                else {
                    currentNode = currentNode.next;
                    position++;
                }
            } while(currentNode != tail);

            if(position > size)
                System.out.println("Node not found.");
        }
    }

    public void display() {
        if (size == 0) {
            System.out.println("Empty List!");
        } else {
            Node currentNode = head;
            System.out.println();
            while (currentNode.next != tail) {
                currentNode = currentNode.next;
                System.out.print(currentNode.data + " ");
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        MyLinkedList linkedList = new MyLinkedList<Integer>();
        int ans = 1, data;

        do {
            System.out.println("**MENU**");
            System.out.println("1.Add element");
            System.out.println("2.Add first element");
            System.out.println("3.Add element at a position");
            System.out.println("4.Search element");
            System.out.println("5.Delete element");
            System.out.println("6.Display linked list");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    linkedList.add(data);
                    break;

                case 2:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    linkedList.addFront(data);
                    break;

                case 3:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    System.out.println("Enter the position: ");
                    int position = sc.nextInt();
                    linkedList.add(data, position);
                    break;

                case 4:
                    System.out.println("Enter the element to search: ");
                    data = sc.nextInt();
                    linkedList.search(data);
                    break;

                case 5:
                    System.out.println("Enter the element to be deleted: ");
                    data = sc.nextInt();
                    linkedList.delete(data);
                    break;

                case 6:
                    linkedList.display();
                    break;

                default:
                    break;

            }

            System.out.println("Do you want to continue?(1/0) ");
            ans = sc.nextInt();

        } while(ans == 1);
    }

}
