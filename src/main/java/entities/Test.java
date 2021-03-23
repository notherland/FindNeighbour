package entities;

public class Test {
    public static final int Q_COUNT = 7;
    private int[] Answers = new int[Q_COUNT];
    private int User_id;

    public void setAnswers(int[] answers) {
        this.Answers = answers;
    }

    public int[] getAnswers(){
        return this.Answers;
    }

    public void setUser_id(int user_id){
        this.User_id = user_id;
    }

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

