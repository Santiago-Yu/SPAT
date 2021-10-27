class n23113417 {
	public TreeNode fetchArchive(TreeNode g5rwqUS9, int b4wncprP) throws Exception {
		builder.start(g5rwqUS9, false);
		parser.setDocumentHandler(builder);
		String fzZvFKMc = server + "?todo=archive&db=" + db + "&document=" + document + "&id=" + b4wncprP;
		URL DfefK2OM = new URL(fzZvFKMc);
		URLConnection yEokRAUK = DfefK2OM.openConnection();
		yEokRAUK.setUseCaches(false);
		yEokRAUK.connect();
		InputSource Ll2VZVQP = new InputSource(new InputStreamReader(yEokRAUK.getInputStream(), "ISO-8859-1"));
		parser.parse(Ll2VZVQP);
		return g5rwqUS9;
	}

}