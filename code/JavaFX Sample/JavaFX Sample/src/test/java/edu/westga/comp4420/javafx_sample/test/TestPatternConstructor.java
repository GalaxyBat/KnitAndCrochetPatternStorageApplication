package edu.westga.comp4420.javafx_sample.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.comp4420.javafx_sample.model.Craft;
import edu.westga.comp4420.javafx_sample.model.Pattern;
import edu.westga.comp4420.javafx_sample.model.Progression;

/**
 * The Test Class for the Pattern Constructor
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */
class TestPatternConstructor {

    @Test
    void testShouldThrowForNullPatternName() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern(null, "Becky", "Raverly.com", craft, progression, 2);
        });
    }

    @Test
    void testShouldThrowForEmptyName() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern("", "Becky", "Raverly.com", craft, progression, 2);
        });
    }

    @Test
    void testShouldThrowForNullAuthor() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern("Pull over raglan", null, "Raverly.com", craft, progression, 2);
        });
    }

    @Test
    void testShouldThrowForEmptyAuthor() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern("Pull over raglan", "", "Raverly.com", craft, progression, 2);
        });
    }

    @Test
    void testShouldThrowForUnderYarnWeightBoundary() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern("Pull over raglan", "Becky", "Raverly.com", craft, progression, 0);
        });
    }

    @Test
    void testShouldThrowForAboveYarnWeightBoundary() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        assertThrows(IllegalArgumentException.class, () -> { 
            new Pattern("Pull over raglan", "Becky", "Raverly.com", craft, progression, 9);
        });
    }


    @Test 
    void testValidConstructor() {
        Craft craft = Craft.Crochet;
        Progression progression = Progression.Complete;
        Pattern pattern = new Pattern("Pull Over Raglan", "Becky Appleburg", "Raverly.com", craft, progression, 4);
        assertAll(
            () -> assertEquals("Pull Over Raglan", pattern.getPatternName()),
            () -> assertEquals("Becky Appleburg", pattern.getAuthor()),
            () -> assertEquals(craft, pattern.getCraft()),
            () -> assertEquals(progression, pattern.getProgression()),
            () -> assertEquals(4, pattern.getYarnWeight())
        );
    }
    
}
