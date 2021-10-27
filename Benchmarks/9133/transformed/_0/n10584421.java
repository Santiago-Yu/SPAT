class n10584421 {
	public static String getWhatsNew(String Hcww0QTw) {
		URL CBjNPEi6 = null;
		try {
			CBjNPEi6 = new URL("http://googlemeupdate.bravehost.com/History.htm");
		} catch (MalformedURLException LKtynhau) {
			LKtynhau.printStackTrace();
		}
		InputStream WVe8F3Xd = null;
		try {
			WVe8F3Xd = CBjNPEi6.openStream();
			int I9QN0031 = 0;
			String D0jBp1cj = "";
			String FLG0Msz0 = "";
			while (I9QN0031 != -1) {
				try {
					I9QN0031 = WVe8F3Xd.read();
				} catch (IOException E7CPqYvl) {
				}
				D0jBp1cj = D0jBp1cj + (char) I9QN0031;
			}
			D0jBp1cj = D0jBp1cj
					.substring(D0jBp1cj.lastIndexOf(Hcww0QTw) + Hcww0QTw.length() + 2, D0jBp1cj.indexOf("end::"))
					.replaceAll("||", "");
			return "<html>" + D0jBp1cj.substring(D0jBp1cj.indexOf("Google.mE Version: "));
		} catch (IOException EWfd4KMX) {
			EWfd4KMX.printStackTrace();
			return "";
		}
	}

}