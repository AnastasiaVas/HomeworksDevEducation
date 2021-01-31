package filter;

import device.Device;
import device.comparators.DeviceArchComparator;
import device.comparators.DeviceMemoryCapComparator;
import device.comparators.DeviceProcessorParamComparator;
import device.comparators.DeviceUsedMemoryComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class DeviceFiltration {
    ArrayList<Device> listToReturn =  new ArrayList<>();

    public ArrayList<Device> compareByProcessorArch(ArrayList<Device> deviceList, Device device){
        DeviceArchComparator deviceArchComparator = new DeviceArchComparator();
        return compareInner(deviceList, device, deviceArchComparator);
    }

    public ArrayList<Device> compareByProcessorParam(ArrayList<Device> deviceList, Device device){
        DeviceProcessorParamComparator devicePPC = new DeviceProcessorParamComparator();
        return compareInner(deviceList, device, devicePPC);
    }

    public ArrayList<Device> compareByMemoryCap(ArrayList<Device> deviceList, Device device){
        DeviceMemoryCapComparator deviceMemoryCapComparator = new DeviceMemoryCapComparator();
        return compareInner(deviceList, device, deviceMemoryCapComparator);
    }

    public ArrayList<Device> compareByUsedMemory(ArrayList<Device> deviceList, Device device){
        DeviceUsedMemoryComparator deviceUsedMemoryComparator = new DeviceUsedMemoryComparator();
        return compareInner(deviceList, device, deviceUsedMemoryComparator);
    }

    private ArrayList<Device> compareInner(ArrayList<Device> deviceList, Device device, Comparator<Device> comparator){
        for (Device deviceElem : deviceList) {
            if (comparator.compare(deviceElem, device) == 0){
                listToReturn.add(deviceElem);
            }
        }
        return listToReturn;
    }
}
