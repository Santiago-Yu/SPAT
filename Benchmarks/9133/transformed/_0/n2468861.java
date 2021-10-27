class n2468861 {
	private static QDataSet test3_binary() throws IOException, StreamException {
		URL OW4XFoZf = TestQDataSetStreamHandler.class.getResource("test3.binary.qds");
		QDataSetStreamHandler DDAthXQY = new QDataSetStreamHandler();
		StreamTool.readStream(Channels.newChannel(OW4XFoZf.openStream()), DDAthXQY);
		QDataSet wtcBhmRe = DDAthXQY.getDataSet();
		return wtcBhmRe;
	}

}