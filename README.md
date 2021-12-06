# individual-project-xinyuli95
individual-project-xinyuli95 created by GitHub Classroom

**Instruction** <br />
In folder /test, you will find individual-project-xinyuli95.jar. Run the program by the following command: <br />
~~~
  java.exe -jar individual-project-xinyuli95.jar <path to dataset file> <path to card file> <path to input file>
~~~
For example: <br />
~~~
  java.exe -jar individual-project-xinyuli95.jar "Dataset - Sheet1.csv" "Cards - Sheet1.csv" "Input1 - Sheet1.csv" <br />
~~~
Please make sure to close the opened result files(Output.csv or Errors.txt) before rerunning the program.
  
**Design Patterns** <br />
1. Singleton <br />
Item and card inventories are maintained in Singleton classes to ensure all operations about inventories are interacting with only 1 instance of database
2. Iterator
Iterator design pattern is used to iterate through each request/item on the order list
4. Chain of Responsibility
This design pattern is used to handle the validation of each requested item 
![Class Diagram](https://github.com/gopinathsjsu/individual-project-xinyuli95/blob/main/class.drawio.png)

**Screenshots** <br />
Test 1:
![image](https://user-images.githubusercontent.com/33916829/144797190-079a0bfe-07dd-4a2a-8404-34cfd584a147.png)
![image](https://user-images.githubusercontent.com/33916829/144797218-239926c3-bff4-4454-b184-87915ba360d1.png)

Test2:
![image](https://user-images.githubusercontent.com/33916829/144797266-46efe242-6636-4def-8158-b63a580af32f.png)
![image](https://user-images.githubusercontent.com/33916829/144797306-29e6f421-7f63-4a83-a67d-3cc2e75507ac.png)

Test 3:
![image](https://user-images.githubusercontent.com/33916829/144797351-e48520e5-f6fd-49af-a1e0-6deeb6df544a.png)
![image](https://user-images.githubusercontent.com/33916829/144797374-84966395-25be-40de-af16-92ebfbcbb4d8.png)



