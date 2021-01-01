package claculations;

public class TimeCalc {
    double receivedValue;

    public TimeCalc(double receivedValue){
        this.receivedValue = receivedValue;
    }

    public double toMinuteCalc(){
        return receivedValue * 0.0166667;
    }

    public double toHourCalc(){
        return receivedValue * 0.000277778;
    }

    public double toDaysCalc(){
        return receivedValue * 0.0000115741;
    }

    public double toWeeksCalc(){
        return receivedValue * 1.6534E-6;
    }

    public double toMonthsCalc(){
        return receivedValue * 3.80517e-7;
    }

    public double toAstrYearsCalc(){

        return receivedValue / 31556952;
    }

    public double fromMinuteCalc(){
        return receivedValue * 60;
    }

    public double fromHourCalc(){
        return receivedValue * 3600;
    }

    public double fromDaysCalc(){
        return receivedValue * 86400;
    }

    public double fromWeeksCalc(){
        return receivedValue * 604800;
    }

    public double fromMonthsCalc(){
        return receivedValue * 2.628e+6;
    }

    public double fromAstrYearsCalc(){
        return receivedValue * 31556952;
    }

}
