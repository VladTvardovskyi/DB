package ua.lviv.iot.model;

import javax.persistence.*;

@Entity
@Table(name = "role", schema = "film_db")
@IdClass(RolePK.class)
public class Role {
    private int filmId;
    private int starId;
    private String role;

    public Role() {
    }

    public Role(int filmId, int starId, String role) {
        this.filmId = filmId;
        this.starId = starId;
        this.role = role;
    }

    @Id
    @Column(name = "film_id")
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Id
    @Column(name = "star_id")
    public int getStarId() {
        return starId;
    }

    public void setStarId(int starId) {
        this.starId = starId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role that = (Role) o;

        if (filmId != that.filmId) return false;
        if (starId != that.starId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + starId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
