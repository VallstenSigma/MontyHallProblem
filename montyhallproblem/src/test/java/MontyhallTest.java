import org.testng.annotations.Test;

public class MontyhallTest {

    @Test
    public void testWinProbabilityChangeBox(){
        System.out.println("Probability of winning when changing the box after an empty one has been removed");
        try{
            var numberOfChecks = Integer.parseInt(System.getProperty("numberOfChecks", "100"));
            var i = 0;
            var numberOfWins = 0;
            while(i<numberOfChecks){
                var gameShow = new GameShow();
                gameShow.pickRandomClosedBox();
                gameShow.openOneEmptyBox();
                gameShow.changeToOtherClosedBox();
                if(gameShow.checkIfPlayerWon()){
                    numberOfWins++;
                }
                i++;
            }
            PrintOutSuccessMessage(numberOfWins, numberOfChecks);
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid input. Must be a number");
            ex.printStackTrace();
        }
    }

    @Test
    public void testWinProbabilityKeepBox(){
        System.out.println("Probability of winning when keeping the first box guess");
        try{
            var numberOfChecks = Integer.parseInt(System.getProperty("numberOfChecks", "100"));
            var i = 0;
            var numberOfWins = 0;
            while(i<numberOfChecks){
                var gameShow = new GameShow();
                gameShow.pickRandomClosedBox();
                gameShow.openOneEmptyBox();
                if(gameShow.checkIfPlayerWon()){
                    numberOfWins++;
                }
                i++;
            }
            PrintOutSuccessMessage(numberOfWins, numberOfChecks);
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid input. Must be a number");
            ex.printStackTrace();
        }
    }

    public void PrintOutSuccessMessage(int numberOfWins, int numberOfChecks){
        System.out.println("You won " + numberOfWins + " times out of " + numberOfChecks);
        System.out.println("Percentage: " + ((float)numberOfWins / (float)numberOfChecks) * 100);
        System.out.println();
    }
}
