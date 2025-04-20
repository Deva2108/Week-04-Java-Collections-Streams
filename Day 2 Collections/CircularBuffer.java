public class CircularBuffer {
    private int[] buffer;
    private int size, start, end, count;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        start = 0;
        end = 0;
        count = 0;
    }

    public void insert(int value) {
        buffer[end] = value;
        end = (end + 1) % size;
        if (count < size) count++;
        else start = (start + 1) % size;
    }

    public void printBuffer() {
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(start + i) % size] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer();
        cb.insert(4);
        cb.printBuffer();
    }
}
