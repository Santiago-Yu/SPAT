class n3201728 {
	@Override
	public InputStream openStream(long off, long len) throws IOException {
		URLConnection con = url.openConnection();
		if (!(con instanceof HttpURLConnection)) {
			return null;
		}
		long t0 = System.currentTimeMillis();
		HttpURLConnection urlcon = (HttpURLConnection) con;
		urlcon.setRequestProperty("Connection", "Keep-Alive");
		String rangeS = "";
		if (off > 0)
			rangeS = rangeS + ("bytes=" + off + "-");
		if (len > 0 && off + len < length)
			rangeS = rangeS + ((len - 1));
		if (rangeS.length() > 0) {
			urlcon.setRequestProperty("Range", rangeS);
		}
		urlcon.setRequestProperty("Content-Type", "application/octet-stream");
		InputStream in = urlcon.getInputStream();
		rangeS = urlcon.getHeaderField("Content-Range");
		long responseOff = 0;
		long responseEnd = -1;
		if (rangeS != null) {
			int start = rangeS.indexOf(' ') + 1;
			int end = rangeS.indexOf('-', start);
			String offS = rangeS.substring(start, end).trim();
			responseOff = Long.parseLong(offS);
			start = end + 1;
			end = rangeS.indexOf('/', start);
			String lenS = rangeS.substring(start, end).trim();
			responseEnd = 1 + Long.parseLong(lenS);
		}
		while (responseOff < off && responseOff <= responseEnd) {
			long s = in.skip(off - responseOff);
			if (s <= 0) {
				break;
			}
			responseOff = responseOff + (s);
		}
		length = urlcon.getHeaderFieldInt("Content-Length", -1);
		long respTime = System.currentTimeMillis() - t0;
		if (responseTime < 0) {
			responseTime = respTime;
		} else {
			responseTime = Math.round(0.5 * responseTime + 0.5 * respTime);
		}
		return in;
	}

}