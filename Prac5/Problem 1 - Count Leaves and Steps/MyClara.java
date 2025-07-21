/* PERMITTED COMMANDS
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf();
   JAVA
   if, else, for, while, do, !, ||, && 
   variables
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    
    int steps = 0;
    int leaf = 0;

    void run() {
        // TODO: Write your code below
        while (!treeFront()) {
            moveAndCount();
            rightTurn();
        }

        // print out the number of collected leaves and steps
        System.out.println(leaf + " leaves, " + steps + " steps");
    }

    // move and count steps
    void moveAndCount() {
        pickLeaf();
        move();
        pickLeaf();
        steps++;
    }

    // pick up and count leaves
    void pickLeaf() {
        if(onLeaf()) {
            removeLeaf();
            leaf++;
        }
    }
    
    // turn right when reach dead end
    void rightTurn() {
        if(treeFront() && !treeRight()) {
            turnRight();
        }
    }
}