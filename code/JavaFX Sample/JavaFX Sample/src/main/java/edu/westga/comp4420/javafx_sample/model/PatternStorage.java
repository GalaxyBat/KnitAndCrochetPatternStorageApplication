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

    /**
     * Checks to see if the list already has the pattern
     * 
     * @precondition pattern != null
     * @postconditino none
     * 
     * @param pattern the pattern
     * @return true if the list contains the pattern
     */
    public boolean contains(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }

        for (Pattern currPattern: this.patterns) {
            if (currPattern.getPatternName.equals(pattern.getPatternName) && currPattern.getAuthor().equals(pattern.getAuthor())) {
                return true;
            }
        }

        return false;
    }

    /**
     * Adds pattern if not a duplicate
     * 
     * @precondition pattern != null && !this.contains(pattern) 
     * @postcondition none
     * 
     * @param pattern the pattern
     * 
     * @return true if pattern is successfully added
     */
    public boolean add(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }
        if (this.contains(pattern)) { 
            throw new IllegalArgumentException(PATTERNS_DUPLICATE);
        }
           
        return this.patterns.add(pattern);
    }

    /**
     * Removes the pattern from the list
     * 
     * @precondition pattern != null
     * @postcondition none
     * 
     * @param pattern the pattern
     * @return true when removed
     */
    public boolean remove(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException(PATTERN_NULL);
        }
        return this.patterns.remove(pattern);
    }

    /**
     * Gets the size of the storage
     * 
     * @return how many patterns are in the list
     */
    public int size() {
        return this.patterns.size();
    }



}