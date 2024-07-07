package mksya.stellar.Stellar.Games.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="spots")
public class Spot {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean hit;

    @Column
    private Integer x;

    @Column
    private Integer y;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ship_id", referencedColumnName = "id")
    private Player player;

    public Spot() {
    }

}
