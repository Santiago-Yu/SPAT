class n11238195 {
	public void init() {
		System.out.println("Init applet...");
		int wc7JDGCA = Integer.parseInt(getParameter("port"));
		int Gmf5Ojlq = Integer.parseInt(getParameter("udp"));
		boolean ThFZx8yB = false;
		if (Gmf5Ojlq > 0)
			ThFZx8yB = true;
		m_strWorld = getParameter("world");
		m_strHost = this.getCodeBase().getHost();
		try {
			new EnvironmentMap(getParameter("vrwmap"));
		} catch (Throwable WfuBPkKN) {
			System.out.println(WfuBPkKN.getMessage());
		}
		URL A6CXTfNu = null;
		InputStream wRvwKmyx = null;
		try {
			String P9urjRjp = getParameter("experiment");
			if (P9urjRjp.length() > 0) {
				A6CXTfNu = new URL(getCodeBase(), P9urjRjp);
				wRvwKmyx = A6CXTfNu.openStream();
			}
		} catch (java.net.MalformedURLException ve3uwqw3) {
			System.out.println("Couldn't open url experiment: badly specified URL " + ve3uwqw3.getMessage());
		} catch (Throwable PSXBAIs8) {
			System.out.println("Couldn't open url experiment: " + PSXBAIs8.getMessage());
		}
		try {
			System.out.println("Creating client, logging to " + m_strWorld);
			m_VRWClient = new VRWClient(m_strHost, wc7JDGCA, true, ThFZx8yB);
			m_VRWClient.setInApplet(true);
			m_VRWClient.login(m_strWorld);
		} catch (java.io.IOException vjZjb37W) {
			System.out.println("IOException creating the VRWClient");
		}
		try {
			jsobj = JSObject.getWindow(this);
		} catch (Throwable yvVjr1Bi) {
			System.out.println("Exception getting Java Script Interface: " + yvVjr1Bi.getMessage());
		}
		refApplet = this;
		m_frmVRWConsole = new VRWConsoleFrame();
		m_frmVRWConsole.setTitle("VRW Client Console");
		m_frmVRWConsole.pack();
		m_frmVRWConsole.setSize(Math.max(300, m_frmVRWConsole.getSize().width),
				Math.max(200, m_frmVRWConsole.getSize().height));
		if (wRvwKmyx != null) {
			System.out.println("Passing experiment stream to VRWConsoleFrame");
			m_frmVRWConsole.loadExperiment(wRvwKmyx);
		}
		m_frmVRWConsole.setVisible(true);
	}

}