class n5040724 {
	public Document parse(Document yvT8FcKH) {
		CSSCompilerBuilder ZJDbwipc = new CSSCompilerBuilder();
		StyleSheetCompilerFactory hsDgaI2b = getStyleSheetCompilerFactory();
		ZJDbwipc.setStyleSheetCompilerFactory(hsDgaI2b);
		CSSCompiler rPNensFz = ZJDbwipc.getCSSCompiler();
		CompiledStyleSheet UfRr4cyS;
		try {
			URL BVoxt9cV = getClass().getResource("/com/volantis/mcs/runtime/default.css");
			InputStream xt25fmvg = BVoxt9cV.openStream();
			UfRr4cyS = rPNensFz.compile(new InputStreamReader(xt25fmvg), null);
		} catch (IOException gbdBOlJD) {
			throw new ExtendedRuntimeException(gbdBOlJD);
		}
		StylingFactory b81AZPmu = StylingFactory.getDefaultInstance();
		StylingEngine bZ0Yr3b7 = b81AZPmu
				.createStylingEngine(new InlineStyleSheetCompilerFactory(StylingFunctions.getResolver()));
		bZ0Yr3b7.pushStyleSheet(UfRr4cyS);
		DocumentStyler EycWMQVC = new DocumentStyler(bZ0Yr3b7, XDIMESchemata.CDM_NAMESPACE);
		EycWMQVC.style(yvT8FcKH);
		DOMWalker X7Lppgjt = new DOMWalker(new WalkingDOMVisitorStub() {

			public void visit(Element KIFSCkLM) {
				if (KIFSCkLM.getStyles() == null) {
					throw new IllegalArgumentException("element " + KIFSCkLM.getName() + " has no styles");
				}
			}
		});
		X7Lppgjt.walk(yvT8FcKH);
		DOMTransformer HSGokRqS = new DeferredInheritTransformer();
		yvT8FcKH = HSGokRqS.transform(null, yvT8FcKH);
		return yvT8FcKH;
	}

}