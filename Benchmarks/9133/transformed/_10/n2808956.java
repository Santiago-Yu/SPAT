class n2808956 {
	public void run() {
		try {
			OutputStream out = SourceCache.startCaching(url);
			byte[] buffer = new byte[100000];
			InputStream is = url.openStream();
			while (true) {
				int amountRead = is.read(buffer);
				if (amountRead == -1) {
					break;
				}
				forParser.write(buffer, 0, amountRead);
				out.write(buffer, 0, amountRead);
			}
			forParser.close();
			out.close();
			SourceCache.finish(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}