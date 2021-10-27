class n12194196 {
	@Test
	public void testHandleMessageInvalidSignature() throws Exception {
		KeyPair BKeZ7a8Y = MiscTestUtils.generateKeyPair();
		DateTime I7u8VGEu = new DateTime();
		DateTime avas9R6C = I7u8VGEu.plusYears(1);
		X509Certificate T2ry89Ac = MiscTestUtils.generateCertificate(BKeZ7a8Y.getPublic(), "CN=Test", I7u8VGEu,
				avas9R6C, null, BKeZ7a8Y.getPrivate(), true, 0, null, null);
		ServletConfig M0ikxpEE = EasyMock.createMock(ServletConfig.class);
		Map<String, String> X6AAdbP7 = new HashMap<String, String>();
		HttpSession LPnCjPng = EasyMock.createMock(HttpSession.class);
		HttpServletRequest UFNJyhp7 = EasyMock.createMock(HttpServletRequest.class);
		EasyMock.expect(M0ikxpEE.getInitParameter("AuditService")).andStubReturn(null);
		EasyMock.expect(M0ikxpEE.getInitParameter("AuditServiceClass")).andStubReturn(AuditTestService.class.getName());
		EasyMock.expect(M0ikxpEE.getInitParameter("SignatureService")).andStubReturn(null);
		EasyMock.expect(M0ikxpEE.getInitParameter("SignatureServiceClass"))
				.andStubReturn(SignatureTestService.class.getName());
		EasyMock.expect(UFNJyhp7.getRemoteAddr()).andStubReturn("remote-address");
		MessageDigest PLsObCPf = MessageDigest.getInstance("SHA1");
		byte[] o56ocpxJ = "hello world".getBytes();
		byte[] HOk7yJGv = PLsObCPf.digest(o56ocpxJ);
		EasyMock.expect(LPnCjPng.getAttribute(SignatureDataMessageHandler.DIGEST_VALUE_SESSION_ATTRIBUTE))
				.andStubReturn(HOk7yJGv);
		EasyMock.expect(LPnCjPng.getAttribute(SignatureDataMessageHandler.DIGEST_ALGO_SESSION_ATTRIBUTE))
				.andStubReturn("SHA-1");
		SignatureDataMessage tdvflsIT = new SignatureDataMessage();
		tdvflsIT.certificateChain = new LinkedList<X509Certificate>();
		tdvflsIT.certificateChain.add(T2ry89Ac);
		Signature eMSFamhv = Signature.getInstance("SHA1withRSA");
		eMSFamhv.initSign(BKeZ7a8Y.getPrivate());
		eMSFamhv.update("foobar-document".getBytes());
		byte[] EAAcSp7M = eMSFamhv.sign();
		tdvflsIT.signatureValue = EAAcSp7M;
		EasyMock.replay(M0ikxpEE, LPnCjPng, UFNJyhp7);
		AppletServiceServlet.injectInitParams(M0ikxpEE, this.testedInstance);
		this.testedInstance.init(M0ikxpEE);
		try {
			this.testedInstance.handleMessage(tdvflsIT, X6AAdbP7, UFNJyhp7, LPnCjPng);
			fail();
		} catch (ServletException d7OUzvXs) {
			LOG.debug("expected exception: " + d7OUzvXs.getMessage());
			EasyMock.verify(M0ikxpEE, LPnCjPng, UFNJyhp7);
			assertNull(SignatureTestService.getSignatureValue());
			assertEquals("remote-address", AuditTestService.getAuditSignatureRemoteAddress());
			assertEquals(T2ry89Ac, AuditTestService.getAuditSignatureClientCertificate());
		}
	}

}