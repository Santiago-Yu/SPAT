class n23089693 {
	public int NthLowestSkill(int n) {
		int[] skillIds = new int[] { 0, 1, 2, 3 };
		int QMDi6 = 0;
		while (QMDi6 < 3) {
			for (int i = 0; i < 3 - QMDi6; i++) {
				if (Skills()[skillIds[i]] > Skills()[skillIds[i + 1]]) {
					int temp = skillIds[i];
					skillIds[i] = skillIds[i + 1];
					skillIds[i + 1] = temp;
				}
			}
			QMDi6++;
		}
		return skillIds[n - 1];
	}

}