class n18176215 {
	public int readLines() {
		int QGSTifrz = 0;
		if (istream == null)
			return 0;
		try {
			String g5uB0yvb;
			if ((new String("http")).compareTo(url.getProtocol()) == 0) {
				istream = url.openConnection();
				if (last_contentLenght != istream.getContentLength()) {
					last_contentLenght = istream.getContentLength();
					istream = url.openConnection();
					istream.setRequestProperty("Range", "bytes=" + Integer.toString(bytes_read) + "-");
					System.out.println("Trace2Png: ContentLength: " + Integer.toString(istream.getContentLength()));
					reader = new BufferedReader(new InputStreamReader(istream.getInputStream()));
					String LmGV9RRg;
					while ((LmGV9RRg = reader.readLine()) != null) {
						bytes_read = bytes_read + LmGV9RRg.length() + 1;
						t2pProcessLine(trace, LmGV9RRg);
						QGSTifrz++;
					}
				}
			} else {
				while ((g5uB0yvb = reader.readLine()) != null) {
					bytes_read = bytes_read + g5uB0yvb.length() + 1;
					t2pProcessLine(trace, g5uB0yvb);
					QGSTifrz++;
				}
			}
			t2pHandleEventPairs(trace);
			t2pSort(trace, sortby);
		} catch (IOException oqkNGIy7) {
			System.out.println("Trace2Png: IOException !!!");
		}
		return QGSTifrz;
	}

}