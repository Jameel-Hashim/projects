class Paddle{
private:
	int x, y;
	int originalX, originalY;

public:
	Paddle(){
		x = y = 0;
	}

	Paddle(int posX, int posY) : Paddle(){
		originalX = posX;
		originalY = posY;
		x = posX;
		y = posY;
	}

	inline void reset() { x = originalX; y = originalY; }
	inline int getX() { return x; }
	inline int getY() { return y; }
	inline void moveUp() { y--; }
	inline void moveDown() { y++; }

	friend ostream & operator<<(ostream &o, Paddle c){
		o << "Paddle [" << c.x << "," << c.y << "]"; 
		return o;
	}
};