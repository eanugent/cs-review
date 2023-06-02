### Environment setup
1. [Download VS Code](https://code.visualstudio.com/download) and install.
2. [Download the Java JDK](https://www.oracle.com/java/technologies/downloads/#jdk20-windows) and install.
3. In VS Code, install the following extensions:
- Extension Pack for Java
- Spring Boot Extension Pack

### Create new Java Spring Boot project
1. Open VS Code
2. Close any open folders or windows
3. Click File -> New Window
4. Click the Explorer tab (top left)
5. Click "Create Java Project"
6. Select Spring Boot
7. Select "Maven Project"
8. Select "3.1.0"
9. Select "Java"
10. Change the Group Id to "csreview"
11. Change the Artifact Id to "nba"
12. Choose Java version "20"
13. For dependencise choose the following:
- Spring Boot DevTools
- Spring Web
- Thymeleaf
14. Press enter to confirm your dependency selection
15. Choose a folder to save your project in
16. Click the "Open" button that appears in the bottom right after the project is created
17. (If you missed the "Open" button, click File -> Open Folder and navigate to the folder that was created
18. Your Explorer should look similar to this:
<img width="204" alt="image" src="https://github.com/eanugent/cs-review/assets/7800184/6c997c6e-615e-4b56-9331-d8e033e6a4b5">

[This video](https://www.youtube.com/watch?v=dq1z9t03mXI) has much of the configuration though the options are different from what we're doing.

### Setup the initial controller and template
1. Create a new file in the path src/main/java/csreview/nba directory named `GreetingController.java`
2. Delete all of the auto-generated text in the file
3. Paste the following into the file:
```
package csreview.nba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
```
4. Create a new file in the path src/main/resources/templates named 'greeting.html'
5. Paste the following into the file:
```
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<head> 
    <title>Getting Started: Serving Web Content</title> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
    <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```
6. Make sure both files are saved
7. Select the "Run and Debug" tab on the left (4th from the top)
8. Click "Run and Debug"
9. Navigate to http://localhost:8080/greeting

For this week, play with the code in GreetingController.java and greeting.html to get familiar with how it works.
