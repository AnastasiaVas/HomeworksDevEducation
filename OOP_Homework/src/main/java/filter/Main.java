package filter;

import device.Device;
import memory.Memory;
import processor.Processor;
import processor.ProcessorArm;
import processor.ProcessorX86;

public class Main {
    public static void main(String args[]) {
  //      Processor processorArm = new ProcessorArm(2.2F, "L1", (byte) 64);
  //      Processor processorX86 = new ProcessorX86(2F, "L1", (byte) 64);
  //      String[] string = new String[5];
  //      String[] stringToSave = {"Lion", "Cow", "Rabbit", "Horse", "Camel", "Tiger"};
  //      String[] string2 = new String[2];
  //      Memory memory1 = new Memory(string);
  //      Memory memory2 = new Memory(string2);
  //
  //      Device device1 = new Device(processorArm, memory1);
  //      Device device2 = new Device(processorX86, memory2);
  //      device1.save(stringToSave);
        String[] stringArray = new String[5];
        Memory memory = new Memory(stringArray);
        System.out.println("Memory save a");
        memory.save("a");
        System.out.println("Memory save b");
        memory.save("b");
        System.out.println("Memory save c");
        memory.save("c");
        System.out.println("Memory getLast");
        System.out.println(memory.removeLast());
    }
}
