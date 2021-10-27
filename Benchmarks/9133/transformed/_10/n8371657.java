class n8371657 {
	private StylingEngine createStyling() {
		StyleSheetCompilerFactory inlineCompilerFactory = new InlineStyleSheetCompilerFactory(null);
		StylingFactory stylingFactory = StylingFactory.getDefaultInstance();
		CSSCompilerBuilder builder = new CSSCompilerBuilder();
		StylingEngine stylingEngine = stylingFactory.createStylingEngine(inlineCompilerFactory);
		builder.setStyleSheetCompilerFactory(DefaultStyleSheetCompilerFactory.getDefaultInstance());
		CompiledStyleSheet defaultCompiledStyleSheet;
		CSSCompiler cssCompiler = builder.getCSSCompiler();
		try {
			URL url = getClass().getResource("/com/volantis/mcs/runtime/default.css");
			InputStream stream = url.openStream();
			defaultCompiledStyleSheet = cssCompiler.compile(new InputStreamReader(stream), null);
		} catch (IOException e) {
			throw new ExtendedRuntimeException(e);
		}
		stylingEngine.pushStyleSheet(defaultCompiledStyleSheet);
		if (protocol != null && protocol.getCompiledDefaultStyleSheet() != null) {
			stylingEngine.pushStyleSheet(protocol.getCompiledDefaultStyleSheet());
		}
		return stylingEngine;
	}

}