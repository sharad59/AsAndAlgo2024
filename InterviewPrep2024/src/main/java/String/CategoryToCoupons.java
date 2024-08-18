package String;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import String.Ideone.Coupon;
import String.Ideone.DiscountType;

public class CategoryToCoupons {

	
	 static class Coupon {
	        String couponName;
	        Date dateModified;
	        double discount;
	        DiscountType discountType;

	        Coupon(String couponName, Date dateModified, double discount, DiscountType type) {
	            this.couponName = couponName;
	            this.dateModified = dateModified;
	            this.discount = discount;
	            this.discountType = type;
	        }
	    }
	 
	   static Map<String, List<Coupon>> map;
	 static   Map<String, String> parentmap;
	 
	public static void main(String args[]) {
		
		   List<String[]> coupons = List.of(
	                new String[]{"CategoryName:Comforter Sets", "CouponName:Comforters Sale", "DateModified:2020-01-01","Discount:10%"},
	                new String[]{"CategoryName:Comforter Sets", "CouponName:Cozy Comforter Coupon", "DateModified:2020-01-01","Discount:$15"},
	                new String[]{"CategoryName:Bedding", "CouponName:Best Bedding Bargains", "DateModified:2019-01-01","Discount:35%"},
	                new String[]{"CategoryName:Bedding", "CouponName:Savings on Bedding", "DateModified:2019-01-01","Discount:25%"},
	                new String[]{"CategoryName:Bed & Bath", "CouponName:Low price for Bed & Bath", "DateModified:2018-01-01","Discount:50%"},
	                new String[]{"CategoryName:Bed & Bath", "CouponName:Bed & Bath extravaganza", "DateModified:2019-01-01","Discount:75%"}
	        );
		   
		   
			List<String[]> couponList = List.of(
					new String[] { "CategoryName:Comforter Sets", "CouponName:Comforters Sale" },
					new String[] { "CategoryName:Bedding", "CouponName:Best Bedding Bargains" });


			for (String[] coupon : couponList) {
				String categoryName = coupon[0].split(":")[1];
				String couponName = coupon[1].split(":")[1];

				if (!map.containsKey(categoryName)) {
					map.put(categoryName, new ArrayList<Coupon>());
				} else {
					map.get(categoryName).add(new Coupon(couponName, null, 0, null));

				}
			}
			
			List<String []> categoryList= List.of(new String[] {"CategoryName:Comforter Sets", "CategoryParentName:Bedding"},new String[] {"CategoryName:Comforter Sets", "CategoryParentName:Bedding"});
			
			Map<String, String> parentmap = new HashMap<>();

			for (String[] str : categoryList) {
				String name = str[0].split(":")[1];
				String parent = str[0].split(":")[1];
				parentmap.put(name, parent);
			}

		}
	
	
	
	
	  private static List<Coupon> getCouponDetails(String category) {
	        if(map.containsKey(category)) {
	            return map.get(category);
	        }
	        String parentCategory = findParent(category);
	        if(parentCategory.equals("None")) {
	            return List.of();
	        }
	        return map.get(parentCategory);
	    }




		private static String findParent(String category) {

			String parent = parentmap.get(category);
			if (parent == null) {
				return "NA";
			}
			if (map.containsKey(parent)) {
				return parent;
			}
			parentmap.put(category, findParent(category));
			return parentmap.get(category);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
