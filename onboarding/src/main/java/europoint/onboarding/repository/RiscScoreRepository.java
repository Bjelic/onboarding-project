package europoint.onboarding.repository;


import europoint.onboarding.model.DTORiscScore;
import europoint.onboarding.model.EntityRiscScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RiscScoreRepository extends JpaRepository<EntityRiscScore, Long> {
    void delete(Long id, EntityRiscScore riscScore);
}
