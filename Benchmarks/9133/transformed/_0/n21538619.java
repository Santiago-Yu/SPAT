class n21538619 {
	public static InputStream getInputStream(URL sxAiPqFP) throws IOException {
		if (sxAiPqFP.getProtocol().equals("resource")) {
			Resources vPOO9Xnu = SpeakReceiver._context.getResources();
			String JBPbGMjd = sxAiPqFP.getFile();
			JBPbGMjd = JBPbGMjd.split("\\.[a-z0-9]{3}")[0];
			int m9E6PhuQ = vPOO9Xnu.getIdentifier(JBPbGMjd, "raw", "com.l1ghtm4n.text2speech");
			if (m9E6PhuQ == 0) {
				throw new NotFoundException();
			} else
				return vPOO9Xnu.openRawResource(m9E6PhuQ);
		} else {
			return sxAiPqFP.openStream();
		}
	}

}