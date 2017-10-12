package helper;

public class TotalPrice {

    public static int calcTotalPrice(int outPriceArg, int inPriceArg) {
        int outPrice = (outPriceArg * 3);
        int inPrice = (inPriceArg * 3);
        int baggage = 42;
        int count = outPrice + inPrice + (baggage * 3);

        return count;
    }

}
