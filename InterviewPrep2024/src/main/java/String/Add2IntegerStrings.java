 6package String;

public class Add2IntegerStrings {

	public static String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int l = num1.length();
		int l2 = num2.length();
		int i = l - 1, j = l2 - 1;
		int carry = 0, sum = 0;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				char ch = num1.charAt(i);
				int a = ch - 48;
				sum += a;

				i--;
			}
			if (j >= 0) {
				char ch1 = num2.charAt(j);
				int b = ch1 - 48;
				sum += b;
				j--;
			}
			carry = sum / 10;
			sum = sum % 10;
			sb.append(sum);
			sum = carry;
		}
		if (carry == 1)
			sb.append(1);

		sb = sb.reverse();
		return sb.toString();
	}

	public static String addStrings2(String num1, String num2) {

		int i = num1.length() - 1;
		int j = num2.length() - 1;

		int sum = 0, carry = 0;
		StringBuilder sb = new StringBuilder();

		while (i >= 0 || j >= 0) {
			sum = 0 + carry;
			if (i >= 0) {
				sum += (int) num1.charAt(i) - 48;
				i--;
			}
			if (j >= 0) {
				sum += (int) num2.charAt(j) - 48;
				j--;
			}
			carry = sum / 10;
			sum = sum % 10;
			sb.append(sum);
		}

		if (carry == 1) {
			carry = 0;
			sb.append(1);
		}

		sb = sb.reverse();
		return sb.toString();

	}

	public static String addStringsResultWithCommons(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int l = num1.length();
		int l2 = num2.length();
		int i = l - 1, j = l2 - 1;
		int carry = 0, sum = 0;
		int count = 0;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				char ch = num1.charAt(i);
				int a = ch - 48;
				sum += a;

				i--;
			}
			if (j >= 0) {
				char ch1 = num2.charAt(j);
				int b = ch1 - 48;
				sum += b;
				j--;
			}
			carry = sum / 10;
			sum = sum % 10;
			if (count % 2 == 1 && count >= 3) {
				sb.insert(0, ",");
				sb.insert(0, sum);
			} else {
				sb.insert(0, sum);
			}
			sum = carry;
			count++;
		}
		if (carry == 1) {
			if (count % 2 == 1)
				sb.insert(0, ",");
			sb.insert(0, "1");
		}

		return sb.toString();
	}

	public static String addStringsWithCommos(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int l = num1.length();
		int l2 = num2.length();
		int i = l - 1, j = l2 - 1;
		int carry = 0, sum = 0;
		int count = 0;
		while (i >= 0 || j >= 0) {
			if (i >= 0) {
				char ch = num1.charAt(i);
				if (ch == ',') {
					i--;
					ch = num1.charAt(i);
				}
				int a = ch - 48;
				sum += a;

				i--;
			}
			if (j >= 0) {
				char ch1 = num2.charAt(j);
				if (ch1 == ',') {
					j--;
					ch1 = num2.charAt(j);
				}
				int b = ch1 - 48;
				sum += b;
				j--;
			}
			carry = sum / 10;
			sum = sum % 10;
			if (count % 2 == 1 && count >= 3) {
				sb.insert(0, ",");
				sb.insert(0, sum);
			} else {
				sb.insert(0, sum);
			}
			sum = carry;
			count++;
			// System.out.println(count);
		}
		if (carry == 1) {
			if (count % 2 == 1)
				sb.insert(0, ",");
			// System.out.println(count);
			sb.insert(0, "1");
		}

		// sb = sb.reverse();
		return sb.toString();
	}

	

	public static void main(String args[]) {
		String a = "79,15,678";
		String b = "71,23,789";

		System.out.println(addStringsWithCommos(a, b));
	}
}
