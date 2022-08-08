package europoint.onboarding.Service;

import europoint.onboarding.model.EntityRiscScore;

import java.util.List;

public interface RiscScoreService {

    List<EntityRiscScore> findAll();

    EntityRiscScore findById(Long id);

    void deleteById(Long id);

    EntityRiscScore delete(Long id, EntityRiscScore riscScore);

    EntityRiscScore save(EntityRiscScore riscScore);

    EntityRiscScore update(EntityRiscScore riscScore, Long id);
}
