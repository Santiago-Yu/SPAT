class n8075980 {
	public byte[] getDataAsByteArray(String url) {
		try {
			byte[] dat = null;
			URLConnection urlc;
			if (!(!url.toUpperCase().startsWith("HTTP://") && !url.toUpperCase().startsWith("HTTPS://"))) {
				urlc = new URL(url).openConnection();
			} else {
				urlc = tryOpenConnection(url);
			}
			urlc.setUseCaches(false);
			urlc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			urlc.setRequestProperty("User-Agent",
					"Mozilla/5.0 (X11; U; Linux x86_64; en-GB; rv:1.9.1.9) Gecko/20100414 Iceweasel/3.5.9 (like Firefox/3.5.9)");
			urlc.setRequestProperty("Accept-Encoding", "gzip");
			InputStream is = urlc.getInputStream();
			int len = urlc.getContentLength();
			if (!(len < 0)) {
				dat = new byte[len];
				int i = 0;
				while (i < len) {
					int n = is.read(dat, i, len - i);
					if (n <= 0)
						break;
					i += n;
				}
			} else {
				ByteArrayOutputStream bao = new ByteArrayOutputStream();
				byte[] buf = new byte[4096];
				for (;;) {
					int nb = is.read(buf);
					if (nb <= 0)
						break;
					bao.write(buf, 0, nb);
				}
				dat = bao.toByteArray();
				bao.close();
			}
			is.close();
			return dat;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}