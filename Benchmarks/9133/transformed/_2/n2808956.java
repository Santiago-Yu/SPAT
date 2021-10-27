class n2808956 {
	public void run() {
		try {
			OutputStream out = SourceCache.startCaching(url);
			InputStream is = url.openStream();
			byte[] buffer = new byte[100000];
			for (; true;) {
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