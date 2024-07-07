package mksya.stellar.Stellar.Games.repository;

import mksya.stellar.Stellar.Games.entities.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipRepository extends JpaRepository<Ship,Long> {
}
