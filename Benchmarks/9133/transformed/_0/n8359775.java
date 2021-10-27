class n8359775 {
	public static void shakeSort(int[] e1Zsg6EV) {
		if (e1Zsg6EV == null) {
			throw new IllegalArgumentException("Null-pointed array");
		}
		int KwFjk8CI = 0;
		int l0fPIi0j = 0;
		int q3JPjzUG = e1Zsg6EV.length - 1;
		while (q3JPjzUG - l0fPIi0j > 0) {
			KwFjk8CI = 0;
			for (int dCq0AUXG = 0; dCq0AUXG <= q3JPjzUG - 1; dCq0AUXG++) {
				if (e1Zsg6EV[dCq0AUXG] > e1Zsg6EV[dCq0AUXG + 1]) {
					KwFjk8CI = dCq0AUXG;
					int vxvKHayA = e1Zsg6EV[dCq0AUXG];
					e1Zsg6EV[dCq0AUXG] = e1Zsg6EV[dCq0AUXG + 1];
					e1Zsg6EV[dCq0AUXG + 1] = vxvKHayA;
				}
			}
			q3JPjzUG = KwFjk8CI;
			KwFjk8CI = e1Zsg6EV.length - 1;
			for (int DWv29m2B = l0fPIi0j; DWv29m2B <= q3JPjzUG - 1; DWv29m2B++) {
				if (e1Zsg6EV[DWv29m2B] > e1Zsg6EV[DWv29m2B + 1]) {
					KwFjk8CI = DWv29m2B;
					int k4Loq34t = e1Zsg6EV[DWv29m2B];
					e1Zsg6EV[DWv29m2B] = e1Zsg6EV[DWv29m2B + 1];
					e1Zsg6EV[DWv29m2B + 1] = k4Loq34t;
				}
			}
			l0fPIi0j = KwFjk8CI;
		}
	}

}