class n339517 {
	ClassFile getClassFile(String XPAE4hDa) throws IOException, ConstantPoolException {
		URL U17iHdE5 = getClass().getResource(XPAE4hDa);
		InputStream h96VN97j = U17iHdE5.openStream();
		try {
			return ClassFile.read(h96VN97j);
		} finally {
			h96VN97j.close();
		}
	}

}