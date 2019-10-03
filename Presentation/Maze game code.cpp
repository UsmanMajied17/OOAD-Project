class Maze
{
	public:
		Maze* instance();
	protected:
		Maze();
	private:
		Maze* uniqueMaze;
	
};

Maze* Maze::instance()
{
	if ( uniqueMaze == null )
	{
		const char* mazeStyle = getenv("MAZESTYLE");
		
		//Conditional Ladder.
		if ( strcmp(mazeStyle, "bombed") ) { uniqueMaze = new BombedMaze(); }
		else if ( strcmp(mazeStyle, "Enchanted") ) { uniqueMaze = new EnchantedMaze(); }
		
		//All conditions...
		
		else { uniqueMaze = new Maze(); }
	}
	return uniqueMaze;
}

class BombedMaze: public Maze
{
	protected:
		BombedMaze();
};

class EnchantedMaze: public Maze
{
	protected:
		EnchantedMaze();
};