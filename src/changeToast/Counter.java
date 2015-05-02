package changeToast;

/**
 * Created by DerpPC on 12/24/2014.
 */
public class Counter
{
    private static int duckSmash =0;
    private  static int  duckCount;

    public static String increase()
    {
        duckSmash++;
        setDuck(duckSmash);
        return Integer.toString(duckSmash);
    }



    //for final count once you stop
    public static int getDuck()
    {
        return duckCount;
    }
    private static void setDuck(int duckSmash)
    {
        duckCount= duckSmash;
    }
}
