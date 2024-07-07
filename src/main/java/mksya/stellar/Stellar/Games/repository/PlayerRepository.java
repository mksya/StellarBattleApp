package mksya.stellar.Stellar.Games.repository;

import mksya.stellar.Stellar.Games.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
