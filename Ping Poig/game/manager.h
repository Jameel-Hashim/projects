#include <iostream>
#include <conio.h>

using namespace std;

enum eDir { STOP = 0, LEFT = 1, UPLEFT = 2, DOWNLEFT = 3, RIGHT = 4, UPRIGHT = 5, DOWNRIGHT = 6};

#include "./ball.h"
#include "./paddle.h"

class Manager{
private:
	int width, height;
	int score1, score2;
	char up1, up2, down1, down2;
	bool quit;
	Ball *ball;
	Paddle *player1;
	Paddle *player2;

public:
	Manager(int w, int h){
		srand(time(NULL));
		quit = false;
		up1 = 'w';
		up2 = 'i';
		down1 = 's';
		down2 = 'k';
		score1 = score2 = 0;
		width = w;
		height = h;
		ball = new Ball(w/2, h/2); //ball in middle
		player1 = new Paddle(1, h/2-3);
		player2 = new Paddle(w-2, h/2-3);
	}

	~Manager(){
		delete ball, player1, player2;
	}

	void scoreUp(Paddle *player){
		if(player == player1)
			score1++;
		else if(player == player2)
			score2++;

		ball->reset();
		player1->reset();
		player2->reset();
	}

	void draw(){
		system("clear");

		//top wall
		for(int i = 0; i < width + 2; i++)
			cout << "#";
		cout << endl;

		for(int i = 0; i < height; i++){
			for(int j = 0; j<width; j++){

				int ballX = ball->getX();
				int ballY = ball->getY();

				int player1X = player1->getX();
				int player1Y = player1->getY();
				int player2X = player2->getX();
				int player2Y = player2->getY();

				//left wall
				if(j == 0) 
					cout << "X";

				 //ball
				if(ballX == j && ballY == i)
					cout << "O";

				//player1
				else if(player1X == j && player1Y == i)
					cout << "|"; 
				else if(player1X == j && player1Y + 1 == i)
					cout << "|";
				else if(player1X == j && player1Y + 2 == i)
					cout << "|";
				else if(player1X == j && player1Y + 3 == i)
					cout << "|";

				//player2
				else if(player2X == j && player2Y == i)
					cout << "|";
				else if(player2X == j && player2Y + 1 == i)
					cout << "|";
				else if(player2X == j && player2Y + 2 == i)
					cout << "|";
				else if(player2X == j && player2Y + 3 == i)
					cout << "|";

				//space
				else
					cout << " ";

				//right wall
				if(j == width-1)
					cout << "X";
			}
			cout << endl;
		}

		//bottom wall
		for(int i = 0; i< width + 2; i++)
			cout << "#";
		cout << endl;

		cout << "Score 1: " << score1 << endl << "Score 2: " << score2 << endl;
	}

	void input(){
		ball->move();

		int ballX = ball->getX();
		int ballY = ball->getY();

		int player1X = player1->getX();
		int player1Y = player1->getY();
		int player2X = player2->getX();
		int player2Y = player2->getY();

		if(_kbhit()){
			char current = getch();

			if(current == up1)
				if(player1Y > 0)
					player1->moveUp();

			if(current == down1)
				if(player1Y + 4 < height)
					player1->moveDown();

			if(current == up2)
				if(player2Y > 0)
					player2->moveUp();

			if(current == down2)
				if(player2Y + 4 < height)
					player2->moveDown();

			if(ball->getDirection() == STOP)
				ball->randomDirection();

			if(current == 'q')
				quit = true;
		}
	}

	void logic(){
		int ballX = ball->getX();
		int ballY = ball->getY();

		int player1X = player1->getX();
		int player1Y = player1->getY();
		int player2X = player2->getX();
		int player2Y = player2->getY();

		//left paddle
		for(int i = 0; i < 4; i++)
			if(ballX == player1X + 1)
				if(ballY == player1Y + i)
					ball->changeDirection((eDir)((rand() % 3 ) + 4));

		//right paddle
		for(int i = 0; i < 4; i++)
			if(ballX == player2X - 1)
				if(ballY == player2Y + i)
					ball->changeDirection((eDir)((rand() % 3 ) + 1));


		//bottom wall
		if(ballY == height - 1)
			ball->changeDirection(ball->getDirection() == DOWNRIGHT ? UPRIGHT : UPLEFT);

		//top wall
		if(ballY == 0)
			ball->changeDirection(ball->getDirection() == UPRIGHT ? DOWNRIGHT : DOWNLEFT);

		//right wall
		if(ballX == width - 1)
			scoreUp(player1);

		//left wall
		if(ballX == 0)
			scoreUp(player2);
	}

	void run(){
		while(!quit){
			draw();
			input();
			logic();
			system("sleep 0.1");
		}
	}
};