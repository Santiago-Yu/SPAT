class n8371657{
    private StylingEngine createStyling() {
        StylingFactory stylingFactory = StylingFactory.getDefaultInstance();
        StyleSheetCompilerFactory inlineCompilerFactory = new InlineStyleSheetCompilerFactory(null);
        StylingEngine stylingEngine = stylingFactory.createStylingEngine(inlineCompilerFactory);
        CSSCompilerBuilder builder = new CSSCompilerBuilder();
        builder.setStyleSheetCompilerFactory(DefaultStyleSheetCompilerFactory.getDefaultInstance());
        CSSCompiler cssCompiler = builder.getCSSCompiler();
        CompiledStyleSheet defaultCompiledStyleSheet;
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