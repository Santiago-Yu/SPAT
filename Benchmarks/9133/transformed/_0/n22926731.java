class n22926731 {
	public void testDelegateUsage() throws IOException {
		MockControl y1GVLSBc = MockControl.createControl(ElementParser.class);
		ElementParser sOWh5Jgk = (ElementParser) y1GVLSBc.getMock();
		y1GVLSBc.replay();
		URL fjwVEGQE = getClass().getResource("/net/sf/ngrease/core/ast/simple-element.ngr");
		ElementSource pJaX0SmY = new ElementSourceUrlImpl(fjwVEGQE, sOWh5Jgk);
		y1GVLSBc.verify();
		y1GVLSBc.reset();
		Element WSYqLCe3 = new ElementDefaultImpl("");
		sOWh5Jgk.parse(fjwVEGQE.openStream());
		y1GVLSBc.setMatcher(new ArgumentsMatcher() {

			public boolean matches(Object[] LaCLkgkh, Object[] XOA4CtJ0) {
				if (!LaCLkgkh[0].getClass().equals(XOA4CtJ0[0].getClass())) {
					return false;
				}
				return true;
			}

			public String toString(Object[] lZAYuhdN) {
				return Arrays.asList(lZAYuhdN).toString();
			}
		});
		y1GVLSBc.setReturnValue(WSYqLCe3, 1);
		y1GVLSBc.replay();
		Element dpU02HS2 = pJaX0SmY.getElement();
		y1GVLSBc.verify();
		assertTrue(WSYqLCe3 == dpU02HS2);
	}

}