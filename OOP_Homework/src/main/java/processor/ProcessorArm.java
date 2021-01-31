package processor;

public class ProcessorArm extends Processor {

    public final String architecture = "ARM";

    public ProcessorArm(float frequency, String cache, byte bitCapacity) {
        super(frequency, cache, bitCapacity);
        super.architecture = this.architecture;
    }

    @Override
    public String dataProcess(String data) {
        if (data == null){
            throw new NullPointerException("Provided string hasn't been initialized.");
        }
       return data + "A";
    }

    @Override
    public long dataProcess(long data) {
        return data + 3;
    }
}
