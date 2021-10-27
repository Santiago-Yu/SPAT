class n12747045 {
	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable iNJy5LFv) {
		}
		Container Kl8mEGal = getContentPane();
		Kl8mEGal.setLayout(new BoxLayout(Kl8mEGal, BoxLayout.Y_AXIS));
		String[] rGESvEuQ = getAppletInfo().split("\n");
		for (int myZ2USIR = 0; myZ2USIR < rGESvEuQ.length; myZ2USIR++) {
			Kl8mEGal.add(new JLabel(rGESvEuQ[myZ2USIR]));
		}
		new Worker() {

			public Object construct() {
				Object tGk3xhGI;
				try {
					if (getParameter("data") != null && getParameter("data").length() > 0) {
						NanoXMLDOMInput pk0I8hEf = new NanoXMLDOMInput(new UMLFigureFactory(),
								new StringReader(getParameter("data")));
						tGk3xhGI = pk0I8hEf.readObject(0);
					} else if (getParameter("datafile") != null) {
						InputStream a3Z5P4dl = null;
						try {
							URL c6509U3Y = new URL(getDocumentBase(), getParameter("datafile"));
							a3Z5P4dl = c6509U3Y.openConnection().getInputStream();
							NanoXMLDOMInput LrHhyRgO = new NanoXMLDOMInput(new UMLFigureFactory(), a3Z5P4dl);
							tGk3xhGI = LrHhyRgO.readObject(0);
						} finally {
							if (a3Z5P4dl != null)
								a3Z5P4dl.close();
						}
					} else {
						tGk3xhGI = null;
					}
				} catch (Throwable Hqj2WIlB) {
					tGk3xhGI = Hqj2WIlB;
				}
				return tGk3xhGI;
			}

			public void finished(Object Js8ZKrnr) {
				Container nEfHhIly = getContentPane();
				nEfHhIly.setLayout(new BorderLayout());
				nEfHhIly.removeAll();
				initComponents();
				if (Js8ZKrnr != null) {
					if (Js8ZKrnr instanceof Drawing) {
						setDrawing((Drawing) Js8ZKrnr);
					} else if (Js8ZKrnr instanceof Throwable) {
						getDrawing().add(new TextFigure(Js8ZKrnr.toString()));
						((Throwable) Js8ZKrnr).printStackTrace();
					}
				}
				boolean DoKuzeyv;
				try {
					Class.forName("netscape.javascript.JSObject");
					DoKuzeyv = true;
				} catch (Throwable EUIxvput) {
					DoKuzeyv = false;
				}
				loadButton.setEnabled(DoKuzeyv && getParameter("dataread") != null);
				saveButton.setEnabled(DoKuzeyv && getParameter("datawrite") != null);
				if (DoKuzeyv) {
					String wKZNzfKd = getParameter("dataread");
					if (wKZNzfKd.indexOf('(') > 0) {
						wKZNzfKd = wKZNzfKd.substring(0, wKZNzfKd.indexOf('(') - 1);
					}
					JSObject KIkkjaxD = JSObject.getWindow(UMLLiveConnectApplet.this);
					Object PMr2j3Ll = KIkkjaxD.call(wKZNzfKd, new Object[0]);
					if (PMr2j3Ll instanceof String) {
						setData((String) PMr2j3Ll);
					}
				}
				nEfHhIly.validate();
			}
		}.start();
	}

}