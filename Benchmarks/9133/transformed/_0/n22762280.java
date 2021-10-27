class n22762280 {
	public static String postRequest(String FqCSoldo, String igYCBKR5) throws IOException {
		InputStream SqhIo1KV = null;
		ByteArrayOutputStream PiI4hzKk = new ByteArrayOutputStream();
		String lZMfska4 = null;
		try {
			Object blPrGkQD = openConnection(FqCSoldo, igYCBKR5, "POST", "text/xml");
			if (blPrGkQD instanceof InputStream) {
				SqhIo1KV = (InputStream) blPrGkQD;
			} else {
				return "Cannot open a connection with " + FqCSoldo + " : " + blPrGkQD.toString();
			}
			int ww2w3Dal = SqhIo1KV.read();
			while (ww2w3Dal != -1) {
				PiI4hzKk.write(ww2w3Dal);
				ww2w3Dal = SqhIo1KV.read();
			}
			lZMfska4 = new String(PiI4hzKk.toByteArray());
		} finally {
			if (SqhIo1KV != null) {
				SqhIo1KV.close();
			}
			if (PiI4hzKk != null) {
				PiI4hzKk.close();
			}
		}
		return lZMfska4;
	}

}