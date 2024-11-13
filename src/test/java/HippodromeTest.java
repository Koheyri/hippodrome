
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

class HippodromeTest {
    @Test
    @DisplayName("Check Exception with null Arg")
    public void nullHorsesException(){
        IllegalArgumentException e = assertThrows (
                IllegalArgumentException.class,
                ()-> new Hippodrome(null));

        assertEquals("Horses cannot be null.",e.getMessage());
    }
    @Test
    @DisplayName("Check Exception with empty List in Arg")
    public void emptyListException(){
        List<Horse> testHorses = new ArrayList<>();

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, (() ->
                    new Hippodrome(testHorses))
        );

        assertEquals("Horses cannot be empty.", e.getMessage());
    }

    @Test
    @DisplayName("Check get List of Horses")
    public void getHorsesTest() {
        List<Horse> testHorses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String horse = "Horse" + (i+1);
            testHorses.add(new Horse(horse,i,i));
        }
        Hippodrome hippodrome = new Hippodrome(testHorses);

        assertEquals(testHorses,hippodrome.getHorses());
    }

    @Test
    @DisplayName("Check using move")
    public void checkMoveTest() {
        List<Horse> mockedList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            mockedList.add(mock(Horse.class));
        }
        Hippodrome hippodrome = new Hippodrome(mockedList);
        hippodrome.move();

        for (Horse horse : mockedList){
            Mockito.verify(horse).move();
        }
    }

    @Test
    @DisplayName("Check return the horse with the most result")
    public void getWinnerTest() {
        List<Horse> testHorses = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            String hourse = "Horse" + (i +1);
            testHorses.add(new Horse(hourse,i,i));
        }

        assertEquals(testHorses.get(testHorses.size()-1),new Hippodrome(testHorses).getWinner());
    }
}