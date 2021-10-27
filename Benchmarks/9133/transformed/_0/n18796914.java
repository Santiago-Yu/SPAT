class n18796914 {
	public String getPloidy(String HNzQRyAV) {
		StringBuilder LJUXz4hB = new StringBuilder();
		String Bwh29j8D = customParameters.getHyperdiploidyUrl();
		String gIngfPvO = Bwh29j8D + "?source=" + HNzQRyAV;
		URL zVVwPBQB = null;
		try {
			zVVwPBQB = new URL(gIngfPvO);
			BufferedReader mLqKGODR = new BufferedReader(new InputStreamReader(zVVwPBQB.openStream()));
			String sM3PQ3NW = "";
			while ((sM3PQ3NW = mLqKGODR.readLine()) != null) {
				LJUXz4hB.append(sM3PQ3NW);
			}
		} catch (MalformedURLException WS1o16yX) {
			WS1o16yX.printStackTrace();
		} catch (IOException mcV4CeDy) {
			mcV4CeDy.printStackTrace();
		}
		return LJUXz4hB.toString();
	}

}