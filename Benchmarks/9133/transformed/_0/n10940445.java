class n10940445 {
	protected HttpResponse doGet(String h77E3ndG, String[][] Ls6E2sR6) throws IOException {
		long huCbO9Wa = System.currentTimeMillis();
		String mWxmVsTj = host + "?" + ACTION_PARAMETER + "=" + h77E3ndG;
		if (Ls6E2sR6 != null && Ls6E2sR6.length != 0) {
			for (int poqD0bcL = 0; poqD0bcL < Ls6E2sR6.length; poqD0bcL++) {
				if (Ls6E2sR6[poqD0bcL].length != 0) {
					mWxmVsTj = mWxmVsTj + "&" + Ls6E2sR6[poqD0bcL][0] + "=" + encode(Ls6E2sR6[poqD0bcL][1]);
				}
			}
		}
		HttpGet AAJOURUm = new HttpGet(mWxmVsTj);
		HttpResponse vPOmpLvX = getHttpClient().execute(AAJOURUm);
		if (timingsOn) {
			totalCalls++;
			long XrHh8Thl = (System.currentTimeMillis() - huCbO9Wa);
			if (totalCalls != 1) {
				totalTime = totalTime + XrHh8Thl;
				minTime = Math.min(minTime, XrHh8Thl);
				maxTime = Math.max(maxTime, XrHh8Thl);
			} else {
				minTime = XrHh8Thl;
				maxTime = 0L;
			}
			System.out.println("http get took " + XrHh8Thl + " ms., (calls, min, max, av) = (" + totalCalls + ", "
					+ minTime + ", " + maxTime + ", " + (totalTime / totalCalls) + ")");
		}
		return vPOmpLvX;
	}

}