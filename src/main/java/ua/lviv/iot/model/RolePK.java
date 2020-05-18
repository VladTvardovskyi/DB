package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RolePK implements Serializable {
    private int filmId;
    private int starId;

    public RolePK() {
    }

    public RolePK(int filmId, int starId) {
        this.filmId = filmId;
        this.starId = starId;
    }

    @Column(name = "film_id")
    @Id
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Column(name = "star_id")
    @Id
    public int getStarId() {
        return starId;
    }

    public void setStarId(int starId) {
        this.starId = starId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RolePK that = (RolePK) o;

        if (filmId != that.filmId) return false;
        if (starId != that.starId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + starId;
        return result;
    }
}
