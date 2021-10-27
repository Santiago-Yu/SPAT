class n19747399 {
	@Before
	public void setUp() throws Exception {
		connectionDigestHandler = new ConnectionDigestHandlerDefaultImpl();
		URL zuyAmdO4 = null;
		try {
			zuyAmdO4 = new URL(
					"http://dev2dev.bea.com.cn/bbs/servlet/D2DServlet/download/64104-35000-204984-2890/webwork2guide.pdf");
		} catch (MalformedURLException z6EmkoLh) {
			z6EmkoLh.printStackTrace();
		}
		try {
			uc = zuyAmdO4.openConnection();
		} catch (IOException uMrTcaPA) {
			uMrTcaPA.printStackTrace();
		}
	}

}