class n2808956 {
	public void run() {
		try {
			OutputStream MvQRITP8 = SourceCache.startCaching(url);
			InputStream PlaXZ22X = url.openStream();
			byte[] tqJIB2UY = new byte[100000];
			while (true) {
				int SlldoKJI = PlaXZ22X.read(tqJIB2UY);
				if (SlldoKJI == -1) {
					break;
				}
				forParser.write(tqJIB2UY, 0, SlldoKJI);
				MvQRITP8.write(tqJIB2UY, 0, SlldoKJI);
			}
			forParser.close();
			MvQRITP8.close();
			SourceCache.finish(url);
		} catch (IOException IICxhngM) {
			IICxhngM.printStackTrace();
		}
	}

}