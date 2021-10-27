class n14960335 {
	private String readData(URL Isflob3I) {
		try {
			BufferedReader oEnyGVWF = new BufferedReader(new InputStreamReader(Isflob3I.openStream()));
			StringBuffer Bay5ksR5 = new StringBuffer();
			String G30T9QuS;
			while ((G30T9QuS = oEnyGVWF.readLine()) != null) {
				Bay5ksR5.append(G30T9QuS);
			}
			oEnyGVWF.close();
			return new String(Bay5ksR5);
		} catch (Exception uZeqqvB8) {
			System.out.println(uZeqqvB8);
		}
		return null;
	}

}