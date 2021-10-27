class n12528437 {
	public static void main(String[] cg75zBFz) throws Exception {
		SocketConnector nAG4XWXt = new SocketConnector();
		nAG4XWXt.setPort(6080);
		SslSocketConnector pG5hXyAH = new SslSocketConnector();
		pG5hXyAH.setPort(6443);
		String LlTt28Jx = MockHttpListenerWithAuthentication.class.getClassLoader()
				.getResource("cert/serverkeystore.jks").getPath();
		pG5hXyAH.setKeystore(LlTt28Jx);
		pG5hXyAH.setKeyPassword("serverpass");
		String A1zawJJZ = MockHttpListenerWithAuthentication.class.getClassLoader()
				.getResource("cert/servertruststore.jks").getPath();
		pG5hXyAH.setTruststore(A1zawJJZ);
		pG5hXyAH.setTrustPassword("serverpass");
		server.addConnector(nAG4XWXt);
		server.addConnector(pG5hXyAH);
		SecurityHandler BONxMFLb = createBasicAuthenticationSecurityHandler();
		HandlerList M9xFonbY = new HandlerList();
		M9xFonbY.addHandler(BONxMFLb);
		M9xFonbY.addHandler(new AbstractHandler() {

			@Override
			public void handle(String UPz1hdPP, HttpServletRequest PfImjmjN, HttpServletResponse cUQR59f0, int SXNvKrMN)
					throws IOException, ServletException {
				System.out.println("uri: " + PfImjmjN.getRequestURI());
				System.out.println("queryString: " + PfImjmjN.getQueryString());
				System.out.println("method: " + PfImjmjN.getMethod());
				ByteArrayOutputStream DcKjBL7w = new ByteArrayOutputStream();
				IOUtils.copy(PfImjmjN.getInputStream(), DcKjBL7w);
				System.out.println("body: " + DcKjBL7w.toString());
				PrintWriter oW6Sde6k = cUQR59f0.getWriter();
				oW6Sde6k.append("testsvar");
				Random WSsvKMcY = new Random();
				for (int gCEFz9aA = 0; gCEFz9aA < 10; gCEFz9aA++) {
					int bnzdvSKp = WSsvKMcY.nextInt(Integer.MAX_VALUE);
					oW6Sde6k.append(bnzdvSKp + "");
				}
				System.out.println();
				oW6Sde6k.close();
				cUQR59f0.setStatus(HttpServletResponse.SC_OK);
			}
		});
		server.addHandler(M9xFonbY);
		server.start();
	}

}