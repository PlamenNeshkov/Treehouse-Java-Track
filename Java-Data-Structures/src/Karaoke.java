import model.Song;
import model.SongBook;

public class Karaoke {
    public static void main(String[] args) {
        SongBook songBook = new SongBook();
        songBook.importFrom("songs.txt");

        KaraokeMachine karaokeMachine = new KaraokeMachine(songBook);
        karaokeMachine.run();

        System.out.println("Saving book...");
        songBook.exportTo("songs.txt");
    }
}
