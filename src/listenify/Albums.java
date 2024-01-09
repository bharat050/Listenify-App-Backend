package listenify;

import java.util.ArrayList;
import java.util.List;
public class Albums {

    private String albumName;
    private String artistName;
    private List<Song> songList;

    public Albums(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public Albums(String albumName, String artistName, List<Song> songList) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = songList;
    }
    public boolean findSong(String title){
        // to check weather the song is available in the list.
        for(Song songList1 : this.songList){
            if(songList1.getTitle().equals(title)) return true;
        }
        return false;
    }
    public void addNewSong(String title, double duration){
        if(!findSong(title)){
            Song song = new Song(title, duration);
            songList.add(song);
            System.out.println("Song: "+title+" is successfully added into the album");
        }
        else{
            System.out.println("This song with this tittle is already been added");
        }
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void addToPlaylist(List<Song> playlist, int songNo){
        Song song = songList.get(songNo-1);
        playlist.add(song);
    }
    public void addToPlaylist(List<Song> playlist, String title){
        for(Song s: songList){
            if(s.getTitle().equals(title)){
                playlist.add(s);
                return;
            }
        }
    }
}
