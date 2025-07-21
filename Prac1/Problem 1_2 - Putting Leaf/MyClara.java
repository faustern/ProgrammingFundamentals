/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        move();
        Leaf();
        Leaf();
        Leaf();
        Leaf();
        Leaf();
        move();
    }

    void Leaf() {
        putLeaf();
        move();
        move();
    }
}