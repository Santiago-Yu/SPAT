class n11238195{
    public void init() {
        System.out.println("Init applet...");
        int port = Integer.parseInt(getParameter("port"));
        int useUDP = Integer.parseInt(getParameter("udp"));
        boolean bUseUDP = false;
        if (useUDP > 0) bUseUDP = true;
        m_strWorld = getParameter("world");
        m_strHost = this.getCodeBase().getHost();
        try {
            new EnvironmentMap(getParameter("vrwmap"));
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        URL urlExperiment = null;
        InputStream expStream = null;
        try {
            String strPathExperiment = getParameter("experiment");
            if (strPathExperiment.length() > 0) {
                urlExperiment = new URL(getCodeBase(), strPathExperiment);
                expStream = urlExperiment.openStream();
            }
        } catch (java.net.MalformedURLException e) {
            System.out.println("Couldn't open url experiment: badly specified URL " + e.getMessage());
        } catch (Throwable t) {
            System.out.println("Couldn't open url experiment: " + t.getMessage());
        }
        try {
            System.out.println("Creating client, logging to " + m_strWorld);
            m_VRWClient = new VRWClient(m_strHost, port, true, bUseUDP);
            m_VRWClient.setInApplet(true);
            m_VRWClient.login(m_strWorld);
        } catch (java.io.IOException e) {
            System.out.println("IOException creating the VRWClient");
        }
        try {
            jsobj = JSObject.getWindow(this);
        } catch (Throwable t) {
            System.out.println("Exception getting Java Script Interface: " + t.getMessage());
        }
        refApplet = this;
        m_frmVRWConsole = new VRWConsoleFrame();
        m_frmVRWConsole.setTitle("VRW Client Console");
        m_frmVRWConsole.pack();
        m_frmVRWConsole.setSize(Math.max(300, m_frmVRWConsole.getSize().width), Math.max(200, m_frmVRWConsole.getSize().height));
        if (expStream != null) {
            System.out.println("Passing experiment stream to VRWConsoleFrame");
            m_frmVRWConsole.loadExperiment(expStream);
        }
        m_frmVRWConsole.setVisible(true);
    }

}