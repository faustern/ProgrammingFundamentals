/* PERMITTED COMMANDS
   move(); treeLeft(); treeRight(); treeFront(); onLeaf(); putLeaf(); removeLeaf(); stop();
   JAVA
   if, else, &&, ||, ! */
   
class MyClara extends Clara { 
    /**
     * In the 'act()' method you can write your program for Clara 
     */
    void act() {
        // TODO: Write your code below
        if (treeLeft() || treeRight()) {
                putLeaf();
        }

        if (!treeFront()) {            
            move();
        }
        else {
            stop();
        }
    }
}