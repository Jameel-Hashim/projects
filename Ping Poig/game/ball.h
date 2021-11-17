class Ball{
private:
	int x, y;
	int originalX, originalY;
	eDir direction;

public:
	Ball(int posX, int posY){
		originalX = posX;
		originalY = posY;
		x = posX;
		y = posY;
		direction = STOP;
	}

	void reset(){
		x = originalX;
		y = originalY;
		direction = STOP;
	}

	void changeDirection(eDir d){
		direction = d;
	}

	void randomDirection(){
		direction = (eDir)((rand() % 6) + 1);
	}

	inline int getX() { return x; }
	inline int getY() { return y; }
	inline eDir getDirection() { return direction; }

	void move(){

		switch (direction){
			case STOP:
				break;
			case LEFT:
				x--;
				break;
			case UPLEFT:
				x--;
				y--;
				break;
			case DOWNLEFT:
				x--;
				y++;
				break;
			case RIGHT:
				x++;
				break;
			case UPRIGHT:
				x++;
				y--;
				break;
			case DOWNRIGHT:
				x++;
				y++;
				break;
			default:
				break;
		}
	}

	friend ostream &operator<<(ostream &o, Ball c){
		o << "Ball [" << c.x << "," << c.y << "][" << c.direction << "]"; 
		return o;
	}
};