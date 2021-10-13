package com.example.BatchApp.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="countries")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String englishShortName;

    private String alphaTwoCode;

    private String alphaThreeCode;

    @Column(length = 200)
    private String numericCode;


    public Country(String englishShortName, String alphaTwoCode, String alphaThreeCode, String numericCode) {
        this.englishShortName = englishShortName;
        this.alphaTwoCode = alphaTwoCode;
        this.alphaThreeCode = alphaThreeCode;
        this.numericCode = numericCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(englishShortName, country.englishShortName) && Objects.equals(alphaTwoCode, country.alphaTwoCode) && Objects.equals(alphaThreeCode, country.alphaThreeCode) && Objects.equals(numericCode, country.numericCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, englishShortName, alphaTwoCode, alphaThreeCode, numericCode);
    }
}
