package String;

public class RotatedStringby2placesIsequalTother {
	public static boolean isRotated(String str1, String str2) {
		int len = str1.length();
		int len2 = str2.length();

		if (len != len2) {
			return false;
		}
		if (len2 < 2)
			return str1.equals(str2);

		String sclock = str1.substring(len - 2, len) + str1.substring(0, len - 2);
		String anticlock = str1.substring(2, len) + str1.substring(0, 2);
		// System.out.println(sclock);
		// System.out.println(anticlock);

		if (sclock.equals(str2) || anticlock.equals(str2)) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {

		String str1 = "geeks";
		String str2 = "eksge";
		System.out.println(isRotated(str1, str2));
	}

}
