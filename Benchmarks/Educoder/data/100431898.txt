    public void init() {
        super.init();
        Runnable doActions = new Runnable() {

            public void run() {
                if (_plot == null) {
                    _plot = newPlot();
                }
                getContentPane().add(plot(), BorderLayout.NORTH);
                int width;
                int height;
                String widthspec = getParameter("width");
                if (widthspec != null) {
                    width = Integer.parseInt(widthspec);
                } else {
                    width = 400;
                }
                String heightspec = getParameter("height");
                if (heightspec != null) {
                    height = Integer.parseInt(heightspec);
                } else {
                    height = 400;
                }
                _setPlotSize(width, height);
                plot().setButtons(true);
                Color background = Color.white;
                String colorspec = getParameter("background");
                if (colorspec != null) {
                    background = PlotBox.getColorByName(colorspec);
                }
                setBackground(background);
                plot().setBackground(background);
                getContentPane().setBackground(background);
                Color foreground = Color.black;
                colorspec = getParameter("foreground");
                if (colorspec != null) {
                    foreground = PlotBox.getColorByName(colorspec);
                }
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
        };
        try {
            SwingUtilities.invokeAndWait(doActions);
        } catch (Exception ex) {
        }
    }
