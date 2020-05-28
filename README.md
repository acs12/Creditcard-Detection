# Individual Project CMPE-202

#### Code Explanation

•	In my system, first of all user will enter the location of path from where to read the file and give the name for output file without extension.

•	After this switch statement will check if the extension provided is correct and then will create object for appropriate class like CSV, XML or JSON, hence <Strong> Strategy Pattern </Strong> is used here. Also, in future if new file formats are added, only new read write function for that class needs to be created and no change to existing code is done.

•	After implementation of Strategy pattern, I used <Strong> Chain of Responsibility </Strong> in which card number is passed to first handler and checked if the card number matches the requirement. If yes, that class will handle the request and return appropriate answer. If not, it will pass the request to next handler that is set in the setSuccessor() function. In future if more card companies are added, only new successors need to be set and no change to existing implementation is done.

•	 After handling the card by particular handler, I implemented <Strong> State pattern </Strong> to check if the length of card is in valid or not and sets the state of the card accordingly. In future if more states are added then we can add “Processing”, “Transaction Successful”, “Transaction Failed” etc. states easily. If card is not handled by any handler then it sets the state to invalid and return the control to the write function selected by strategy function and writes the file into appropriate format.


#### Test Cases

•	Number of test cases are written to check if the file is handled properly when entered into the system by user, also for the strategy pattern selecting the appropriate algorithm for the extension given. Test cases for particular card companies are also tested for the valid and invalid card number provided and setting the state of the system accordingly.

Apart from these <Strong> Factory pattern </Strong> can also be implemented as suggested in part-1 of the project to create the object of particular card company and then proceed to State pattern to set different states as mentioned above but as per the given scenario we need not create addition factory pattern as pattern implemented meets the given requirements.

#### Class Diagram
![Class Diagram part-3](https://user-images.githubusercontent.com/46435796/80420610-e01e3b80-888f-11ea-9ef5-71236a2f662b.jpg)
