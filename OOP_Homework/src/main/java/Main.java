public class Main {
    public static void main (String args[]){
ProcessorArm processorArm = new ProcessorArm(2.2F, "L1", (byte) 64);
        String[] string = new String[5];
    Memory memory = new Memory(string);
    Device device = new Device(processorArm, memory);
    String[] stringToSave = {"Lion", "Cow", "Rabbit", "Horse", "Camel", "Tiger"};
    device.save(stringToSave);
    for (String str : string){
        System.out.println(str);
    }
    }
}
