## Exercise Instructions
1. Download the file data.csv from the nba-data folder [here]([url](https://github.com/eanugent/cs-review/blob/main/2023-06-08/nba-data/data.csv)).
2. In the folder of your Java Spring project, put the downloaded file at the following location: src/main/resources/data.csv
3. In your GreetingController.java file, add the following method (within the `GreetingController` class):
```
public String[][] getData() {
  String line;
  String csvSplitBy = ","; // CSV separator

  try {
      File file = ResourceUtils.getFile("classpath:data.csv");
      Scanner scanner = new Scanner(file);
      int rows = 0; // Number of rows in the CSV file
      int cols = 0; // Number of columns in the CSV file

      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        cols = Math.max(cols, line.split(csvSplitBy).length);
        rows++;
      }

      String[][] dataArray = new String[rows][cols]; // 2D string array to store the CSV data
      int row = 0;

      scanner.close();
      scanner = new Scanner(file);
      // Read the CSV file and store the data in the 2D array
      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        String[] data = line.split(csvSplitBy);
        for (int col = 0; col < data.length; col++) {
            dataArray[row][col] = data[col];
        }
        row++;
      }

      scanner.close();
      return dataArray;
  } catch (IOException e) {
      e.printStackTrace();
      return null;
  }
}
```
2. Add the following lines after your last `import ...` at the top of the GreetingController.java file:
```
import java.io.IOException;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.util.Scanner;
```
4. In your `greeting` method, create a 2-dimensional array of strings named `data` that gets its value by calling the newly created `getData` method.
5. Change the parameter name for the `greeting` method to by `id` and make it required without a default value.
6. Use the `id` parameter's value to send the specified array from the `data` array.
7. In the greeting.html file, output some of the fields in the array.
8. Run your site and debug until you figure it out.
