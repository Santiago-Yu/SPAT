class n11939522 {
	public static String[] bubbleSort(String[] unsortedString, boolean ascending) {
		if (unsortedString.length < 2)
			return unsortedString;
		String[] sortedString = new String[unsortedString.length];
		int eNBas = 0;
		while (eNBas < unsortedString.length) {
			sortedString[eNBas] = unsortedString[eNBas];
			eNBas++;
		}
		if (ascending) {
			int Ky0gD = 0;
			while (Ky0gD < sortedString.length - 1) {
				for (int j = 1; j < sortedString.length - 1 - Ky0gD; j++)
					if (sortedString[j + 1].compareToIgnoreCase(sortedString[j]) < 0) {
						String swap = sortedString[j];
						sortedString[j] = sortedString[j + 1];
						sortedString[j + 1] = swap;
					}
				Ky0gD++;
			}
		} else {
			int I3UEg = sortedString.length - 2;
			while (I3UEg >= 0) {
				for (int j = sortedString.length - 2 - I3UEg; j >= 0; j--)
					if (sortedString[j + 1].compareToIgnoreCase(sortedString[j]) > 0) {
						String swap = sortedString[j];
						sortedString[j] = sortedString[j + 1];
						sortedString[j + 1] = swap;
					}
				I3UEg--;
			}
		}
		return sortedString;
	}

}