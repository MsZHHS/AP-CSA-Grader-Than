package gradebookentry.project;

public class GradebookEntry {
    private int score1, score2, score3;
    private String name;

    public GradebookEntry(String n, int ts1, int ts2, int ts3) {
        name = n;
        score1 = ts1;
        score2 = ts2;
        score3 = ts3;
    }

    public String getName() {
        return name;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    

    /**
    * Method Name: setTestScore
    *
    * THIS METHOD SHOULD ALLOW THE USER TO CHANGE A STUDENT'S
    * SCORE. THERE SHOULD BE A LIMIT SO THEY CANNOT MAKE A SCORE LESS
    * THAN 0 AND CANNOT MAKE A SCORE GREATER THAN 105. THE USER SHOULD
    * INDICATE WHICH TEST THEY WANT CHANGED (1 = TEST1, 2 = TEST2, 3 = TEST3). 
    * IF THE VALUE FOR WHICH TEST IS INVALID, NOTHING SHOULD BE DONE
    *
    * @param  NEW SCORE, WHICH TEST
    * @return NOTHING
    */
    public void setTestScore(int newScore, int whichTest) {
        if (newScore >= 0 && newScore <= 105) {
            if (whichTest == 1) {
                score1 = newScore;
            }
            else if (whichTest == 2) {
                score2 = newScore;
            }
            else if (whichTest == 3) {
                score3 = newScore;
            }
        }

    }

    /**
    * Method Name: calcAvg
    *
    * THIS METHOD SHOULD CALCULATE THE AVERAGE OF THE
    * 3 TESTS
    *
    * @param  NONE
    * @return THE AVERAGE OF THE 3 TESTS
    */
    public double calcAvg() {
        return (double) (score1 + score2 + score3)/3;
    }

    /**
    * Method Name: getBestScore
    *
    * THIS METHOD SHOULD FIND THE BEST SCORE OF THE
    * 3 TESTS
    *
    * @param  NONE
    * @return THE HIGHEST SCORE OF THE 3 TESTS
    */
    public int getBestScore() {
        if (score1 >= score2 && score1 >= score3) {
            return score1;
        }
        else if (score2 >= score3) {
            return score2;
        }
        else {
            return score3;
        }
    }

    /**
    * Method Name: hasAtLeast
    *
    * THIS METHOD WILL DECIDE IF THE STUDENT HAS AT LEAST
    * THE SCORE THE USER PASSES IN
    *
    * @param  SCORE TO COMPARE TO
    * @return TRUE IF THE USER HAS AT LEAST THE SCORE
    *         PASSED IN, FALSE IF NOT.
    */
    public boolean hasAtLeast (int compScore) {
        return (getBestScore() >= compScore);
    }
    
}