import com.peexell.binaryExercise.BinaryTree
import com.peexell.pilestonegame.PileStoneGame
import com.peexell.pilestonegame.Player

class App {

    // TIPS: change the interationSize to see more nodes or piles (eg. 1..10)
    static def interationSize = 100

    static void main(String[] args = []) {
        if (args && args[0] == "binaryTree") {
            buildBinaryTree()
        } else {
            startPileGame()
        }
    }

    static void startPileGame() {
        println("-----------------")
        println("Building the game")
        println("-----------------")

        for (def i = 0; i < interationSize; i++) {
            def randomNumber = Math.abs(new Random().nextInt() % (101 - 2)) + 2
            PileStoneGame.addPile(randomNumber)
        }
        try {
            PileStoneGame.validate()

            PileStoneGame.addPlayer("Alex")
            PileStoneGame.addPlayer("Lee")

            PileStoneGame.startGame()

            PileStoneGame.players.each { Player player ->
                println("$player.name has $player.points")
            }

            PileStoneGame.decideWinner()

            println("And the winner is: $PileStoneGame.winner.name!")
            if (PileStoneGame.winner.name == "Alex")
                println(true)
            else
                println(false)

        } catch (Exception e) {
            println(e.getMessage())
        }

    }

    static void buildBinaryTree() {
        println("Start Running the Binary tree!")
        for (def i = 0; i <= interationSize; i++) {
            def number = (Math.random() * 100).toInteger()
            println(number)
            BinaryTree.addValue(number)
        }
        println("-------Before reverse----")
        BinaryTree.printValues()
        BinaryTree.reverseTree()
        println("-------After reverse----")
        BinaryTree.printValues()
    }
}
