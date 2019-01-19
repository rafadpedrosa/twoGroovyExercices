package com.peexell.pilestonegame

class PileStoneGame {

    private static def piles = []
    static def players = []
    static Player winner

    PileStoneGame(def piles_) {
        piles = piles_
    }

    static boolean startGame() {
        println("-----------------")
        println("Starting the game")
        println("-----------------")

        def gamerTurn = 0
        while (piles.size() > 0) {
            def player = (Player) players[gamerTurn]
            // println("Player turn: $player.name")
            player.take()

            gamerTurn = tryResetTurn(gamerTurn)
        }
    }

    static void addPile(def pile) {
        println("Added: $pile stones in the piles row")
        piles.add(pile)
    }

    static void decideWinner() {
        while (players.size() > 1) {
            Player firstPlayer = players.pop()
            Player secondPlayer = players.pop()

            if (firstPlayer.points > secondPlayer.points) {
                players.add(firstPlayer)
            } else {
                players.add(secondPlayer)
            }
        }
        winner = players.pop()
    }

    static def addPlayer(String player) {
        println("Player $player entered in game")
        players.add(new Player(piles, player))
    }

    static def validate() throws Exception {
        pileEven()
        pilesEmpty()
        pileSumOdd()
    }

    private static int tryResetTurn(int gamerTurn) {
        if (++gamerTurn == players.size()) {
            gamerTurn = 0
        }
        gamerTurn
    }

    private static def pilesEmpty() {
        if (piles.size() <= 0) {
            throw new Exception("The game can't initialize *without a pile row*")
        }
    }

    private static def pileEven() {
        if (piles.size() >= 2 && piles.size() % 2 != 0) {
            throw new Exception("The game can't initialize *with 0 or a ODD* pile row number")
        }
    }

    private static def pileSumOdd() {
        def sumTotal = piles.inject { totalValue, currentPileValue ->
            totalValue + currentPileValue
        }
        if (sumTotal % 2 == 0) {
            throw new Exception("The game can't initialize *with a ODD SUM* pile row number")
        }
    }
}
