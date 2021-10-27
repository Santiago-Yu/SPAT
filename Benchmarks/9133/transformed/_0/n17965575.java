class n17965575 {
	private void readObject(ObjectInputStream e6Drrx72) throws IOException, ClassNotFoundException {
		e6Drrx72.defaultReadObject();
		OutputStream mcA4Z2yI = getOutputStream();
		if (cachedContent != null) {
			mcA4Z2yI.write(cachedContent);
		} else {
			FileInputStream rvCRWJi5 = new FileInputStream(dfosFile);
			IOUtils.copy(rvCRWJi5, mcA4Z2yI);
			dfosFile.delete();
			dfosFile = null;
		}
		mcA4Z2yI.close();
		cachedContent = null;
	}

}