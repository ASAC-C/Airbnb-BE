package acac.airbnb.be.data.repository;

import acac.airbnb.be.data.entity.MainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<MainEntity, Integer> {
}