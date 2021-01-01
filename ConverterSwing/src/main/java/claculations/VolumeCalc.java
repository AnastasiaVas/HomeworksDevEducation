package claculations;

public class VolumeCalc {
    double receivedValue;

    public VolumeCalc(double receivedValue){
        this.receivedValue = receivedValue;
    }

    public double toCubicMetreCalc(){
        return receivedValue * 0.001;
    }

    public double toGallonCalc(){
        return receivedValue * 0.264172;
    }

    public double toPintCalc(){
        return receivedValue * 2.11338;
    }

    public double toQuartCalc(){
        return receivedValue * 1.05669;
    }

    public double toBarrelCalc(){
        return receivedValue * 0.00628981;
    }

    public double toCubicFootCalc(){

        return receivedValue * 0.0353147;
    }
    public double toCubicInchCalc(){

        return receivedValue / 61.0237;
    }

    public double fromCubicMetreCalc(){
        return receivedValue * 1000;
    }

    public double fromGallonCalc(){
        return receivedValue * 3.78541;
    }

    public double fromPintCalc(){
        return receivedValue * 0.473176;
    }

    public double fromQuartCalc(){
        return receivedValue * 0.946353;
    }

    public double fromBarrelCalc(){
        return receivedValue * 158.987;
    }

    public double fromCubicFootCalc(){
        return receivedValue * 28.3168;
    }

    public double fromCubicInchCalc(){
        return receivedValue * 0.0163871;
    }


}