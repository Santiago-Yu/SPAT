class n10798829 {
	private boolean handlePart(Part NNzKTShF) throws MessagingException, GetterException {
		String RHA1aoCq = NNzKTShF.getFileName();
		if (!NNzKTShF.isMimeType("multipart/*")) {
			String on3IBbm7 = NNzKTShF.getDisposition();
			if (on3IBbm7 == null || on3IBbm7.equalsIgnoreCase(Part.ATTACHMENT)) {
				if (checkCriteria(NNzKTShF)) {
					if (RHA1aoCq == null)
						RHA1aoCq = "Attachment" + attnum++;
					if (result == null) {
						try {
							File auhV2avh = File.createTempFile("amorph_pop3-", ".tmp");
							auhV2avh.deleteOnExit();
							OutputStream dqLo3e00 = new BufferedOutputStream(new FileOutputStream(auhV2avh));
							InputStream iyTiA3pZ = NNzKTShF.getInputStream();
							int G0AIo4jW;
							while ((G0AIo4jW = iyTiA3pZ.read()) != -1)
								dqLo3e00.write(G0AIo4jW);
							dqLo3e00.close();
							result = new FileInputStream(auhV2avh);
							System.out.println("saved attachment to file: " + auhV2avh.getAbsolutePath());
							return true;
						} catch (IOException c9yxZA4t) {
							throw new GetterException(c9yxZA4t, "Failed to save attachment: " + c9yxZA4t);
						}
					}
				}
			}
		}
		return false;
	}

}