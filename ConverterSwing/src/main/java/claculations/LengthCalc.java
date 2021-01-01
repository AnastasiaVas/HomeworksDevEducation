package claculations;

public class LengthCalc {
    double receivedValue;

    public LengthCalc(double receivedValue){
        this.receivedValue = receivedValue;
    }

    public double toKMCalc(){
        return receivedValue * 1000;
    }

    public double toMilesCalc(){
        return receivedValue * 0.00062;
    }

    public double toNautMilesCalc(){
        return receivedValue * 0.0005399568;
    }

    public double toCableCalc(){
        return receivedValue * 0.0054;
    }

    public double toLeagueCalc(){
        return receivedValue * 0.0002071237;
    }

    public double toFootCalc(){
        return receivedValue * 3.28084;
    }

    public double toYardCalc(){
        return receivedValue * 1.09361;
    }

    public double fromKMCalc(){
        return receivedValue / 1000;
    }

    public double fromMilesCalc(){
        return receivedValue * 1609.34;
    }

    public double fromNautMilesCalc(){
        return receivedValue * 1852;
    }

    public double fromCableCalc(){
        return receivedValue * 185.3184;
    }

    public double fromLeagueCalc(){
        return receivedValue * 5556;
    }

    public double fromFootCalc(){
        return receivedValue * 0.3048;
    }

    public double fromYardCalc(){
        return receivedValue * 0.9144;
    }
}
