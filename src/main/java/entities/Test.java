package entities;

/**
 * Test class represents test as array of answers as numbers and contains user's id for each user
 */
public class Test {
    /**
     * Count of answers
     */
    public static final int Q_COUNT = 7;
    /**
     * Array of ansers
     */
    private int[] Answers = new int[Q_COUNT];
    /**
     * User's id
     */
    private int User_id;

    /**
     * Set array of numbers as array of answers
     * @param answers
     */
    public void setAnswers(int[] answers) {
        this.Answers = answers;
    }

    /**
     * Returns array of answers
     * @return
     */
    public int[] getAnswers(){
        return this.Answers;
    }

    /**
     * Sets user's id
     * @param user_id
     */
    public void setUser_id(int user_id){
        this.User_id = user_id;
    }

    /**
     * @param test
     * @return Count of matches in answers of two tests
     */
    public int countMatches(Test test){
        int count = 0;

        int[] Answers = test.getAnswers();

        if (Answers[0] == this.Answers[1])
            count++;

        if (Answers[1] == this.Answers[0])
            count++;

        for (int i = 2; i < Q_COUNT; i++){
            if (Answers[i] == this.Answers[i])
                count++;
        }
        return count;
    }
}

