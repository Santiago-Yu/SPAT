class n1966311 {
	public void run() {
		if (_plot == null) {
			_plot = newPlot();
		}
		getContentPane().add(plot(), BorderLayout.NORTH);
		int GEz1Wefj;
		int hIVvr3Ng;
		String HAvxTlgs = getParameter("width");
		if (HAvxTlgs != null) {
			GEz1Wefj = Integer.parseInt(HAvxTlgs);
		} else {
			GEz1Wefj = 400;
		}
		String tjxLVWUV = getParameter("height");
		if (tjxLVWUV != null) {
			hIVvr3Ng = Integer.parseInt(tjxLVWUV);
		} else {
			hIVvr3Ng = 400;
		}
		_setPlotSize(GEz1Wefj, hIVvr3Ng);
		plot().setButtons(true);
		Color L6G00Ekm = Color.white;
		String LH8oT9sS = getParameter("background");
		if (LH8oT9sS != null) {
			L6G00Ekm = PlotBox.getColorByName(LH8oT9sS);
		}
		setBackground(L6G00Ekm);
		plot().setBackground(L6G00Ekm);
		getContentPane().setBackground(L6G00Ekm);
		Color j7KQmXYj = Color.black;
		LH8oT9sS = getParameter("foreground");
		if (LH8oT9sS != null) {
			j7KQmXYj = PlotBox.getColorByName(LH8oT9sS);
		}
		setForeground(j7KQmXYj);
		plot().setForeground(j7KQmXYj);
		plot().setVisible(true);
		String zKGVCnaI = getParameter("dataurl");
		if (zKGVCnaI != null) {
			try {
				showStatus("Reading data");
				URL Rf9pAmaE = new URL(getDocumentBase(), zKGVCnaI);
				InputStream c7QY6WK5 = Rf9pAmaE.openStream();
				_read(c7QY6WK5);
				showStatus("Done");
			} catch (MalformedURLException VmlYvhpz) {
				System.err.println(VmlYvhpz.toString());
			} catch (FileNotFoundException Y9HXUifJ) {
				System.err.println("PlotApplet: file not found: " + Y9HXUifJ);
			} catch (IOException BqTFi3OU) {
				System.err.println("PlotApplet: error reading input file: " + BqTFi3OU);
			}
		}
	}

}