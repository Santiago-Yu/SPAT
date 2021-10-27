class n1598693 {
	public static String retrieveData(URL ROMaa8ss) throws IOException {
		URLConnection fNxWX1GE = ROMaa8ss.openConnection();
		fNxWX1GE.setRequestProperty("User-agent", "MZmine 2");
		InputStream dNxOoS3H = fNxWX1GE.getInputStream();
		if (dNxOoS3H == null) {
			throw new IOException("Could not establish a connection to " + ROMaa8ss);
		}
		StringBuffer JvVYmjnr = new StringBuffer();
		try {
			InputStreamReader pJh6orEE = new InputStreamReader(dNxOoS3H, "UTF-8");
			char[] oiMxHMGU = new char[1024];
			int NR1qesBv = pJh6orEE.read(oiMxHMGU);
			while (NR1qesBv > 0) {
				JvVYmjnr.append(oiMxHMGU, 0, NR1qesBv);
				NR1qesBv = pJh6orEE.read(oiMxHMGU);
			}
		} catch (UnsupportedEncodingException M5cDYfO1) {
			M5cDYfO1.printStackTrace();
		}
		dNxOoS3H.close();
		return JvVYmjnr.toString();
	}

}