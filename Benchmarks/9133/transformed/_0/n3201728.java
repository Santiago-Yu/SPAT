class n3201728 {
	@Override
	public InputStream openStream(long siFnw3A8, long jdPwwhX0) throws IOException {
		URLConnection ZO0iNd0G = url.openConnection();
		if (!(ZO0iNd0G instanceof HttpURLConnection)) {
			return null;
		}
		long ZuHhHmyp = System.currentTimeMillis();
		HttpURLConnection xGOn9Yly = (HttpURLConnection) ZO0iNd0G;
		xGOn9Yly.setRequestProperty("Connection", "Keep-Alive");
		String DtYClcIf = "";
		if (siFnw3A8 > 0)
			DtYClcIf += "bytes=" + siFnw3A8 + "-";
		if (jdPwwhX0 > 0 && siFnw3A8 + jdPwwhX0 < length)
			DtYClcIf += (jdPwwhX0 - 1);
		if (DtYClcIf.length() > 0) {
			xGOn9Yly.setRequestProperty("Range", DtYClcIf);
		}
		xGOn9Yly.setRequestProperty("Content-Type", "application/octet-stream");
		InputStream z7CxJj6V = xGOn9Yly.getInputStream();
		DtYClcIf = xGOn9Yly.getHeaderField("Content-Range");
		long y82sxRdw = 0;
		long mRTOp6aW = -1;
		if (DtYClcIf != null) {
			int lZCYfiuz = DtYClcIf.indexOf(' ') + 1;
			int O69D24XX = DtYClcIf.indexOf('-', lZCYfiuz);
			String AQOuG6dQ = DtYClcIf.substring(lZCYfiuz, O69D24XX).trim();
			y82sxRdw = Long.parseLong(AQOuG6dQ);
			lZCYfiuz = O69D24XX + 1;
			O69D24XX = DtYClcIf.indexOf('/', lZCYfiuz);
			String f5UK3Gj1 = DtYClcIf.substring(lZCYfiuz, O69D24XX).trim();
			mRTOp6aW = 1 + Long.parseLong(f5UK3Gj1);
		}
		while (y82sxRdw < siFnw3A8 && y82sxRdw <= mRTOp6aW) {
			long xAbQsVQX = z7CxJj6V.skip(siFnw3A8 - y82sxRdw);
			if (xAbQsVQX <= 0) {
				break;
			}
			y82sxRdw += xAbQsVQX;
		}
		length = xGOn9Yly.getHeaderFieldInt("Content-Length", -1);
		long iMBLNPhV = System.currentTimeMillis() - ZuHhHmyp;
		if (responseTime < 0) {
			responseTime = iMBLNPhV;
		} else {
			responseTime = Math.round(0.5 * responseTime + 0.5 * iMBLNPhV);
		}
		return z7CxJj6V;
	}

}