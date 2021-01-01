package claculations;

public class WeightCalc {
    double receivedValue;

    public WeightCalc(double receivedValue){
        this.receivedValue = receivedValue;
    }

    public double toGramCalc(){
        return receivedValue * 1000;
    }

    public double toCaratCalc(){
        return receivedValue * 5000;
    }

    public double toEngPoundCalc(){
        return receivedValue * 0.3048;
    }

    public double toPoundCalc(){
        return receivedValue * 0.3048;
    }

    public double toStoneCalc(){
        return receivedValue * 0.157473;
    }

    public double toRusPoundCalc(){
        return receivedValue * 3.28084;
    }

    public double fromGramCalc(){
        return receivedValue / 1000;
    }

    public double fromCaratCalc(){
        return receivedValue * 0.2;
    }

    public double fromEngPoundCalc(){
        return receivedValue / 0.3048;
    }

    public double fromPoundCalc(){
        return receivedValue * 453.592;
    }

    public double fromStoneCalc(){
        return receivedValue * 6350.29;
    }

    public double fromRusPoundCalc(){
        return receivedValue / 3.28084;
    }
}
