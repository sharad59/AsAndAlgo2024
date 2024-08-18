package Array;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellMaxProfit {

	public static void main(String[] args) {
		//int price[] = { 100, 180, 260, 310, 40, 535, 695 };
		int price[] =  {7,1,5,3,6,4};
		int n = price.length;

		System.out.print(maxProfit(price, 0, n));
	}

	static class Interval {

		int buy;
		int sell;
	}

	private static int maxProfit(int[] arr, int i, int n) {
		List<Interval> list = new ArrayList<Interval>();


		while(i<n-1) {
			Interval e= new Interval();
			
			while(i<n-1 && arr[i]>=arr[i+1])
			i++;
			e.buy=i++;
			
			if(i==n-1) {
				break;
			}
			while(i<=n-1 && arr[i]>=arr[i-1]) {
				i++;
			}
			e.sell=i-1;
             list.add(e);
		}
		int res=0;
		for(int i1=0;i1<list.size();i1++) {
			Interval in=list.get(i1);
			res+=(arr[in.sell]-arr[in.buy]);
		}
		return res;
	}
}
