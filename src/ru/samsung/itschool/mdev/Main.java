package ru.samsung.itschool.mdev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	/*
	Дерево называется сбалансированным, если для любой его вершины высота левого
	и правого поддерева для этой вершины различаются не более чем на 1.

    Входные данные
    Вводится последовательность целых чисел, оканчивающаяся нулем.
    Сам ноль в последовательность не входит.
    Постройте дерево, соответствующее данной последовательности.

    Выходные данные
    Определите, является ли дерево сбалансированным, выведите слово YES или NO.

    7 3 2 1 9 5 4 6 8 0 - YES
    1 2 0 - YES
    1 2 3 0 - NO
    2 1 3 0 - YES
    2 1 3 9 5 4 7 6 8 0 - NO
    https://www.cs.usfca.edu/~galles/visualization/BST.html
	 */

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        Node root = new Node(input);
        while (input != 0) {
            root.add(new Node(input));
            input = scanner.nextInt();
        }
        scanner.close();

        System.out.println(root.isBalanced() ? "YES" : "NO");
    }


}

class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;

    Node(int val) {
        this.value = val;
    }

    public boolean isBalanced() {
        if (left == null && right == null) {
            return true;
        } else if (left == null) {
            return right.height == 1;
        } else if (right == null) {
            return left.height == 1;
        } else {
            int heightDiff = left.height - right.height;
            return Math.abs(heightDiff) <= 1 && left.isBalanced() && right.isBalanced();
        }
    }

    public void add(Node node) {
        if (node.value < this.value) {
            if(left == null) {
                left = node;
            } else {
                left.add(node);
            }
            // высота
            if(right == null) {
                height = left.height + 1;
            } else {
                height = Math.max(left.height, right.height) + 1;
            }



        } else if(node.value > this.value) {
            if(right == null) {
                right = node;
            } else {
                right.add(node);
            }
            if(left == null) {
                height = right.height + 1;
            } else {
                height = Math.max(left.height, right.height) + 1;
            }
        }

    }
}
