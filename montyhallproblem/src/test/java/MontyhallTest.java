import org.testng.annotations.Test;

import java.util.stream.IntStream;

public class MontyhallTest {

    @Test
    public void testWinProbabilityChangeBox(){
        System.out.println("Probability of winning when changing the box after an empty one has been removed");
        try{
            var numberOfChecks = Integer.parseInt(System.getProperty("numberOfChecks", "100"));
            var wrapper = new Object(){int numberOfWins = 0;};

            IntStream.range(0, numberOfChecks).forEach(n -> {
                var gameShow = new GameShow(3);
                gameShow.pickRandomClosedBox();
                gameShow.openOneEmptyBox();
                gameShow.changeToOtherClosedBox();
                if(gameShow.checkIfPlayerWon()){
                    wrapper.numberOfWins++;
                }
            });
            PrintOutSuccessMessage(wrapper.numberOfWins, numberOfChecks);
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
            var wrapper = new Object(){ int numberOfWins = 0;};
            IntStream.range(0, numberOfChecks).forEach(n -> {
                var gameShow = new GameShow(3);
                gameShow.pickRandomClosedBox();
                gameShow.openOneEmptyBox();
                if(gameShow.checkIfPlayerWon()){
                    wrapper.numberOfWins++;
                }
            });
            PrintOutSuccessMessage(wrapper.numberOfWins, numberOfChecks);
        }
        catch (NumberFormatException ex){
            System.out.println("Invalid input. Must be a number");
            ex.printStackTrace();
        }
    }

    public void PrintOutSuccessMessage(int numberOfWins, int numberOfChecks){
        System.out.printf("You won %d times out of %d%n", numberOfWins, numberOfChecks);
        System.out.printf("Percentage: %.1f%n", ((float)numberOfWins / (float)numberOfChecks) * 100);
        System.out.println();
    }
}
