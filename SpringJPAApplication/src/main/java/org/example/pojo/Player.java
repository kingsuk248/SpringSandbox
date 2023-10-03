package org.example.pojo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Player")
@NamedQuery(name="get_all_players", query="SELECT p FROM Player p")
public class Player {

    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(name="nationality")
    private String nationality;
    private Date birthDate;
    private int titles;

    public Player() {

    }

    public Player(int id, String name, String nationality, Date birthDate, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    public Player(String name, String nationality, Date birthDate, int titles) {
        super();
        this.name = name;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "id=" + this.id + ", name=" + this.name + ", nationality=" + this.nationality
                + ", birthDate=" + this.birthDate + ", titles=" + this.titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
