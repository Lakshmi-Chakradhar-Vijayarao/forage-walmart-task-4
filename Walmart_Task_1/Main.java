public class Main {
    public static void main(String[] args) {
        PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2); // 2^2 = 4 children

        heap.insert(10);
        heap.insert(40);
        heap.insert(30);
        heap.insert(20);
        heap.insert(60);
        heap.insert(5);

        while (true) {
            Integer val = heap.popMax();
            if (val == null) break;
            System.out.println(val);
        }
    }
}
