class n18305036 {
	@Override
	protected Drawing construct() throws IOException {
		Drawing h9jsvvz9;
		System.out.println("getParameter.datafile:" + getParameter("datafile"));
		if (getParameter("data") != null) {
			NanoXMLDOMInput Wg65AgMO = new NanoXMLDOMInput(new NetFactory(), new StringReader(getParameter("data")));
			h9jsvvz9 = (Drawing) Wg65AgMO.readObject(0);
		} else if (getParameter("datafile") != null) {
			URL HM7fi1BI = new URL(getDocumentBase(), getParameter("datafile"));
			InputStream WYGBvKvv = HM7fi1BI.openConnection().getInputStream();
			try {
				NanoXMLDOMInput YWZWrGnD = new NanoXMLDOMInput(new NetFactory(), WYGBvKvv);
				h9jsvvz9 = (Drawing) YWZWrGnD.readObject(0);
			} finally {
				WYGBvKvv.close();
			}
		} else {
			h9jsvvz9 = null;
		}
		return h9jsvvz9;
	}

}