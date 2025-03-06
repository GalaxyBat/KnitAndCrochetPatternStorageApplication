package main.java.edu.westga.comp4420.javafx_sample.model;

/**
 * The Class PatternStorage
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */

 public class PatternStorage {
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
            throw new IllegalAccessException("Patterns can't be null");
        }
        this.patterns = patterns;
    }

    public boolean contains(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern can't be null");
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
            throw new IllegalArgumentException("Pattern can't be null");
        }
        if (this.contains(pattern)) { 
            throw new IllegalArgumentException("Patterns can't be duplicate");
        }
           
        return this.patterns.add(pattern);
    }

    public boolean remove(Pattern pattern) {
        if (pattern == null) {
            throw new IllegalArgumentException("Pattern can't be null");
        }
        return this.patterns.remove(pattern);
    }



 }