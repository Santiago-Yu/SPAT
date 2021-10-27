class n8565955 {
	private static String webService(String w5NMj9Pv) {
		StringBuffer YQwPhEkp = new StringBuffer();
		try {
			URL HWjk623u = new URL(w5NMj9Pv);
			InputStream PSc08550 = HWjk623u.openStream();
			String YzCBQ5tR = "";
			InputStreamReader BfJXJIHG = new InputStreamReader(PSc08550, "utf-8");
			BufferedReader Z1xDJIXn = new java.io.BufferedReader(BfJXJIHG);
			while ((YzCBQ5tR = Z1xDJIXn.readLine()) != null) {
				YQwPhEkp.append(YzCBQ5tR);
			}
			return YQwPhEkp.toString();
		} catch (Exception wlNTm0Na) {
			wlNTm0Na.printStackTrace();
			return null;
		}
	}

}