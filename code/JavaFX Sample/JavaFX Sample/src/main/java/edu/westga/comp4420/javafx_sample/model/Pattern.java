package main.java.edu.westga.comp4420.javafx_sample.model;

/**
 * The model class for knit and crochet Pattern
 * 
 * @version Spring 2025
 * @author Genesis Ross
 */

 public class Pattern {
    private String patternName;
    private String author;
    private String website;
    private Craft craft;
    private Progression progression;
    private int yarnWeight;

    /**
     * The contructor for the class Pattern
     * 
     * @precondition patternName != null && !patternName.isEmpty() && !patterName.isBlank()
     *               && author != null && !author.isEmpty() && !author.isBlank()
     *               && website != null && !website.isEmpty() && !website.isBlank()
     *               && yarnWeight >= 1 && yarnWeight <= 4
     * @postcondition getPatternName == patternName && getAuthor == author && getWebsite == website && getCraft = craft
     *                && getProgression == progression && getYarnWeight == YarnWeight
     * @param patternName the pattern's name
     * @param author the pattern's author
     * @param website the website the pattern can be found on
     * @param craft if the pattern is knit or crochet
     * @param progression if the pattern has been started, finished, or haven't been started on yet
     * @param yarnWeight the thickness of the yarn
     */
   
     public Pattern(String patternName, String author, String website, Craft craft, Progression progression, int yarnWeight) {
        if (patternName == null) {
            throw new IllegalArgumentException("Pattern can not be null");
        }
        if (patternName.isEmpty()) {
            throw new IllegalArgumentException("Pattern can not be empty");
        }
        if (patternName.isBlank()) {
            throw new IllegalArgumentException("Pattern can not be blank");
        }

        if (author == null) {
            throw new IllegalArgumentException("Author can not be null");
        }
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author can not be empty");
        }
        if (author.isBlank()) {
            throw new IllegalArgumentException("Author can not be blank");
        }

        if (website == null) {
            throw new IllegalArgumentException("Website can not be null");
        }
        if (website.isEmpty()) {
            throw new IllegalArgumentException("Website can not be empty");
        }
        if (website.isBlank()) {
            throw new IllegalArgumentException("Website can not be blank");
        }

        if (yarnWeight <= 0 || yarnWeight >=5) {
            throw new IllegalArgumentException("Yarn weight must be in 1, 2, 3, or 4");
        }

        this.patternName = patternName;
        this.author = author;
        this.website = website;
        this.craft = craft;
        this.progression = progression;
        this.yarnWeight = yarnWeight;

     }

     /**
      * Gets the name of the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public String getPatternName() {
        return this.patternName;
     }

     /**
      * Sets the pattern name
      *
      * @param patternName
      */
     public void setPatternName(String patternName) {
        this.patternName = patternName;
     }

     /**
      * Gets the author of the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public String getAuthor() {
        return this.author;
     }

      /**
      * Sets the name of the author 
      *
      * @param author
      */
     public void setAuthor(String author) {
        this.author = author;
     }

     /**
      * Gets the website of the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public String getWebsite() {
        return this.website;
     }

      /**
      * Sets the website url
      *
      * @param website
      */
     public void setWebsite(String website) {
        this.website = website;
     }

     /**
      * Gets the type of craft of the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public Craft getCraft() {
        return this.craft;
     }

      /**
      * Sets the craft
      *
      * @param craft
      */
     public void setCraft(Craft craft) {
        this.craft = craft;
     }

     /**
      * Gets the progression made on the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public Progression getProgression() {
        return this.progression;
     }

      /**
      * Sets the progression status
      *
      * @param progression
      */
     public void setProgression(Progression progression) {
        this.progression = progression;
     }

     /**
      * Gets the yarn weight for the pattern
      *
      * @precondition none
      * @postcondition none
      *
      * @return the pattern name
      */
     public int getYarnWeight() {
        return this.yarnWeight;
     }

      /**
      * Sets the yarn weight
      *
      * @param yarnWeight
      */
     public void setYarnWeight(int yarnWeight) {
        this.yarnWeight = yarnWeight;
     }

     @Override
     public String toString() {
        return this.patternName + " by: " + this.author;
     }

 }