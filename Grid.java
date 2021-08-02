

package coditation_system;
import java.util.Scanner;
//Implement Life of cell
public class Grid {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
 System.out.println("Enter the X-Axis value");
 int rows=sc.nextInt();
 System.out.println("Enter the Y-Axis value");
 int cols=sc.nextInt();
 // Initializing the grid.
 int grid[][]=new int[rows][cols];

 for (int i = 0; i < rows; i++)
 {
 for (int j = 0; j < cols; j++)
 // Pre-star (*) as (1) Initialization
 {
 if((i==2&&j==3)||(i==2&&j==4)){
 grid[i][j]=1; //Live Cell
 }else{
 grid[i][j]=0; // Dead Cell
 }
 }

 }


 // Displaying the grid


 for (int i = 0; i < rows; i++)
 {
 for (int j = 0; j < cols; j++)
 {
 if (grid[i][j] == 0)
 System.out.print(".");
 else
 System.out.print("*");
 }
 System.out.println();
 }
 Cls();
 System.out.println();


int z=0;
int limit=1; // limit of while loop for cell initialization
// Function to print next generation
 int[][] future = new int[rows][cols];

 while(z!=limit) { // curly bracket of while loop start

 // Loop through every cell
 for (int l = 1; l < rows - 1; l++)
 {
 for (int m = 1; m < cols - 1; m++)
 {
 // finding no Of Neighbours that are alive
 int aliveNeighbours = 0;
 for (int i = -1; i <= 1; i++)
 for (int j = -1; j <= 1; j++)
 if(grid[l+i][m+j]==1) {
 aliveNeighbours =aliveNeighbours +1;
 }

 // The cell needs to be subtracted from
 // its neighbours as it was counted before
 
 aliveNeighbours -= grid[l][m];
 // Implementing the Life of cell
 // Cell is lonely and dies
 if ((grid[l][m] == 1) && (aliveNeighbours < 2))
 future[l][m] = 0; // Dead Cell
 // Cell dies due to over population
 else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
 future[l][m] = 0; // Dead Cell
 // A new cell is born
 else if ((grid[l][m] == 0) && (aliveNeighbours == 3)||
(aliveNeighbours == 2))
 future[l][m] = 1; // Live Cell
 // Remains the same
 else
 future[l][m]=grid[l][m];


 }
 }


 for (int i = 0; i < rows; i++)
 {
 for (int j = 0; j < cols; j++)
 {
 if (grid[i][j] == 1)
 System.out.print("*");
 else
 System.out.print(".");
 }
 System.out.println();

 }
 Cls();
 System.out.println();

 // Output of future grid as a input of Grid[][]
 // cell Initialization continue ---->( Repeat)

 for(int i=0;i<rows;i++){
 for(int j=0;j<cols;j++){
 grid[i][j]=future[i][j];
 }
 }
 z++;
 limit++;

 } // curly bracket of while loop end


 }
public static void Cls() {
try{
new
ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor()
;
}catch(Exception e) {
System.out.println(e);
}
}
}