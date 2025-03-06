package main.java.edu.westga.comp4420.javafx_sample.model;

import java.util.ArrayList;

/**
 * The Class PatternStorage
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */

public class PatternStorage {
    private static final String PATTERNS_DUPLICATE = "Patterns can't be duplicate";
    private static final String PATTERNS_NULL = "Patterns can't be null";
    private static final String PATTERN_NULL = "Pattern can't be null";
    private ArrayList<Pattern> patterns;

    /**
     * The constructor to create pattern
     * 
     * @precondition none
     * @postcondition none
     * 
     */
    public PatternStorage() {
        this.patterns = new ArrayList<Pattern>();
    }

    /**
     * Gets all the patterns in the list
     * 
     * @return the patterns
     */
    public ArrayList<Pattern> getPatterns() {
        return this.patterns;
    }


    /**
     * Sets the patterns in the list.
     * 
     * @precondition patterns can't be null
     * 
     * @param patterns the patterns in the list
     */
    public void setPatterns(ArrayList<Pattern> patterns) {
        if (patterns == null) {
            throw new IllegalAccessException(PATTERNS_NULL);
        }
        this.patterns = patterns;
    }

    public boolean contains(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }

        for (Pattern currPattern: this.patterns) {
            if (currPattern.getPatternName.equals(pattern.getPatternName)) {
                return true;
            }
        }

        return false;
    }

    public boolean add(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }
        if (this.contains(pattern)) { 
            throw new IllegalArgumentException(PATTERNS_DUPLICATE);
        }
           
        return this.patterns.add(pattern);
    }

    public boolean remove(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }
        return this.patterns.remove(pattern);
    }



}