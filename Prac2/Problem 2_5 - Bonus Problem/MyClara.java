/* PERMITTED COMMANDS
   move, stop, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, else, &&, ||, ! */
   
class MyClara extends Clara { 
    /**
     * In the 'act()' function you can write your program for Clara 
     */
    void act() {
        // TODO: Write your code below
        if (treeFront()) {
            turnLeft();
        }
        else if (!treeRight()) {
            turnRight();
        }
        move();
        if ((treeLeft())) {
                RepRight();
        }
        if (onLeaf()) {
            removeLeaf();
            stop();
        }
    }

    void RepRight() {
            turnRight();
            turnRight();
    }

}