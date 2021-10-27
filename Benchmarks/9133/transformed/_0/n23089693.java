class n23089693 {
	public int NthLowestSkill(int tkcc7tXM) {
		int[] f9BB1Pb1 = new int[] { 0, 1, 2, 3 };
		for (int Sc5lEwrA = 0; Sc5lEwrA < 3; Sc5lEwrA++) {
			for (int bAq7c3jX = 0; bAq7c3jX < 3 - Sc5lEwrA; bAq7c3jX++) {
				if (Skills()[f9BB1Pb1[bAq7c3jX]] > Skills()[f9BB1Pb1[bAq7c3jX + 1]]) {
					int WoT7AMlM = f9BB1Pb1[bAq7c3jX];
					f9BB1Pb1[bAq7c3jX] = f9BB1Pb1[bAq7c3jX + 1];
					f9BB1Pb1[bAq7c3jX + 1] = WoT7AMlM;
				}
			}
		}
		return f9BB1Pb1[tkcc7tXM - 1];
	}

}