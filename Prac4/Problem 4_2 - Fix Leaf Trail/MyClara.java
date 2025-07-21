/* PERMITTED COMMANDS
   Clara commands:
   move(); turnLeft(); turnRight(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); mushroomFront();
   JAVA commands:
   if, else, for, while, do, &&, ||, ! */
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        // TODO: Write your code below
        while (!mushroomFront()) {
            leaveLeaf();
            leftTurn();
        }
        leafThread();
    }

    // put down a leaf
    void leafThread() {
        if(!onLeaf()) {
            putLeaf();
        }
    }

    // leave a trail of leaves when move
    void leaveLeaf() {
        leafThread();
        move();
    }

    // turn left when reach dead end
    void leftTurn() {
        if(treeFront() && !treeLeft()) {
            turnLeft();
        }
    }
}