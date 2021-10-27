class n20377776 {
	public static void assertEquals(String xmlpath, Object actualObject) throws Exception {
		InputStreamReader isr;
		try {
			isr = new FileReader(xmlpath);
		} catch (FileNotFoundException e) {
			URL url = AssertHelper.class.getClassLoader().getResource(xmlpath);
			if (null != url) {
				try {
					isr = new InputStreamReader(url.openStream());
				} catch (Exception e1) {
					throw new AssertionFailedError("Unable to find output xml : " + xmlpath);
				}
			} else {
				throw new AssertionFailedError("Could not read output xml : " + xmlpath);
			}
		}
		DOMParser parser = new DOMParser();
		parser.parse(new InputSource(isr));
		Document document = parser.getDocument();
		try {
			assertEqual(document.getDocumentElement(), actualObject);
		} catch (AssertionFailedError e) {
			String message = null;
			message = (null != e.getCause()) ? e.getCause().getMessage() : e.getMessage();
			StringBuffer sbf = new StringBuffer(message + " \n " + xmlpath);
			Iterator iter = nodestack.iterator();
			while (iter.hasNext()) {
				sbf.append(" -> " + ((Object[]) iter.next())[0]);
				iter.remove();
			}
			AssertionFailedError a = new AssertionFailedError(sbf.toString());
			a.setStackTrace(e.getStackTrace());
			throw a;
		} catch (Exception e) {
			String message = null;
			message = (null != e.getCause()) ? e.getCause().getMessage() : e.getMessage();
			StringBuffer sbf = new StringBuffer(message + " \n " + xmlpath);
			Iterator iter = nodestack.iterator();
			while (iter.hasNext()) {
				sbf.append(" -> " + ((Object[]) iter.next())[0]);
				iter.remove();
			}
			Exception ex = new Exception(sbf.toString());
			ex.setStackTrace(e.getStackTrace());
			throw ex;
		}
	}

}