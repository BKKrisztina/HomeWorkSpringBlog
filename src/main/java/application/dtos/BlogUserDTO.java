package application.dtos;

import application.models.BlogUser;

import javax.persistence.Column;

public class BlogUserDTO {

    private String username;
    private String password;
    private String email;

    public BlogUserDTO() {
    }

    public BlogUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public BlogUserDTO(String username, String password, String email) {
        this(username,password);
        this.email = email;
    }

    public BlogUserDTO(BlogUser BlogUser){
        this(BlogUser.getUsername(), BlogUser.getPassword());
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
