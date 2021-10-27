class n18490448 {
	@Deprecated
	public void encodeBegin(FacesContext bWYYQBZN, UIComponent ChuAnnmT) throws IOException {
		XUIResponseWriter YEHQhWMR = getResponseWriter();
		XUIViewRoot rQvxDV5R = (XUIViewRoot) ChuAnnmT;
		XUIResponseWriter lbDZCy2R = getResponseWriter().getHeaderWriter();
		lbDZCy2R.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<!DOCTYPE foo [\n");
		InputStream ddgK0cus = Thread.currentThread().getContextClassLoader().getResourceAsStream("xhtml-lat1.ent");
		lbDZCy2R.write(new String(IOUtils.copyByte(ddgK0cus)));
		lbDZCy2R.write("\n");
		ddgK0cus.close();
		InputStream hZutlwMu = Thread.currentThread().getContextClassLoader().getResourceAsStream("xhtml-special.ent");
		lbDZCy2R.write(new String(IOUtils.copyByte(hZutlwMu)));
		lbDZCy2R.write("\n");
		hZutlwMu.close();
		InputStream fhh9ChKt = Thread.currentThread().getContextClassLoader().getResourceAsStream("xhtml-symbol.ent");
		lbDZCy2R.write(new String(IOUtils.copyByte(fhh9ChKt)));
		lbDZCy2R.write("\n]>\n");
		fhh9ChKt.close();
		lbDZCy2R.startElement("html", ChuAnnmT);
		XUITheme C9MHp3GH = getTheme();
		if (C9MHp3GH != null) {
			lbDZCy2R.writeAttribute("style", getTheme().getHtmlStyle(), "style");
		}
		lbDZCy2R.startElement("head", ChuAnnmT);
		lbDZCy2R.startElement("base", ChuAnnmT);
		HttpServletRequest h9NckJWY = (HttpServletRequest) getRequestContext().getRequest();
		String JjEkNGD7 = (h9NckJWY.isSecure() ? "https" : "http") + "://" + h9NckJWY.getServerName()
				+ (h9NckJWY.getServerPort() == 80 ? "" : ":" + h9NckJWY.getServerPort())
				+ getRequestContext().getResourceUrl("");
		lbDZCy2R.writeAttribute("href", JjEkNGD7, "href");
		lbDZCy2R.endElement("base");
		YEHQhWMR.startElement("body", ChuAnnmT);
		if (C9MHp3GH != null && C9MHp3GH.getBodyStyle() != null) {
			YEHQhWMR.writeAttribute("style", getTheme().getBodyStyle() + ";height:100%;width:100%", "style");
		}
		lbDZCy2R.writeText('\n');
		YEHQhWMR.startElement("div", ChuAnnmT);
		YEHQhWMR.writeAttribute("id", ((XUIViewRoot) ChuAnnmT).getClientId(), "id");
		if (rQvxDV5R.findComponent(Window.class) != null) {
			YEHQhWMR.writeAttribute(HTMLAttr.CLASS, "x-panel", "");
		}
		YEHQhWMR.writeAttribute("style", "width:100%;height:100%", null);
		if (C9MHp3GH != null) {
			C9MHp3GH.addScripts(YEHQhWMR.getScriptContext());
			C9MHp3GH.addStyle(YEHQhWMR.getStyleContext());
		}
	}

}