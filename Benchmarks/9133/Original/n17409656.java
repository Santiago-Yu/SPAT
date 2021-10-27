class n17409656{
    public XMLPieChartDemo(final String title) {
        super(title);
        PieDataset dataset = null;
        final URL url = getClass().getResource("/org/jfree/chart/demo/piedata.xml");
        try {
            final InputStream in = url.openStream();
            dataset = DatasetReader.readPieDatasetFromXML(in);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        final JFreeChart chart = ChartFactory.createPieChart("Pie Chart Demo 1", dataset, true, true, false);
        chart.setBackgroundPaint(Color.yellow);
        final PiePlot plot = (PiePlot) chart.getPlot();
        plot.setNoDataMessage("No data available");
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);
    }

}