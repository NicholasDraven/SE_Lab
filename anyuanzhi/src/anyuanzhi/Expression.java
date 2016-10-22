package anyuanzhi;

/*import anyuanzhi.Expression;*/

public class Expression {
private String  thisExpression;
/**
* 
*
* @author George Bush
*/
private boolean  simpleOrComplex;
private Expression  head;
private  boolean  abcOrNum;/**/
private String abc;
private long num;
private long pow;
private boolean positiveOrNegative;

private Expression down;
private Expression right;
			
public void Set(String ExpressionInput) throws ArithmeticException
{
		final int changliang1 = 18;
		thisExpression=ExpressionInput;
		simpleOrComplex = false;
		String str=null;
		if (str.equals("0"))
		{
			System.out.print("0");
		}
		head = new Expression();
		char variousreplaceofjiahao = '+';
		Expression temp = head;
		Expression leftTemp = head;
		Expression next = new Expression();
		for(int i=0;i<ExpressionInput.length();)
		{
			if(ExpressionInput.charAt(i)==variousreplaceofjiahao)
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!1");
					throw new ArithmeticException();
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=true;
				leftTemp=next;
				temp=next;
			}
			else if (ExpressionInput.charAt(i)=='-')
			{
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1)
				{
					System.out.println("ERROR!2");
					throw new ArithmeticException();
				}
				next = new Expression();
				leftTemp.down=next;
				next.positiveOrNegative=false;
				leftTemp=next;
				temp=next;
			} else if (ExpressionInput.charAt(i) == '*') {
				if(leftTemp.simpleOrComplex&&leftTemp.abc==null&&leftTemp.num==-1||temp.simpleOrComplex&&temp.abc==null&&temp.num==-1)
				{
					System.out.println("ERROR!3");
					throw new ArithmeticException();
				}
				next = new Expression();
				temp.right=next;
				temp=next;
			}



			else if (ExpressionInput.charAt(i)=='^')
			{
				int variousreplaceofj;
				i++;
				for(;ExpressionInput.charAt(i)==' ';i++)
				{}
				for (variousreplaceofj = i; (ExpressionInput
				.charAt(variousreplaceofj) >= '0' && ExpressionInput
						.charAt(variousreplaceofj) <= '9');)
				{
					variousreplaceofj++;
					if ((variousreplaceofj - i) >= changliang1)
					{
						System.out.println("ERROR!4");
						throw new ArithmeticException();
					}
					if (variousreplaceofj == ExpressionInput.length()) {
						break;
					}
				}
				if(i==variousreplaceofj)
				{
					System.out.println("ERROR!5");
					throw new ArithmeticException();
				}
				temp.pow=Long.parseLong(ExpressionInput.substring(i,variousreplaceofj));
				i=variousreplaceofj;
				continue;
			}
			else if (ExpressionInput.charAt(i)=='(')
			{
				int x=1;
				int variousreplaceofj;
				for (variousreplaceofj=i;ExpressionInput.charAt(variousreplaceofj)!=')'||x>0;)
				{
					variousreplaceofj++;
					if(ExpressionInput.charAt(variousreplaceofj)=='(')
						x++;
					if(ExpressionInput.charAt(variousreplaceofj)==')')
						x--;
					if (variousreplaceofj==ExpressionInput.length())
					{
						if (x>0)
						{
							System.out.println("ERROR!6");
							throw new ArithmeticException();
						}
						break;
					}
				}

					next = new Expression();
					temp.right=next;
					temp=next;
				next.Set(ExpressionInput.substring(i+1,variousreplaceofj));
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=variousreplaceofj;

			}
			
			else if ((ExpressionInput.charAt(i)>='A'&&ExpressionInput.charAt(i)<='Z') || (ExpressionInput.charAt(i)>='a'&&ExpressionInput.charAt(i)<='z'))
			{
				int variousreplaceofj;
				for(variousreplaceofj=i;(ExpressionInput.charAt(variousreplaceofj)>='A'&&ExpressionInput.charAt(variousreplaceofj)<='Z') || (ExpressionInput.charAt(variousreplaceofj)>='a'&&ExpressionInput.charAt(variousreplaceofj)<='z');)
				{
					variousreplaceofj++;
					if (variousreplaceofj==ExpressionInput.length())
						break;
				}
				if(next.num!=-1||next.abc!=null||next.simpleOrComplex==false)
				{
					next = new Expression();
					temp.right=next;
					temp=next;
				}
				next.abc=ExpressionInput.substring(i, variousreplaceofj);
				next.abcOrNum=true;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=variousreplaceofj;
				continue;
			}
			else if (ExpressionInput.charAt(i)>='0' && ExpressionInput.charAt(i)<='9')
			{
				int variousreplaceofj;
				for(variousreplaceofj=i;ExpressionInput.charAt(variousreplaceofj)>='0' && ExpressionInput.charAt(variousreplaceofj)<='9';)
				{
					variousreplaceofj++;
					if((variousreplaceofj-i)>=18)
					{
						System.out.println("ERROR!7");
						throw new ArithmeticException();
					}
					if (variousreplaceofj==ExpressionInput.length())
						{break;}
				}
				if(next.num!=-1||next.abc!=null||next.simpleOrComplex==false)
				{
					next = new Expression();
					temp.right=next;
					temp=next;
				}
				next.num=Long.parseLong(ExpressionInput.substring(i, variousreplaceofj));
				next.abcOrNum=false;
				next.pow=1;
				if (head.down==null && head.right==null)
				{
					head.down=next;
					leftTemp=next;
					temp=next;
				}
				i=variousreplaceofj;
				continue;
			}
			else if (ExpressionInput.charAt(i)!='\t'&&ExpressionInput.charAt(i)!=' ')
			{
				System.out.println("ERROR!8");
				throw new ArithmeticException();
			}
			i++;
		}
		if(next.simpleOrComplex&&next.abc==null&&next.num==-1)
		{
			System.out.println("ERROR!9");
			throw new ArithmeticException();
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
		thisExpression=null;
	}
	/**
	 * 
	 */
	public void printout()
	{
		if (simpleOrComplex)
		{
			if(abcOrNum)
			{	System.out.print(abc);}
			else 
			{	System.out.print(num);}
		}
		else
		{
			Expression next;
			Expression leftHead;
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
				if(leftHead.pow!=1)
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
					if(next.pow!=1)
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

	public void change(String[][] x,int n)
	{
		if(simpleOrComplex)
		{
			if(abcOrNum)
			{
				for(int i=0;i<n;i++)
				{
					if(x[i][0].equals(abc))
					{
						num=Long.parseLong(x[i][1]);
						abcOrNum=false;
						abc=null;
					}
				}
			}
		}
		else
		{
			for(Expression i=head.down;i!=null;i=i.down)
			{
				for(Expression variousreplaceofj=i;variousreplaceofj!=null;variousreplaceofj=variousreplaceofj.right)
				{
					variousreplaceofj.change(x, n);
				}
			}
		}
	}
	public void simplify()
	{
		if(simpleOrComplex)
		{
			if(!abcOrNum)
			{
				num= (long) Math.pow(num, pow);
				pow=1;
			}
		}
		else
		{
			Expression i,variousreplaceofj;
			Expression leftTemp=null;
			Expression plusTemp=null;
			for(i=head.down;i!=null;i=i.down)
			{
				leftTemp=null;
				Expression lalalaTemp=null;
				for(variousreplaceofj=i;variousreplaceofj!=null;variousreplaceofj=variousreplaceofj.right)
				{
					variousreplaceofj.simplify();
					if(!variousreplaceofj.abcOrNum&&variousreplaceofj.simpleOrComplex)
					{
						if(leftTemp==null)
							leftTemp=variousreplaceofj;
						else
						{
							leftTemp.num=leftTemp.num*variousreplaceofj.num;
							lalalaTemp.right=variousreplaceofj.right;
							//variousreplaceofj=lalalaTemp;
							continue;
						}
					}
					lalalaTemp=variousreplaceofj;
				}
				if(leftTemp!=null&&leftTemp.equals(i)==true)
				{
					Expression preTemp,topTemp,temp;
					for(preTemp=i;preTemp.right!=leftTemp;preTemp=preTemp.right);
					for(topTemp=head;topTemp.down!=i;topTemp=topTemp.down);
					topTemp.down=leftTemp;
					leftTemp.down=i.down;
					i.down=null;
					preTemp.right=i;
					temp=i.right;
					i.right=leftTemp.right;
					leftTemp.right=temp;
					leftTemp.positiveOrNegative=leftTemp.positiveOrNegative&&i.positiveOrNegative;
					i=leftTemp;
				}
				if(!i.abcOrNum&&i.simpleOrComplex&&i.right==null)
				{
					if(plusTemp==null)
						plusTemp=i;
					else
					{
						if(i.positiveOrNegative)
							plusTemp.num=plusTemp.num+i.num;
						else
							plusTemp.num=plusTemp.num-i.num;
						Expression topTemp=null;
						for(topTemp=head;topTemp.down!=i;topTemp=topTemp.down);
						topTemp.down=i.down;
					}
				}
			}
			
			if(head.down.down==null&&head.down.right==null&&head.down.pow==1)
			{
				simpleOrComplex=head.down.simpleOrComplex;
				abc=head.down.abc;
				pow=pow*head.down.pow;
				num=head.down.num;
				abc=head.down.abc;
				abcOrNum=head.down.abcOrNum;
				positiveOrNegative=head.down.positiveOrNegative;
				thisExpression=head.down.thisExpression;	
				head=head.down.head;
				if(!abcOrNum)
				{
					num= (long) Math.pow(num, pow);
					pow=1;
				}
			}
			
		}
	}

	public int derivative(String var)
	{
		int flag =1;
		if(simpleOrComplex)
		{
			if(abcOrNum)
			{
				if(abc.equals(var))
					flag=0;
			}
		}
		else
		{
			int flag2=1;
			for(Expression i=head.down;i!=null;i=i.down)
			{
				flag=1;
				for(Expression variousreplaceofj=i;variousreplaceofj!=null;variousreplaceofj=variousreplaceofj.right)
				{
					if(!variousreplaceofj.simpleOrComplex)
					{
						Expression copy = new Expression();
						copy.pow=variousreplaceofj.pow;
						copy.Set(variousreplaceofj.thisExpression);
						copy.right = variousreplaceofj.right;
						variousreplaceofj.right = copy;
						variousreplaceofj.pow=1;
						flag *= variousreplaceofj.derivative(var);
						variousreplaceofj=variousreplaceofj.right;
					}
					else 
						flag *= variousreplaceofj.derivative(var);
					if (flag == 0)
					{
						flag2=0;
						if(variousreplaceofj.pow==1)
						{
							variousreplaceofj.num=1;
							variousreplaceofj.abcOrNum=false;
						}
						else
						{
							Expression powTemp = new Expression();
							powTemp.right=variousreplaceofj.right;
							variousreplaceofj.right=powTemp;
							powTemp.abcOrNum=false;
							powTemp.num=variousreplaceofj.pow;
							variousreplaceofj.pow--;
							variousreplaceofj=variousreplaceofj.right;
						}
					}
					
				}
				if(flag==1)
				{
					i.num=0;
					i.abcOrNum=false;
				}
			}
			flag *=flag2;
		}
		return flag;
	}

	public void Command(String commandInput)
	{
		Expression lalala=new Expression();
		lalala.Set(thisExpression);
		lalala.simplify();
		if(commandInput.substring(1,4).equals("d/d"))
		{
			String var = new String();
			int variousreplaceofj;
			for(variousreplaceofj=4;variousreplaceofj<commandInput.length()&&commandInput.charAt(variousreplaceofj)!= ' ';variousreplaceofj++);
			var = commandInput.substring(4,variousreplaceofj);
			lalala.derivative(var);
		}
		else if (commandInput.substring(1,9).equals("simplify"))
		{
			String[][] x=new String[100][2];
			int n=0;
			for(int i=9;i<commandInput.length();i++)
			{
				if((commandInput.charAt(i)>='A'&&commandInput.charAt(i)<='Z') || (commandInput.charAt(i)>='a'&&commandInput.charAt(i)<='z'))
				{
					int variousreplaceofj;
					for(variousreplaceofj=i;commandInput.charAt(variousreplaceofj)!= '=';variousreplaceofj++);
					x[n][0] = commandInput.substring(i,variousreplaceofj);
					i = variousreplaceofj;
				}
				else if(commandInput.charAt(i)>='0'&&commandInput.charAt(i)<='9')
				{
					int variousreplaceofj;
					for(variousreplaceofj=i;variousreplaceofj <commandInput.length()&&commandInput.charAt(variousreplaceofj)!= ' ';variousreplaceofj++);
					x[n][1] = commandInput.substring(i,variousreplaceofj);
					i = variousreplaceofj;
					n++;
				}
			}
			lalala.change(x,n);
		}
		lalala.simplify();
		lalala.printout();
		System.out.print("\n");

	}

}
