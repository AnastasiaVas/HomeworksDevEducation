package device;
import memory.Memory;
import processor.Processor;

public class Device {

    Processor processor;
    Memory memory;
    Memory.MemoryInfo memoryInfo = memory.getMemoryInfo();

    public Device(Processor processor, Memory memory) {
        this.processor = processor;
        this.memory = memory;
    }

    public void save(String[] data) {
        for (String str : data) {
            if (!memory.save(str)) {
                throw new OutOfMemoryError("Not enough memory to save " + str);
            }
        }
    }

    public String[] readAll() {
        int cellsOccupied = (int) memoryInfo.getOccupiedMemory() * memoryInfo.getMemoryCapacity();
        String[] resultArray = new String[cellsOccupied];
        for (int i = 0; i < cellsOccupied; i++) {
            try {
                resultArray[i] = memory.removeLast();
            } catch (NullPointerException e) {
                break;
            }
        }
        return resultArray;
    }

    public void dataProcessing(){
        String[] resultArray = readAll();
        for (String str : resultArray) {
            memory.save(processor.dataProcess(str));
        }
    }

    public String getSystemInfo(){
        return String.format(processor.getDetails() + " memory.Memory capacity is %s and occupied memory space is %s", memoryInfo.getMemoryCapacity(), memoryInfo.getOccupiedMemory());
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory.MemoryInfo getMemoryInfo() {
        return memoryInfo;
    }
}