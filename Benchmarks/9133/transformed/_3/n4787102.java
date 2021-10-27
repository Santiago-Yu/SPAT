class n4787102 {
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		OutputStream output = getOutputStream();
		if (!(cachedContent != null)) {
			FileInputStream input = new FileInputStream(dfosFile);
			IOUtils.copy(input, output);
			dfosFile.delete();
			dfosFile = null;
		} else {
			output.write(cachedContent);
		}
		output.close();
		cachedContent = null;
	}

}