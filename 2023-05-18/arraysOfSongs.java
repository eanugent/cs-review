// Online Java compiler: https://www.jdoodle.com/online-java-compiler/


public class MyClass {
    public static void main(String args[]) {
        Song[] songs = new Song[3];
        
        String[] overMyDeadBodyWriters = new String[]{"Aubrey Graham", "Noah Shebib", "Anthony Palman"};
        String[] overMyDeadBodyProducers = new String[]{"40", "Kreviazuk"};
        songs[0] = new Song("Over My Dead Body", overMyDeadBodyWriters, overMyDeadBodyProducers, getSeconds(4, 32));

        String[] shotForMeWriters = new String[]{"Graham", "Shebib", "Abel Tesfaye"};
        String[] shotForMeProducers = new String[]{"40"};
        songs[1] = new Song("Shot for Me", shotForMeWriters, shotForMeProducers, getSeconds(3, 44));

        String[] headlinesWriters = new String[]{"Graham", "Matthew Samuels", "Shebib", "Palman"};
        String[] headlinesProducers = new String[]{"Boi-1da", "40", "Hikwa MM"};
        songs[2] = new Song("Headlines", headlinesWriters, headlinesProducers, getSeconds(3, 56));
        
        AlbumPlayer player = new AlbumPlayer(songs);
        
        player.playAlbum();
    }
    
    public static int getSeconds(int minutes, int seconds){
        return (minutes * 60) + seconds;
    }
}

class AlbumPlayer {
    public Song[] album;

    public AlbumPlayer(Song songsInput[]) {
        album = songsInput;
    }
    
    
    public void playAlbum(){
        int compoundedSeconds = 0;
        for(int i=0; i<album.length; i++){
          Song theCurrentSong = album[i];
          compoundedSeconds += theCurrentSong.length;
        }
    
        System.out.println("The length of the whole album is " + String.valueOf(compoundedSeconds));
        for(int i=0; i<album.length; i++){
            Song theSong = album[i];
            theSong.play();
        }
    }
}

class Song {
     public String name;
     public String writers;
     public String producers;
     public int length;
     
     public Song(String nameInput, String writersInput[], String producersInput[], int lengthInput){
         name = nameInput;
         writers = arrayToString(writersInput);
         producers = arrayToString(producersInput);
         length = lengthInput;
     }
     
     public void play(){
         System.out.println("Now playing ...");
         System.out.println("Name: \"" + name + "\"");
         System.out.println("Writers: \"" + writers + "\"");
         System.out.println("Producers: \"" + producers + "\"");
         System.out.println("Length: " + String.valueOf(length) + " seconds");
         System.out.println("\n\n");
     }
     
     private String arrayToString(String arr[]){
         String returnString = "";
         for(int i=0; i<arr.length; i++){
             returnString += arr[i];
             if (i < arr.length-1){
                 returnString += ", ";
            }
         }
         
         return returnString;
     }
}
