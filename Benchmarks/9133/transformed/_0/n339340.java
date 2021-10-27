class n339340 {
	ClassFile getClassFile(String mIG7ErvB) throws IOException, ConstantPoolException {
		URL vmPE8RMb = getClass().getResource(mIG7ErvB);
		InputStream fwJjUUp8 = vmPE8RMb.openStream();
		try {
			return ClassFile.read(fwJjUUp8);
		} finally {
			fwJjUUp8.close();
		}
	}

}