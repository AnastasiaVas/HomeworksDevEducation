package device.comparators;

import device.Device;

import java.util.Comparator;

public class DeviceArchComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2){
        String arch1 =  o1.getProcessor().getArchitecture();
        String arch2 = o2.getProcessor().getArchitecture();
        return arch1.compareTo(arch2);
    }
}
