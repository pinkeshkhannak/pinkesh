import java.util.*;
public class CricketDash {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the score");
		int[] batsman = {0,0,0,0,0,0,0,0,0,0,0};
		int[] crease= {1,2};
		String players[]=new String[7];
		players[0]="panzer"; 
		players[1]="pink";
		players[2]="boja";
		players[3]="rules";
		players[4]="diva";
		players[5]="srinath";
		players[6]="mani the don";
		int over=0,total=0,overcomp=0,extras=0,now=0,current=1,out=0,count=2,temp=0,w=11;
		String score = sc.nextLine();
		char a[]=score.toCharArray();
		HashMap<String,Integer> hm=new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(a[i]=='.') {
				total=total+0;
			}
			if(a[i]=='o') {
				over++;
				out++;
				count++;
				current=count;
				crease[0] = count;
			}
		    if(a[i]=='1'||a[i]=='3') {
				total+=Integer.parseInt(""+a[i]);
				now+=Integer.parseInt(""+a[i]);
				batsman[current-1]+=now;
				temp=crease[1];
	              crease[1] = current;
	              crease[0] = temp;
	              current = crease[0];
	              now = 0; 
				over++;
				now=0;
			}
			if(a[i]=='2'||a[i]=='4'||a[i]=='6') {
				total+=Integer.parseInt(""+a[i]);
				now+=Integer.parseInt(""+a[i]);
				over++;
				batsman[current-1]+=now;
				now=0;
				
			}
			if(a[i]=='w') {
				extras=extras+1;
			}
			
		 if(over!=0 && over%6==0) {
				overcomp=overcomp+1;
				temp=crease[1];
	              crease[1] = current;
	              crease[0] = temp;
	              current = crease[0];
					}
			
		}
		total=total+extras;
		System.out.println("total"+" "+total);
		System.out.println("overcomplete"+" "+overcomp);
		for(int i=0;i<out+2;i++){
	           System.out.print(players[i]+" ");
	           System.out.println(batsman[i]+" ");
	        }
		System.out.println("extras"+" "+extras);
		System.out.println("wicket"+" "+out);
		int rem = w-out;
		System.out.println("remaining wicket"+" "+rem);
		
		
		

	}

}
