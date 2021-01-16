public class ProcessorArm extends Processor {

    public ProcessorArm(float frequency, String cache, byte bitCapacity) {
        super(frequency, cache, bitCapacity);
    }

    @Override
    public String dataProcess(String data) {
       return data + "A";
    }

    @Override
    public long dataProcess(long data) {
        return data + 3;
    }
}
