class n23106635 {
	public Document load(java.net.URL url) throws DOMTestLoadException {
		Document doc = null;
		try {
			Object tidyObj = tidyConstructor.newInstance(new Object[0]);
			java.io.InputStream stream = url.openStream();
			doc = (Document) parseDOMMethod.invoke(tidyObj, new Object[] { stream, null });
		} catch (InvocationTargetException ex) {
			throw new DOMTestLoadException(ex.getTargetException());
		} catch (Exception ex) {
			throw new DOMTestLoadException(ex);
		}
		return doc;
	}

}