package by.resliv.tourist_bot.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "city_info")
public class CityInfo {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "id_city", nullable = false)
    private Integer idCity;

    @Column(name = "value", nullable = false)
    private String value;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city", insertable = false, updatable = false)
    private City city;
}
