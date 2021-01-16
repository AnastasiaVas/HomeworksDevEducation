package claculations;

public interface ICalculator {

    double valueToStandardUnit(String unitName, double receivedValue);

    double valueFromStandardUnit(String unitName, double receivedValue);

}
