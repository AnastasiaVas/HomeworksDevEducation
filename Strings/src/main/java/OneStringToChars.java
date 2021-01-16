public class OneStringToChars {

    public void fromAtoZUpperCase(){
        int num = 65;
        while (num <= 90) {
            System.out.print((char) num);
            num++;
        }
    }

    public void fromZtoALowerCase(){
        int num = 122;
        while (num >= 97) {
            System.out.print((char) num);
            num--;
        }
    }

    public void RussAlphabetLowerCase(){
        for (int i = 0x0430; i <= 0x044f; i++){
            System.out.print((char) i);
        }
    }

    public void numbersFrom0To9(){
        int num = 48;
        while (num <= 57) {
            System.out.print((char) num);
            num++;
        }
    }
}
