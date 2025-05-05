package edu.westga.comp4420.javafx_sample.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

class TestPatternStorageFilterYarnWeightFour {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyWeightFourPatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoWeightFourPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 3);
        storage.add(pattern);
        assertTrue(storage.onlyWeightFourPatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneWeightFourPatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        ArrayList<Pattern> onlyWeightFourPatterns = storage.onlyWeightFourPatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightFourPatterns.size()),
            () -> assertSame(pattern, onlyWeightFourPatterns.get(0))
        );
    }

    @Test
    void testWhenThereIsOneWeightFourPatternandOneNonWeightFourPatternInStorage() {
        PatternStorage storage = new PatternStorage();

        Craft crochet = Craft.Crochet;
        Craft knit = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", crochet, progression, 4);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", knit, progression, 3);

        storage.add(pattern);
        storage.add(pattern2);

        ArrayList<Pattern> onlyWeightFourPatterns = storage.onlyWeightFourPatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightFourPatterns.size()),
            () -> assertSame(pattern, onlyWeightFourPatterns.get(0))
        );

    }

    @Test
    void testWhenThereIsMultipleWeightFourPatternAndOneNonWeightFourPatterns() {
        PatternStorage storage = new PatternStorage();

        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;

        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;

        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft, progression, 4);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        
        ArrayList<Pattern> onlyWeightFourPatterns = storage.onlyWeightFourPatterns();
        assertAll(
            () -> assertEquals(2, onlyWeightFourPatterns.size()),
            () -> assertSame(pattern, onlyWeightFourPatterns.get(0)),
            () -> assertSame(pattern2, onlyWeightFourPatterns.get(1))
        );
    }
}
