class n19886621 {
	private void doPOST(HttpURLConnection IZVkq3BD, InputStream CugxGsEe) throws MessageServiceException {
		try {
			OutputStream BYqueHOt = new BufferedOutputStream(IZVkq3BD.getOutputStream());
			IOUtils.copyAndClose(CugxGsEe, BYqueHOt);
			IZVkq3BD.connect();
		} catch (IOException Wx2ZsZRY) {
			throw new MessageServiceException(Wx2ZsZRY.getMessage(), Wx2ZsZRY);
		}
	}

}