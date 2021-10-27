class n5933080 {
	public void addUser(String d4MecPwj, String q7fRU9Gg, String kBVA3gvt) {
		String r56DSh36 = "";
		try {
			open(kBVA3gvt);
			MessageDigest a8FEipAU = MessageDigest.getInstance("MD5");
			a8FEipAU.update(q7fRU9Gg.getBytes());
			byte[] xUYrBqKP = a8FEipAU.digest();
			StringBuffer ZLsBOHa6 = new StringBuffer();
			for (int WKTinA4S = 0; WKTinA4S < xUYrBqKP.length; WKTinA4S++) {
				q7fRU9Gg = Integer.toHexString(255 & xUYrBqKP[WKTinA4S]);
				if (q7fRU9Gg.length() < 2) {
					q7fRU9Gg = "0" + q7fRU9Gg;
				}
				ZLsBOHa6.append(q7fRU9Gg);
				r56DSh36 = d4MecPwj + " " + ZLsBOHa6 + "\r\n";
			}
			try {
				long MyhGI85Z = file.length();
				file.seek(MyhGI85Z);
				file.write(r56DSh36.getBytes());
			} catch (IOException mwHydAfu) {
				mwHydAfu.printStackTrace();
			}
			close();
		} catch (NoSuchAlgorithmException qqefevfY) {
		}
	}

}