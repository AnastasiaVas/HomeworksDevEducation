package claculations;

import utils.Units;

public class TemperatureCalc implements ICalculator {
    double receivedValue;
    @Override
    public double valueToStandardUnit(String unitName, double receivedValue) {
        double answer = 0;
        for (Units unit : Units.groupTemperature){
            if (unit.getName().equals(unitName)){
                answer = chooseUnitToStandardUnit(unit);
            }
        }
        return answer;
    }

    @Override
    public double valueFromStandardUnit(String unitName, double receivedValue) {
        double answer = 0;
        for (Units unit : Units.groupTemperature){
            if (unit.getName().equals(unitName)){
                answer = chooseUnitToStandardUnit(unit);
            }
        }
        return answer;
    }

    private double chooseUnitToStandardUnit(Units unit){
        double answer;
                switch (unit){
            case KELVIN_SCALE:
                answer = toKelvinCalc();
                break;
            case ROMER_SCALE:
                answer = toRomerCalc();
                break;
            case FAHRENHEIT_SCALE:
                answer = toFahrenheitCalc();
                break;
            case RANKIN_SCALE:
                answer = toRankinCalc();
                break;
            case NEWTON_SCALE:
                answer = toNewtoneCalc();
                break;
            case DELISLE_SCALE:
                answer = toDelisleCalc();
                break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + unit);
                }
        return answer;
    }

    private double chooseUnitFromStandardUnit(Units unit){
        double answer;
        switch (unit){
            case KELVIN_SCALE:
                answer = fromKelvinCalc();
                break;
            case ROMER_SCALE:
                answer = fromRomerCalc();
                break;
            case FAHRENHEIT_SCALE:
                answer = fromFahrenheitCalc();
                break;
            case RANKIN_SCALE:
                answer = fromRankinCalc();
                break;
            case NEWTON_SCALE:
                answer = fromNewtoneCalc();
                break;
            case DELISLE_SCALE:
                answer = fromDelisleCalc();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + unit);
        }
        return answer;
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
