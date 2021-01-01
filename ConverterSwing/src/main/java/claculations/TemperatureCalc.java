package claculations;

public class TemperatureCalc {
    double receivedValue;

    public TemperatureCalc(double receivedValue){
        this.receivedValue = receivedValue;
    }

    public double toKelvinCalc(){
        return receivedValue + 273.15;
    }

    public double toFahrenheitCalc(){
        return receivedValue * 1.8 + 32;
    }

    public double toRomerCalc(){
        return receivedValue * 0.525 + 7.5;
    }

    public double toRankinCalc(){
        return (receivedValue + 273.15) * 1.8;
    }

    public double toNewtoneCalc(){
        return receivedValue * 0.33000;
    }

    public double toDelisleCalc(){
        return (100 - receivedValue) * 1.5;
    }

    public double fromKelvinCalc(){
        return receivedValue - 273;
    }

    public double fromFahrenheitCalc(){
        return (receivedValue - 32) * 0.5556;
    }

    public double fromRomerCalc(){
        return (receivedValue - 7.5) * 1.90476190476;
    }

    public double fromRankinCalc(){
        return (receivedValue - 491.67) * 0.55555555556;
    }

    public double fromNewtoneCalc(){
        return receivedValue * 3.030303;
    }

    public double fromDelisleCalc(){
        return 100 - receivedValue * 0.66667;
    }

}
