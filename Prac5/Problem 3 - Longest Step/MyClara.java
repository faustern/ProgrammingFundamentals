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

    int maxStep = 0;

    void run() {
    // TODO: Write your code below
        while (!onLeaf()) {
            moveCounter();

            // Navigate around the steps if not on a leaf
            if (!onLeaf()) {
                Navigate();
            }
        }

        removeLeaf(); // Remove leaf at the end
        System.out.println("longest step = " + maxStep); // Print out the longest step
    }

    // Move and find the longest step
    void moveCounter() {

        int steps = 0;

        // Move and find the length of each step
        while (!treeFront()) {
            move();
            steps++;
        }

        // Find the longest step
        if (steps > maxStep) {
            maxStep = steps;
        }
    }

    // Navigate around the steps
    void Navigate() {
        turnLeft();
        move();
        turnRight();
    }
}