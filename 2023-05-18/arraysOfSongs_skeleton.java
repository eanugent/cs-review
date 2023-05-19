// Online Java compiler: https://www.jdoodle.com/online-java-compiler/

public class MyClass {
  public static void main(String args[]) {
      Song[] songs = new Song[3];
      
      String[] overMyDeadBodyWriters = new String[]{"Aubrey Graham", "Noah Shebib", "Anthony Palman"};
      String[] overMyDeadBodyProducers = new String[]{"40", "Kreviazuk"};
      songs[0] = new Song("Over My Dead Body", overMyDeadBodyWriters, overMyDeadBodyProducers, getSeconds(4, 32));

      AlbumPlayer player = new AlbumPlayer(songs);
      
      player.playAlbum();
  }
  
  public static int getSeconds(int minutes, int seconds){
      // Convert the minutes and seconds into seconds
      return 0;
  }
}

class AlbumPlayer {
  public Song[] album;

  public AlbumPlayer(Song songsInput[]) {
      album = songsInput;
  }
  
  
  public void playAlbum(){
      // Bonus: Before playing the songs, print out the total length of the album

      // For each song in album, call the song's play method.
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
       // Use System.out.println("") to output the song's information
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