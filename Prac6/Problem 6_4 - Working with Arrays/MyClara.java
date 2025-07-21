/* PERMITTED COMMANDS 
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront,
   addTree(x, y),
   JAVA
   if, while, for, do, &&, !, ||, variables, arrays
*/
   
class MyClara extends Clara {

    // Array representing the stair pattern, where 1 indicates a tree
    int[][] stairs = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
        {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
        {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    };

    void run() {
        // Build the stairs
        buildStairs();
        
        // Climb the stairs, collect the leaf, and return
        climbStairs();
        collectLeaf();
        descendStairs();
    }

    // Build the stairs by adding trees according to the array
    void buildStairs() {
        for (int y = 0; y < stairs.length; y++) {
            for (int x = 0; x < stairs[y].length; x++) {
                if (stairs[y][x] == 1) {
                    addTree(x, y);
                }
            }
        }
    }

    // Climb the Stairs
    void climbStairs() {
        while (!onLeaf()){
            turnLeft();
            collectLeaf();
            turnRight();
            collectLeaf();
        }
    }

    // Move and collect the leaf at the top of the stairs
    void collectLeaf() {
        if (onLeaf()) {
            removeLeaf();
        }
        move();
    }

    // Descend the Stairs
    void descendStairs() {
        while (!treeFront()) {
            turnRight();
            move();
            turnLeft();
            move();
        }
    }
}