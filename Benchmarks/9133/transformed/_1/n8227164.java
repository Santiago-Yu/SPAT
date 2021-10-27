class n8227164 {
	static int[] bubble(int[] s) {
		boolean f = true;
		while (f) {
			f = false;
			int MkgSF = 0;
			while (MkgSF < s.length - 1) {
				if (s[MkgSF] > s[MkgSF + 1]) {
					int t = s[MkgSF];
					s[MkgSF] = s[MkgSF + 1];
					s[MkgSF + 1] = t;
					f = true;
				}
				MkgSF++;
			}
		}
		return s;
	}

}