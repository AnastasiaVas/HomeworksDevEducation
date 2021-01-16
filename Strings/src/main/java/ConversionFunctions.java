public class ConversionFunctions {

    public String digitToString(long num){
        return String.valueOf(num);
    }

    public String realNumToString(double num){
        return String.valueOf(num);
    }

    public long stringToDigit(String num) throws NumberFormatException{
        return Long.parseLong(num);
    }

    public double stringToRealNum(String num){
        return Double.parseDouble(num);
    }
}
