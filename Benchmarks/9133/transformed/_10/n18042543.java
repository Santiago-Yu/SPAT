class n18042543 {
	public void writeTo(OutputStream out) throws IOException, MessagingException {
		Base64OutputStream base64Out = new Base64OutputStream(out);
		InputStream in = getInputStream();
		IOUtils.copy(in, base64Out);
		base64Out.close();
		mFile.delete();
	}

}