import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoMaxHeap {
    private final int branchingFactor;
    private final List<Integer> heap;

    public PowerOfTwoMaxHeap(int powerFactor) {
        if (powerFactor < 0 || powerFactor > 20) {
            throw new IllegalArgumentException("powerFactor must be between 0 and 20");
        }
        this.branchingFactor = 1 << powerFactor;
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public Integer popMax() {
        if (heap.isEmpty()) return null;
        if (heap.size() == 1) return heap.remove(0);
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return maxValue;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / branchingFactor;
        while (index > 0 && heap.get(index) > heap.get(parentIndex)) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / branchingFactor;
        }
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        while (true) {
            int largest = index;
            for (int i = 1; i <= branchingFactor; i++) {
                int childIndex = branchingFactor * index + i;
                if (childIndex < size && heap.get(childIndex) > heap.get(largest)) {
                    largest = childIndex;
                }
            }
            if (largest == index) break;
            swap(index, largest);
            index = largest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
