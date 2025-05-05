package edu.westga.comp4420.javafx_sample.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

class TestPatternStorageFilterYarnWeightFive {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyWeightFivePatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoWeightFivePatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        assertTrue(storage.onlyWeightFivePatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneWeightFivePatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 5);
        storage.add(pattern);
        ArrayList<Pattern> onlyWeightFivePatterns = storage.onlyWeightFivePatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightFivePatterns.size()),
            () -> assertSame(pattern, onlyWeightFivePatterns.get(0))
        );
    }

    @Test
    void testWhenThereIsOneWeightFivePatternandOneNonWeightFivePatternInStorage() {
        PatternStorage storage = new PatternStorage();

        Craft crochet = Craft.Crochet;
        Craft knit = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", crochet, progression, 5);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", knit, progression, 3);

        storage.add(pattern);
        storage.add(pattern2);

        ArrayList<Pattern> onlyWeightFivePatterns = storage.onlyWeightFivePatterns();
        assertAll(
            () -> assertEquals(1, onlyWeightFivePatterns.size()),
            () -> assertSame(pattern, onlyWeightFivePatterns.get(0))
        );

    }

    @Test
    void testWhenThereIsMultipleWeightFivePatternAndOneNonWeightFivePatterns() {
        PatternStorage storage = new PatternStorage();

        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;

        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;

        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 5);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft, progression, 5);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        
        ArrayList<Pattern> onlyWeightFivePatterns = storage.onlyWeightFivePatterns();
        assertAll(
            () -> assertEquals(2, onlyWeightFivePatterns.size()),
            () -> assertSame(pattern, onlyWeightFivePatterns.get(0)),
            () -> assertSame(pattern2, onlyWeightFivePatterns.get(1))
        );
    }
}
