package processor;

public abstract class Processor {
    float frequency;
    String cache;
    byte bitCapacity;
    protected String architecture;

    public Processor(float frequency, String cache, byte bitCapacity) {
        if (frequency >= 1 && frequency <= 8.723) {
            this.frequency = frequency;
        } else{
            throw new IllegalArgumentException("Frequency can't be lower that 1 Ghz or higher than 8.723 Ghz.");
        }
        if (cache != null && (cache.equals("L1") || cache.equals("L2") || cache.equals("L3"))) {
            this.cache = cache;
        } else {
            throw new IllegalArgumentException("Cache should be L1, L2 or L3.");
        }
        if (bitCapacity == 64 || bitCapacity == 32 || bitCapacity == 16 || bitCapacity == 8 || bitCapacity == 4){
            this.bitCapacity = bitCapacity;
        }else{
            throw new IllegalArgumentException("Bit capacity should be: 4, 8, 16, 32 or 64.");
        }
    }

    public String getDetails(){
        return String.format("processor.Processor details are as follows: frequency %s GHz, cache %s, bit capacity %s bits", frequency, cache, bitCapacity);
    }

    public abstract String dataProcess(String data);

    public abstract long dataProcess(long data);

    public String getArchitecture(){
        return architecture;
    }

    public float getFrequency() {
        return frequency;
    }

    public String getCache() {
        return cache;
    }

    public byte getBitCapacity() {
        return bitCapacity;
    }
}
