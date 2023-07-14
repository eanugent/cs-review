Add the following method to your `GreetingController` class:

```
/*
 * Returns a Hashtable with NBA IDs as the keys and player data as the values
 */ 
public Hashtable<String, String[]> getHashedData() {
  String line;
  String csvSplitBy = ",";

  try {
      File file = ResourceUtils.getFile("classpath:data.csv");
      Scanner scanner = new Scanner(file);
      int rows = 0;
      int cols = 0;

      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        cols = Math.max(cols, line.split(csvSplitBy).length);
        rows++;
      }

      Hashtable<String, String[]> dataArray = new Hashtable<String, String[]>(rows);

      scanner.close();
      scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        String[] data = line.split(csvSplitBy);
        for (int col = 0; col < data.length; col++) {
          dataArray.put(data[1], data);
        }
      }

      scanner.close();
      return dataArray;
  } catch (IOException e) {
      e.printStackTrace();
      return null;
  }
}
```

Create a `getPlayerDataByNbaId` method with the following signature:

```
public String[] getPlayerDataByNbaId(String nbaId) {
  /* USE getHashedData() to get the player's data */
}
```

Change your `greeting` method to use the `getPlayerDataByNbaId` method instead of `getData`.
