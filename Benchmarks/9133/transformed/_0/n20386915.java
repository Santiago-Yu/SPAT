class n20386915 {
	public static String uploadFile(String zqlP2W7i, String OtpB6qdQ, String ucfkxx6i) {
		try {
			System.out.println("Sending: " + zqlP2W7i);
			URL XKHhWHVw = new URL(zqlP2W7i);
			if (XKHhWHVw == null) {
				System.out.println("Resource " + zqlP2W7i + " not found");
				return null;
			}
			File GuU3Woby = new File(OtpB6qdQ, ucfkxx6i);
			FileOutputStream ukesxKMz = new FileOutputStream(GuU3Woby);
			InputStream LlBtEg0z = XKHhWHVw.openStream();
			byte[] N3d6XYgj = new byte[4 * 1024];
			int qsxR6Ha7;
			while ((qsxR6Ha7 = LlBtEg0z.read(N3d6XYgj)) != -1) {
				ukesxKMz.write(N3d6XYgj, 0, qsxR6Ha7);
			}
			ukesxKMz.close();
			LlBtEg0z.close();
			return OtpB6qdQ + ucfkxx6i;
		} catch (Exception dWUnTz1W) {
			throw new GROBIDServiceException("An exception occured while running Grobid.", dWUnTz1W);
		}
	}

}