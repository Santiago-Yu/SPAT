class n11312019 {
	public static String sendGetRequest(String HXW9eNqc, String PPCZxmAp) {
		String I9wgdxUm = null;
		if (HXW9eNqc.startsWith("http://")) {
			try {
				System.setProperty("java.net.useSystemProxies", "true");
				String plqcdVHc = HXW9eNqc;
				if (PPCZxmAp != null && PPCZxmAp.length() > 0) {
					plqcdVHc += "?" + PPCZxmAp;
				}
				URL ssWVV3eW = new URL(plqcdVHc);
				URLConnection xTkT5CZp = ssWVV3eW.openConnection();
				BufferedReader myvcyIHZ = new BufferedReader(new InputStreamReader(xTkT5CZp.getInputStream()));
				StringBuffer HB5ayaBZ = new StringBuffer();
				String sY8Glhnq;
				while ((sY8Glhnq = myvcyIHZ.readLine()) != null) {
					HB5ayaBZ.append(sY8Glhnq + "\n");
				}
				myvcyIHZ.close();
				I9wgdxUm = HB5ayaBZ.toString();
			} catch (Exception FLWuqT0P) {
				DebuggerQueue.addDebug(HTTPClient.class.getName(), Level.ERROR,
						"Error during download url %s error: %s", HXW9eNqc, FLWuqT0P.getMessage());
			}
		}
		return I9wgdxUm;
	}

}