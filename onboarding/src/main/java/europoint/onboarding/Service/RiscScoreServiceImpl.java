package europoint.onboarding.Service;

import europoint.onboarding.model.EntityRiscScore;
import europoint.onboarding.repository.RiscScoreRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RiscScoreServiceImpl implements RiscScoreService {

    @Autowired
    private RiscScoreRepository riscScoreRepository;

    private static final Logger logger = LoggerFactory.getLogger(RiscScoreServiceImpl.class);

    @Override
    public List<EntityRiscScore> findAll() {
        return riscScoreRepository.findAll();
    }

    @Override
    public EntityRiscScore findById(Long id) {
        Optional<EntityRiscScore> riscScore = riscScoreRepository.findById(id);

        if (!riscScore.isPresent()) {
            logger.error(String.format("Error finding Risc Score with id = %d", id));
        }
        return riscScore.get();
    }

    @Override
    public void deleteById(Long id) {
        logger.info(String.format("Risc Score with id = %d, has been deleted successfully", id));
        riscScoreRepository.deleteById(id);
    }

    @Override
    public EntityRiscScore delete(Long id, EntityRiscScore riscScore) {
        riscScoreRepository.delete(id, riscScore);
        logger.info(String.format("Risc Score with id = %d, has been deleted successfully", id));
        return riscScore;
    }

    @Override
    public EntityRiscScore save(EntityRiscScore riscScore) {
        return riscScoreRepository.save(riscScore);
    }

    @Override
    public EntityRiscScore update(EntityRiscScore riscScore, Long id) {
        Optional<EntityRiscScore> riscScoreDb = riscScoreRepository.findById(id);
        if (!riscScoreDb.isPresent()) {
            logger.error(String.format("Error finding Risc Score with id = %d", id));
            throw new IllegalStateException(String.format("Risc Score object not found with id = %d", id));
        }
        if (!"".equalsIgnoreCase(riscScore.getName())) {
            riscScoreDb.get().setName(riscScore.getName());
        }
        if (!"".equalsIgnoreCase(riscScore.getDescription())) {
            riscScoreDb.get().setDescription(riscScore.getDescription());
        }
        logger.info(String.format("Risc Score with id = %d, has been updated", id));
        return riscScoreRepository.save(riscScoreDb.get());
    }
}
