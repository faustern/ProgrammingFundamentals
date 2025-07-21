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
        while(!onLeaf()) {
            if (!treeRight()) {
                turnRight();
                move();
            } 
            if (!treeFront()) {
                move();
            } 
            else {
                turnLeft();
            }
        }
        removeLeaf();
    }
}