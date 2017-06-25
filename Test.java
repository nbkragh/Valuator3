public class Test {
    public static void main(String[] args) {

        Valuator val3 = new Valuator(3);
        Valuator val5 = new Valuator(5);
        Valuator val10 = new Valuator(10);
        Valuator val11 = new Valuator(11);
        Valuator val16 = new Valuator(16);
        BinaryValuator binval = new BinaryValuator();
        SignedBinaryValuator sbinval = new SignedBinaryValuator();

        System.out.println(Integer.toBinaryString(2147483647));
        System.out.println(val10.getInput());
        System.out.println(val3.valueForRadix());
        val3.setInputValue(val3.valueForRadix());
        System.out.println(val11.valueForRadix());
        val11.setInputValue(val11.valueForRadix());
        System.out.println(binval.valueForRadix());
        binval.setInputValue(binval.valueForRadix());
        System.out.println(val16.valueForRadix());
        val16.setInputValue(val16.valueForRadix());
        System.out.println(sbinval.valueForRadix());
        sbinval.setInputValue(sbinval.valueForRadix());
        System.out.println(val5.getInput());
        System.out.println("_______________");
        val10.setInputValue(""+Integer.MIN_VALUE);
        System.out.println(val10.getInput());
        System.out.println(val3.valueForRadix());
        val3.setInputValue(val3.valueForRadix());
        System.out.println(val11.valueForRadix());
        val11.setInputValue(val11.valueForRadix());
        System.out.println(binval.valueForRadix());
        binval.setInputValue(binval.valueForRadix());
        System.out.println(val16.valueForRadix());
        val16.setInputValue(val16.valueForRadix());
        System.out.println(sbinval.valueForRadix());
        sbinval.setInputValue(sbinval.valueForRadix());
        System.out.println(val5.getInput());
        System.out.println("_______________");
        val10.setInputValue("-1");
        System.out.println(val10.getInput());
        System.out.println(val3.valueForRadix());
        val3.setInputValue(val3.valueForRadix());
        System.out.println(val11.valueForRadix());
        val11.setInputValue(val11.valueForRadix());
        System.out.println(binval.valueForRadix());
        binval.setInputValue(binval.valueForRadix());
        System.out.println(val16.valueForRadix());
        val16.setInputValue(val16.valueForRadix());
        System.out.println(sbinval.valueForRadix());
        sbinval.setInputValue(sbinval.valueForRadix());
        System.out.println(val5.getInput());

    }
}
