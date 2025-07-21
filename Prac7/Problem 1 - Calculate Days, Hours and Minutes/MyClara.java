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
        // Number of seconds input
        int totalSeconds = readInt("Enter the number of seconds: ");

        // Ensure the input is positive
        if (totalSeconds < 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        // Calculate the number of days, hours, minutes, and seconds
        int days = totalSeconds / (24 * 3600);
        totalSeconds %= (24 * 3600);

        int hours = totalSeconds / 3600;
        totalSeconds %= 3600;

        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        // Output the result
        System.out.println("Number of Days: " + days);
        System.out.println("Number of Hours: " + hours);
        System.out.println("Number of Minutes: " + minutes);
        System.out.println("Number of Seconds: " + seconds);
    }
}