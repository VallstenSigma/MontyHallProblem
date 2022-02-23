import java.util.concurrent.ThreadLocalRandom;

public class GameShow {

    Box[] boxes = {new Box("Empty"), new Box("Empty"), new Box("Empty")};

    public GameShow(){
        var randomIndex = ThreadLocalRandom.current().nextInt(0, 3);
        boxes[randomIndex] = new Box("Money");
    }

    public void pickRandomClosedBox(){
        var randomIndex = ThreadLocalRandom.current().nextInt(0, 3);
        boxes[randomIndex].isChosenByPlayer = true;
    }

    public void openOneEmptyBox(){
        for(var box: boxes){
            if(!box.isChosenByPlayer && box.content.equals("Empty")){
                box.isOpen = true;
                break;
            }
        }
    }

    public void changeToOtherClosedBox(){
        int chosenBoxIndex = -1;
        int lastClosedBoxIndex = -1;
        for(var i = 0; i<boxes.length; i++){
            if(boxes[i].isChosenByPlayer){
                chosenBoxIndex = i;
            }
            else if(!boxes[i].isOpen){
                lastClosedBoxIndex = i;
            }
        }
        boxes[chosenBoxIndex].isChosenByPlayer = false;
        boxes[lastClosedBoxIndex].isChosenByPlayer = true;
    }

    public boolean checkIfPlayerWon(){
        for(var box: boxes){
            if(box.isChosenByPlayer){
                if(box.content.equals("Money")){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
