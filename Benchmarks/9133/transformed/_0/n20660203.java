class n20660203 {
	public static void main(String uMrl8id2[]) {
		int fcBQwZgK;
		int[] EUfv8Znu = { 6, 2, -3, 7, -1, 8, 9, 0 };
		for (int bBOLm8C5 = 0; bBOLm8C5 < (EUfv8Znu.length * EUfv8Znu.length); bBOLm8C5++) {
			for (int AZ3vTnvi = 0; AZ3vTnvi < EUfv8Znu.length - 1; AZ3vTnvi++) {
				if (EUfv8Znu[AZ3vTnvi] > EUfv8Znu[AZ3vTnvi + 1]) {
					fcBQwZgK = EUfv8Znu[AZ3vTnvi];
					EUfv8Znu[AZ3vTnvi] = EUfv8Znu[AZ3vTnvi + 1];
					EUfv8Znu[AZ3vTnvi + 1] = fcBQwZgK;
				}
			}
		}
		for (int rwLV0PzM = 0; rwLV0PzM < EUfv8Znu.length; rwLV0PzM++) {
			System.out.print(" " + EUfv8Znu[rwLV0PzM]);
		}
	}

}