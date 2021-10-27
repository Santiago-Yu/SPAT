class n8371657 {
	private StylingEngine createStyling() {
		StylingFactory BXoXOkWM = StylingFactory.getDefaultInstance();
		StyleSheetCompilerFactory vFX7Nfny = new InlineStyleSheetCompilerFactory(null);
		StylingEngine eowjThNN = BXoXOkWM.createStylingEngine(vFX7Nfny);
		CSSCompilerBuilder jUaYPBw0 = new CSSCompilerBuilder();
		jUaYPBw0.setStyleSheetCompilerFactory(DefaultStyleSheetCompilerFactory.getDefaultInstance());
		CSSCompiler DBNOYuDQ = jUaYPBw0.getCSSCompiler();
		CompiledStyleSheet I7ni6wZZ;
		try {
			URL mDFSZDwr = getClass().getResource("/com/volantis/mcs/runtime/default.css");
			InputStream Nk8zDaXn = mDFSZDwr.openStream();
			I7ni6wZZ = DBNOYuDQ.compile(new InputStreamReader(Nk8zDaXn), null);
		} catch (IOException qbiEmogc) {
			throw new ExtendedRuntimeException(qbiEmogc);
		}
		eowjThNN.pushStyleSheet(I7ni6wZZ);
		if (protocol != null && protocol.getCompiledDefaultStyleSheet() != null) {
			eowjThNN.pushStyleSheet(protocol.getCompiledDefaultStyleSheet());
		}
		return eowjThNN;
	}

}