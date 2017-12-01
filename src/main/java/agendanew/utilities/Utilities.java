package agendanew.utilities;

public class Utilities {

    public static boolean isNumeric(String string){
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }
}
