package sk.liptovzije.model;

/**
 * Created by jan.husenica on 8/31/2016.
 */
public class UserCredentials {
    private String username;
    private String password;

    public UserCredentials () {}

    public UserCredentials (String username, String password ) {
        this.username = username;
        this.password = password;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + ((this.username != null) ? this.username.hashCode() : 0);
        result = prime * result + ((this.password != null) ? this.password.hashCode() : 0);

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof UserCredentials))
            return false;
        UserCredentials other = (UserCredentials) obj;
        if (!username.equals(other.username))
            return false;
        if (!password.equals(other.password))
            return false;
        return true;
    }
}
