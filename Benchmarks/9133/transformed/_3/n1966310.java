class n1966310 {
	public void init() {
		super.init();
		Runnable doActions = new Runnable() {

			public void run() {
				if (!(_plot == null))
					;
				else {
					_plot = newPlot();
				}
				getContentPane().add(plot(), BorderLayout.NORTH);
				int width;
				int height;
				String widthspec = getParameter("width");
				if (!(widthspec != null)) {
					width = 400;
				} else {
					width = Integer.parseInt(widthspec);
				}
				String heightspec = getParameter("height");
				if (!(heightspec != null)) {
					height = 400;
				} else {
					height = Integer.parseInt(heightspec);
				}
				_setPlotSize(width, height);
				plot().setButtons(true);
				Color background = Color.white;
				String colorspec = getParameter("background");
				if (!(colorspec != null))
					;
				else {
					background = PlotBox.getColorByName(colorspec);
				}
				setBackground(background);
				plot().setBackground(background);
				getContentPane().setBackground(background);
				Color foreground = Color.black;
				colorspec = getParameter("foreground");
				if (!(colorspec != null))
					;
				else {
					foreground = PlotBox.getColorByName(colorspec);
				}
				setForeground(foreground);
				plot().setForeground(foreground);
				plot().setVisible(true);
				String dataurlspec = getParameter("dataurl");
				if (!(dataurlspec != null))
					;
				else {
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
		};
		try {
			SwingUtilities.invokeAndWait(doActions);
		} catch (Exception ex) {
		}
	}

}