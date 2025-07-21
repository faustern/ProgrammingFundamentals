/* PERMITTED COMMANDS
   Clara commands:
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); mushroomFront();
   JAVA commands:
   if, while, for, do, !, ||, &&
    */
   
class MyClara extends Clara { 
    /**
     * In the 'run()' function you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        while(!mushroomFront()) {

            backOnTrack();
            moveAndEat();

            leftTurn();
            rightTurn();
        }
        eatLeaf();
    }

    // loop breaker (world 1)
    void w1LoopBreaker() {
        if(!treeRight() && !treeLeft()) {
                turnRight();
            }
    }

    // pick up leaves
    void eatLeaf() {
        if(onLeaf()) {
            removeLeaf();
        }
    }

    // move and pick up leaves
    void moveAndEat() {
        eatLeaf();
        move();
    }

    // 180 degrees turn
    void turnAround() {
        turnLeft();
        turnLeft();
    }

    // turn left when dead end
    void leftTurn() {
        if(!treeLeft() && treeFront()) {
            turnLeft();
        }
    }
    
    // turn right when dead end
    void rightTurn() {
        if(!treeRight() && treeFront()) {
            turnRight();
        }
    }

    // turn back when no leaves
    void backOnTrack() {
        if(!onLeaf()) {
            turnAround();
            move();
            
            w1LoopBreaker();
        }
    }
}