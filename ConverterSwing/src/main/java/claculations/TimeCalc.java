package claculations;

import utils.Units;

public class TimeCalc implements ICalculator {
    @Override
    public double valueToStandardUnit(String unitName, double receivedValue) {
        double answer = 0;
        for (Units unit : Units.groupTime){
            if (unit.getName().equals(unitName)){
                answer = receivedValue * unit.getValueInStandardUnit();
            }
        }
        return answer;
    }

    @Override
    public double valueFromStandardUnit(String unitName, double receivedValue) {
        double answer = 0;
        for (Units unit : Units.groupTime){
            if (unit.getName().equals(unitName)){
                answer = receivedValue / unit.getValueInStandardUnit();
            }
        }
        return answer;
    }

}
