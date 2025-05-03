package edu.westga.comp4420.javafx_sample.model;

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
            throw new IllegalArgumentException(PATTERNS_NULL);
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
            if (currPattern.getPatternName().equals(pattern.getPatternName()) && currPattern.getAuthor().equals(pattern.getAuthor())) {
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

    /**
     * Returns only knit patterns
     * 
     * @return the list of knit patterns
     */
    public ArrayList<Pattern> onlyKnitPatterns() {
        ArrayList<Pattern> knitPatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getCraft() == Craft.Knit) {
                knitPatterns.add(pattern);
            }
        }
        return knitPatterns;
    }

    /**
     * Returns only crochet patterns
     * 
     * @return the list of crochet patterns
     */
    public ArrayList<Pattern> onlyCrochetPatterns() {
        ArrayList<Pattern> crochetPatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getCraft() == Craft.Crochet) {
                crochetPatterns.add(pattern);
            }
        }
        return crochetPatterns;
    }

    /**
     * Returns only patterns that yarn weight is weight one
     * 
     * @return the list of patterns with a yarn weight of one
     */
    public ArrayList<Pattern> onlyWeightOnePatterns() {
        ArrayList<Pattern> weightOnePatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 1) {
                weightOnePatterns.add(pattern);
            }
        }
        return weightOnePatterns;
    }

     /**
     * Returns only patterns that yarn weight is weight two
     * 
     * @return the list of patterns with a yarn weight of two
     */
    public ArrayList<Pattern> onlyWeightTwoPatterns() {
        ArrayList<Pattern> weightTwoPatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 2) {
                weightTwoPatterns.add(pattern);
            }
        }
        return weightTwoPatterns;
    }

     /**
     * Returns only patterns that yarn weight is weight three
     * 
     * @return the list of patterns with a yarn weight of three
     */
    public ArrayList<Pattern> onlyWeightThreePatterns() {
        ArrayList<Pattern> weightThreePatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 3) {
                weightThreePatterns.add(pattern);
            }
        }
        return weightThreePatterns;
    }

     /**
     * Returns only patterns that yarn weight is weight four
     * 
     * @return the list of patterns with a yarn weight of four
     */
    public ArrayList<Pattern> onlyWeightFourPatterns() {
        ArrayList<Pattern> weightFourPatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 4) {
                weightFourPatterns.add(pattern);
            }
        }
        return weightFourPatterns;
    }

     /**
     * Returns only patterns that yarn weight is weight five
     * 
     * @return the list of patterns with a yarn weight of five
     */
    public ArrayList<Pattern> onlyWeightFivePatterns() {
        ArrayList<Pattern> weightFivePatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 5) {
                weightFivePatterns.add(pattern);
            }
        }
        return weightFivePatterns;
    }

     /**
     * Returns only patterns that yarn weight is weight six
     * 
     * @return the list of patterns with a yarn weight of six
     */
    public ArrayList<Pattern> onlyWeightSixPatterns() {
        ArrayList<Pattern> weightSixPatterns = new ArrayList<Pattern>();
        for (Pattern pattern : this.patterns) {
            if (pattern.getYarnWeight() == 6) {
                weightSixPatterns.add(pattern);
            }
        }
        return weightSixPatterns;
    }

    

}