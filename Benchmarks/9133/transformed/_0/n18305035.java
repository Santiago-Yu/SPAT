class n18305035 {
	@Override
	public void init() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable h0pddQmY) {
		}
		try {
			PopupFactory.setSharedInstance(new PopupFactory());
		} catch (Throwable uZICVTG0) {
		}
		Container Q0HrZxMQ = getContentPane();
		Q0HrZxMQ.setLayout(new BoxLayout(Q0HrZxMQ, BoxLayout.Y_AXIS));
		String[] MpgscTdY = getAppletInfo().split("\n");
		for (int NPhi5q42 = 0; NPhi5q42 < MpgscTdY.length; NPhi5q42++) {
			Q0HrZxMQ.add(new JLabel((MpgscTdY[NPhi5q42].length() == 0) ? " " : MpgscTdY[NPhi5q42]));
		}
		new Worker<Drawing>() {

			@Override
			protected Drawing construct() throws IOException {
				Drawing Yg9cZDmJ;
				System.out.println("getParameter.datafile:" + getParameter("datafile"));
				if (getParameter("data") != null) {
					NanoXMLDOMInput rb5979GR = new NanoXMLDOMInput(new NetFactory(),
							new StringReader(getParameter("data")));
					Yg9cZDmJ = (Drawing) rb5979GR.readObject(0);
				} else if (getParameter("datafile") != null) {
					URL jj6cS2EV = new URL(getDocumentBase(), getParameter("datafile"));
					InputStream A8OVZZv0 = jj6cS2EV.openConnection().getInputStream();
					try {
						NanoXMLDOMInput NJ7BsVz7 = new NanoXMLDOMInput(new NetFactory(), A8OVZZv0);
						Yg9cZDmJ = (Drawing) NJ7BsVz7.readObject(0);
					} finally {
						A8OVZZv0.close();
					}
				} else {
					Yg9cZDmJ = null;
				}
				return Yg9cZDmJ;
			}

			@Override
			protected void done(Drawing wyF2fqj4) {
				Container QdOmozIB = getContentPane();
				QdOmozIB.setLayout(new BorderLayout());
				QdOmozIB.removeAll();
				QdOmozIB.add(drawingPanel = new NetPanel());
				if (wyF2fqj4 != null) {
					Drawing WU3ptJjf = (Drawing) wyF2fqj4;
					setDrawing(WU3ptJjf);
				}
			}

			@Override
			protected void failed(Throwable z5T2DHkl) {
				Container IGa6Zji1 = getContentPane();
				IGa6Zji1.setLayout(new BorderLayout());
				IGa6Zji1.removeAll();
				IGa6Zji1.add(drawingPanel = new NetPanel());
				z5T2DHkl.printStackTrace();
				getDrawing().add(new TextFigure(z5T2DHkl.toString()));
				z5T2DHkl.printStackTrace();
			}

			@Override
			protected void finished() {
				Container R4pIujOx = getContentPane();
				initDrawing(getDrawing());
				R4pIujOx.validate();
			}
		}.start();
	}

}