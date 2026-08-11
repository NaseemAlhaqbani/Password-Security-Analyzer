
package password.strength.checker;


public class PasswordReport {
    
    private int score;
    private String strength;
    private String feedback;

    public PasswordReport(int score, String strength, String feedback) {
        this.score = score;
        this.strength = strength;
        this.feedback = feedback;
    }

    public int getScore() {
        return score;
    }

    public String getStrength() {
        return strength;
    }

    public String getFeedback() {
        return feedback;
    }
    
    
    
    
    
    
}

