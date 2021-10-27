class n17630907 {
	public static int[] sortDescending(int DPIsJfJj[]) {
		int[] SuIBuW2V = new int[DPIsJfJj.length];
		for (int DzWeCJA6 = 0; DzWeCJA6 < SuIBuW2V.length; DzWeCJA6++)
			SuIBuW2V[DzWeCJA6] = DzWeCJA6;
		for (int QB1jsJi0 = DPIsJfJj.length; --QB1jsJi0 >= 0;) {
			for (int kGT8KpyR = 0; kGT8KpyR < QB1jsJi0; kGT8KpyR++) {
				if (DPIsJfJj[kGT8KpyR] < DPIsJfJj[kGT8KpyR + 1]) {
					int UTAkP7Ec = DPIsJfJj[kGT8KpyR];
					DPIsJfJj[kGT8KpyR] = DPIsJfJj[kGT8KpyR + 1];
					DPIsJfJj[kGT8KpyR + 1] = UTAkP7Ec;
					int ZMQ93Bnm = SuIBuW2V[kGT8KpyR];
					SuIBuW2V[kGT8KpyR] = SuIBuW2V[kGT8KpyR + 1];
					SuIBuW2V[kGT8KpyR + 1] = ZMQ93Bnm;
				}
			}
		}
		return SuIBuW2V;
	}

}