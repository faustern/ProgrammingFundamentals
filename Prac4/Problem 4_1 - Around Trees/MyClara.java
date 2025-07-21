/* PERMITTED COMMANDS
   move, turnLeft, turnRight, treeLeft, treeRight, treeFront, onLeaf, putLeaf, removeLeaf, mushroomFront
   JAVA
   if, while, for
*/
   
class MyClara extends Clara { 
    void run() {

        moveAndEat();
        
        while (!mushroomFront()) {

            // move and pick up leaf when there's no tree in front
            if(!treeFront()) {
                moveAndEat();
            }

            // stop when in front of mushroom (world 2)
            if (mushroomFront()) {
                break;
            }

            // detect and pick up leaf
            if (!treeRight()) {
                moveHole();
            }

            // Dodge tree in front
            if (treeFront()) {
                moveHole();
            }
        }
    }

// move and pick up leaf
    void moveAndEat() {
        move();
        eatLeaf();
    }

    void eatLeaf() {
        if (onLeaf()) {
            removeLeaf();
        }
    }

// move into spaces between trees
    void moveHole() {
        turnRight();
        moveAndEat();
        turnLeft();
    }
}