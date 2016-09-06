package sk.liptovzije.service;

import sk.liptovzije.model.AuthResponse;
import sk.liptovzije.model.User;

/**
 * Created by jan.husenica on 8/29/2016.
 */
public interface IAuthenticator {
    AuthResponse sign(User user);
    void verify(String token);
    void validate(String token);
}
