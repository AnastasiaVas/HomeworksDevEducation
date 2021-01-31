package device.comparators;

import device.Device;
import processor.Processor;

import java.util.Comparator;

public class DeviceProcessorParamComparator implements Comparator<Device> {

    @Override
    public int compare(Device o1, Device o2){
        if (o1 != null && o2 != null){
            Processor processor1 = o1.getProcessor();
            Processor processor2 = o2.getProcessor();
            if (processor1.getFrequency() != processor2.getFrequency()){
                return processor1.getFrequency() < processor2.getFrequency() ? -1
                        : processor1.getFrequency() > processor2.getFrequency() ? 1
                        : 0;
            }
            if (!processor1.getCache().equals(processor2.getCache())){
                return processor1.getCache().compareTo(processor2.getCache());
            }
            if (processor1.getBitCapacity() != processor2.getBitCapacity()){
                return processor1.getBitCapacity() - processor2.getBitCapacity();
            }
        }
        return 0;
    }
}
