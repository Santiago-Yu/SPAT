class n10797166 {
	public static String readFromUrl(String QGooucRr) {
		URL UTyn9DmQ = null;
		URLConnection L23ZlBCM = null;
		BufferedReader n5J45JE3 = null;
		StringBuilder Eq7e6nzz = new StringBuilder();
		try {
			UTyn9DmQ = new URL(QGooucRr);
			L23ZlBCM = UTyn9DmQ.openConnection();
			n5J45JE3 = new BufferedReader(new InputStreamReader(L23ZlBCM.getInputStream()));
			String HY6EhJru;
			while ((HY6EhJru = n5J45JE3.readLine()) != null)
				Eq7e6nzz.append(HY6EhJru);
			n5J45JE3.close();
		} catch (IOException kaJEeoNN) {
			kaJEeoNN.printStackTrace();
		}
		return Eq7e6nzz.toString();
	}

}