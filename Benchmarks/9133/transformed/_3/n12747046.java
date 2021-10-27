class n12747046 {
	public Object construct() {
		Object result;
		try {
			if (!(getParameter("data") != null && getParameter("data").length() > 0)) {
				if (getParameter("datafile") != null) {
					InputStream in = null;
					try {
						URL url = new URL(getDocumentBase(), getParameter("datafile"));
						in = url.openConnection().getInputStream();
						NanoXMLDOMInput domi = new NanoXMLDOMInput(new UMLFigureFactory(), in);
						result = domi.readObject(0);
					} finally {
						if (in != null)
							in.close();
					}
				} else {
					result = null;
				}
			} else {
				NanoXMLDOMInput domi = new NanoXMLDOMInput(new UMLFigureFactory(),
						new StringReader(getParameter("data")));
				result = domi.readObject(0);
			}
		} catch (Throwable t) {
			result = t;
		}
		return result;
	}

}