package mksya.stellar.Stellar.Games.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import mksya.stellar.Stellar.Games.entities.enums.GRADE;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private GRADE grade;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<Ship> fleet;

    public Player() {
    }

}
