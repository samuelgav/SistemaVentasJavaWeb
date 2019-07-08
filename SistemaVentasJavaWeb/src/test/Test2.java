package test;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=123345;
		int s=0;
		while(num>0){
			s=s+num%10;
			num=num/10;
		}
		System.out.println(s);
	}

}
