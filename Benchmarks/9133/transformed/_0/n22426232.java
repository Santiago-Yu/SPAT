class n22426232 {
	public Element rootFromURL(URL DhjcB382) throws org.jdom.JDOMException, java.io.IOException {
		Element jU14Bp5S;
		try {
			InputStream sB0skPJV = new BufferedInputStream(DhjcB382.openConnection().getInputStream());
			return getRootViaURI(verify, sB0skPJV);
		} catch (org.jdom.input.JDOMParseException WyoM8ham) {
			throw WyoM8ham;
		} catch (org.jdom.JDOMException MhhY8jdG) {
			if (!openWarn1)
				reportError1(DhjcB382.toString(), MhhY8jdG);
			openWarn1 = true;
			try {
				InputStream XhltqrBV = new BufferedInputStream(DhjcB382.openConnection().getInputStream());
				jU14Bp5S = getRootViaURL(verify, XhltqrBV);
				log.info("getRootViaURL succeeded as 2nd try");
				return jU14Bp5S;
			} catch (org.jdom.JDOMException pzeDeV6c) {
				if (!openWarn2)
					reportError2(DhjcB382.toString(), pzeDeV6c);
				openWarn2 = true;
				InputStream z3eZoIrx = new BufferedInputStream(DhjcB382.openConnection().getInputStream());
				jU14Bp5S = getRootViaRelative(verify, z3eZoIrx);
				log.info("GetRootViaRelative succeeded as 3rd try");
				new Exception().printStackTrace();
				return jU14Bp5S;
			}
		}
	}

}