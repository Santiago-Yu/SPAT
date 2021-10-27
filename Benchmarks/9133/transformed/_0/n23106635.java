class n23106635 {
	public Document load(java.net.URL FAJ2BU1X) throws DOMTestLoadException {
		Document qJotPH8v = null;
		try {
			java.io.InputStream gouqBpve = FAJ2BU1X.openStream();
			Object nYAgbDTr = tidyConstructor.newInstance(new Object[0]);
			qJotPH8v = (Document) parseDOMMethod.invoke(nYAgbDTr, new Object[] { gouqBpve, null });
		} catch (InvocationTargetException lsnFbGTM) {
			throw new DOMTestLoadException(lsnFbGTM.getTargetException());
		} catch (Exception wB42SaTn) {
			throw new DOMTestLoadException(wB42SaTn);
		}
		return qJotPH8v;
	}

}