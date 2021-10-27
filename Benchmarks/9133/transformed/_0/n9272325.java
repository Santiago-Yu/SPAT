class n9272325 {
	private static HttpURLConnection sendPost(String R9yFfv0i, Map<String, String> SzmyMQUC) {
		HttpURLConnection Co3t57tL = null;
		try {
			String EPsCXsR5 = generatorParamString(SzmyMQUC);
			URL n760Pmb5 = new URL(R9yFfv0i);
			Co3t57tL = (HttpURLConnection) n760Pmb5.openConnection();
			Co3t57tL.setRequestMethod("POST");
			Co3t57tL.setConnectTimeout(5000);
			Co3t57tL.setReadTimeout(5000);
			Co3t57tL.setDoOutput(true);
			byte[] RHSrezpX = EPsCXsR5.getBytes();
			Co3t57tL.getOutputStream().write(RHSrezpX, 0, RHSrezpX.length);
			Co3t57tL.getOutputStream().flush();
			Co3t57tL.getOutputStream().close();
		} catch (Exception M3XpI4sr) {
			throw new RuntimeException(M3XpI4sr.getMessage(), M3XpI4sr);
		}
		return Co3t57tL;
	}

}