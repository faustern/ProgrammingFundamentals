/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        while(!mushroomFront()) {
            leaveTrail();
            forkingPaths();
        
            rightTurn();
            leftTurn();    
            turnBack();
        }
        leaveLeaf();
    }

    // explore other available paths
    void forkingPaths() {
        if(!treeLeft() && !treeRight()) {
            turnLeft();
        }
    }

    // turn back when dead end
    void turnBack() {
        if(treeLeft() && treeRight() && treeFront()) {
            turnAround();
        }
    }

    // 180 degrees turn
    void turnAround() {
        turnLeft();
        turnLeft();
    }

    // turn right when dead end
    void rightTurn() {
        if(!treeRight() && treeFront()) {
            turnRight();
        }
    }

    // turn left when dead end
    void leftTurn() {
        if(!treeLeft() && treeFront()) {
            turnLeft();
        }
    }

    // put down a leaf
    void leaveLeaf() {
        if(!onLeaf()) {
            putLeaf();
        }
    }

    // move and put down leaves
    void leaveTrail() {
        leaveLeaf();
        move();
    }
}