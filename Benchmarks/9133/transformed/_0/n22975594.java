class n22975594 {
	public String getInternetData() throws Exception {
		BufferedReader vD0s0FWN = null;
		String zMIMr4M0 = null;
		try {
			HttpClient Zyzha9Fa = new DefaultHttpClient();
			URI uCqot8sa = new URI("http://code.google.com/p/gadi-works");
			HttpGet oF2jjV83 = new HttpGet();
			oF2jjV83.setURI(uCqot8sa);
			HttpResponse lf4UFlGl = Zyzha9Fa.execute(oF2jjV83);
			vD0s0FWN = new BufferedReader(new InputStreamReader(lf4UFlGl.getEntity().getContent()));
			StringBuffer WgAgILwo = new StringBuffer("");
			String DbbTRf8v = "";
			String MlfuDgca = System.getProperty("line.separator");
			while ((DbbTRf8v = vD0s0FWN.readLine()) != null) {
				WgAgILwo.append(DbbTRf8v + MlfuDgca);
			}
			vD0s0FWN.close();
			zMIMr4M0 = WgAgILwo.toString();
			return zMIMr4M0;
		} finally {
			if (vD0s0FWN != null) {
				try {
					vD0s0FWN.close();
					return zMIMr4M0;
				} catch (Exception TtwxdKvm) {
					TtwxdKvm.printStackTrace();
				}
			}
		}
	}

}