public class ProcessorX86 extends  Processor{

    public ProcessorX86(float frequency, String cache, byte bitCapacity) {
        super(frequency, cache, bitCapacity);
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
