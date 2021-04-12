package rimac.appnativa.qa.api.model;

import rimac.appnativa.qa.api.util.Constantes;

public class Json {

    protected String url;
    private String metodo;

    public Json() {
        this.url = Constantes.protocol + "://" + Constantes.endpoint + "/" + Constantes.environment + "/" + Constantes.app + "/";
    }
}
