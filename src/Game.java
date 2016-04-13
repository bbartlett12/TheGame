
public class Game {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Environment mainEnviro = new Environment();
		eChar[][] temp = mainEnviro.getBoard();
		int i = 0;
		for(eChar[] set : temp)
		{
			int j = 0;
			for(eChar val : set)
			{
				System.out.print(temp[i][j] + " ");
				j++;
			}
			System.out.println();
			i++;
		}
		Menu mainFrame = new Menu();
		mainFrame.showMenu();
	}
	void update()
	{
		
	}

}
