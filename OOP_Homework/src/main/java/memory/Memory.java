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
                memoryCell[lastElemInd] = str;
                return true;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
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

    public class MemoryInfo {
        private int memoryCapacity;
        private double occupiedMemory;

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
