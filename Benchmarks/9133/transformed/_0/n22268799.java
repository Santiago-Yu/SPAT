class n22268799 {
	@Override
	public void writeToContent(Object SCSUDEqf, String kiORRYxk, InputStream IkyO76x5)
			throws IOException, ContentException {
		if (writable) {
			URL ULrmuEIb = buildURL(kiORRYxk);
			URLConnection Gflf52d6 = ULrmuEIb.openConnection();
			OutputStream B4iimqNX = Gflf52d6.getOutputStream();
			try {
				ContentUtil.pipe(IkyO76x5, B4iimqNX);
			} finally {
				try {
					B4iimqNX.close();
				} catch (Exception EDthsfcM) {
					log.log(Level.WARNING, "unable to close " + ULrmuEIb, EDthsfcM);
				}
			}
		} else {
			throw new ContentException("not writable");
		}
	}

}