/* PERMITTED COMMANDS
   move(); turnLeft(); putLeaf(); removeLeaf();
*/
   
class MyClara extends Clara { 
    /**
     * In the 'run()' method you can write your program for Clara 
     */
    void run() {
        move();
        turnRight();
        x2steps();
        x2steps();
        turnLeft();
        x2steps();

        int x = Clara.getRandomNumber(10);
        System.out.println(x);
    }

    void x2steps() {
        move();
        move();
    }


}