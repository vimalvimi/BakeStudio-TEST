package roxybakestudio.bakestudio.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import roxybakestudio.bakestudio.R;

public class Utils {

    private final static String NUTELLA_PIE = "Nutella Pie";
    private final static String BROWNIES = "Brownies";
    private final static String YELLOW_CAKE = "Yellow Cake";
    private final static String CHEESE_CAKE = "Cheesecake";

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();

        return info != null && info.isConnectedOrConnecting();
    }

    public static int getImage(String name) {
        switch (name) {
            case NUTELLA_PIE:
                return R.drawable.display_nutella_pie;
            case BROWNIES:
                return R.drawable.display_brownies;
            case YELLOW_CAKE:
                return R.drawable.display_yellow_cake;
            case CHEESE_CAKE:
                return R.drawable.display_cheesecake;
            default:
                return R.drawable.display_nutella_pie;
        }
    }

    private static String getMeasure(String measure) {
        switch (measure) {
            case "CUP":
                return "Cup";
            case "G":
                return "Gram";
            case "UNIT":
                return "Single";
            case "TBLSP":
                return "Tablespoon";
            case "TSP":
                return "Teaspoon";
            default:
                return measure;
        }
    }

    public static String makeIngredientString(Double quantity, String measure, String ingredient) {

        measure = getMeasure(measure);
        return quantity + " " + measure + " " + ingredient;
    }
}
