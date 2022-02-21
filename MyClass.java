import java.util.regex.Pattern;
public class MyClass {
    private static String API_ENDPOINT_REGEX = "https://[\\S]*teksystems\\.com[/]?";
    public static void main(String args[]) {
          
        String endpoint = "https://traslate.teksystems.com";
        System.out.println("Sum of x+y = " +MyClass.isApiEndpointValid(endpoint));
    }
    private static boolean isApiEndpointValid(String endpoint) {
    return Pattern.matches(API_ENDPOINT_REGEX, endpoint);
  }
    
}
