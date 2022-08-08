package europoint.onboarding.controller;

import europoint.onboarding.Service.RiscScoreServiceImpl;
import europoint.onboarding.model.EntityRiscScore;
import europoint.onboarding.utils.HelperClass;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class RiscScoreController {

    @Autowired
    private RiscScoreServiceImpl riscScoreServiceImpl;

    @Autowired
    private ModelMapper helperClass;

    private static final Logger logger = LoggerFactory.getLogger(RiscScoreController.class);


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/scores")
    public List<EntityRiscScore> findAllRiscScores() {
        List<EntityRiscScore> riscScores = riscScoreServiceImpl.findAll();
        logger.info("All Risc Score's are found");
        return riscScores.stream().toList();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/scores/{id}")
    public EntityRiscScore findRiscScoreById(@PathVariable("id") Long id) {
        logger.info(String.format("Risc Score with id = %d, has been found", id));
        return riscScoreServiceImpl.findById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/scores/{id}")
    public String deleteRiscScore(@PathVariable("id") Long id) {
        riscScoreServiceImpl.deleteById(id);
        logger.info(String.format("Risc Score with id = %d, has been deleted", id));
        return String.format("Risc Score with id = %d, has been deleted", id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/scores")
    public EntityRiscScore saveRiscScore(@Valid @RequestBody EntityRiscScore riscScore) {
        logger.info("New Risc Score has been created");
        return riscScoreServiceImpl.save(riscScore);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/scores/{id}")
    public Optional<EntityRiscScore> updateRiscScore(@PathVariable("id") Long id,
                                                     @RequestBody EntityRiscScore riscScore) {
        logger.info(String.format("Risc Score with id = %d, has been updated", id));
        return Optional.ofNullable(riscScoreServiceImpl.update(riscScore, id));
    }
}
