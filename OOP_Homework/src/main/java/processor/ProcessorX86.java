package processor;

public class ProcessorX86 extends  Processor{

    public final String architecture = "X86";

    public ProcessorX86(float frequency, String cache, byte bitCapacity) {
        super(frequency, cache, bitCapacity);
        super.architecture = this.architecture;
    }

    @Override
    public String dataProcess(String data) {
        return data + "B";
    }

    @Override
    public long dataProcess(long data) {
        return data - 3;
    }
}