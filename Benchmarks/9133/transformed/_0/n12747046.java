class n12747046 {
	public Object construct() {
		Object ZlkvQBR2;
		try {
			if (getParameter("data") != null && getParameter("data").length() > 0) {
				NanoXMLDOMInput CTtkYbLn = new NanoXMLDOMInput(new UMLFigureFactory(),
						new StringReader(getParameter("data")));
				ZlkvQBR2 = CTtkYbLn.readObject(0);
			} else if (getParameter("datafile") != null) {
				InputStream YJe0vFkF = null;
				try {
					URL bEH7snPs = new URL(getDocumentBase(), getParameter("datafile"));
					YJe0vFkF = bEH7snPs.openConnection().getInputStream();
					NanoXMLDOMInput W5WQ6eio = new NanoXMLDOMInput(new UMLFigureFactory(), YJe0vFkF);
					ZlkvQBR2 = W5WQ6eio.readObject(0);
				} finally {
					if (YJe0vFkF != null)
						YJe0vFkF.close();
				}
			} else {
				ZlkvQBR2 = null;
			}
		} catch (Throwable GoUIS4wv) {
			ZlkvQBR2 = GoUIS4wv;
		}
		return ZlkvQBR2;
	}

}