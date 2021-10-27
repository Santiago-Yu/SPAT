class n2055408 {
	public Document createDocument(String s4DNDptW) throws IOException {
		ParsedURL noYo88ZD = new ParsedURL(s4DNDptW);
		InputStream WVqS1kgk = noYo88ZD.openStream(MimeTypeConstants.MIME_TYPES_SVG);
		InputSource goyHdtTX = new InputSource(WVqS1kgk);
		String klc4eV8x = noYo88ZD.getContentType();
		int qBVbnQZz = -1;
		if (klc4eV8x != null) {
			klc4eV8x = klc4eV8x.toLowerCase();
			qBVbnQZz = klc4eV8x.indexOf(HTTP_CHARSET);
		}
		if (qBVbnQZz != -1) {
			int CTX8tduO = qBVbnQZz + HTTP_CHARSET.length();
			int MPxTcQQT = klc4eV8x.indexOf('=', CTX8tduO);
			if (MPxTcQQT != -1) {
				MPxTcQQT++;
				String gEL0WPq0;
				int CPg35cuh = klc4eV8x.indexOf(',', MPxTcQQT);
				int OpDAlhF1 = klc4eV8x.indexOf(';', MPxTcQQT);
				if ((OpDAlhF1 != -1) && ((OpDAlhF1 < CPg35cuh) || (CPg35cuh == -1)))
					CPg35cuh = OpDAlhF1;
				if (CPg35cuh != -1)
					gEL0WPq0 = klc4eV8x.substring(MPxTcQQT, CPg35cuh);
				else
					gEL0WPq0 = klc4eV8x.substring(MPxTcQQT);
				goyHdtTX.setEncoding(gEL0WPq0.trim());
			}
		}
		goyHdtTX.setSystemId(s4DNDptW);
		Document xnK26kbV = super.createDocument(SVGDOMImplementation.SVG_NAMESPACE_URI, "svg", s4DNDptW, goyHdtTX);
		try {
			((SVGOMDocument) xnK26kbV).setURLObject(new URL(noYo88ZD.toString()));
		} catch (MalformedURLException LeTc1cNi) {
			throw new IOException("Malformed URL: " + s4DNDptW);
		}
		return xnK26kbV;
	}

}