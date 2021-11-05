package application.models;

public enum UserRole {

    USER(UserAuth.READ, UserAuth.WRITE),
    ADMIN(UserAuth.READ, UserAuth.WRITE, UserAuth.DELETE);

    public final UserAuth[] AUTHS;

    UserRole(UserAuth... auths) {
        AUTHS = auths;
    }
}
