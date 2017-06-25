public class SignedBinaryValuator extends BinaryValuator{

    public SignedBinaryValuator(){
        super();
        name = "Signed Binær";
    }
    @Override
    public boolean setInputValue(String string){
        if (string.matches("^[0]++$")){
            input = 0;
            return true;
        }
        if (string.charAt(0) == '-'){
            return  false;
        }
        if (string.matches("^[01]++$")){
            int pos = 0b1;
            int value = 0b0;
            for (int i = 0; i < string.length(); i++){
                value <<= 1;
                if(string.charAt(i) == '1'){
                    value = value|pos;
                }

            }
            System.out.println("succes");
            this.input = value;
            return true;
        }else{
            System.out.println("fail");
            return false;
        }

    }
    @Override
    public String valueForRadix() {
        String returnString = "";
        if (input == 0){
            return "00000000000000000000000000000000";
        }
        int value = this.input;
        long cifer =0b1;
        for(int i = 0; i < 32; i++){
            if((cifer&value) > 0){
                returnString = "1"+returnString;
            }else{
                returnString = "0"+returnString;
            }
            cifer = cifer<<1;
        }
        return returnString;
    }
}

/*
 2820130816
 2147483647
-2147483648

01111111111111111111111111111111
10000000000000000000000000000000
*/
