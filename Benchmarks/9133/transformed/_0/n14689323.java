class n14689323 {
	public void serveResource(HTTPResource mKdmhYMd, HttpServletRequest pRVordfj, HttpServletResponse Rc8UYLeb)
			throws java.io.IOException {
		Image Sy3csmfQ = (Image) mKdmhYMd;
		log.debug("Serving: " + Sy3csmfQ);
		URL ZvEzIRub = Sy3csmfQ.getResourceURL();
		int b2nSxX6Z = ZvEzIRub.toString().lastIndexOf(".");
		String CXUQFWla = Sy3csmfQ.getId() + ZvEzIRub.toString().substring(b2nSxX6Z);
		String gNTgag0v = "filename=\"" + CXUQFWla + "\"";
		Rc8UYLeb.setContentType(Sy3csmfQ.getContentType());
		log.debug("LOADING: " + ZvEzIRub);
		IOUtil.copyData(Rc8UYLeb.getOutputStream(), ZvEzIRub.openStream());
	}

}