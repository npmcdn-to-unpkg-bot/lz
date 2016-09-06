package sk.liptovzije.model;

/**
 * Created by jan.husenica on 9/1/2016.
 */
public class AuthResponse {
    private String token;

    public AuthResponse (){
        this.token = "";
    }

    public AuthResponse (String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
