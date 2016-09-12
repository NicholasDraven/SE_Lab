package 表达式计算;

public class Expression {
	private boolean simpleOrComplex;
	
	private Expression  head;
	
	private boolean abcOrNum;
	private String abc;
	private long num;
	private long pow;
	private boolean positiveOrNegative;
	
	private Expression down;
	private Expression right;
	
	public void Set(String expressionInput)
	{
		//赋初始值
		simpleOrComplex = false;
		
		head = new Expression();
		
		
		Expression temp = head;
		Expression leftTemp = head;
		Expression next =new Expression();
		for(int i=0;i<expressionInput.length();)
		{
			if(expressionInput.charAt(i)=='+')
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!");
					return ;
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=true;
				leftTemp=next;
				temp=next;
			}
			else if (expressionInput.charAt(i)=='-')
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!");
					return ;
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=false;
				leftTemp=next;
				temp=next;
			}
			else if (expressionInput.charAt(i)=='*')
			{
				if((leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)||(temp.simpleOrComplex&&temp.abc==null&&temp.num==-1))
				{
					System.out.println("ERROR!");
					return ;
				}
				next = new Expression();
				temp.right=next;
				temp=next;
			}
			
			
			
			else if (expressionInput.charAt(i)=='^')
			{
				int j;
				i++;
				for (j=i;expressionInput.charAt(j)>='0'&&expressionInput.charAt(j)<='9';)
				{
					j++;
					if((j-i)>=18)
					{
						System.out.println("ERROR!");
						return ;
					}
					if (j==expressionInput.length())
						break;
				}
				if(i==j)
				{
					System.out.println("ERROR!");
					return;
				}
				temp.pow=Long.parseLong(expressionInput.substring(i,j));
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)=='(')
			{
				int x=1;
				int j;
				for (j=i;expressionInput.charAt(j)!=')'||x>0;)
				{
					j++;
					if(expressionInput.charAt(j)=='(')
						x++;
					if(expressionInput.charAt(j)==')')
						x--;
					if (j==expressionInput.length())
					{
						if (x>0)
						{
							System.out.println("ERROR!");
							return ;
						}
						break;
					}
				}
				next.Set(expressionInput.substring(i+1,j));
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				//以后再调整范围
			}
			
			else if (expressionInput.charAt(i)>='A' && expressionInput.charAt(i)<='z')
			{
				int j;
				for(j=i;(expressionInput.charAt(j)>='A'&&expressionInput.charAt(j)<='Z') || (expressionInput.charAt(j)>='a'&&expressionInput.charAt(j)<='z');)
				{
					j++;
					if (j==expressionInput.length())
						break;
				}
				next.abc=expressionInput.substring(i, j);
				next.abcOrNum=true;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)>='0' && expressionInput.charAt(i)<='9')
			{
				int j;
				for(j=i;expressionInput.charAt(j)>='0' && expressionInput.charAt(j)<='9';)
				{
					j++;
					if((j-i)>=18)
					{
						System.out.println("ERROR!");
						return ;
					}
					if (j==expressionInput.length())
						break;
				}
				next.num=Long.parseLong(expressionInput.substring(i, j));
				next.abcOrNum=false;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=j;
				continue;
			}
			else if (expressionInput.charAt(i)!='\t'&&expressionInput.charAt(i)!=' ')
			{
				System.out.println("ERROR!");
				return ;
			}
			i++;
		}
		if(next.simpleOrComplex&&next.abc==null&&next.num==-1)
		{
			System.out.println("ERROR!");
			return;
		}
	}
	public Expression()
	{
		simpleOrComplex=true;
		head=null;
		down=null;
		right=null;
		abc=null;
		pow=1;
		num=-1;
		abc=null;
		abcOrNum=true;
		positiveOrNegative=true;
	}
	
	public void printout()
	{
		if (simpleOrComplex)
		{
			if(abcOrNum)
				System.out.print(abc);
			else 
				System.out.print(num);
		}
		else
		{
			Expression next,leftHead;
			leftHead=head.down;
			while(leftHead != null)
			{
				if(leftHead.simpleOrComplex==false)
				{
					System.out.print('(');
					leftHead.printout();
					System.out.print(')');
				}
				else
					leftHead.printout();
				if(leftHead.pow>1)
				{
					System.out.print('^');
					System.out.print(leftHead.pow);
				}
				
				next=leftHead.right;
				while(next != null)
				{
					System.out.print('*');
					if(next.simpleOrComplex==false)
					{
						System.out.print('(');
						next.printout();
						System.out.print(')');
					}
					else
						next.printout();
					if(next.pow>1)
					{
						System.out.print('^');
						System.out.print(next.pow);
					}
					next=next.right;
				}
				leftHead=leftHead.down;
				if (leftHead!=null)
				{	
					if(leftHead.positiveOrNegative)
						System.out.print('+');
					else
						System.out.print('-');
				}
			}
		}
		
		
		
		

	}

	public Expression simplify()
	{
		Expression result = new Expression();
		
		return result;
	}
}
