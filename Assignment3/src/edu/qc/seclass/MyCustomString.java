package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {
	
	private String myString;
	
	public String getString() 
	{
		if(this.myString.isEmpty())
			return null;
		else
		{
			return myString;
		}
	}
	
	public void setString(String s)
	{
		this.myString = s;
	}
	public int countNumbers()
	{
		int count = 0;
		boolean lastChar = false;
		if(this.myString.isEmpty())
			return 0;
		if(this.myString == null)
		{
			throw new NullPointerException();
		}
		for(int i = 0; i < this.myString.length(); i++)
		{		
			if(this.myString.charAt(i) >= '0' && this.myString.charAt(i) <= '9')
			{
				
				if(lastChar == false)
				{
					count++;
					lastChar = true;
				}else 
				{
					lastChar = true;
				}
			}else
			{
				lastChar = false;
			}
		}
		
		return count;
	}
	
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd)
	{
		StringBuffer result = new StringBuffer();
		if(n <= 0)
			throw new IllegalArgumentException();
		if(n > 0 && myString == null)
			throw new NullPointerException();
		if(myString.isEmpty() || myString.length() < n)
			return "";
		else
		{
			if(startFromEnd == false)
			{
				for(int i = n-1; i < myString.length(); i += n)
				{
					result.append(myString.charAt(i));
				}
			}else
			{	
				for(int i = myString.length() - n; i >= 0; i -= n)
				{
					result.insert(0, myString.charAt(i));
				}
				
			}
			return result.toString();
		}
	}
	
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		StringBuffer result = new StringBuffer();
		if(startPosition > endPosition)
			throw new IllegalArgumentException();
		if((startPosition <= endPosition) && ((startPosition < 1 || endPosition > myString.length())))
			throw new MyIndexOutOfBoundsException();
		if(startPosition <= endPosition && startPosition > 0 && endPosition > 0 && myString == null)
			throw new NullPointerException();
		for(int i = 0; i < myString.length(); i++)
		{
			if((i >= startPosition - 1 && i <= endPosition - 1) && (myString.charAt(i) >= '0' && myString.charAt(i) <= '9'))
			{
				switch(myString.charAt(i) - '0')
				{
					case 0:
						result.append("Zero");
						break;
					case 1:
						result.append("One");
						break;
					case 2:
						result.append("Two");
						break;
					case 3:
						result.append("Three");
						break;
					case 4:
						result.append("Four");
						break;
					case 5:
						result.append("Five");
						break;
					case 6:
						result.append("Six");
						break;
					case 7:
						result.append("Seven");
						break;
					case 8:
						result.append("Eight");
						break;
					case 9:
						result.append("Nine");
						break;
				}
			}
			else {
				result.append(myString.charAt(i));
			}
			
		}
		myString = result.toString();
	}
	public static void main(String[] args) {
		MyCustomString ms = new MyCustomString();
		System.out.println(ms.getEveryNthCharacterFromBeginningOrEnd(3, false));
	}
}
