class n7254343 {
	public void manageRequest(Transformer kQlghrFs) throws ServletException {
		try {
			this.parser.reset();
			String yqZdjg0h = URLEncoder.encode(this.query, "ISO-8859-1");
			URL iSaSfUSl = new URL(EXIST_SERVER + "?_query=" + yqZdjg0h);
			InputStream xbyHMA7e = iSaSfUSl.openStream();
			Document cwU7rpUk = this.parser.parse(xbyHMA7e);
			Source cxCjr828 = new DOMSource(cwU7rpUk);
			kQlghrFs.transform(cxCjr828, new StreamResult(this.getOut()));
		} catch (TransformerException B93DlakI) {
			B93DlakI.printStackTrace();
		} catch (UnsupportedEncodingException YP6hIxIR) {
			YP6hIxIR.printStackTrace();
		} catch (MalformedURLException hZ6L0RwT) {
			hZ6L0RwT.printStackTrace();
		} catch (IOException XTgrrSb1) {
			XTgrrSb1.printStackTrace();
		} catch (SAXException lxnWGMmg) {
			lxnWGMmg.printStackTrace();
		}
	}

}