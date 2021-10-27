class n2468861 {
	private static QDataSet test3_binary() throws IOException, StreamException {
		QDataSetStreamHandler handler = new QDataSetStreamHandler();
		URL url = TestQDataSetStreamHandler.class.getResource("test3.binary.qds");
		StreamTool.readStream(Channels.newChannel(url.openStream()), handler);
		QDataSet qds = handler.getDataSet();
		return qds;
	}

}