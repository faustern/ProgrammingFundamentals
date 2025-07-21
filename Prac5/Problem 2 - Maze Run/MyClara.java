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
    boolean leafAtStart = false;

    void run() {
        // TODO: Write your code below
        while (!mushroomFront()) {
            leafStart();

            moveToEnd();

            Navigate();
        }
    }

    // Check for leaf at the start of the corridor
    void leafStart() {
        if(onLeaf()) {
            leafAtStart = true;
            removeLeaf(); // Remove leaf if there is one
        }
    }

    // Move Clara until she hits a tree or stands in front of the mushroom
    void moveToEnd() {
        while(!treeFront() && !mushroomFront()) {
            move();
        }
    }

    // Turn based on whether there was a leaf at the start of the corridor
    void Navigate() {
        if (leafAtStart == true) 
        {
            turnRight();  // Turn right if there was a leaf at the start
        } 
        else if (!mushroomFront()) 
        {
            turnLeft();  // Otherwise, turn left
        }

        leafAtStart = false;  // Reset leaf tracking after navigating

    }
}