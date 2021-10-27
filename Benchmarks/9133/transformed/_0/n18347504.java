class n18347504 {
	public void run() {
		try {
			System.out.println("Setting page on Cobra");
			SimpleHtmlRendererContext lt713w4J = new SimpleHtmlRendererContext(htmlPanel, new SimpleUserAgentContext());
			int IifpovQD = furl.indexOf("/", 10);
			if (IifpovQD == -1)
				IifpovQD = furl.length();
			String y1nhV8Ep = furl.substring(0, IifpovQD);
			InputStream T3w9hu2O = new URL(furl).openStream();
			BufferedReader qzXt7Yrh = new BufferedReader(new InputStreamReader(T3w9hu2O));
			String Q7RypGNT = "";
			String oIZVAELr;
			while ((oIZVAELr = qzXt7Yrh.readLine()) != null)
				Q7RypGNT += oIZVAELr;
			Q7RypGNT = borderImages(Q7RypGNT, y1nhV8Ep);
			htmlPanel.setHtml(Q7RypGNT, furl, lt713w4J);
		} catch (Exception NZ3YUPmw) {
			System.out.println("Error loading page " + furl + " : " + NZ3YUPmw);
		}
	}

}