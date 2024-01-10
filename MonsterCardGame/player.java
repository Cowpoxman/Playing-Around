import java.util.*;
public class player
{
    int hth;
    ArrayList<Card> arr=new ArrayList<Card>(){{}};
public player(){for(int i=0;i<5;i++)
{
arr.add(Card.gen());
}
hth=10;}
    public void update(Monster a,char ch,int val,int choice)
    {
        if(ch=='d'){hth=hth+val>10?10:hth+val;if(hth>=10){hth=10;}}
        else{a.health-=val;
        }
        this.arr.remove(choice);
    }
}
