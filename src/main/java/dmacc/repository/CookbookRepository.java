package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dmacc.beans.Cookbook;

@Repository
public interface CookbookRepository extends JpaRepository<Cookbook, Long> {
}