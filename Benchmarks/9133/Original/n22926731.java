class n22926731{
    public void testDelegateUsage() throws IOException {
        MockControl elementParserControl = MockControl.createControl(ElementParser.class);
        ElementParser elementParser = (ElementParser) elementParserControl.getMock();
        elementParserControl.replay();
        URL url = getClass().getResource("/net/sf/ngrease/core/ast/simple-element.ngr");
        ElementSource source = new ElementSourceUrlImpl(url, elementParser);
        elementParserControl.verify();
        elementParserControl.reset();
        Element element = new ElementDefaultImpl("");
        elementParser.parse(url.openStream());
        elementParserControl.setMatcher(new ArgumentsMatcher() {

            public boolean matches(Object[] arg0, Object[] arg1) {
                if (!arg0[0].getClass().equals(arg1[0].getClass())) {
                    return false;
                }
                return true;
            }

            public String toString(Object[] arg0) {
                return Arrays.asList(arg0).toString();
            }
        });
        elementParserControl.setReturnValue(element, 1);
        elementParserControl.replay();
        Element elementAgain = source.getElement();
        elementParserControl.verify();
        assertTrue(element == elementAgain);
    }

}