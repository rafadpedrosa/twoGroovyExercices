package com.peexell.binaryExercise

class Node {

    Integer value
    Node leftNode
    Node rightNode

    Node(value) {
        this.value = value
    }

    def isLeftPriority = { value -> value <= this.leftNode.value }
    def isNodeNull = { node -> node == null }

    def addValue(def value) {
        if (isNodeNull(this.leftNode)) {
            this.leftNode = new Node(value)
        } else if (isLeftPriority(value)) {
            this.leftNode.addValue(value)
        } else if (isNodeNull(this.rightNode)) {
            this.rightNode = new Node(value)
        } else {
            this.rightNode.addValue(value)
        }
    }

    def reverseChildNodes() {
        def nodes = [this.rightNode, this.leftNode]
        this.leftNode = nodes.pop()
        this.rightNode = nodes.pop()

        this.leftNode?.reverseChildNodes()
        this.rightNode?.reverseChildNodes()
    }

    def printValues() {
        def getNodeValue = { node ->
            def nodeValue = node?.value
            return nodeValue ? nodeValue : -1
        }

        def leftValue = getNodeValue(this.leftNode)
        def rightValue = getNodeValue(this.rightNode)

        println("father ${this.value} // left ${this.leftNode?.value} // ${this.rightNode?.value}")
        println("##################")

        // I'm printing values sorted to facilitate the diff.
        if (leftValue >= rightValue) {
            [this.leftNode, this.rightNode].each { node -> node?.printValues() }
        } else {
            [this.rightNode, this.leftNode].each { node -> node?.printValues() }
        }
    }
}
