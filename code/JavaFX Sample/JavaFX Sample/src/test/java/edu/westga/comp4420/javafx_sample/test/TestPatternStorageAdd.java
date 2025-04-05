package edu.westga.comp4420.javafx_sample.test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.PatternStorage;
import edu.westga.comp4420.javafx_sample.model.Progression;

/**
 * The Test Class for the Pattern Storage add method
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */

class TestPatternStorageAdd {

    @Test
    void testShouldThrowWhenAddingNull() {
        PatternStorage storage = new PatternStorage();
        assertThrows(IllegalArgumentException.class, () -> {
            storage.add(null);
        });
    }

    @Test
    void testShouldAddOnePattern() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        PatternStorage storage = new PatternStorage();
        assertAll(

            () -> assertTrue(storage.add(pattern)),
            () -> assertEquals(1, storage.size())
        );
       
       
    }

    @Test
    void testShouldThrowWhenAddingDuplicate() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        Pattern pattern2 = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 3);
        PatternStorage storage = new PatternStorage();
        storage.add(pattern);
        assertThrows(IllegalArgumentException.class, () -> {
            storage.add(pattern2);
        });
    }

    @Test
    void testShouldAddMultiplePatterns() {
        Craft craft = Craft.Crochet;
        Craft craft2 = Craft.Knit;
        Progression progression = Progression.Complete;
        Progression progression2 = Progression.InProgress;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        Pattern pattern2 = new Pattern("Cardigan", "Tiffany Appleburg", "Raverly.com", craft2, progression, 3);
        Pattern pattern3 = new Pattern("Circle yoke sweater", "Ashley Tipton", "Raverly.com", craft2, progression2, 2);
        PatternStorage storage = new PatternStorage();
        storage.add(pattern);
        storage.add(pattern2);
        storage.add(pattern3);
        assertAll(
            () -> assertSame(pattern, storage.getPatterns().get(0)),
            () -> assertSame(pattern2, storage.getPatterns().get(1)),
            () -> assertSame(pattern3, storage.getPatterns().get(2)),
            () -> assertEquals(3, storage.size())
        );
    }
 }