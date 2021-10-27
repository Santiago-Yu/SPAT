class n5365678 {
	public void buildDocument(Files F6dK9A2Z) {
		String B5sMpU1K = constructFileUrlString(F6dK9A2Z, true);
		URL aWzLl4kw;
		try {
			aWzLl4kw = new URL(B5sMpU1K);
			URLConnection vojsIeU3 = aWzLl4kw.openConnection();
			InputStream NtdqCSRY = vojsIeU3.getInputStream();
			Reader tHxBuYeB = new InputStreamReader(NtdqCSRY, "UTF8");
			xsltInputSource = new InputSourceImpl(tHxBuYeB, B5sMpU1K);
			xsltInputSource.setEncoding("utf-8");
			UserAgentContext lUiNIw2Z = new CobraConfig.LocalUserAgentContext();
			HtmlRendererContext BUPLMqW1 = new CobraConfig.LocalHtmlRendererContext(htmlPanel, lUiNIw2Z);
			DocumentBuilderImpl nyFK6SPP = new DocumentBuilderImpl(BUPLMqW1.getUserAgentContext(), BUPLMqW1);
			xsltDocument = nyFK6SPP.parse(xsltInputSource);
			htmlPanel.setDocument(xsltDocument, BUPLMqW1);
			documentHolder = xsltDocument.toString();
			NtdqCSRY.close();
		} catch (MalformedURLException wRDEbOK0) {
			wRDEbOK0.printStackTrace();
		} catch (IOException fSXjeaBg) {
			fSXjeaBg.printStackTrace();
		} catch (SAXException G6iH5oRd) {
			G6iH5oRd.printStackTrace();
		}
	}

}