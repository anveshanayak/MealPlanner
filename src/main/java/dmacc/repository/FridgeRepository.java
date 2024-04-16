package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Fridge;

@Repository
public interface FridgeRepository extends JpaRepository<Fridge, Long> {
}