    @Before
    public void setUp() throws Exception {
        connectionDigestHandler = new ConnectionDigestHandlerDefaultImpl();
        URL url = null;
        try {
            url = new URL("http://dev2dev.bea.com.cn/bbs/servlet/D2DServlet/download/64104-35000-204984-2890/webwork2guide.pdf");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            uc = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
