package device.comparators;

import device.Device;

import java.util.Comparator;

public class DeviceMemoryCapComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2) {
        return o1.getMemoryInfo().getMemoryCapacity() - o2.getMemoryInfo().getMemoryCapacity();
    }
}
