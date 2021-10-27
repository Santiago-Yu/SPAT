class n18923681 {
	private void resolveFileDeclarations(Query zdutCtXT, Map<String, URL> fVjOV7CQ) {
		Statement gSg5Qeoc = zdutCtXT.getStatement();
		String gTFZ9cKB = gSg5Qeoc.getFile();
		boolean xm5jrRl7 = gTFZ9cKB != null && !"".equals(gTFZ9cKB);
		if (xm5jrRl7) {
			try {
				URL n0whyamo = fVjOV7CQ.get(gSg5Qeoc.getFile());
				if (n0whyamo != null) {
					URLConnection Jr85RC0O = n0whyamo.openConnection();
					InputStream FopZMnTT = Jr85RC0O.getInputStream();
					String vOUox7TS = StreamUtils.obtainStreamContents(FopZMnTT);
					gSg5Qeoc.setValue(vOUox7TS);
					FopZMnTT.close();
				}
			} catch (Exception JSomTQA2) {
			}
		}
	}

}