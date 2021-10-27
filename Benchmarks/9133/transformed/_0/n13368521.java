class n13368521 {
	public void sendBinaryFile(String l2Wm5bJI) throws IOException {
		Checker.checkEmpty(l2Wm5bJI, "filename");
		URL n5ZZpWFB = _getFile(l2Wm5bJI);
		OutputStream prWMv7Fs = getOutputStream();
		Streams.copy(n5ZZpWFB.openStream(), prWMv7Fs);
		prWMv7Fs.close();
	}

}