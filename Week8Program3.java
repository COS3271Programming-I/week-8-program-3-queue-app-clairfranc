package week8;

//Claire Francis, Week8Program3, October 24, 2025
import java.util.Queue;
import java.util.LinkedList;

public class Week8Program3 {

	public static void main(String[] args) {
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        char let = 'A';  // Start with 'A' for the first person
        int time = 0;
        int rn;  // Random number generator for actions
        String person = "" + let + let + let;  // The first person is "AAA"
        
        // Add the first person to either queue, for example, queue1
        queue1.add(person);

        // Simulate for 40 time intervals
        while (time < 40) {
            rn = (int)(Math.random() * 6);  // Generate a random number between 0 and 5

            // Add a new person to either queue (queue1 or queue2)
            if (rn == 1 || rn == 2) {
                let++;  // Move to the next letter (B, C, D...)
                if (let <= 'Z') {  // Ensure we don't run out of letters (A-Z)
                    person = "" + let + let + let;  // Create a new person ID
                    if (Math.random() < 0.5) {  // 50% chance to add to either queue
                        queue1.add(person);
                    } else {
                        queue2.add(person);
                    }
                }
            }

            // Remove a person from either queue (queue1 or queue2)
            if (rn == 3 || rn == 4 || rn == 5) {
                if (!queue1.isEmpty() && Math.random() < 0.5) {
                    queue1.poll();  // Remove from queue1
                } else if (!queue2.isEmpty()) {
                    queue2.poll();  // Remove from queue2
                }
            }

            // Print the state of both queues after each time interval
            System.out.println("Time " + time + " : ");
            System.out.println("Queue 1: " + queue1);
            System.out.println("Queue 2: " + queue2);
            time++;  // Increment the time step
        }

	}

}
