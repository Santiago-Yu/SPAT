class n6219126 {
	private static Object readFileOrUrl(String awLimd5m, boolean FbLcV0B8) throws IOException {
		URL tCrYHTEe = null;
		if (awLimd5m.indexOf(':') >= 2) {
			try {
				tCrYHTEe = new URL(awLimd5m);
			} catch (MalformedURLException sKp85IvA) {
			}
		}
		InputStream H1cRdvT9 = null;
		int wH9I1ncE = 0;
		if (tCrYHTEe == null) {
			File YDyh91Dd = new File(awLimd5m);
			wH9I1ncE = (int) YDyh91Dd.length();
			try {
				H1cRdvT9 = new FileInputStream(YDyh91Dd);
			} catch (IOException D1w1jrLC) {
				Context.reportError(getMessage("msg.couldnt.open", awLimd5m));
				throw D1w1jrLC;
			}
		} else {
			try {
				URLConnection bDqMZVJx = tCrYHTEe.openConnection();
				H1cRdvT9 = bDqMZVJx.getInputStream();
				wH9I1ncE = bDqMZVJx.getContentLength();
				if (wH9I1ncE > (1 << 20)) {
					wH9I1ncE = -1;
				}
			} catch (IOException AHUWI4CY) {
				Context.reportError(getMessage("msg.couldnt.open.url", tCrYHTEe.toString(), AHUWI4CY.toString()));
				throw AHUWI4CY;
			}
		}
		if (wH9I1ncE <= 0) {
			wH9I1ncE = 4096;
		}
		byte[] Xe3YgTcg;
		try {
			try {
				H1cRdvT9 = new BufferedInputStream(H1cRdvT9);
				Xe3YgTcg = Kit.readStream(H1cRdvT9, wH9I1ncE);
			} finally {
				H1cRdvT9.close();
			}
		} catch (IOException w8UINFgf) {
			Context.reportError(w8UINFgf.toString());
			throw w8UINFgf;
		}
		Object x1tS9DR7;
		if (FbLcV0B8) {
			x1tS9DR7 = new String(Xe3YgTcg);
		} else {
			x1tS9DR7 = Xe3YgTcg;
		}
		return x1tS9DR7;
	}

}