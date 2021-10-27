class n4787102 {
	private void readObject(ObjectInputStream apP0pxqu) throws IOException, ClassNotFoundException {
		apP0pxqu.defaultReadObject();
		OutputStream ToK4fH9Y = getOutputStream();
		if (cachedContent != null) {
			ToK4fH9Y.write(cachedContent);
		} else {
			FileInputStream vzwJQB8s = new FileInputStream(dfosFile);
			IOUtils.copy(vzwJQB8s, ToK4fH9Y);
			dfosFile.delete();
			dfosFile = null;
		}
		ToK4fH9Y.close();
		cachedContent = null;
	}

}