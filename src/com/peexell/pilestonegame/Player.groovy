package com.peexell.pilestonegame

class Player {
    String name
    Integer points = 0
    def Piles = []

    Player(def piles, def name){
        this.piles = piles
        this.name = name
    }

    void take(){
        def first = this.piles.last()
        def last = this.piles.first()

        if(first >= last){
            points += this.piles.pop()
        } else {
            points += this.piles.removeLast()
        }
    }
}
