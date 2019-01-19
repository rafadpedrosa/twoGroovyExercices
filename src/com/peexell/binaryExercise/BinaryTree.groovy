package com.peexell.binaryExercise

class BinaryTree {
    private static Node root = null

    static def addValue(value) {
        root == null
                ? root = new Node(value)
                : root.addValue(value)
    }

    static def reverseTree(){
        root.reverseChildNodes()
    }

    static def printValues(){
        root.printValues()
    }
}
