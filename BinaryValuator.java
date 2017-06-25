public class BinaryValuator extends Valuator {

    public BinaryValuator(){
        super(2);
        name = "Binær";
    }
    @Override
    public boolean setInputValue(String string){
        if (string.matches("^[0]++$")){
            input = 0;
            return true;
        }
        int direction = 1;
        if (string.charAt(0) == '-'){
            string = string.substring(1);
            direction = -1;

        }
        if (string.matches("^[01]++$")){
            int pos = 0b1;
            int value = 0b0;
            for (int i = 0; i < string.length(); i++){
                value <<= 1;
                if(string.charAt(i) == '1'){
                    value = value|pos;
                }/*
                if ((direction>1 && value < 0)||(direction< 0 && value> 0)){
                    System.out.println("too much");
                    return false;
                }*/
            }
            this.input = direction*value;
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String valueForRadix() {
        String returnString = "";
        if (input == 0){
            return "0";
        }
        long value = this.input;
        if (this.input < 0) {
            value *= -1;
        }
        long cifer =0b1;
        while (cifer <= value){
            if((cifer&value) > 0){
                returnString = "1"+returnString;
            }else{
                returnString = "0"+returnString;
            }

            cifer = (cifer<<1);
        }

        if (this.input < 0){
            returnString = "-"+returnString;
        }
        return returnString;
    }
}
