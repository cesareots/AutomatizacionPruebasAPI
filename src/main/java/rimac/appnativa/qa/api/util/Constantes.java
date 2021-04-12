package rimac.appnativa.qa.api.util;

public class Constantes {

    //dataDriven
    private static final String res = "src/test/resources/dataDriven/";
    private static final String ruta = res + System.getProperty("user.name") + "/";
    public static final String file01 = ruta + "01-login.xlsx";

    //json
    public static final String protocol = "https";
    public static final String endpoint = "o6zknw5pf3.execute-api.us-east-2.amazonaws.com";
    public static final String environment = "test";
    public static final String app = "app";

    //endpoint
    public static final String endpoint001 = "persona/loginapp";
}
