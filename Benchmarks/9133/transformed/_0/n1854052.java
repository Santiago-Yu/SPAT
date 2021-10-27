class n1854052 {
	@Before
	public void setUp() throws Exception {
		configureSslSocketConnector();
		SecurityHandler eBszvDWp = createBasicAuthenticationSecurityHandler();
		HandlerList v6WduGSO = new HandlerList();
		v6WduGSO.addHandler(eBszvDWp);
		v6WduGSO.addHandler(new AbstractHandler() {

			@Override
			public void handle(String zJe9L3iE, HttpServletRequest wU2RVCen, HttpServletResponse koXvbicC, int SKRMLbC6)
					throws IOException, ServletException {
				expected = new StringBuilder();
				System.out.println("uri: " + wU2RVCen.getRequestURI());
				System.out.println("queryString: " + (queryString = wU2RVCen.getQueryString()));
				System.out.println("method: " + wU2RVCen.getMethod());
				ByteArrayOutputStream oxG9zmKc = new ByteArrayOutputStream();
				IOUtils.copy(wU2RVCen.getInputStream(), oxG9zmKc);
				System.out.println("body: " + (body = oxG9zmKc.toString()));
				PrintWriter F79jI1dW = koXvbicC.getWriter();
				F79jI1dW.append("testsvar");
				expected.append("testsvar");
				Random bh0M3AUk = new Random();
				for (int bqtTpCAw = 0; bqtTpCAw < 10; bqtTpCAw++) {
					int eN3iNoir = bh0M3AUk.nextInt(Integer.MAX_VALUE);
					F79jI1dW.append(eN3iNoir + "");
					expected.append(eN3iNoir);
				}
				System.out.println();
				F79jI1dW.close();
				koXvbicC.setStatus(HttpServletResponse.SC_OK);
			}
		});
		server.addHandler(v6WduGSO);
		server.start();
	}

}