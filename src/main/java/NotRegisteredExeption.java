public class NotRegisteredExeption extends RuntimeException{
    public NotRegisteredExeption (String playerName){
        super("Игрок с именем " + playerName + " не найден");
    }
}
