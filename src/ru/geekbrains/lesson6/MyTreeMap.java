package ru.geekbrains.lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;
        int height;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            size = 1;
            height = 0;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        } else return node.size;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null || node.right == null && node.left == null) {
            return 0;
        } else if (node.left != null && node.right != null) {
            return Math.max(height(node.left) + 1, height(node.right) + 1);
        } else if (node.left != null) {
            return height(node.left) + 1;
        } else return height(node.right) + 1;
    }


    public boolean isBalancedTree(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node.right!=null&&node.left!=null) {
            return height(node.left)+1==height(node.right)||
                    height(node.right)+1==height(node.left)||
                    height(node.left)==height(node.right);
        }
        if (node.right==null&&node.left!=null){
            return height(node.left)<=1;
        }
        if (node.left==null&&node.right!=null){
            return height(node.right)<=1;
        }
        return node.left == null && node.right == null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void checkKeyNotNull(Key key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException("key не должен быть null");
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        checkKeyNotNull(key);
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            return node.value;
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
    }

    public void put(Key key, Value value) {
        checkKeyNotNull(key);
        if (value == null) {
            //remove(key)
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            Node newNode = new Node(key, value);
            return newNode;
        }
        int cmp = key.compareTo(node.key);
        if (cmp == 0) {
            node.value = value;
        } else if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.right = put(node.right, key, value);
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right));
        return node;
    }

    public Key minKey() {
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Key maxKey() {
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    public void delMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("элемент не найден");
        }
        root = delMin(root);
    }

    private Node delMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = delMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right));
        return node;
    }

    public void del(Key key) {
        checkKeyNotNull(key);
        root = del(root, key);
    }

    private Node del(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = del(node.right, key);
        } else if (cmp < 0) {
            node.left = del(node.left, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node temp = node;
            node = min(node.right);
            node.right = delMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        node.height = Math.max(height(node.left), height(node.right));
        return node;
    }

    @Override
    public String toString() {
        return toString(root);
    }


    private String toString(Node node) {
        if (node == null) {
            return "";
        }
        return toString(node.left) + " " + node.key + " = " + node.value +
                toString(node.right);
    }
}
