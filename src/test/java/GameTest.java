import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void whenFirstPlayerWin() {
        Player noob = new Player(1, "Noob", 1_000_000);
        Player scorpion = new Player(2, "Scorpion", 1_000);

        Game game = new Game();

        game.register(scorpion);
        game.register(noob);

        int actual = game.round("Noob", "Scorpion");
        int expected = 1;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void whenSecondPlayerWin() {
        Player noob = new Player(1, "Noob", 1_000_000);
        Player scorpion = new Player(2, "Scorpion", 1_000);

        Game game = new Game();

        game.register(scorpion);
        game.register(noob);

        int actual = game.round("Scorpion", "Noob");
        int expected = 2;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void whenDrawPlayers() {
        Player noob = new Player(1, "Noob", 1_000);
        Player scorpion = new Player(2, "Scorpion", 1_000);

        Game game = new Game();

        game.register(scorpion);
        game.register(noob);

        int actual = game.round("Scorpion", "Noob");
        int expected = 0;
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void whenFirstNotRegisteredPlayer() {
        Player noob = new Player(1, "Noob", 1_000_000);
        Player scorpion = new Player(2, "Scorpion", 1_000);

        Game game = new Game();

        game.register(scorpion);
        game.register(noob);

        Assertions.assertThrows(NotRegisteredExeption.class, () -> game.round("Sub zero", "Scorpion"));
    }

    @Test
    public void whenSecondNotRegisteredPlayer() {
        Player noob = new Player(1, "Noob", 1_000_000);
        Player scorpion = new Player(2, "Scorpion", 1_000);

        Game game = new Game();

        game.register(scorpion);
        game.register(noob);

        Assertions.assertThrows(NotRegisteredExeption.class, () -> game.round("Scorpion", "Sub zero"));
    }
}
