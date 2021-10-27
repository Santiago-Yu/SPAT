class n18065573 {
	private static String executeGet(String XjbMRGJ7) {
		StringBuffer leXMaJi9 = new StringBuffer();
		try {
			Authentication.doIt();
			URL fq9TVCd6 = new URL(XjbMRGJ7);
			System.out.println("Host: " + fq9TVCd6.getHost());
			BufferedReader KLuS2t2R = new BufferedReader(new InputStreamReader(fq9TVCd6.openStream()));
			HttpURLConnection ajqdZcpK = (HttpURLConnection) fq9TVCd6.openConnection();
			ajqdZcpK.setDoInput(true);
			String i2gH8bIs;
			while ((i2gH8bIs = KLuS2t2R.readLine()) != null) {
				leXMaJi9.append(i2gH8bIs);
			}
			KLuS2t2R.close();
			ajqdZcpK.disconnect();
		} catch (MalformedURLException u1cvJyrE) {
			u1cvJyrE.printStackTrace();
		} catch (IOException X1ZkMiAI) {
			X1ZkMiAI.printStackTrace();
		}
		return leXMaJi9.toString();
	}

}