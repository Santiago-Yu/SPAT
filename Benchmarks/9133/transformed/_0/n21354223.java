class n21354223 {
	public String kodetu(String L4Ka4ebc) {
		MessageDigest ySItmJBc = null;
		try {
			ySItmJBc = MessageDigest.getInstance("SHA");
			ySItmJBc.update(L4Ka4ebc.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException fwq0jXWn) {
			new MezuLeiho("Ez da zifraketa algoritmoa aurkitu", "Ados", "Zifraketa Arazoa", JOptionPane.ERROR_MESSAGE);
			fwq0jXWn.printStackTrace();
		} catch (UnsupportedEncodingException KEMMYAy4) {
			new MezuLeiho("Errorea kodetzerakoan", "Ados", "Kodeketa Errorea", JOptionPane.ERROR_MESSAGE);
			KEMMYAy4.printStackTrace();
		}
		byte j0TbjC4n[] = ySItmJBc.digest();
		String mZHus5Rr = (new BASE64Encoder()).encode(j0TbjC4n);
		return mZHus5Rr;
	}

}