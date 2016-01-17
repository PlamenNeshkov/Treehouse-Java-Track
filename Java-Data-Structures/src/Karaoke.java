import model.Song;
import model.SongBook;

public class Karaoke {
    public static void main(String[] args) {
        SongBook songBook = new SongBook();
        KaraokeMachine karaokeMachine = new KaraokeMachine(songBook);
        karaokeMachine.run();
    }
}
