import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class HorseTest {
    private static final Horse horse = new Horse("TestHorse",1,1);
    @Test
    @DisplayName("Check Exception with null first Arg")
    public void nullNameException(){
        IllegalArgumentException e = assertThrows (IllegalArgumentException.class,
                ()-> new Horse(null,1,1));

        assertEquals("Name cannot be null.",e.getMessage());
    }
    @ParameterizedTest
    @DisplayName("Check Exception with empty or blank first Arg")
    @ValueSource(strings = {""," ","\t\t","\n\n"})
    public void blankNameMessage(String name){
        IllegalArgumentException e = assertThrows (IllegalArgumentException.class,
                ()-> new Horse(name,1,1));

        assertEquals("Name cannot be blank.",e.getMessage());
    }
    @Test
    @DisplayName("Check Exception with negative second Arg")
    public void secondNegativeArgTest(){
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> new Horse("TestHorse", -1 * Math.random(), 1)
        );

        assertEquals("Speed cannot be negative.", e.getMessage());
    }

    @Test
    @DisplayName("Check Exception with negative second Arg")
    public void thirdNegativeArgTest(){
        Throwable e = assertThrows(
                IllegalArgumentException.class,
                () -> new Horse("TestHorse", 1, -1 * Math.random())
        );

        assertEquals("Distance cannot be negative.", e.getMessage());
    }

    @Test
    @DisplayName("Check return first Arg")
    public void getNameTest() {
        assertEquals("TestHorse", horse.getName());
    }

    @Test
    @DisplayName("Check return second Arg")
    public void getSpeedTest() {
        assertEquals(1,horse.getSpeed());
    }

    @Test
    @DisplayName("Check return zero without third Arg && third Arg")
    public void getDistanceTest() {
        assertEquals(1,horse.getDistance());
        assertEquals(0,new Horse("TestHorseZero", 1).getDistance());
    }


    @DisplayName("Check getRandomDouble in move")
    @ParameterizedTest
    @ValueSource(doubles = {1.3, 0.7, 0.9})
    public void moveUsesGetRandomTest(double value) {
        try (MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            mockedStatic.when(() -> Horse.getRandomDouble(0.2,0.9)).thenReturn(value);
            Horse testHorse = new Horse("TestHorses",0.2,0.1);
            testHorse.move();


            mockedStatic.verify(() -> Horse.getRandomDouble(0.2,0.9));
            assertEquals(0.1 + 0.2 * value,testHorse.getDistance());
        }
    }


}