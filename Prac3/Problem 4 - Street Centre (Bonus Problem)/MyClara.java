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
        move();
        while (!treeFront()) {
            putLeaf();
            move();
        }
        
        turnAround();
        move();

        while (onLeaf()) {
            move();

            while (onLeaf()) {
                move();

                if (!onLeaf()) {
                    turnAround();
                    move();
                    removeLeaf();
                    move();
                }
            }
        }

        if(!onLeaf()) {
            turnAround();
            move();
            putLeaf();
        }
    }

    void turnAround() {
        turnLeft();
        turnLeft();
    }
}