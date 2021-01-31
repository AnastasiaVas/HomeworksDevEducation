package memory;

public class Memory {

    private String[] memoryCell;

    public Memory(String[] memoryCell) {
        boolean hasNullsOnly = true;
        for (String str : memoryCell) {
            if (str != null) {
                this.memoryCell = memoryCell;
                hasNullsOnly = false;
                break;
            }
        }
        if (hasNullsOnly) {
            this.memoryCell = memoryCell;
        } else {
            throw new IllegalArgumentException("Provided array should be initialized and empty.");
        }
    }

    public String readLast() {
        return memoryCell[getLast()];
    }

    public String removeLast() {
        int lastElemInd = getLast();
        if (lastElemInd != -1) {
            String valueToReturn = memoryCell[lastElemInd];
            memoryCell[lastElemInd] = null;
            return valueToReturn;
        }
        throw new NullPointerException("memory.Memory is empty.");
    }

    private int getLast() {
        for (int i = memoryCell.length - 1; i >= 0; i--) {
            if (memoryCell[i] != null) {
                return i;
            }
        }
        return -1;
    }

    public boolean save(String str) {
        try {
            int lastElemInd = getLast();
            if (lastElemInd != -1) {
                memoryCell[lastElemInd+1] = str;
            } else {
                memoryCell[0] = str;
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public MemoryInfo getMemoryInfo() {
        int length = memoryCell.length;
        int count = 0;
        for (String s : memoryCell) {
            if (s != null) {
                count++;
            }
        }
        return new MemoryInfo(length, (double) count / length);
    }

    public static class MemoryInfo {
        private final int memoryCapacity;
        private final double occupiedMemory;

        public int getMemoryCapacity() {
            return memoryCapacity;
        }

        public double getOccupiedMemory() {
            return occupiedMemory;
        }

        public MemoryInfo(int memoryCapacity, double occupiedMemory) {
            this.memoryCapacity = memoryCapacity;
            this.occupiedMemory = occupiedMemory;
        }
    }
}
