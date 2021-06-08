package buffer;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>{
	public int compare(Person p1,Person p2)
	{
		 if(p1.age>=60 && p2.age>=60)
		{
			if(p2.age >= p1.age )		
				return 1;
			else
				return -1;
					
		}
		     
		else if(p2.medical == true && p1.medical == false)
		{
			if(p2.medical == true && p1.medical == false)
				return 1;
			else
				return -1;
		}
		else if(p2.fam == true && p1.fam == false)
		{
			if(p2.fam == true && p1.fam == false)
				return 1;
			else
				return -1;
		}
		else
		{
			return -1;
		}
	}
}
