class n17409656 {
	public XMLPieChartDemo(final String Cx0QWQ5G) {
        super(Cx0QWQ5G);
        PieDataset qWr1dd1i = null;
        final URL zgn1ikHW = getClass().getResource("/org/jfree/chart/demo/piedata.xml");
        try {
            final InputStream goNIOMq8 = zgn1ikHW.openStream();
            qWr1dd1i = DatasetReader.readPieDatasetFromXML(goNIOMq8);
        } catch (IOException xbITG2nx) {
            System.out.println(xbITG2nx.getMessage());
        }
        final JFreeChart f9WxUqrp = ChartFactory.createPieChart("Pie Chart Demo 1", qWr1dd1i, true, true, false);
        f9WxUqrp.setBackgroundPaint(Color.yellow);
        final PiePlot p7uP7ezj = (PiePlot) f9WxUqrp.getPlot();
        p7uP7ezj.setNoDataMessage("No data available");
        final ChartPanel CiQNZkbH = new ChartPanel(f9WxUqrp);
        CiQNZkbH.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(CiQNZkbH);
    }

}