class n22448399 {
	private HttpURLConnection getHttpURLConnection(String Qi51vA5n) {
		StringBuffer pPU0mtEI = new StringBuffer();
		pPU0mtEI.append(getBaseServletURL());
		pPU0mtEI.append("?_BIZVIEW=").append(Qi51vA5n);
		Map<String, Object> qStXOBg7 = getInputParams();
		if (qStXOBg7 != null) {
			Set<Entry<String, Object>> gzrrflZq = qStXOBg7.entrySet();
			for (Entry<String, Object> LBt1FPM9 : gzrrflZq) {
				String FOaHwCal = LBt1FPM9.getKey();
				String T5EQN2vV = LBt1FPM9.getValue().toString();
				pPU0mtEI.append("&").append(FOaHwCal).append("=").append(T5EQN2vV);
			}
		}
		HttpURLConnection QBlr4vc3 = null;
		try {
			URL yc3VhBNf = new URL(pPU0mtEI.toString());
			QBlr4vc3 = (HttpURLConnection) yc3VhBNf.openConnection();
		} catch (IOException uKO5AQS7) {
			Assert.fail("Failed to connect to the test servlet: " + uKO5AQS7);
		}
		return QBlr4vc3;
	}

}