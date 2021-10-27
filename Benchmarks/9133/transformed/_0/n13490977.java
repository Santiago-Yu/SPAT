class n13490977 {
	private void readObject(ObjectInputStream JbQU4W5v) throws IOException, ClassNotFoundException {
		JbQU4W5v.defaultReadObject();
		OutputStream TJMLvTh9 = getOutputStream();
		if (cachedContent != null) {
			TJMLvTh9.write(cachedContent);
		} else {
			FileInputStream L5uhCbxr = new FileInputStream(dfosFile);
			IOUtils.copy(L5uhCbxr, TJMLvTh9);
			dfosFile.delete();
			dfosFile = null;
		}
		TJMLvTh9.close();
		cachedContent = null;
	}

}