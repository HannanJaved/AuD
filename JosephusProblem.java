public class JosephusProblem {
 // Solve the Josephus problem for a list of persons and a number k
// of persons to be skipped. The solution should "simulate" the
// counting-out and return a queue that contains all persons in the
// order they were counted out.
//

    public static Queue<String> solve(String[] persons, int k) {
        //TODO: implementation
        Queue<String> queue = new Queue<String>();
        Queue<String> nq = new Queue<String>();

        int count = persons.length;

        for (int i = 0; i < count; i++) {
            queue.enqueue(persons[i]);
        }
        //System.out.println("The queue is : " + queue);

        while(!queue.is_empty()){
            for (int i = 0; i < k - 1; i++) {
                String eliminatedPosition = queue.dequeue();
                queue.enqueue(eliminatedPosition);  //new queue with order of execution
            }
            nq.enqueue(queue.dequeue());
        }
        System.out.println("The new queue is : " + nq);
        return nq;
    }
    public static void main(String[] args) {
        //TODO: test
        String[] names = {"Jan","Jil","Ulf", "Kai", "Mark"};// = {"abcdefghijklm"};
        //System.out.println("Order of execution : ");
        solve(names,5);
    }
}