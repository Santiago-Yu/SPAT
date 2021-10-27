class n13368520 {
	public void sendTextFile(String wHmzFYBR) throws IOException {
		Checker.checkEmpty(wHmzFYBR, "filename");
		URL krcxxAKf = _getFile(wHmzFYBR);
		PrintWriter qcsnZ7uo = getWriter();
		Streams.copy(new InputStreamReader(krcxxAKf.openStream()), qcsnZ7uo);
		qcsnZ7uo.close();
	}

}