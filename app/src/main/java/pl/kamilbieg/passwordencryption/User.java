package pl.kamilbieg.passwordencryption;

public class User {

    private String mName;
    private String mPassword;

    private User() {

    }

    public String getName() {
        return mName;
    }

    public String getPassword() {
        return mPassword;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String mName;
        private String mPassword;

        public Builder name(String name) {
            this.mName = name;
            return this;
        }

        public Builder password(String pass) {
            this.mPassword = pass;
            return this;
        }

        public User build() {
            if (this.mName.isEmpty())
                throw new IllegalStateException("Name cannot be empty");
            if (this.mPassword.isEmpty())
                throw new IllegalStateException("Password cannot be empty");

            User user = new User();
            user.mName = this.mName;
            user.mPassword = this.mPassword;

            return user;
        }
    }
}
