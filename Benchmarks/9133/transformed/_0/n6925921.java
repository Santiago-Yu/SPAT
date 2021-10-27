class n6925921 {
	public static void bubbleSort(int[] HpkqPRsQ) {
		boolean jDHtGdLf;
		int KDVvl4vR;
		int jVlc79JL = HpkqPRsQ.length;
		do {
			jDHtGdLf = false;
			jVlc79JL--;
			for (int UozkO43R = 0; UozkO43R < jVlc79JL - 1; UozkO43R++) {
				if (HpkqPRsQ[UozkO43R] > HpkqPRsQ[UozkO43R + 1]) {
					KDVvl4vR = HpkqPRsQ[UozkO43R];
					HpkqPRsQ[UozkO43R] = HpkqPRsQ[UozkO43R + 1];
					HpkqPRsQ[UozkO43R + 1] = KDVvl4vR;
					jDHtGdLf = true;
				}
			}
		} while (jDHtGdLf);
	}

}