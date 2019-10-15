# MatrixCalculator
This calculator, similar to others allows users to use a scientific calculator. Although this program also allows users to calculate matrices as well.

Operating Instructions:
- Click the program to start, and a pop-up menu will appear for either a scientific or a matrix calculator. Click whichever calculator is needed to solve the mathematical equation. 
- If using the scientific calculator, the symbols indicated by the button correspond to those mathematical operations and will operate exactly like a regular scientific calculator. 
- If the matrix calculator is chosen, then a different screen will appear. Similar to the scientific calculator, the symbols on the button represent mathematical operations that can be used. Although different from the scientific calculator, there will be no number buttons. The user will first need to choose the size of the matrix, which can range from a 1-by-1 to a 4-by-4. Once done, the user can input numbers into the text field but will need to use a space or a comma to indicate the start of a new number. The numbers will be placed from left to right, meaning the first number is row one column one and the second is row one column two and so on. The place button is used to add the numbers input into the matrix. The solve button is used to solve the matrices through the operations indicated. The rewrite button will be used to rewrite the most recent matrix created and will work similarly to the clear button replacing the old matrix entirely with the new one indicated in the text field. 

Assumptions made by developers:
- If numbers in the text field outnumber the number of spaces available in the matrix: The program will not add the additional numbers **The program will _NOT_ create a matrix that is capable of holding all the numbers input**.
- If numbers of spaces in matrix outnumber the ones in the text field: All remaining empty spaces will then be replaced with zero
- If no operations are indicated: For the matrix calculator, it will default to multiplication unless multiplication between matrices is impossible then it will simply overwrite the previous matrix similar to clicking the rewrite button. For the scientific calculator, it will also default to multiplication. *Note: This will only occur if there are parenthesis between the numbers for the scientific calculator.
