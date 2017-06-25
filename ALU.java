public abstract class ALU {

    static int add(int x, int y) {
        int sum = 0;
        int bit = 0b1;
        int carry = 0b0;

        while (bit <= (x | y) << 1) {
            int a = x & bit;
            int b = y & bit;

            int aXORb = a ^ b;
            int carryXORaXORb = carry ^ aXORb;
            int aANDb = a & b;

            sum |= carryXORaXORb;
            carry = (carry & aXORb) | aANDb;

            carry <<= 1;
            bit <<= 1;
        }
        return sum;
    }

    static int subtract(int x, int y) {
        int diff = 0;
        int bit = 0b1;
        int borrow = 0b0;
        while (bit <= (x | y) << 1) {
            int a = x & bit;
            int b = y & bit;

            int aXORb = a ^ b;
            int NOTaANDb = (~a) & b;
            int NOTaXORb = ~aXORb;
            int borrowANDNOTaXORb = borrow & NOTaXORb;

            diff |= borrow ^ aXORb;
            borrow = NOTaANDb | borrowANDNOTaXORb;
            borrow <<= 1;
            bit <<= 1;
        }

        return diff;
    }

    static int twosCompliment(int i) {

        return add(~i, +1);
    }
}
