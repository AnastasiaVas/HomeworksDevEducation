package device.comparators;

import device.Device;
import memory.Memory;
import processor.Processor;

import java.util.Comparator;

public class DeviceUsedMemoryComparator implements Comparator<Device> {


    @Override
    public int compare(Device o1, Device o2) {
        double occupiedMemory1 = o1.getMemoryInfo().getOccupiedMemory();
        double occupiedMemory2 = o2.getMemoryInfo().getOccupiedMemory();
        return occupiedMemory1 < occupiedMemory2 ? -1
                : occupiedMemory1 > occupiedMemory2 ? 1
                : 0;
    }
}
