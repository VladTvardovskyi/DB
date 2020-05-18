package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class BoxOfficePK implements Serializable {
    private int filmId;
    private int countryId;

    public BoxOfficePK() {
    }

    public BoxOfficePK(int filmId, int countryId) {
        this.filmId = filmId;
        this.countryId = countryId;
    }

    @Column(name = "film_id")
    @Id
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Column(name = "country_id")
    @Id
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoxOfficePK that = (BoxOfficePK) o;

        if (filmId != that.filmId) return false;
        if (countryId != that.countryId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = filmId;
        result = 31 * result + countryId;
        return result;
    }
}
