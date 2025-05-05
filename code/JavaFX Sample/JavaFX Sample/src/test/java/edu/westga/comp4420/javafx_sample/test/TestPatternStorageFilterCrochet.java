package edu.westga.comp4420.javafx_sample.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

/**
 * The Test Class for the Pattern Storage onlyKnitPatterns method
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */

class TestPatternStorageFilterCrochet {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyCrochetPatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoCrochetPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        assertTrue(storage.onlyCrochetPatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneCrochetPatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        ArrayList<Pattern> crochetPatterns = storage.onlyCrochetPatterns();
        assertAll(
            () -> assertEquals(1, crochetPatterns.size()),
            () -> assertSame(pattern, crochetPatterns.get(0))
        );
    }

    @Test
    void testWhenThereIsOneKnitPatternandOneCrochetPatternInStorage() {
        PatternStorage storage = new PatternStorage();

        Craft crochet = Craft.Crochet;
        Craft knit = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", crochet, progression, 4);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", knit, progression, 3);

        storage.add(pattern);
        storage.add(pattern2);

        ArrayList<Pattern> crochetPatterns = storage.onlyCrochetPatterns();
        assertAll(
            () -> assertEquals(1, crochetPatterns.size()),
            () -> assertSame(pattern, crochetPatterns.get(0))
        );

    }

    @Test
    void testWhenThereIsMultipleKnitPatternAndOneCrochetPatterns() {
        PatternStorage storage = new PatternStorage();

        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;

        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;

        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft, progression, 3);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        
        ArrayList<Pattern> crochetPatterns = storage.onlyCrochetPatterns();
        assertAll(
            () -> assertEquals(2, crochetPatterns.size()),
            () -> assertSame(pattern, crochetPatterns.get(0)),
            () -> assertSame(pattern2, crochetPatterns.get(1))
        );
    }
}
