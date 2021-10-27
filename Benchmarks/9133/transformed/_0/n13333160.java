class n13333160 {
	private void run(Reader cnk5ZbKr, OutputStream npTtIgip) throws IOException, SAXException {
		Document Fk3rBrsj = null;
		try {
			DocumentBuilderFactory PMGGMnny = DocumentBuilderFactory.newInstance();
			PMGGMnny.setNamespaceAware(false);
			PMGGMnny.setCoalescing(true);
			PMGGMnny.setIgnoringComments(true);
			PMGGMnny.setValidating(false);
			DocumentBuilder l4s2ylNf = PMGGMnny.newDocumentBuilder();
			Fk3rBrsj = l4s2ylNf.parse(new InputSource(cnk5ZbKr));
		} catch (ParserConfigurationException nU1t4tb5) {
			throw new IOException(nU1t4tb5);
		}
		Element KEBFJiLF = Fk3rBrsj.getDocumentElement();
		if (KEBFJiLF == null)
			throw new SAXException("Not root in document");
		Attr TjQvKVxd = KEBFJiLF.getAttributeNode("label");
		if (TjQvKVxd == null)
			KEBFJiLF.setAttribute("label", "Wikipedia");
		Menu UG0ozXlO = parseMenu(KEBFJiLF);
		UG0ozXlO.id = "menuWikipedia";
		ZipOutputStream Dj8kCo08 = new ZipOutputStream(npTtIgip);
		String qAf9M3Uz = ResourceUtils.getContent(XUL4Wikipedia.class, "chrome.manifest");
		addEntry(Dj8kCo08, "chrome.manifest", qAf9M3Uz);
		qAf9M3Uz = ResourceUtils.getContent(XUL4Wikipedia.class, "install.rdf");
		addEntry(Dj8kCo08, "install.rdf", qAf9M3Uz);
		qAf9M3Uz = ResourceUtils.getContent(XUL4Wikipedia.class, "library.js");
		addDir(Dj8kCo08, "chrome/");
		addDir(Dj8kCo08, "chrome/content/");
		addDir(Dj8kCo08, "chrome/skin/");
		String cOLHFqGw = "/*INSERT_CMD_HERE*/";
		int Bmiam1bP = qAf9M3Uz.indexOf(cOLHFqGw);
		if (Bmiam1bP == -1)
			throw new RuntimeException("where is " + cOLHFqGw + " ??");
		ZipEntry F8WoPOTQ = new ZipEntry("chrome/content/library.js");
		Dj8kCo08.putNextEntry(F8WoPOTQ);
		PrintWriter wZiRrjXq = new PrintWriter(Dj8kCo08);
		wZiRrjXq.write(qAf9M3Uz.substring(0, Bmiam1bP));
		UG0ozXlO.toJS(wZiRrjXq);
		wZiRrjXq.write(qAf9M3Uz.substring(Bmiam1bP + cOLHFqGw.length()));
		wZiRrjXq.flush();
		Dj8kCo08.closeEntry();
		F8WoPOTQ = new ZipEntry("chrome/content/menu.xul");
		Dj8kCo08.putNextEntry(F8WoPOTQ);
		wZiRrjXq = new PrintWriter(Dj8kCo08);
		wZiRrjXq.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		wZiRrjXq.println("<overlay id=\"xul4wikipedia\" xmlns=\"" + XUL.NS + "\">");
		wZiRrjXq.println("<script src=\"library.js\"/>");
		wZiRrjXq.println("<popup id=\"contentAreaContextMenu\">");
		wZiRrjXq.println("<menuseparator/>");
		UG0ozXlO.toXUL(wZiRrjXq);
		wZiRrjXq.println("</popup>");
		wZiRrjXq.println("</overlay>");
		wZiRrjXq.flush();
		Dj8kCo08.closeEntry();
		InputStream cXaIsNHG = XUL4Wikipedia.class.getResourceAsStream("32px-Wikipedia-logo.png");
		if (cXaIsNHG == null)
			throw new IOException("Cannot get icon");
		F8WoPOTQ = new ZipEntry("chrome/skin/wikipedia.png");
		Dj8kCo08.putNextEntry(F8WoPOTQ);
		IOUtils.copyTo(cXaIsNHG, Dj8kCo08);
		Dj8kCo08.closeEntry();
		Dj8kCo08.finish();
		Dj8kCo08.flush();
	}

}