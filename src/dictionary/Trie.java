package dictionary;
import java.io.*;
import org.json.*;

public class Trie {
    Setter s;
    ///to display result in Choice List 
    void setListener(Setter s)
    {this.s=s;
        
    }
TNode root;
////constructor
	Trie()
	{
		root=createTrieNode();
              
	}
        ///creating a Trie Node
	TNode createTrieNode()
	{

	    TNode newNode = new TNode();
	    newNode.isEOW = false;
	   
	    return newNode;
	}
        ////inserting word into trie
	boolean insertWordInTrie(TNode root,String word)
	{
	  int len=word.length();
	 
	  for(int i=0;i<len;i++)
	  {
	  if(root.next[word.charAt(i)-'a']==null)
	    root.next[word.charAt(i)-'a']=createTrieNode();
	    root=root.next[word.charAt(i)-'a'];



	  }
	  if(root.isEOW)
	    return false;
	  root.isEOW=true;
	  return true;


	}
        
	StringBuilder str=new StringBuilder();
	
        
        ///printing all words in trie
	void printWordsInTrie(TNode root){

	  if(root==null)
	    return;
	  if(root.isEOW)
	  { 
	    System.out.println(str);}
	  for(int i=0;i<26;i++)
	  {

	   if(root.next[i]!=null && str!=null)
	   {
		   
	   str.append((char)i+'a');
	   
	     printWordsInTrie(root.next[i]);
	    str.substring(0, str.length());



	   }
	  }

	}
	
	/*To  restrict the result of search */int countPrefix=0;///
        
        //Helper function to perform prefix based print
	void printWordsInTrie(TNode root,String str1){

	  if(root==null)
	    return;
	  if(root.isEOW)
	  { str1=str1.concat(str.toString());
          str=new StringBuilder();
          if(countPrefix<10)
          s.setText(str1);
                    else
              return;
	//System.out.println(str1); 
	
	
	    countPrefix++;}
	  for(int i=0;i<26;i++)
	  {

	   if(root.next[i]!=null)
	   {
	   str.append((char)(i+'a'));
	     
	     printWordsInTrie(root.next[i],str1);
	     
	     str.substring(0, str.length());




	   }
	  }

	}
        ///to check whether the node is leaf or not
	boolean isLeaf(TNode root){
	    int i;
	    for(i = 0;i < 26; i++)
	        if(root.next[i] != null)
	            return false;
	    return true;
	}


/// loading data from words.txt and initializing trie 
	TNode initializeTrie()
	{
	   
	try {

		BufferedReader br=new BufferedReader(new FileReader("build/classes/dictionary/words.txt"));
		String temp;
		while((temp=br.readLine())!=null)
		{
			if(!temp.equalsIgnoreCase("and/or"))
				insertWordInTrie(root,temp);
		}
		br.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	    return root;

	}
///prefix print
	void printAllPrefix(TNode root,String str)
	{countPrefix=0;
	    if(root==null)
	        return;
	    for(int i=0;i<str.length();i++)
	    {

	        if(root.next[str.charAt(i)-'a']!=null)
	        {

	            root=root.next[str.charAt(i)-'a'];

	        }
	    }


	    printWordsInTrie(root,str);


	}


}
