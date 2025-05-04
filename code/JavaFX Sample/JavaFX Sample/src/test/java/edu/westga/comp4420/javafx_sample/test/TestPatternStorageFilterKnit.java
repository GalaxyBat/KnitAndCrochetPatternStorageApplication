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
class TestPatternStorageFilterKnit {
    @Test
    void testWhenThereIsNoPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        assertTrue(storage.onlyKnitPatterns().isEmpty());
    }

    @Test 
    void testWhenThereIsNoKnitPatternsInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        assertTrue(storage.onlyKnitPatterns().isEmpty());
    }

    @Test
    void testWhenThereIsOneKnitPatternInStorage() {
        PatternStorage storage = new PatternStorage();
        Craft craft = Craft.Knit;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        storage.add(pattern);
        ArrayList<Pattern> knitPatterns = storage.onlyKnitPatterns();
        assertAll(
            () -> assertEquals(1, knitPatterns.size()),
            () -> assertSame(pattern, knitPatterns.get(0))
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

        ArrayList<Pattern> knitPatterns = storage.onlyKnitPatterns();
        assertAll(
            () -> assertEquals(1, knitPatterns.size()),
            () -> assertSame(pattern2, knitPatterns.get(0))
        );

    }
}
