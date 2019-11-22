# MatrixCalculator
This calculator allows users to choose between three different calculators; a basic calculator, scientific calculator, and matrix calculator.

Important Information:
The project updated version of the project will be in the section called Demo3, and that version should be the one downloaded. Currently, there are no JUnit tests for this project.

Compiling/Running the code:

To run the program, the user will first need to compile the code. In most cases, the project will be in the Downloads folder. If not, find the location of the program on your computer. Once found, open the file Demo3 and then copy the information found written in the location bar; the default location should be /home/ugd/Username/Downloads/Demo3. Once copied, open Terminal and write 'cd' then paste the location of the Demo3 folder. Next, to compile the code, write the line 'javac computerGUI'. Finally, to run the code type the line 'java computerGUI' this will cause a pop-up menu to appear and start the code.

Operating Instructions:
- First, follow the steps listed in Compiling/Running the code, if done correctly a new window should open up displaying four options; 'Basic Calculator', 'Scientific Calculator', 'Matrix Calculator', and 'History'.
- Click whichever calculator fits your current needs or click the history button to display all operations done in this current session.
- If using the scientific calculator, the symbols indicated by the button correspond to those mathematical operations and will operate exactly like a regular scientific calculator.
- If the matrix calculator is chosen, then a different screen will appear. Similar to the scientific calculator, the symbols on the button represent mathematical operations that can be used. The button labelled 'T', stands for transpose; 'RREF' stands for reduced-row echelon form; 'S' stands for scalar multiplication. Once done, the user can input numbers into the text field but will need to use a space or a comma to indicate the start of a new number. The numbers will be placed from left to right, meaning the first number is row one column one and the second is row one column two and so on. 

Assumptions made by developers:
- If numbers in the text field outnumber the number of spaces available in the matrix: The program will not add the additional numbers **The program will _NOT_ create a matrix that is capable of holding all the numbers input**.
- If numbers of spaces in matrix outnumber the ones in the text field: All remaining empty spaces will then be replaced with zero
- If no operations are indicated: For the matrix calculator, it will default to multiplication unless multiplication between matrices is impossible then it will simply overwrite the previous matrix similar to clicking the rewrite button. For the scientific calculator, it will also default to multiplication. *Note: This will only occur if there are parenthesis between the numbers for the scientific calculator.
