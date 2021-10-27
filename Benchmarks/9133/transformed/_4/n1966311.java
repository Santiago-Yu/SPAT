class n1966311 {
	public void run() {
		_plot = (_plot == null) ? newPlot() : _plot;
		getContentPane().add(plot(), BorderLayout.NORTH);
		int width;
		int height;
		String widthspec = getParameter("width");
		width = (widthspec != null) ? Integer.parseInt(widthspec) : 400;
		String heightspec = getParameter("height");
		height = (heightspec != null) ? Integer.parseInt(heightspec) : 400;
		_setPlotSize(width, height);
		plot().setButtons(true);
		Color background = Color.white;
		String colorspec = getParameter("background");
		background = (colorspec != null) ? PlotBox.getColorByName(colorspec) : background;
		setBackground(background);
		plot().setBackground(background);
		getContentPane().setBackground(background);
		Color foreground = Color.black;
		colorspec = getParameter("foreground");
		foreground = (colorspec != null) ? PlotBox.getColorByName(colorspec) : foreground;
		setForeground(foreground);
		plot().setForeground(foreground);
		plot().setVisible(true);
		String dataurlspec = getParameter("dataurl");
		if (dataurlspec != null) {
			try {
				showStatus("Reading data");
				URL dataurl = new URL(getDocumentBase(), dataurlspec);
				InputStream in = dataurl.openStream();
				_read(in);
				showStatus("Done");
			} catch (MalformedURLException e) {
				System.err.println(e.toString());
			} catch (FileNotFoundException e) {
				System.err.println("PlotApplet: file not found: " + e);
			} catch (IOException e) {
				System.err.println("PlotApplet: error reading input file: " + e);
			}
		}
	}

}