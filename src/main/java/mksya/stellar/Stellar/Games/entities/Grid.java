package mksya.stellar.Stellar.Games.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "grid")
public class Grid {

   List<Spot> spots;

}
