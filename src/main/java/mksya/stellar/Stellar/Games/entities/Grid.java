package mksya.stellar.Stellar.Games.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grid")
public class Grid {

    Spot[][] grid;

}
