class n18176215 {
	public int readLines() {
		if (istream == null)
			return 0;
		int i = 0;
		try {
			String s1;
			if ((new String("http")).compareTo(url.getProtocol()) == 0) {
				istream = url.openConnection();
				if (last_contentLenght != istream.getContentLength()) {
					last_contentLenght = istream.getContentLength();
					istream = url.openConnection();
					istream.setRequestProperty("Range", "bytes=" + Integer.toString(bytes_read) + "-");
					System.out.println("Trace2Png: ContentLength: " + Integer.toString(istream.getContentLength()));
					String s;
					reader = new BufferedReader(new InputStreamReader(istream.getInputStream()));
					while ((s = reader.readLine()) != null) {
						bytes_read = bytes_read + s.length() + 1;
						t2pProcessLine(trace, s);
						i++;
					}
				}
			} else {
				while ((s1 = reader.readLine()) != null) {
					bytes_read = bytes_read + s1.length() + 1;
					t2pProcessLine(trace, s1);
					i++;
				}
			}
			t2pHandleEventPairs(trace);
			t2pSort(trace, sortby);
		} catch (IOException ioexception) {
			System.out.println("Trace2Png: IOException !!!");
		}
		return i;
	}

}