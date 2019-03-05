#include <stdio.h>
#include <iostream>
#include <windows.h>
#include <stdlib.h>
#include <winuser.h>

using namespace std;
const int size=13,gameSpeed=500;

class node
{
private:
    int x;
    int y;
    node *next;
public:
    node();
    void changeX(int X);
    void changeY(int Y);
    void changeNext(node *N);
    int getX();
    int getY();
    node *getNext();
};
node::node()
{
    x=0;
    y=0;
    next=NULL;
}
int node::getX()
{
    return x;
}
int node::getY()
{
    return y;
}
void node::changeX(int X)
{
    x=X;
}
void node::changeY(int Y)
{
    y=Y;
}
void node::changeNext(node *N)
{
    next=N;
}
node *node::getNext()
{
    return next;
}

class linkList
{
protected:
    node *head;
public:
    linkList();//制造一个有头结点的线性表
    int getLength();
    node *getNode(int i);//i:0-n
    int getIndex(node *e);//i:1-n,没有返回0
    node *getPriorNode(node *e);
    node *getNextNode(node *e);
    void insert(int i,node *e);//i:1-(n+1)
    void Delete(int i);
};
linkList::linkList()
{
    head=new node;
    head->changeNext(NULL);
}
int linkList::getLength()
{
    node *p=head->getNext();
    int i=0;
    while(p)
    {
        i++;
        p=p->getNext();
    }
    return i;
}
node *linkList::getNode(int i)
{
    node *p=head;
    int j=0;
    while(p&&j<i)//!记住这句
    {
        p=p->getNext();
        j++;
    }
    return p;
}
int linkList::getIndex(node *e)
{
    node *p=head->getNext();
    int i=1;
    while(p)
    {
        if(p->getX()==e->getX()&&p->getY()==e->getY())
        {
            return i;
        }
        i++;
        p=p->getNext();
    }
    return 0;
}
node *linkList::getPriorNode(node *e)
{
    node *p=NULL;
    int i=getIndex(e);
    if(i!=0)
    {
        p=getNode(i-1);
    }
    return p;
}
node *linkList::getNextNode(node *e)
{
    node *p=NULL;
    int i=getIndex(e);
    if(i!=0)
    {
        p=getNode(i+1);
    }
    return p;
}
void linkList::insert(int i,node *e)
{
    node *p=getNode(i-1);
    e->changeNext(p->getNext());
    p->changeNext(e);
}
void linkList::Delete(int i)
{
    node *p=getNode(i-1),*q=p->getNext();
    p->changeNext(p->getNext()->getNext());
    delete q;
}

class snake:public linkList
{
private:
    char direction;
    node *lastTail;
public:
    snake();
    char getDirection();
    void go();
    void changeDirection(char D);
    node *getLastTail();
};
node *snake::getLastTail()
{
    return lastTail;
}
void snake::changeDirection(char D)
{
    direction=D;
}
void snake::go()
{
    node *e=new node;
    e->changeNext(NULL);
    switch(direction)
    {
    case 'w':
        e->changeX(head->getNext()->getX()-1);
        e->changeY(head->getNext()->getY());
        insert(1,e);
        break;
    case 's':
        e->changeX(head->getNext()->getX()+1);
        e->changeY(head->getNext()->getY());
        insert(1,e);
        break;
    case 'a':
        e->changeX(head->getNext()->getX());
        e->changeY(head->getNext()->getY()-1);
        insert(1,e);
        break;
    case 'd':
        e->changeX(head->getNext()->getX());
        e->changeY(head->getNext()->getY()+1);
        insert(1,e);
        break;
    }
    lastTail=new node;
    lastTail->changeX(getNode(getLength())->getX());
    lastTail->changeY(getNode(getLength())->getY());
    lastTail->changeNext(NULL);
    Delete(getLength());
}
char snake::getDirection()
{
    return direction;
}
snake::snake():linkList()
{
    direction='d';
    head=new node;
    head->changeNext(new node);
    head->getNext()->changeNext(new node);
    head->getNext()->getNext()->changeNext(new node);
    head->getNext()->getNext()->getNext()->changeNext(NULL);
    head->changeX(0);
    head->changeY(0);
    head->getNext()->changeX(size/2);
    head->getNext()->changeY(size/2);
    head->getNext()->getNext()->changeX(size/2);
    head->getNext()->getNext()->changeY(size/2-1);
    head->getNext()->getNext()->getNext()->changeX(size/2);
    head->getNext()->getNext()->getNext()->changeY(size/2-2);
    lastTail=NULL;
}
class food:public linkList
{
public:
    food();
};
food::food():linkList()
{
    head=new node;
    head->changeNext(new node);
    head->getNext()->changeNext(new node);
    head->getNext()->getNext()->changeNext(NULL);
    head->changeX(0);
    head->changeY(0);
    do
    {
        head->getNext()->changeX(rand()%(size-1)+1);
        head->getNext()->changeY(rand()%(size-1)+1);
    }
    while(0); //***
    do
    {
        head->getNext()->getNext()->changeX(rand()%(size-1)+1);
        head->getNext()->getNext()->changeY(rand()%(size-1)+1);
    }
    while(0);
}
class border:public linkList
{
public:
    border();
};
border::border():linkList()
{
    head=new node;
    head->changeX(0);
    head->changeY(0);
    node *p=head;
    int i;
    for(i=0; i<size+2; i++)
    {
        p->changeNext(new node);
        p=p->getNext();
        p->changeX(0);
        p->changeY(i);
    }
    for(i=1; i<size+2; i++)
    {
        p->changeNext(new node);
        p=p->getNext();
        p->changeX(i);
        p->changeY(size+1);
    }
    for(i=size; i>=0; i--)
    {
        p->changeNext(new node);
        p=p->getNext();
        p->changeX(size+1);
        p->changeY(i);
    }
    for(i=size; i>0; i--)
    {
        p->changeNext(new node);
        p=p->getNext();
        p->changeX(i);
        p->changeY(0);
    }
    p->changeNext(NULL);
}
class map
{
private:
    int m[size+2][size+2];
public:
    map();
    void refresh();
    void display(snake *S,food *F,border *B,float score);
    bool detectCollision(linkList *S,linkList *O);
};
void map::refresh()
{
    for(int i=0; i<size+2; i++)
    {
        for(int j=0; j<size+2; j++)
        {
            m[i][j]=0;
        }
    }
}
map::map()
{
    for(int i=0; i<size+2; i++)
    {
        for(int j=0; j<size+2; j++)
        {
            m[i][j]=0;
        }
    }
}
bool map::detectCollision(linkList *S,linkList *O)
{
    node *p=S->getNode(1);
    if(O->getIndex(p)!=0)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}
void map::display(snake *S,food *F,border *B,float score)
{
    system("cls");
    int i;
    for( i=1; i<=S->getLength(); i++)
    {
        m[S->getNode(i)->getX()][S->getNode(i)->getY()]=1;
    }
    for(i=1; i<=F->getLength(); i++)
    {
        m[F->getNode(i)->getX()][F->getNode(i)->getY()]=2;
    }
    for(i=1; i<=B->getLength(); i++)
    {
        m[B->getNode(i)->getX()][B->getNode(i)->getY()]=4;
    }
    cout<<"score="<<score*10<<endl;
    for(i=0; i<size+2; i++)
    {
        for(int j=0; j<size+2; j++)
        {

            if(m[i][j]==0)
            {
                cout<<" ";
            }
            else if(m[i][j]==1)
            {
                cout<<"* ";
            }
            else if(m[i][j]==2)
            {
                cout<<"o ";
            }
            else if(m[i][j]==4)
            {
                cout<<"+ ";
            }
        }
        cout<<endl;
    }
}
int main()
{
    snake *S=new snake;
    snake *S2=new snake;
    food *F=new food;
    border *B=new border;
    map *M=new map;
    int j=0;
    float score=0;
    node *q=NULL;
    while(1)
    {
        M->display(S,F,B,score);
        Sleep(gameSpeed/(score+1));
        if(::GetAsyncKeyState(int('W'))&&(S->getDirection()=='a'||S->getDirection()=='d'))
        {
            S->changeDirection('w');
        }
        else if(::GetAsyncKeyState(int('S'))&&(S->getDirection()=='a'||S->getDirection()=='d'))
        {
            S->changeDirection('s');
        }
        else if(::GetAsyncKeyState(int('A'))&&(S->getDirection()=='w'||S->getDirection()=='s'))
        {
            S->changeDirection('a');
        }
        else if(::GetAsyncKeyState(int('D'))&&(S->getDirection()=='w'||S->getDirection()=='s'))
        {
            S->changeDirection('d');
        }
        S->go();
        S2->getNode(0)->changeNext(S->getNode(2));
        if(M->detectCollision(S,F))
        {
            score+=1;
            S->insert(S->getLength()+1,S->getLastTail());
            j=F->getIndex(S->getNode(1));
            q=F->getNode(j);
            q->changeX(rand()%(size-1)+1);
            q->changeY(rand()%(size-1)+1);
        }
        else if(M->detectCollision(S,B)||M->detectCollision(S,S2))
        {
            system("cls");
            cout<<"score="<<score*10<<endl<<"Game over!"<<endl;
            Sleep(2000);
            break;
        }
        M->refresh();
        M->display(S,F,B,score);
    }
    return 0;
}
