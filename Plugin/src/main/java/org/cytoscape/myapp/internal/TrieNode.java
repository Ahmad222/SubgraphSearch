package org.cytoscape.myapp.internal;

import java.util.*;

public class TrieNode
{
  public long freq;
  public TrieNode one;
  public TrieNode zero;



    void incrementString(int pos, char[] s ) {
	if (s[pos] == 0) freq++;
	else {
	    if (s[pos] == '1') {
		if (one == null) one = new TrieNode();
		one.incrementString(pos + 1, s);
	    }
	    else if (s[pos] == '0') {
		if (zero == null) zero = new TrieNode();
		zero.incrementString(pos + 1, s);
	    }
	}
    }
    public TrieNode()
    {
	freq = 0;
	one = null;
	zero = null;
    }




    public final TreeMap< String, Long> populateMap(TreeMap< String, Long> m, int size, int pos, char [] s)
    {
	//System.out.println(pos+  "   **  "+ "in Populate000 \n");
	if (zero == null && one == null)
	    {
		s[pos] = 0;//' ';//0;
		
		//char [] s2 = new char [size * size+1]; 
		  
		//s2 = Isomorphism.canonicalBasedNauty(s, s2, size);
		
		m.put(String.valueOf(s).trim(), freq);
		  
	    }
	else
	    {
		if (zero != null)
		    {
			s[pos] = '0';
			zero.populateMap(m, size, pos + 1, s);
		    }
		if (one != null)
		    {
			s[pos] = '1';
			one.populateMap(m, size, pos + 1, s);
		    }
	    }
	return m;
    }

 
}

