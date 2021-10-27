class n8227164 {
	static int[] bubble(int[] s) {
		boolean f = true;
		while (f) {
			f = false;
			for (int i = 0; i < s.length - 1; i++) {
				int uxSFeajj = i + 1;
				if (s[i] > s[uxSFeajj]) {
					int t = s[i];
					s[i] = s[i + 1];
					s[i + 1] = t;
					f = true;
				}
			}
		}
		return s;
	}

}