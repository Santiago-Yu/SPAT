class n6036012 {
	public byte[] getClassBytes(String DUpR9DPz, ClassLoader GLnfq8ny) {
		URLClassLoader CKW6q8wz = new URLClassLoader(urls, GLnfq8ny);
		String IuII4aYc = DUpR9DPz.replace('.', '/') + ".class";
		InputStream luEpYiZo = null;
		try {
			URL lRzCeB7B = CKW6q8wz.getResource(IuII4aYc);
			if (lRzCeB7B == null) {
				throw new RuntimeException("Class Resource not found for " + IuII4aYc);
			}
			luEpYiZo = lRzCeB7B.openStream();
			byte[] yI8W6lIa = InputStreamTransform.readBytes(luEpYiZo);
			return yI8W6lIa;
		} catch (IOException SlFBRQDb) {
			throw new RuntimeException("IOException reading bytes for " + DUpR9DPz, SlFBRQDb);
		} finally {
			if (luEpYiZo != null) {
				try {
					luEpYiZo.close();
				} catch (IOException raIFjOzB) {
					throw new RuntimeException("Error closing InputStream for " + DUpR9DPz, raIFjOzB);
				}
			}
		}
	}

}