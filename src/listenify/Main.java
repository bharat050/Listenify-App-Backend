package listenify;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Albums a1 = new Albums("Reputation", "Taylor Swift");

        a1.addNewSong("Delicate", 3.52);
        a1.addNewSong("Look What you made me do", 3.31);
        a1.addNewSong("End Game", 4.04);

        Albums a2 = new Albums("Dangerous Woman", "Ariana Grande");
        a2.addNewSong("Into You", 4.04);
        a2.addNewSong("Side to Side", 3.46);
        a2.addNewSong("Moonlight", 3.22);

        List<Song> playList = new ArrayList<>();
        a1.addToPlaylist(playList, 1);
        a1.addToPlaylist(playList, 3);
        a1.addToPlaylist(playList, "Look What you made me do");
        a2.addToPlaylist(playList, "Into You");
        a2.addToPlaylist(playList,"Side to Side");
        a2.addToPlaylist(playList,"Moonlight");

        printMenu();
        int currIndex = 0;
        System.out.println("Current Song playing "+ playList.get(currIndex).toString());

        boolean loop = true;
        boolean status = true;
        while(loop){

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();

            switch (choice){

                case 1:
                    currIndex += 1;
                    if(currIndex% playList.size() == 0){
                        currIndex = 0;
                    }
                    System.out.println("Current Song playing "+ playList.get(currIndex).toString());
                    break;

                case 2:
                    currIndex -= 1;
                    if(currIndex<=0){
                        currIndex =0;
                    }
                    System.out.println("Current Song playing "+ playList.get(currIndex).toString());
                    break;

                case 3:
                    if(status){
                        status = false;
                        System.out.println("Current song paused");
                    }
                    else{
                        status = true;
                        System.out.println("Current song played");
                    }
                    break;

                case 4:
                    System.out.println("Restarting the Current Song "+ playList.get(currIndex).toString());
                    break;
                case 5:
                    Collections.shuffle(playList);
                    printPlaylist(playList);
                    break;
                case 6:
                    playList.remove(currIndex);
                    break;
                case 7:
                    printPlaylist(playList);
                    break;
                case 8:
                    printMenu();
                    break;
                case 9:
                    loop = false;
                    System.out.println("exiting the application");
                    break;
            }
        }
    }

    public static void printMenu(){
        System.out.println("<------------------->");
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Pause/Play the Song");
        System.out.println("4. Restart the Song");
        System.out.println("5. Shuffle the playlist");
        System.out.println("6. Delete the Current Song from the playlist");
        System.out.println("7. Print the Playlist.");
        System.out.println("8. Print the Menu again");
        System.out.println("9. Exit the system");
        System.out.println("<------------------->");

    }

    public static void printPlaylist(List<Song> playList){
        int i=0;
        for(Song song: playList){
            System.out.println(i+1 +". "+ song.toString());
            i++;
        }
    }
}
