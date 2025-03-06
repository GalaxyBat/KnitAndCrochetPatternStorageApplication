package main.java.edu.westga.comp4420.javafx_sample.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import main.java.edu.westga.comp4420.javafx_sample.model.Craft;
import main.java.edu.westga.comp4420.javafx_sample.model.Pattern;
import main.java.edu.westga.comp4420.javafx_sample.model.Progression;

/**
 * The Test Class for the Pattern Constructor
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */
class TestPatternConstructor {

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
