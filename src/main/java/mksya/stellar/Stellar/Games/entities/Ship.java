package mksya.stellar.Stellar.Games.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mksya.stellar.Stellar.Games.entities.enums.AXIS;
import mksya.stellar.Stellar.Games.entities.enums.DIRECTION;
import mksya.stellar.Stellar.Games.entities.enums.SHIPCLASS;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ships")
public class Ship {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private SHIPCLASS shipClass;

    @Column
    private boolean sunk;

    @Column
    private boolean positionNotAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id", referencedColumnName = "id")
    private Player player;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private List<Spot> coordinates;

    private Spot origin;
    private AXIS axis;
    private DIRECTION direction;

    public Ship() {
    }

}
