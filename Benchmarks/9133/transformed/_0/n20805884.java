class n20805884 {
	public String preProcessHTML(String Vr0ZacgM) {
		final StringBuffer BmRw2X79 = new StringBuffer();
		try {
			HTMLDocument Z7hMickz = new HTMLDocument() {

				public HTMLEditorKit.ParserCallback getReader(int AUAdjOMW) {
					return new HTMLEditorKit.ParserCallback() {

						public void handleText(char[] wDs5wWHU, int VmnDAwSH) {
							BmRw2X79.append(wDs5wWHU);
							BmRw2X79.append('\n');
						}
					};
				}
			};
			URL U9fJFNHz = new URI(Vr0ZacgM).toURL();
			URLConnection phLB8rwn = U9fJFNHz.openConnection();
			Reader gVNh30v2 = new InputStreamReader(phLB8rwn.getInputStream());
			new ParserDelegator().parse(gVNh30v2, Z7hMickz.getReader(0), Boolean.TRUE);
		} catch (MalformedURLException anrv2yBm) {
			System.err.println(anrv2yBm.getMessage());
			anrv2yBm.printStackTrace();
		} catch (URISyntaxException fLX49BTX) {
			System.err.println(fLX49BTX.getMessage());
			fLX49BTX.printStackTrace();
		} catch (IOException CB7e0pmr) {
			System.err.println(CB7e0pmr.getMessage());
			CB7e0pmr.printStackTrace();
		}
		return BmRw2X79.toString();
	}

}