class n10174628 {
	@Override
	public T[] sort(T[] oC1vrghQ) {
		super.compareTimes = 0;
		for (int CdDvpXGD = 0; CdDvpXGD < oC1vrghQ.length; CdDvpXGD++) {
			for (int HRBMlbN0 = 0; HRBMlbN0 < oC1vrghQ.length - CdDvpXGD - 1; HRBMlbN0++) {
				super.compareTimes++;
				if (oC1vrghQ[HRBMlbN0].compareTo(oC1vrghQ[HRBMlbN0 + 1]) > 0) {
					T TM7ZpJWR = oC1vrghQ[HRBMlbN0];
					oC1vrghQ[HRBMlbN0] = oC1vrghQ[HRBMlbN0 + 1];
					oC1vrghQ[HRBMlbN0 + 1] = TM7ZpJWR;
				}
			}
		}
		return oC1vrghQ;
	}

}