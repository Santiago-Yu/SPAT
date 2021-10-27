class n12985466 {
	@Override
	protected Map<String, Definition> loadDefinitionsFromURL(URL u926JTnA) {
		Map<String, Definition> rdGoC8dy = null;
		try {
			URLConnection xg6qjVfJ = u926JTnA.openConnection();
			xg6qjVfJ.connect();
			lastModifiedDates.put(u926JTnA.toExternalForm(), xg6qjVfJ.getLastModified());
			rdGoC8dy = reader.read(xg6qjVfJ.getInputStream());
		} catch (IOException ZUYgB8fK) {
			if (log.isDebugEnabled()) {
				log.debug("File " + null + " not found, continue [" + ZUYgB8fK.getMessage() + "]");
			}
		}
		return rdGoC8dy;
	}

}