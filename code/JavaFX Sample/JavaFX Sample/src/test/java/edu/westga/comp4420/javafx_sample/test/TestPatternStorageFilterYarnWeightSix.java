package edu.westga.comp4420.javafx_sample.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

class TestPatternStorageFilterYarnWeightSix {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyWeightSixPatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoWeightSixPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        assertTrue(storage.onlyWeightSixPatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneWeightSixPatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 6);
        storage.add(pattern);
        ArrayList<Pattern> onlyWeightSixPatterns = storage.onlyWeightSixPatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightSixPatterns.size()),
            () -> assertSame(pattern, onlyWeightSixPatterns.get(0))
        );
    }

    @Test
    void testWhenThereIsOneWeightSixPatternandOneNonWeightSixPatternInStorage() {
        PatternStorage storage = new PatternStorage();

        Craft crochet = Craft.Crochet;
        Craft knit = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", crochet, progression, 6);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", knit, progression, 3);

        storage.add(pattern);
        storage.add(pattern2);

        ArrayList<Pattern> onlyWeightSixPatterns = storage.onlyWeightSixPatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightSixPatterns.size()),
            () -> assertSame(pattern, onlyWeightSixPatterns.get(0))
        );

    }

    @Test
    void testWhenThereIsMultipleWeightSixPatternAndOneNonWeightSixPatterns() {
        PatternStorage storage = new PatternStorage();

        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;

        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;

        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 6);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft, progression, 6);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        
        ArrayList<Pattern> onlyWeightSixPatterns = storage.onlyWeightSixPatterns();
        assertAll(
            () -> assertEquals(2, onlyWeightSixPatterns.size()),
            () -> assertSame(pattern, onlyWeightSixPatterns.get(0)),
            () -> assertSame(pattern2, onlyWeightSixPatterns.get(1))
        );
    }
}
