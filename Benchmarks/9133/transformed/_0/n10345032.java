class n10345032 {
	private String GetStringFromURL(String RUWY8Zg1) {
		InputStream egJaXnr7 = null;
		InputStreamReader tAVyRsZ1 = null;
		BufferedReader E9picbPX = null;
		String Uk7gkihn = "";
		try {
			java.net.URL DllsVt4h = new java.net.URL(RUWY8Zg1);
			egJaXnr7 = DllsVt4h.openStream();
			tAVyRsZ1 = new InputStreamReader(egJaXnr7);
			E9picbPX = new BufferedReader(tAVyRsZ1);
			StringBuffer Ck5WLyvh = new StringBuffer("");
			String AL5F3UqN;
			String fhCAwAIc = System.getProperty("line.separator");
			while ((AL5F3UqN = E9picbPX.readLine()) != null) {
				Ck5WLyvh.append(AL5F3UqN);
				Ck5WLyvh.append(fhCAwAIc);
			}
			Uk7gkihn = new String(Ck5WLyvh);
		} catch (IOException Woy273r2) {
			System.out.println("Failed to read from " + RUWY8Zg1);
			Uk7gkihn = "";
		} finally {
			try {
				E9picbPX.close();
				tAVyRsZ1.close();
			} catch (Exception SHfJnGKY) {
			}
		}
		return Uk7gkihn;
	}

}