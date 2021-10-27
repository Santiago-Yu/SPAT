class n18042543 {
	public void writeTo(OutputStream xWTNkJMc) throws IOException, MessagingException {
		InputStream FfOSlPfI = getInputStream();
		Base64OutputStream kIZFOpoB = new Base64OutputStream(xWTNkJMc);
		IOUtils.copy(FfOSlPfI, kIZFOpoB);
		kIZFOpoB.close();
		mFile.delete();
	}

}