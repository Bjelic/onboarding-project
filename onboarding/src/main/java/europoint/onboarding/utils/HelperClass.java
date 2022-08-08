package europoint.onboarding.utils;

import europoint.onboarding.model.DTORiscScore;
import europoint.onboarding.model.EntityRiscScore;
import org.modelmapper.ModelMapper;

public class HelperClass {

    ModelMapper modelMapper = new ModelMapper();

    public DTORiscScore convertToDto(EntityRiscScore riscScore) {
        DTORiscScore DTORiscScore = modelMapper.map(riscScore, DTORiscScore.class);
        return DTORiscScore;
    }

    public EntityRiscScore convertToEntity(DTORiscScore DTORiscScore) {
        EntityRiscScore entityRiscScore = modelMapper.map(DTORiscScore, EntityRiscScore.class);
        return entityRiscScore;
    }
}
