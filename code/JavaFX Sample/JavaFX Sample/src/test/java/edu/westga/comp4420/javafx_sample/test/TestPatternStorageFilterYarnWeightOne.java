package edu.westga.comp4420.javafx_sample.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

class TestPatternStorageFilterYarnWeightOne {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyWeightOnePatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoWeightOnePatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        assertTrue(storage.onlyWeightOnePatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneWeightOnePatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 1);
        storage.add(pattern);
        ArrayList<Pattern> weightOnePatterns = storage.onlyWeightOnePatterns();
        assertAll(
            () -> assertEquals(1, weightOnePatterns.size()),
            () -> assertSame(pattern, weightOnePatterns.get(0))
        );
    }

    @Test
    void testWhenThereIsOneWeightOnePatternandOneNonWeightOnePatternInStorage() {
        PatternStorage storage = new PatternStorage();

        Craft crochet = Craft.Crochet;
        Craft knit = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", crochet, progression, 1);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", knit, progression, 3);

        storage.add(pattern);
        storage.add(pattern2);

        ArrayList<Pattern> weightOnePatterns = storage.onlyWeightOnePatterns();
        assertAll(
            () -> assertEquals(1, weightOnePatterns.size()),
            () -> assertSame(pattern, weightOnePatterns.get(0))
        );

    }

    @Test
    void testWhenThereIsMultipleWeightOnePatternAndOneNonWeightOnePatterns() {
        PatternStorage storage = new PatternStorage();

        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;

        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;

        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 1);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft, progression, 1);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        
        ArrayList<Pattern> weightOnePatterns = storage.onlyWeightOnePatterns();
        assertAll(
            () -> assertEquals(2, weightOnePatterns.size()),
            () -> assertSame(pattern, weightOnePatterns.get(0)),
            () -> assertSame(pattern2, weightOnePatterns.get(1))
        );
    }
}
