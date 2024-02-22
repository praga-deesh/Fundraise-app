package org.company.fundraisedemo.fundraiser;

import jakarta.persistence.*;
import org.company.fundraisedemo.post.Post;

import java.util.List;

@Entity
public class Fundraiser {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String email;
    private String password;

    @OneToMany
    @Column(nullable = true)
    private List<Post> posts;

    public Fundraiser() {
    }

    public Fundraiser(Integer id, String name, String email, String password, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.posts = posts;
    }

    public Fundraiser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    // changes made by Rishi
}
