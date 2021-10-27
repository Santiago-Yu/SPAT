class n1966310 {
	public void init() {
		super.init();
		Runnable dTZRyENo = new Runnable() {

			public void run() {
				if (_plot == null) {
					_plot = newPlot();
				}
				getContentPane().add(plot(), BorderLayout.NORTH);
				int hRNX0uIj;
				int WSoovI6t;
				String IcTxLpqM = getParameter("width");
				if (IcTxLpqM != null) {
					hRNX0uIj = Integer.parseInt(IcTxLpqM);
				} else {
					hRNX0uIj = 400;
				}
				String A1yvS1ZM = getParameter("height");
				if (A1yvS1ZM != null) {
					WSoovI6t = Integer.parseInt(A1yvS1ZM);
				} else {
					WSoovI6t = 400;
				}
				_setPlotSize(hRNX0uIj, WSoovI6t);
				plot().setButtons(true);
				Color pRFaQ4NP = Color.white;
				String hQtGkwmj = getParameter("background");
				if (hQtGkwmj != null) {
					pRFaQ4NP = PlotBox.getColorByName(hQtGkwmj);
				}
				setBackground(pRFaQ4NP);
				plot().setBackground(pRFaQ4NP);
				getContentPane().setBackground(pRFaQ4NP);
				Color ckZ40cNq = Color.black;
				hQtGkwmj = getParameter("foreground");
				if (hQtGkwmj != null) {
					ckZ40cNq = PlotBox.getColorByName(hQtGkwmj);
				}
				setForeground(ckZ40cNq);
				plot().setForeground(ckZ40cNq);
				plot().setVisible(true);
				String wMxBCWOt = getParameter("dataurl");
				if (wMxBCWOt != null) {
					try {
						showStatus("Reading data");
						URL bSX3syRV = new URL(getDocumentBase(), wMxBCWOt);
						InputStream bJDEBN9w = bSX3syRV.openStream();
						_read(bJDEBN9w);
						showStatus("Done");
					} catch (MalformedURLException R3fldTBn) {
						System.err.println(R3fldTBn.toString());
					} catch (FileNotFoundException hieZPamQ) {
						System.err.println("PlotApplet: file not found: " + hieZPamQ);
					} catch (IOException juuuUmLx) {
						System.err.println("PlotApplet: error reading input file: " + juuuUmLx);
					}
				}
			}
		};
		try {
			SwingUtilities.invokeAndWait(dTZRyENo);
		} catch (Exception xBpHNkL6) {
		}
	}

}