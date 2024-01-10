import java.util.*;/** 2,3,3,4,4*/
public class Battleship
{
static Ship locs[]=new Ship[5];
    public void play()
{Scanner sc=new Scanner(System.in);for(int i=0;i<99;i++){System.out.println();}
System.out.println("welcome to battleship! \n you\'re in charge of setting the fleet \n there are five ships: 2,3,3,4 and 5 units in length \n you have to arrange these ships in the fleet from A0 to J9... \n are you ready ? Say Ay Ay Captain if so ");
String a=sc.nextLine();a=a.toLowerCase();
while(a.indexOf("ay ay captain")==-1){System.out.println("Looks like you take time to follow instructions ... try again , say- Ay Ay Captain");a=sc.nextLine();}

System.out.println("Great! lets begin");System.out.print("  ");
boolean cowpox=true;
for(int i=65;i<=74;i++)
{System.out.print((char)(i)+" ");}
System.out.println();
for(int i=0;i<=9;i++)
{
System.out.print(i+" ");
for(int j=0;j<=9;j++)
{
System.out.print("o ");
}
System.out.println();
}
System.out.println("\n this is your grid ");

System.out.println("enter the start co-ords of panther(2)");
Ship ob2=new Ship();ob2.len=2;
ob2.start=sc.next();
System.out.println("enter end coords of panther(2)");
ob2.end=sc.next();
while(ob2.checkvalid()==false)
{
System.out.println("invalid");
System.out.println("enter the start co-ords of panther(2)");
ob2.start=sc.next();
System.out.println("enter end coords of panther(2)");
ob2.end=sc.next();
}
locs[0]=ob2;
System.out.println(ob2.start);System.out.println(ob2.end);

System.out.println("enter the start co-ords of submarine(3)");
Ship ob3=new Ship();ob3.len=3;
ob3.start=sc.next();
System.out.println("enter end coords of submarine(3)");
ob3.end=sc.next();
while(ob3.checkvalid()!=true  )
{
System.out.println("invalid");
System.out.println("enter the start co-ords of submarine(3)");
ob3.start=sc.next();
System.out.println("enter end coords of submarine(3)");
ob3.end=sc.next();
}locs[1]=ob3;
while(chk(locs,1)!=true )
{
System.out.println("invalid");
System.out.println("enter the start co-ords of submarine(3)");
ob3.start=sc.next();
System.out.println("enter end coords of submarine(3)");
ob3.end=sc.next();
}
locs[1]=ob3;
System.out.println(ob3.start);System.out.println(ob3.end);

System.out.println("enter the start co-ords of destroyer(3)");
Ship ob23=new Ship();ob23.len=3;
ob23.start=sc.next();
System.out.println("enter end coords of destroyer(3)");
ob23.end=sc.next();
while(ob23.checkvalid()!=true )
{
System.out.println("invalid");
System.out.println("enter the start co-ords of destroyer(3)");
ob23.start=sc.next();
System.out.println("enter end coords of destroyer(3)");
ob23.end=sc.next();
}
locs[2]=ob23;
while( chk(locs,2)!=true)
{
System.out.println("invalid");
System.out.println("enter the start co-ords of destroyer(3)");
ob23.start=sc.next();
System.out.println("enter end coords of destroyer(3)");
ob23.end=sc.next();
}
locs[2]=ob23;
System.out.println(ob23.start);System.out.println(ob23.end);

System.out.println("enter the start co-ords of greyhound(4)");
Ship ob4=new Ship();ob4.len=4;
ob4.start=sc.next();
System.out.println("enter end coords of greyhound(4)");
ob4.end=sc.next();
while(ob4.checkvalid()!=true )
{
System.out.println("invalid");
System.out.println("enter the start co-ords of greyhound(4)");
ob4.start=sc.next();
System.out.println("enter end coords of greyhound(4)");
ob4.end=sc.next();
}locs[3]=ob4;
while( chk(locs,3)!=true)
{
System.out.println("invalid");
System.out.println("enter the start co-ords of greyhound(4)");
ob4.start=sc.next();
System.out.println("enter end coords of greyhound(4)");
ob4.end=sc.next();
}
locs[3]=ob4;
System.out.println(ob4.start);System.out.println(ob4.end);

System.out.println("enter the start co-ords of carrier(5)");
Ship ob5=new Ship();ob5.len=5;
ob5.start=sc.next();
System.out.println("enter end coords of carrier(5)");
ob5.end=sc.next();
while(ob5.checkvalid()!=true )
{
System.out.println("invalid");
System.out.println("enter the start co-ords of carrier(5)");
ob5.start=sc.next();
System.out.println("enter end coords of carrier(5)");
ob5.end=sc.next();
}
locs[4]=ob5;
while( chk(locs,4)!=true)
{
System.out.println("invalid");
System.out.println("enter the start co-ords of carrier(5)");
ob5.start=sc.next();
System.out.println("enter end coords of carrier(5)");
ob5.end=sc.next();
}
locs[4]=ob5;
System.out.println(ob5.start);System.out.println(ob5.end);

System.out.println("all valid , generating grid in a moment");
System.out.println("YOUR GRID");
System.out.print(" ");
ArrayList<String> arr=new ArrayList<String>(){{}};
for(int i=0;i<5;i++){
String j1=locs[i].start;
String j2=locs[i].end;
if(j1.charAt(0)==j2.charAt(0)){

for(int u=j1.charAt(1);u<=j2.charAt(1);u++)
{
arr.add(""+j1.charAt(0)+(char)(u));
}
}
else
{
for(char u=j1.charAt(0);u<=j2.charAt(0);u++)
{
arr.add(""+(char)(u)+j1.charAt(1));
}
}
}System.out.print(" ");
for(int i=0;i<10;i++){System.out.print((char)(65+i)+" ");}
System.out.println();
for(int j=0;j<10;j++)
{
System.out.print(j+" ");
for(int k=0;k<10;k++)
{int ghu=0;
for(int m=0, n=1;n<arr.size();m+=2,n+=2)
{String h=arr.get(m);String g=arr.get(n); String b=""+(char)(65+k)+j;
if(arr.get(m).equals(""+(char)(65+k)+j))
{System.out.print("O ");ghu=1;break;}
else if(arr.get(n).equals(""+(char)(65+k)+j))
{System.out.print("O ");ghu=1;break;}
else if(arr.get(arr.size()-1).equals(""+(char)(65+k)+j)){System.out.print("O ");ghu=1;break;}
}
if(ghu==0){System.out.print(". ");}
}System.out.println();
}
System.out.println("positions:");
for(int i=0;i<locs.length;i++){System.out.println(locs[i].start+"-"+locs[i].end);}
ArrayList<String> emeni=new ArrayList<String>(){{}};
Ship emenio[]=new Ship[5];System.out.println("generating enemy fleet... pease wait");
int temp=(int)(Math.random()*9);
char temp2=(char)(65+(int)(Math.random()*9));Ship obtest=new Ship();emenio[0]=obtest;Ship obtest2=new Ship();emenio[1]=obtest2;Ship obtest3=new Ship();obtest3.len=3;emenio[2]=obtest3;Ship obtest4=new Ship();obtest4.len=4;emenio[3]=obtest4;Ship obtest5=new Ship();obtest5.len=5;emenio[4]=obtest5;
emeni.add(""+temp2+temp);emenio[0].start=""+temp2+temp;
if(Math.random()>=0.3){
temp2=(char)(temp2+1);
}
else{temp+=1;}
emeni.add(""+temp2+temp);emenio[0].end=""+temp2+temp;emenio[0].len=2;

System.out.println(emeni.get(0)+"    "+emeni.get(1));//SOMETHING'S GOING WRONG IN INITIALISING J2
emenio[1].start=""+(char)(65+(int)(Math.random()*8))+(int)(Math.random()*8);
if(Math.random()>0.3){emenio[1].end=""+(emenio[1].start.charAt(0))+((char)(emenio[1].start.charAt(1)+2));}else{emenio[1].end=""+(char)(emenio[1].start.charAt(0)+2)+((int)(emenio[1].start.charAt(1)));}
while(chk(emenio,1)!=true || emenio[1].checkvalid()!=true){
    if(emenio[1].start.charAt(0)<='J' && emenio[1].start.charAt(1)<='9' && emenio[1].end.charAt(0)<='J' && emenio[1].start.charAt(1)<='9' ){
    emenio[1].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[1].end=""+(emenio[1].start.charAt(0))+((char)(emenio[1].start.charAt(1)+2));}else{emenio[1].end=""+(char)(emenio[1].start.charAt(0)+2)+((int)(emenio[1].start.charAt(1)));}
}
if(emenio[1].end.charAt(0)>'J' || emenio[1].end.charAt(1)>'9'){cowpox=false;}

}
String j1=emenio[1].start;
String j2=emenio[1].end;
if(j1.charAt(0)==j2.charAt(0)){

for(int u=j1.charAt(1);u<=j2.charAt(1);u+=1)
{emeni.add(""+j1.charAt(0)+(char)(u));
}
}
else
{
for(char u=j1.charAt(0);u<=j2.charAt(0);u+=1)
{
    emeni.add(""+(char)(u)+j1.charAt(1));
}
}

emenio[2].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[2].end=""+(emenio[2].start.charAt(0))+((char)(emenio[2].start.charAt(1)+2));}else{emenio[2].end=""+(char)(emenio[2].start.charAt(0)+2)+((int)(emenio[2].start.charAt(1)));}
while(chk(emenio,2)!=true || emenio[2].checkvalid()!=true){
     if(emenio[2].start.charAt(0)<='J' && emenio[2].start.charAt(1)<='9' && emenio[2].end.charAt(0)<='J' && emenio[2].start.charAt(1)<='9' ){

    emenio[2].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[2].end=""+(emenio[2].start.charAt(0))+((char)(emenio[2].start.charAt(1)+2));}else{emenio[2].end=""+(char)(emenio[2].start.charAt(0)+2)+((int)(emenio[2].start.charAt(1)));}
}
if(emenio[2].end.charAt(0)>'J' || emenio[2].end.charAt(1)>'9'){cowpox=false;}

}
 j1=emenio[2].start;
 j2=emenio[2].end;
if(j1.charAt(0)==j2.charAt(0)){

for(int u=j1.charAt(1);u<=j2.charAt(1);u+=1)
{emeni.add(""+j1.charAt(0)+(char)(u));
}
}
else
{
for(char u=j1.charAt(0);u<=j2.charAt(0);u+=1)
{
    emeni.add(""+(char)(u)+j1.charAt(1));
}
}

emenio[3].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[3].end=""+(emenio[3].start.charAt(0))+((char)(emenio[3].start.charAt(1)+3));}else{emenio[3].end=""+(char)(emenio[3].start.charAt(0)+3)+((int)(emenio[3].start.charAt(1)));}
while(chk(emenio,3)!=true || emenio[3].checkvalid()!=true || cowpox!=true){
     if(emenio[3].start.charAt(0)<='J' && emenio[3].start.charAt(1)<='9' && emenio[3].end.charAt(0)<='J' && emenio[3].start.charAt(1)<='9' ){

    emenio[3].start=""+(char)(65+(int)(Math.random()*8))+(int)(Math.random()*8);
if(Math.random()>0.3){emenio[3].end=""+(emenio[3].start.charAt(0))+((char)(emenio[3].start.charAt(1)+3));}else{emenio[3].end=""+(char)(emenio[3].start.charAt(0)+3)+((int)(emenio[3].start.charAt(1)));}
}
if(emenio[3].end.charAt(0)>'J' || emenio[3].end.charAt(1)>'9'){cowpox=false;}
}
 j1=emenio[3].start;
 j2=emenio[3].end;
if(j1.charAt(0)==j2.charAt(0)){

for(int u=j1.charAt(1);u<=j2.charAt(1);u+=1)
{emeni.add(""+j1.charAt(0)+(char)(u));
}
}
else
{
for(char u=j1.charAt(0);u<=j2.charAt(0);u+=1)
{
    emeni.add(""+(char)(u)+j1.charAt(1));
}
}

emenio[4].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[4].end=""+(emenio[4].start.charAt(0))+((char)(emenio[4].start.charAt(1)+4));}else{emenio[4].end=""+(char)(emenio[4].start.charAt(0)+4)+((int)(emenio[4].start.charAt(1)));}
while(chk(emenio,4)!=true || emenio[4].checkvalid()!=true){
     if(emenio[4].start.charAt(0)<='J' && emenio[4].start.charAt(1)<='9' && emenio[4].end.charAt(0)<='J' && emenio[4].start.charAt(1)<='9' ){

    emenio[4].start=""+(char)(65+(int)(Math.random()*10))+(int)(Math.random()*10);
if(Math.random()>0.3){emenio[4].end=""+(emenio[4].start.charAt(0))+((char)(emenio[4].start.charAt(1)+4));}else{emenio[4].end=""+(char)(emenio[4].start.charAt(0)+4)+((int)(emenio[4].start.charAt(1)));}
}if(emenio[4].end.charAt(0)>'J' || emenio[4].end.charAt(1)>'9'){cowpox=false;}

}
 j1=emenio[4].start;
 j2=emenio[4].end;
if(j1.charAt(0)==j2.charAt(0)){

for(int u=j1.charAt(1);u<=j2.charAt(1);u+=1)
{emeni.add(""+j1.charAt(0)+(char)(u));
}
}
else
{
for(char u=j1.charAt(0);u<=j2.charAt(0);u+=1)
{
    emeni.add(""+(char)(u)+j1.charAt(1));
}
}


int csgo=0;
System.out.println("enemy grid");System.out.print("  ");
for(int i=0;i<10;i++){System.out.print((char)(65+i)+" ");}
System.out.println();
for(int j=0;j<10;j++)
{
System.out.print(j+" ");
for(int k=0;k<10;k++)
{int ghu=0;
for(int m=0, n=1;n<emeni.size();m+=2,n+=2)
{String h=emeni.get(m);String g=emeni.get(n); String b=""+(char)(65+k)+j;
if(emeni.get(m).equals(""+(char)(65+k)+j))
{System.out.print("O ");csgo++;ghu=1;break;}
else if(emeni.get(n).equals(""+(char)(65+k)+j))
{System.out.print("O ");csgo++;ghu=1;break;}
else if(emeni.get(emeni.size()-1).equals(""+(char)(65+k)+j)){System.out.print("O ");csgo++;ghu=1;break;}
}
if(ghu==0){System.out.print(". ");}
}System.out.println();
}

System.out.println(csgo);
if(csgo!=17){System.out.println("invalid try again");System.exit(0);}



for(int o=0;o<emeni.size();o++){System.out.print(emeni.get(o)+" ");}

boolean cow=false;
ArrayList<String> a12=new ArrayList<String>(){{}};
a12=coordlist(emenio,4);
do{
System.out.println("test target");
String test=sc.next();
for(int uj=0;uj<a12.size();uj++)
{
if(test.equals(a12.get(uj))){cow=true;break;}
}
}while(cow!=true);
System.out.println("yayyyy");
}
//FOUND THE PROBLEM...CHK ONLY CHECKS FOR STARTING  AND ENDING , NOT MIDDLE VALUES
private static boolean chk(Ship a[],int i)
{ int h=0;
  /*  
 for(int j=0;j<i;j++)
 {
    if(a[i].start.equals(a[j].start) || a[i].start.equals(a[j].end) || a[i].end.equals(a[j].start) || a[i].end.equals(a[j].end) )
    {h=1;break;}
    }
    */
   ArrayList<String> arr=new ArrayList<String>(){{}};ArrayList<String> arr2=new ArrayList<String>(){{}};
   for(int i2=0;i2<i;i2++){
    if(a[i2].start.charAt(0)==a[i2].end.charAt(0) && a[i2].end.charAt(1)<='9' ){
    for(int j=0;j<a[i2].len;j++){arr.add(""+a[i2].start.charAt(0)+(char)((int)(a[i2].start.charAt(1)+j)));}
    }
    else if( a[i2].end.charAt(0)<='J')
    {
    for(int j=0;j<a[i2].len;j++){arr.add(""+(char)((a[i2].start.charAt(0)+j))+a[i2].start.charAt(1));}
    
    }
    
    }
    if(a[i].start.charAt(0)==a[i].end.charAt(0)){
    for(int j=0;j<a[i].len;j++){arr2.add(""+a[i].start.charAt(0)+(char)((int)(a[i].start.charAt(1)+j)));}
    }
    else 
    {
    for(int j=0;j<a[i].len;j++){arr2.add(""+(char)((a[i].start.charAt(0)+j))+a[i].start.charAt(1));}
    
    }
    for(int u=0;u<arr2.size();u++){
    String h2=arr2.get(u);
    if(arr.contains(h2)){h=1;break;}
    }
    return h==0;
}
private static ArrayList<String> coordlist(Ship a[],int i)
{

  /*  
 for(int j=0;j<i;j++)
 {
    if(a[i].start.equals(a[j].start) || a[i].start.equals(a[j].end) || a[i].end.equals(a[j].start) || a[i].end.equals(a[j].end) )
    {h=1;break;}
    }
    */
   ArrayList<String> arr=new ArrayList<String>(){{}};ArrayList<String> arr2=new ArrayList<String>(){{}};
   for(int i2=0;i2<i;i2++){
    if(a[i2].start.charAt(0)==a[i2].end.charAt(0)){
    for(int j=0;j<a[i2].len;j++){arr.add(""+a[i2].start.charAt(0)+(char)((int)(a[i2].start.charAt(1)+j)));}
    }
    else 
    {
    for(int j=0;j<a[i2].len;j++){arr.add(""+(char)((a[i2].start.charAt(0)+j))+a[i2].start.charAt(1));}
    
    }
    
    }
    if(a[i].start.charAt(0)==a[i].end.charAt(0)){
    for(int j=0;j<a[i].len;j++){arr.add(""+a[i].start.charAt(0)+(char)((int)(a[i].start.charAt(1)+j)));}
    }
    else 
    {
    for(int j=0;j<a[i].len;j++){arr.add(""+(char)((a[i].start.charAt(0)+j))+a[i].start.charAt(1));}
    
    }
    return arr;
}
private static void gridgen(ArrayList<String> emeni)
{
System.out.print("  ");int csgo=0;
for(int i=0;i<10;i++){System.out.print((char)(65+i)+" ");}
System.out.println();
for(int j=0;j<10;j++)
{
System.out.print(j+" ");
for(int k=0;k<10;k++)
{int ghu=0;
for(int m=0, n=1;n<emeni.size();m+=2,n+=2)
{String h=emeni.get(m);String g=emeni.get(n); String b=""+(char)(65+k)+j;
if(emeni.get(m).equals(""+(char)(65+k)+j))
{System.out.print("O ");csgo++;ghu=1;break;}
else if(emeni.get(n).equals(""+(char)(65+k)+j))
{System.out.print("O ");csgo++;ghu=1;break;}
else if(emeni.get(emeni.size()-1).equals(""+(char)(65+k)+j)){System.out.print("O ");csgo++;ghu=1;break;}
}
if(ghu==0){System.out.print(". ");}
}System.out.println();
}

}

}
