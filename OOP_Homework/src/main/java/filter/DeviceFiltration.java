package main;

import device.Device;
import device.comparators.DeviceArchComparator;
import device.comparators.DeviceProcessorParamComparator;
import memory.Memory;
import processor.Processor;
import processor.ProcessorArm;
import processor.ProcessorX86;

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

    private ArrayList<Device> compareInner(ArrayList<Device> deviceList, Device device, Comparator<Device> comparator){
        for (Device deviceElem : deviceList) {
            if (comparator.compare(deviceElem, device) == 0){
                listToReturn.add(deviceElem);
            }
        }
        return listToReturn;
    }
}
