package sk.liptovzije.service;

import sk.liptovzije.model.AuthResponse;
import sk.liptovzije.model.User;

import java.io.UnsupportedEncodingException;

/**
 * Created by jan.husenica on 8/29/2016.
 */
public interface IAuthenticator {
    AuthResponse sign(User user);
    boolean verify(String token);
}
