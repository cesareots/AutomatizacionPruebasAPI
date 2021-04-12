package rimac.appnativa.qa.api.model;

public class JsonRequest extends Json {

    private String authorization;
    private String body;

    public JsonRequest(String endpoint) {
        this.url += endpoint;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
