class n3197876 {
	public ArrayList<String> showTopLetters() {
		int[] isdWp3Xc = new int[engCountLetters.length];
		char[] udBJO5kt = new char[abcEng.length];
		ArrayList<String> hEhs80mv = new ArrayList<String>();
		isdWp3Xc = engCountLetters.clone();
		udBJO5kt = abcEng.clone();
		int uAHPPB59;
		char YDcatN1d;
		for (int jmkwxtc4 = 0; jmkwxtc4 < (abcEng.length * abcEng.length); jmkwxtc4++) {
			for (int acAtPDyP = 0; acAtPDyP < abcEng.length - 1; acAtPDyP++) {
				if (isdWp3Xc[acAtPDyP] > isdWp3Xc[acAtPDyP + 1]) {
					uAHPPB59 = isdWp3Xc[acAtPDyP];
					YDcatN1d = udBJO5kt[acAtPDyP];
					isdWp3Xc[acAtPDyP] = isdWp3Xc[acAtPDyP + 1];
					udBJO5kt[acAtPDyP] = udBJO5kt[acAtPDyP + 1];
					isdWp3Xc[acAtPDyP + 1] = uAHPPB59;
					udBJO5kt[acAtPDyP + 1] = YDcatN1d;
				}
			}
		}
		for (int qye0Xr0C = udBJO5kt.length - 1; qye0Xr0C > udBJO5kt.length - 6; qye0Xr0C--) {
			hEhs80mv.add(udBJO5kt[qye0Xr0C] + ":" + isdWp3Xc[qye0Xr0C]);
		}
		return hEhs80mv;
	}

}