#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <time.h>
#include <windows.h>
//蛇的活动区域[0,60],[0,20]
#define MAX_X   (61)
#define MAX_Y   (21)
//蛇的运动方向
#define UP       (0)
#define DOWN     (1)
#define LEFT     (2)
#define RIGHT    (3)
using namespace std;

void cursor(int x,int y)
{
    HANDLE hd=GetStdHandle(STD_OUTPUT_HANDLE);
    CONSOLE_CURSOR_INFO cci;
    GetConsoleCursorInfo(hd,&cci);
    cci.bVisible=false;
    SetConsoleCursorInfo(hd,&cci);
    COORD pos;
    pos.X=x;
    pos.Y=y;
    SetConsoleCursorPosition(hd,pos);
}

class Fruit
{
public:
    Fruit();
    void drawFruit();
    int getFruitX();
    int getFruitY();
    void setFruitXY();
private:
    int fruitX;
    int fruitY;
    const char fruitShape;
};

Fruit::Fruit():fruitShape('o')
{
    //随机数种子初始化果实位置
  //  srand(time(0));
    //a + (int)b * rand() / (RAND_MAX + 1)
  //  fruitX=0 + 60 * rand() / (RAND_MAX + 1);
  //  fruitY=0 + 20 * rand() / (RAND_MAX + 1);
    //cursor(headX,headY);
    //cout<<fruitShape;
}

void Fruit::drawFruit()
{
 //   fruitX=30;      /**< 测试专用代码 */
 //   fruitY=11;      /**< 测试专用代码 */
    cursor(fruitX,fruitY);
    cout<<fruitShape;
}

int Fruit::getFruitX()
{
    return fruitX;
}

int Fruit::getFruitY()
{
    return fruitY;
}

void Fruit::setFruitXY()
{

    //随机数种子初始化果实位置

    srand(time(0));
    //a + (int)b * rand() / (RAND_MAX + 1)
    fruitX=0 + 60 * rand() / (RAND_MAX + 1);
    fruitY=0 + 20 * rand() / (RAND_MAX + 1);

}

class Snake
{
private:
    int  length;
    int  direction;


    struct Body
    {
        int bodyX;
        int bodyY;
        char bodyShape;
        char iAmBodyHead;
        struct Body* next;
    }body;

    struct Head
    {
        int headX;
        int headY;
        char headShape;
        struct Body* bodyHead;
    }head;

public:
    Snake();
    ~Snake();
    int justMove();
    void controlSnake();
    char getHeadshape();
    struct Head& getHead();
    struct Body& getBody();
    int  getLength();
    void drawHead();
    void drawBody();
    void clearHead();
    void clearBody();
    int  getHeadPosX();
    int  getHeadPosY();
    void setHeadPosXY(int a,int b);
    void setHeadAndBodyShape(char HeadShape,char BodyShape);
    struct Body& getTail();
    struct Body& getLastSecond();
    bool eatingCheck(Fruit&fruit);
    bool crackCheck();
    bool overWall();
    friend class Menue;
};



Snake::Snake():length(2)
{
  //  Head head;
  //  Body body;
    body.iAmBodyHead='Y';
    body.next=NULL;
    //随机数种子初始化蛇的坐标和运动方向
    head.headX=30;
    head.headY=10;
    head.bodyHead=&body;

    srand(time(NULL));
    direction=(rand()%(3-0+1))+ 0 ;
    Body& tempBodyHead=*head.bodyHead;

    direction=1;    /**< 测试专用代码； */

    if(0==direction)
    {
        head.headShape='^';
        body.bodyShape='I';
        tempBodyHead.bodyX=head.headX;
        tempBodyHead.bodyY=head.headY+1;
        drawHead();
        drawBody();
    }
    else if(1==direction)
    {
        head.headShape='V';
        body.bodyShape='I';
        tempBodyHead.bodyX=head.headX;
        tempBodyHead.bodyY=head.headY-1;
        drawHead();
        drawBody();
    }
    else if(2==direction)
    {
        head.headShape='<';
        body.bodyShape='-';
        tempBodyHead.bodyX=head.headX+1;
        tempBodyHead.bodyY=head.headY;
        drawHead();
        drawBody();
    }
    else if(3==direction)
    {
        head.headShape='>';
        body.bodyShape='-';
        tempBodyHead.bodyX=head.headX-1;
        tempBodyHead.bodyY=head.headY;
        drawHead();
        drawBody();
    }
}

Snake::~Snake()
{
    try
    {
        //构造类时最初的一个Body对象是不能够delete的其他的body对象都必须delete
        Body& tempBody=*head.bodyHead;
        if(tempBody.next==NULL)
            return;
        while(tempBody.iAmBodyHead=='N')
        {
            if(getTail().iAmBodyHead=='Y')
            {
                getLastSecond().next=NULL;
                delete &getTail();
                getLastSecond().next=NULL;
            }
            else
            {
                delete &getTail();
                getLastSecond().next=NULL;
            }
        }
        throw;
    }
    catch(...)
    {
        cout<<"got it in ~Snake()";
    }

}

int Snake::justMove()
{
    int overWallFlagOrCrackBody=0;
    int tempHeadX=head.headX,tempHeadY=head.headY;
    Body& tempTailBody=getTail();
  //  head.headShape='>';//测试用代码，用完需注释
  //  tempTailBody.bodyShape='-';//测试专用用代码
    switch(head.headShape)
    {
    case '^':
        cursor(head.headX,head.headY);
        head.headY--;
        if(overWall()||crackCheck())
        {
            overWallFlagOrCrackBody=1;
            break;
        }
        else
        {
            clearHead();
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next)
            {
                getLastSecond().next=NULL;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.bodyShape='I';
                tempTailBody.next=head.bodyHead;
                head.bodyHead=&tempTailBody;//将尾巴坐标改为头部坐标后，重新定义现在的尾巴
                drawBody();
                break;
            }
            else
            {
                head.bodyHead=&tempTailBody;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.bodyShape='I';
                drawBody();
                break;
            }
        }
    case 'V':
        cursor(head.headX,head.headY);
        head.headY++;
        if(overWall()||crackCheck())
        {
            overWallFlagOrCrackBody=1;
            break;
        }
        else
        {
            clearHead();
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next)
            {
                getLastSecond().next=NULL;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.next=head.bodyHead;
                head.bodyHead=&tempTailBody;
                //将尾巴坐标改为头部坐标后，重新定义现在的尾巴
                tempTailBody.bodyShape='I';
                drawBody();
                break;
            }
            else
            {
                head.bodyHead=&tempTailBody;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.bodyShape='I';
                drawBody();
                break;
            }
        }
    case '<':
        cursor(head.headX,head.headY);
        head.headX--;
        if(overWall()||crackCheck())
        {
            overWallFlagOrCrackBody=1;
            break;
        }
        else
        {
            clearHead();
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next)
            {
                getLastSecond().next=NULL;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.next=head.bodyHead;
                head.bodyHead=&tempTailBody;
                //将尾巴坐标改为头部坐标后，重新定义现在的尾巴
                tempTailBody.bodyShape='-';
                drawBody();
                break;
            }
            else
            {
                head.bodyHead=&tempTailBody;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.bodyShape='-';
                drawBody();
                break;
            }
        }
    case '>':
         cursor(head.headX,head.headY);
        head.headX++;
        if(overWall()||crackCheck())
        {
            overWallFlagOrCrackBody=1;
            break;
        }
        else
        {
            clearHead();
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next)
            {
                getLastSecond().next=NULL;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.next=head.bodyHead;
                head.bodyHead=&tempTailBody;
                //将尾巴坐标改为头部坐标后，重新定义现在的尾巴
                tempTailBody.bodyShape='-';
                drawBody();
                break;
            }
            else
            {
                head.bodyHead=&tempTailBody;
                tempTailBody.bodyX=tempHeadX;
                tempTailBody.bodyY=tempHeadY;
                tempTailBody.bodyShape='-';
                drawBody();
                break;
            }
        }
    }
    Sleep(200);
    return overWallFlagOrCrackBody;
}

void Snake::controlSnake()
{
    Head tempHead=head;
    Body& tempTailBody=getTail();

    static char controlDirect;
    controlDirect=getch();
//    fflush(stdin);

    switch(controlDirect)
    {
    case 'W':
    case 'w':
        switch(head.headShape)
        {
        case '>':
        case '<':
            head.headShape='^'; /**< Here */
            tempTailBody.bodyShape='I'; /**< here */

            cursor(head.headX,head.headY);
            clearHead();

            head.headY--;       /**< and here */
            cursor(head.headX,head.headY);
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next!=NULL)
            {
                getLastSecond().next=NULL;
                tempTailBody.next=head.bodyHead;/**< 此处的BUG */
                head.bodyHead=&tempTailBody;
            }

            tempTailBody.bodyX=tempHead.headX;
            tempTailBody.bodyY=tempHead.headY;
            drawBody();
            break;
        case '^':
        case 'V':
            break;
        }
        break;
    case 'S':
    case 's':
        switch(head.headShape)
        {
        case '>':
        case '<':
            head.headShape='V'; /**< Here */
            tempTailBody.bodyShape='I'; /**< here */

            cursor(head.headX,head.headY);
            clearHead();

            head.headY++;       /**< and here */
            cursor(head.headX,head.headY);
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next!=NULL)
            {
                getLastSecond().next=NULL;
                tempTailBody.next=head.bodyHead;/**< 此处的BUG */
                head.bodyHead=&tempTailBody;
            }

            tempTailBody.bodyX=tempHead.headX;
            tempTailBody.bodyY=tempHead.headY;
            drawBody();
            break;
        case 'V':
        case '^':
            break;
        }
        break;
    case 'A':
    case 'a':
        switch(head.headShape)
        {
        case '<':
        case '>':
            break;
        case '^':
        case 'V':
            head.headShape='<'; /**< Here */
            tempTailBody.bodyShape='-'; /**< here */

            cursor(head.headX,head.headY);
            clearHead();

            head.headX--;       /**< and here */
            cursor(head.headX,head.headY);
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next!=NULL)
            {
                getLastSecond().next=NULL;
                tempTailBody.next=head.bodyHead;/**< 此处的BUG */
                head.bodyHead=&tempTailBody;
            }

            tempTailBody.bodyX=tempHead.headX;
            tempTailBody.bodyY=tempHead.headY;
            drawBody();
            break;
        }
        break;
    case 'D':
    case 'd':
        switch(head.headShape)
        {
        case '>':
        case '<':
            break;
        case '^':
        case 'V':
            head.headShape='>'; /**< Here */
            tempTailBody.bodyShape='-'; /**< here */

            cursor(head.headX,head.headY);
            clearHead();

            head.headX++;       /**< and here */
            cursor(head.headX,head.headY);
            drawHead();

            cursor(tempTailBody.bodyX,tempTailBody.bodyY);
            clearBody();

            if(head.bodyHead->next!=NULL)
            {
                getLastSecond().next=NULL;
                tempTailBody.next=head.bodyHead;/**< 此处的BUG */
                head.bodyHead=&tempTailBody;
            }

            tempTailBody.bodyX=tempHead.headX;
            tempTailBody.bodyY=tempHead.headY;
            drawBody();
            break;
        }
        break;
    default:
        break;
    }
    Sleep(200);
}

char Snake::getHeadshape()
{
    return head.headShape;
}

Snake::Head& Snake::getHead()
{
    return head;
}

Snake::Body& Snake::getBody()
{
    return body;
}

int Snake::getLength()
{
    return length;
}

void Snake::drawHead()
{
    cursor(head.headX,head.headY);
    switch(head.headShape)
    {
    case '^':
        cout<<'^';
        break;
    case 'V':
        cout<<'V';
        break;
    case '<':
        cout<<'<';
        break;
    case '>':
        cout<<'>';
        break;
    }
}

void Snake::drawBody()
{
    cursor(head.bodyHead->bodyX,head.bodyHead->bodyY);
    switch(head.bodyHead->bodyShape)
    {
    case 'I':
      //  cursor(head.headX,head.headY+1);
        cout<<'I';
        break;
    case '-':
      //  cursor(head.headX,head.headY-1);
        cout<<'-';
        break;
    }
}

void Snake::clearHead()
{
  //  cursor(head.headX,head.headY);
    cout<<' ';
}

void Snake::clearBody()
{
   // cursor(head.headX,head.headY);
    cout<<' ';
}

int Snake::getHeadPosX()
{
    return head.headX;
}

int Snake::getHeadPosY()
{
    return head.headY;
}

void Snake::setHeadPosXY(int a,int b)
{
    head.headX=a;
    head.headY=b;
}

void Snake::setHeadAndBodyShape(char HeadShape,char BodyShape)
{
    head.headShape=HeadShape;
    body.bodyShape=BodyShape;
}

Snake::Body& Snake::getTail()
{
    Body temp;
    static Body *tempTailBody;

    temp=*head.bodyHead;
    tempTailBody=head.bodyHead;

    while(temp.next!=NULL)
    {
        tempTailBody=temp.next;
        temp=*temp.next;
    }
    return *tempTailBody;
}

bool Snake::eatingCheck(Fruit&fruit)
{
    if(head.headX==fruit.getFruitX()&&head.headY==fruit.getFruitY())
    {
        length++;
        Body& tempBody=getTail();

        if(head.bodyHead->next==NULL)
        {
            tempBody.next=new struct Body;
            switch(tempBody.next->bodyShape=tempBody.bodyShape)
            {
            case 'I':
                switch(head.headShape)
                {
                case '^':
                    tempBody.next->bodyY=tempBody.bodyY+1;
                case 'V':
                    tempBody.next->bodyY=tempBody.bodyY-1;
                    tempBody.next->bodyX=tempBody.bodyX;
                    cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                    cout<<tempBody.next->bodyShape;
                    break;
                }
                break;
            case '-':
                switch(head.headShape)
                {
                case '<':
                    tempBody.next->bodyX=tempBody.bodyX+1;
                case '>':
                    tempBody.next->bodyX=tempBody.bodyX-1;
                    tempBody.next->bodyY=tempBody.bodyY;
                    cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                    cout<<tempBody.next->bodyShape;
                    break;
                }
                break;
            }

       //     tempBody.next->iAmBodyHead='N';
       //     tempBody.next->next=head.bodyHead;
       //     head.bodyHead=tempBody.next;
       //     tempBody.next=NULL;

         //   head.bodyHead=tempBody.next;
            tempBody.next->iAmBodyHead='N';
            tempBody.next->next=NULL;
            return true;
        }
        Body& tempLSBody=getLastSecond();
        tempBody.next=new struct Body;

        switch(tempBody.next->bodyShape=tempBody.bodyShape)
        {
        case 'I':
            if(tempLSBody.bodyY<tempBody.bodyY)
            {
                tempBody.next->bodyX=tempBody.bodyX;
                tempBody.next->bodyY=tempBody.bodyY+1;

                cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                cout<<tempBody.next->bodyShape;
            }
            else
            {
                tempBody.next->bodyX=tempBody.bodyX;
                tempBody.next->bodyY=tempBody.bodyY-1;

                cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                cout<<tempBody.next->bodyShape;
            }
            break;
        case '-':
            if(tempLSBody.bodyX<tempBody.bodyX)
            {
                tempBody.next->bodyX=tempBody.bodyX+1;
                tempBody.next->bodyY=tempBody.bodyY;

                cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                cout<<tempBody.next->bodyShape;
            }
            else
            {
                tempBody.next->bodyX=tempBody.bodyX-1;
                tempBody.next->bodyY=tempBody.bodyY;

                cursor(tempBody.next->bodyX,tempBody.next->bodyY);
                cout<<tempBody.next->bodyShape;
            }
            break;
        }
        tempBody.next->iAmBodyHead='N';
        tempBody.next->next=NULL;
        return true;
    }
    else
        return false;
}

Snake::Body&  Snake::getLastSecond()
{
    Body tempBody;
    static Body *tempLSBody;

    tempBody=*head.bodyHead;
    tempLSBody=head.bodyHead;

    if(tempBody.next)
    {
        while(tempBody.next->next)
        {
            tempLSBody=tempBody.next;
            tempBody=*tempBody.next;
        }
    }
    return *tempLSBody;
}

bool Snake::crackCheck()
{
    try
    {
        static Body tempBody;
        tempBody=*head.bodyHead;
        if(tempBody.next==NULL)
            return false;
        while(tempBody.next!=NULL)
        {
            if(  (head.headX==tempBody.bodyX)  &&  (head.headY==tempBody.bodyY)  )
                return true;
            else
                tempBody=*tempBody.next;
        }
        if(  (head.headX==tempBody.bodyX)  &&  (head.headY==tempBody.bodyY)  )
            return true;
        else
            return false;
        throw;
    }
    catch(...)
    {
        cout<<"Got it in crackCheck()";
    }
}

bool Snake::overWall()
{
    try{
        if(  (0<=head.headX&&head.headX<MAX_X)  &&  (0<=head.headY&&head.headY<MAX_Y)  )
            return false;
        else
            return true;
        throw;
    }
    catch(...)
    {
        cout<<"Got it in overWall()";
    }
}

class Menue
{
public:
    Menue(Snake&snake,Fruit&fruit);
    void setScore(Snake&,Fruit&);
    int  getScore(Snake&);
    bool fruitCoverCheck(Snake&snake,Fruit&fruit);
private:
    const char WALL_X;
    const char WALL_Y;
 //   int score;
};

Menue::Menue(Snake&snake,Fruit&fruit):WALL_X('-'),WALL_Y('I')
{
    int i;
    cursor(0,MAX_Y);
    for(i=0;i<MAX_X;i++)
        cout<<WALL_X;

    for(i=0;i<=MAX_Y;i++)
    {
        cursor(MAX_X,i);
        cout<<WALL_Y<<endl;
    }

    cursor(MAX_X+3, 5);
    cout<<"操作：";
    cout<<"w,a,s,d";
    cursor(MAX_X+3,10);
    cout<<"得分："<<getScore(snake);
    fruit.drawFruit();

    if(snake.eatingCheck(fruit))
    {
        Menue::setScore(snake,fruit);
    }
}

void Menue::setScore(Snake&snake,Fruit&fruit)
{
 //   score++;
    cursor(70,10);
    cout<<getScore(snake);
}

int Menue::getScore(Snake&snake)
{
    return 10*(snake.getLength()-2);
}

bool Menue::fruitCoverCheck(Snake&snake,Fruit&fruit)
{
    Snake::Head testHead=snake.getHead();
    Snake::Body testBody=snake.getBody();

    if(testHead.headX==fruit.getFruitX()&&testHead.headY==fruit.getFruitY())
        return true;
    else
    {
        while(testBody.next!=NULL)
        {
            if(testBody.bodyX==fruit.getFruitX()&&testBody.bodyY==fruit.getFruitY())
                return true;
            else
                testBody=*testBody.next;
        }
        if(testBody.bodyX==fruit.getFruitX()&&testBody.bodyY==fruit.getFruitY())
            return true;
        else
            return false;
    }
}

void StartIt()
{
    Snake snake;
    Fruit fruit;
    fruit.setFruitXY();
    Menue menue(snake,fruit);


    while(1)
    {
        if(snake.justMove())
            break;
        if(snake.eatingCheck(fruit))
        {
            menue.setScore(snake,fruit);

            while(menue.fruitCoverCheck(snake,fruit))
                fruit.setFruitXY();

            fruit.drawFruit();
        }
        fflush(stdin);
        if(kbhit())
        {
            snake.controlSnake();
            if(snake.overWall()||snake.crackCheck())
                break;
        }
    }
}

int main(int agrs,char** argv)
{
    StartIt();
    return 0;
}
