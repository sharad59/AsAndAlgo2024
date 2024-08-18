package String;

class Solution {
	public static String findLatestTime(String s) {

		String str = s.substring(0, 2);
		String str2 = s.substring(3, 5);
		char arr[] = str.toCharArray();
		char arr1[] = str2.toCharArray();

		if (arr[0] == '?' && arr[1] != '?') {
			if(arr[1]>'1') {
				arr[0]='0';
			}
			else {
				arr[0]='1';
			}
		}  if (arr[0] == '1' && arr[1] == '?') {
			arr[1] = '1';
		}  if (arr[0] == '0' && arr[1] == '?') {
			arr[1] = '9';
		}  if (arr[0] == '?' && arr[1] == '?') {
			arr[0] = '1';
			arr[1] = '1';
		}

		if (arr1[0] == '?') {
			arr1[0] = '5';
		}
		if (arr1[1] == '?') {
			arr1[1] = '9';
		}
		String a = new String(arr) +":"+ new String(arr1);
		return a;
	}

	public static void main(String args[]) {

		String a = "?1:?6";
		String b = findLatestTime(a);
		System.out.println(b);

	}
}