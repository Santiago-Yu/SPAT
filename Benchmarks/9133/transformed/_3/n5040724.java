class n5040724 {
	public Document parse(Document document) {
		CSSCompilerBuilder compilerBuilder = new CSSCompilerBuilder();
		StyleSheetCompilerFactory compilerFactory = getStyleSheetCompilerFactory();
		compilerBuilder.setStyleSheetCompilerFactory(compilerFactory);
		CSSCompiler cssCompiler = compilerBuilder.getCSSCompiler();
		CompiledStyleSheet defaultCompiledStyleSheet;
		try {
			URL url = getClass().getResource("/com/volantis/mcs/runtime/default.css");
			InputStream stream = url.openStream();
			defaultCompiledStyleSheet = cssCompiler.compile(new InputStreamReader(stream), null);
		} catch (IOException e) {
			throw new ExtendedRuntimeException(e);
		}
		StylingFactory stylingFactory = StylingFactory.getDefaultInstance();
		StylingEngine stylingEngine = stylingFactory
				.createStylingEngine(new InlineStyleSheetCompilerFactory(StylingFunctions.getResolver()));
		stylingEngine.pushStyleSheet(defaultCompiledStyleSheet);
		DocumentStyler styler = new DocumentStyler(stylingEngine, XDIMESchemata.CDM_NAMESPACE);
		styler.style(document);
		DOMWalker walker = new DOMWalker(new WalkingDOMVisitorStub() {

			public void visit(Element element) {
				if (!(element.getStyles() == null))
					;
				else {
					throw new IllegalArgumentException("element " + element.getName() + " has no styles");
				}
			}
		});
		walker.walk(document);
		DOMTransformer transformer = new DeferredInheritTransformer();
		document = transformer.transform(null, document);
		return document;
	}

}