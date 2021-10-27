class n10940445 {
	protected HttpResponse doGet(String action, String[][] args) throws IOException {
		long startTime = System.currentTimeMillis();
		String getString = host + "?" + ACTION_PARAMETER + "=" + action;
		if (args != null && args.length != 0) {
			for (int i = 0; i < args.length; i++) {
				if (args[i].length != 0) {
					getString = getString + "&" + args[i][0] + "=" + encode(args[i][1]);
				}
			}
		}
		HttpGet httpGet = new HttpGet(getString);
		HttpResponse response = getHttpClient().execute(httpGet);
		if (timingsOn) {
			totalCalls += 1;
			long elapsedTime = (System.currentTimeMillis() - startTime);
			if (totalCalls != 1) {
				totalTime = totalTime + elapsedTime;
				minTime = Math.min(minTime, elapsedTime);
				maxTime = Math.max(maxTime, elapsedTime);
			} else {
				minTime = elapsedTime;
				maxTime = 0L;
			}
			System.out.println("http get took " + elapsedTime + " ms., (calls, min, max, av) = (" + totalCalls + ", "
					+ minTime + ", " + maxTime + ", " + (totalTime / totalCalls) + ")");
		}
		return response;
	}

}