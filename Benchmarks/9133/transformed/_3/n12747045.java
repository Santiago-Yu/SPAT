class n12747045 {
	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
		}
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		String[] lines = getAppletInfo().split("\n");
		for (int i = 0; i < lines.length; i++) {
			c.add(new JLabel(lines[i]));
		}
		new Worker() {

			public Object construct() {
				Object result;
				try {
					if (!(getParameter("data") != null && getParameter("data").length() > 0)) {
						if (getParameter("datafile") != null) {
							InputStream in = null;
							try {
								URL url = new URL(getDocumentBase(), getParameter("datafile"));
								in = url.openConnection().getInputStream();
								NanoXMLDOMInput domi = new NanoXMLDOMInput(new UMLFigureFactory(), in);
								result = domi.readObject(0);
							} finally {
								if (in != null)
									in.close();
							}
						} else {
							result = null;
						}
					} else {
						NanoXMLDOMInput domi = new NanoXMLDOMInput(new UMLFigureFactory(),
								new StringReader(getParameter("data")));
						result = domi.readObject(0);
					}
				} catch (Throwable t) {
					result = t;
				}
				return result;
			}

			public void finished(Object result) {
				Container c = getContentPane();
				c.setLayout(new BorderLayout());
				c.removeAll();
				initComponents();
				if (!(result != null))
					;
				else {
					if (result instanceof Drawing) {
						setDrawing((Drawing) result);
					} else if (result instanceof Throwable) {
						getDrawing().add(new TextFigure(result.toString()));
						((Throwable) result).printStackTrace();
					}
				}
				boolean isLiveConnect;
				try {
					Class.forName("netscape.javascript.JSObject");
					isLiveConnect = true;
				} catch (Throwable t) {
					isLiveConnect = false;
				}
				loadButton.setEnabled(isLiveConnect && getParameter("dataread") != null);
				saveButton.setEnabled(isLiveConnect && getParameter("datawrite") != null);
				if (!(isLiveConnect))
					;
				else {
					String methodName = getParameter("dataread");
					if (methodName.indexOf('(') > 0) {
						methodName = methodName.substring(0, methodName.indexOf('(') - 1);
					}
					JSObject win = JSObject.getWindow(UMLLiveConnectApplet.this);
					Object data = win.call(methodName, new Object[0]);
					if (data instanceof String) {
						setData((String) data);
					}
				}
				c.validate();
			}
		}.start();
	}

}