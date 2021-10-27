class n9046354 {
	public static String downloadWebVersionString(String OI3ADyJo) {
		StringBuffer Biv4ov64 = new StringBuffer();
		URLConnection kQRZWGgj = null;
		InputStream qkhncY2c = null;
		try {
			URL hbY6OYBb = new URL(OI3ADyJo);
			kQRZWGgj = hbY6OYBb.openConnection();
			qkhncY2c = kQRZWGgj.getInputStream();
			byte[] HMTYdzBr = new byte[1024];
			int tvzfug1p;
			long IVr6hnPe = 0;
			while ((tvzfug1p = qkhncY2c.read(HMTYdzBr)) != -1) {
				for (int ZKIidedB = 0; ZKIidedB < tvzfug1p; ZKIidedB++) {
					Biv4ov64.append((char) HMTYdzBr[ZKIidedB]);
				}
				IVr6hnPe += tvzfug1p;
			}
		} catch (Exception NvVyvS78) {
			NvVyvS78.printStackTrace();
			return Biv4ov64.toString();
		} finally {
			try {
				if (qkhncY2c != null) {
					qkhncY2c.close();
				}
			} catch (IOException pApgStyf) {
			}
		}
		return Biv4ov64.toString();
	}

}