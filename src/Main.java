import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;
import java.util.Collections;

public class Main {	
	public static void main(String[] args) {
		try
		{	
			FileReader input;
			// Path is automaticly given by function
			input = new FileReader(new File("src/problem.txt").getAbsoluteFile());
			BufferedReader bufRead = new BufferedReader(input);
			int  counter = 0;
			// How money problem we Have?
		    counter = Integer.parseInt(bufRead.readLine());
		    for(int i=0; i<counter; i++)
		    {
		    	String[] n = bufRead.readLine().split(" ");
		    	node start = new node(n[0],n[1]);
		    	node end = new node(n[2],n[3]);
		    	bfs bfsSearch = new bfs(start, end);
		    	Vector<node> solution = new Vector<node>();
		    	solution = bfsSearch.search();
		    	String sPath="";
		    	if (solution!=null)
			    {
		    		for(node ss:solution)
			    	{
			    		sPath += ss.getNode(); 
			    	}
			    }
		    	else
		    		sPath="Sorry my friend, I could not find solution!";
		    	try(FileWriter fw = new FileWriter(new File("src/solution.txt").getAbsoluteFile(), true);
		    		    BufferedWriter bw = new BufferedWriter(fw);
		    		    PrintWriter out = new PrintWriter(bw))
		    		{
		    		    out.println("Start:"+start.getNode()+" End:"+end.getNode()+" Solution->"+sPath);
		    		} catch (IOException e) {
		    		
		    		}
		    }
		    bufRead.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

// This is a linked-list
class node{
	public int pRow; // Row Position
	public int pCol; // Colums Position
	public node path;// Path of  Node remembers Last node
	public node(int r, int c){pRow = r; pCol = c; path=null;}
	public node(String r, String c){pRow = Integer.parseInt(r); pCol = Integer.parseInt(c); path=null;}
	public String getNode(){return "("+String.valueOf(pRow)+","+String.valueOf(pCol)+")";}
}

class bfs{
	private Vector<node> travelled = new Vector<node>();
	private Queue<node> Q = new LinkedList<node>();
	private node start;
	private node end;
	//Loop Check
	public boolean LoopCheck(node temp)
	{
		for(node n1:travelled)
		{
			if(n1.pRow==temp.pRow && n1.pCol == temp.pCol)
				return false;
		}
		return true;
	}
	
	public bfs(node start, node end){
		this.start = start;
		this.end = end;
		Q.add(this.start);
	}
	
	public Vector<node> search()
	{
		while(true)
		{
			// Is Queque's First Element is Goal?
			node goalChecker = Q.element();
			if(goalChecker.pRow == end.pRow && goalChecker.pCol == end.pCol)
			{
				Vector<node> tempPath = new Vector<node>();
				//Reverse of path calculation
				while(true)
				{
					tempPath.add(goalChecker);
					goalChecker = goalChecker.path;
					if(goalChecker == null)
						break;
				}
				// reverse Path
				Collections.reverse(tempPath);
				return tempPath;
			}
			
			// first element of Q is not our goal we need to remove it. 
			node t = Q.remove();
			//Add It to Travelled for preventing infinete - loop
			travelled.add(t);
			// Find and Add Node child's to Queque
			// Find Chid 3,1
			if(t.pRow+3<10 && t.pCol+1<10)
			{
				node temp = new node(t.pRow+3,t.pCol+1);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid 3,-1
			if(t.pRow+3<10 && t.pCol-1>=0)
			{
				node temp = new node(t.pRow+3,t.pCol-1);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid -3,1
			if(t.pRow-3>=0 && t.pCol+1<10)
			{
				node temp = new node(t.pRow-3,t.pCol+1);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid -3,-1
			if(t.pRow-3>=0 && t.pCol-1>=0)
			{
				node temp = new node(t.pRow-3,t.pCol-1);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid 1,3
			if(t.pRow+1<10 && t.pCol+3<10)
			{
				node temp = new node(t.pRow+1,t.pCol+3);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid 1,-3
			if(t.pRow+1<10 && t.pCol-3>=0)
			{
				node temp = new node(t.pRow+1,t.pCol-3);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// Find Chid -1,3
			if(t.pRow-1>=0 && t.pCol+3<10)
			{
				node temp = new node(t.pRow-1,t.pCol+3);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			
			// Find Chid -1,-3
			if(t.pRow-1>=0 && t.pCol-3>=0)
			{
				node temp = new node(t.pRow-1,t.pCol-3);
				if(LoopCheck(temp))
				{
					temp.path = t;
					Q.add(temp);
				}
			}
			// If Queque is Empty return NULL?
			if(Q.isEmpty())
			{
				return null;	
			}
		}
	}
}
