package by.resliv.tourist_bot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "city")
public class City {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "city", fetch = FetchType.LAZY, orphanRemoval = true)
    private CityInfo cityInfo;
}
