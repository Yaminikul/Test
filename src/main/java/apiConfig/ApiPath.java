package apiConfig;


public enum ApiPath {

    GET_USER("/api/users"),
    GET_RESOURCE("/api/unknown"),
    LOGIN("/api/login"),
    REGISTER("/api/register");

    private String value;

    ApiPath(String value){
        this.value = value;
    }

    public String getValue(){return value;}


}
