package anyuanzhi;

import java.util.*;

public class Polynomialarithmetic {


/**
 * @param args
 */
public static void main(final String[] args) {
		// TODO �Զ����ɵķ������
		Scanner lalala = new Scanner(System.in);
		String input;
		int la=0;
		Expression a=new Expression();
		System.out.println("Welcome to the PolynomialaArithmetic monitor.\nServer version: 1.0.9\nCopyright (c) 2016��\nType '!h' for help. Type '!q' for exit.\n ");
		while(true){
			input = lalala.nextLine();
			try{
			if(input.length()>0&&input.charAt(0)=='!')
			{
				if(input.equals("!q")){
					System.out.println("end");
					break;
				}
				else if (input.equals("!h"))
					System.out.println("����������д���͸�\n!���磺!simplify a=1  !d/dx \n�����ϸ��չ������룡");

				else if(input.substring(0,4).equals("!d/d")||input.substring(0,9).equals("!simplify"))
				{
					if(la==0)
						System.out.println("��δ�����κα��ʽ���޷�ִ�����\n");
					else 
						a.Command(input);
				}
			}
			else 
			{
				la=1;
				a.Set(input);
				a.printout();
				System.out.print("\n");
			}
		}
			catch(Exception e)
			{
				System.out.println("���벻�Ϸ���\n"+e);
			}
		}
		lalala.close();
	}
}
