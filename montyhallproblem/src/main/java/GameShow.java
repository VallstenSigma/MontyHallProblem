import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class GameShow {

    ArrayList<Box> boxes = new ArrayList<>();

    public GameShow(int numBoxes){

        IntStream.range(0, numBoxes).forEach(n -> {
            boxes.add(new Box());
        });

        // Selects a random box and place a price
        var randomIndex = ThreadLocalRandom.current().nextInt(0, 3);
        boxes.get(randomIndex).SetPrice();
    }

    public void pickRandomClosedBox(){
        var randomIndex = ThreadLocalRandom.current().nextInt(0, 3);
        boxes.get(randomIndex).isChosenByPlayer = true;
    }

    public void openOneEmptyBox(){
        for(var box: boxes){
            if(!box.isChosenByPlayer && !box.hasPrice){
                box.isOpen = true;
                break;
            }
        }
    }

    public void changeToOtherClosedBox(){
        var playerBox = getPlayerBox();
        var closedBox = getClosedBox();

        playerBox.isChosenByPlayer = false;
        closedBox.isChosenByPlayer = true;
    }

    public Box getPlayerBox(){
        for(var box: boxes){
            if(box.isChosenByPlayer){
                return box;
            }
        }
        return null;
    }

    public Box getClosedBox(){
        for(var box: boxes){
            if(!box.isChosenByPlayer && !box.isOpen){
                return box;
            }
        }
        return null;
    }

    public boolean checkIfPlayerWon(){
        var playerBox = getPlayerBox();
        return (playerBox != null) && playerBox.hasPrice;
    }
}