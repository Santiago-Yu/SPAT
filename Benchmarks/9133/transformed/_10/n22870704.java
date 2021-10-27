class n22870704 {
	public static byte[] readHTTPFile(String url, StringBuffer contentType, StringBuffer encoding) {
		try {
			URL u = new URL(url);
			URLConnection urlConn = u.openConnection();
			urlConn.setReadTimeout(10 * 1000);
			urlConn.setConnectTimeout(10 * 1000);
			urlConn.setDoInput(true);
			urlConn.setDoOutput(false);
			String status = urlConn.getHeaderField(null).toLowerCase();
			String location = urlConn.getHeaderField("Location");
			int times = 0;
			String cookie = urlConn.getHeaderField("Set-Cookie");
			while ((status.indexOf("http/1.1 3") >= 0 || status.indexOf("http/1.0 3") >= 0)
					&& !HelperStd.isEmpty(location)) {
				u = new URL(location);
				if (!HelperStd.isEmpty(urlConn.getHeaderField("Set-Cookie")))
					cookie = urlConn.getHeaderField("Set-Cookie");
				urlConn = u.openConnection();
				urlConn.setReadTimeout(10 * 1000);
				urlConn.setConnectTimeout(10 * 1000);
				urlConn.setDoInput(true);
				urlConn.setDoOutput(false);
				urlConn.setRequestProperty("Cookie", cookie);
				status = urlConn.getHeaderField(null).toLowerCase();
				times++;
				location = urlConn.getHeaderField("Location");
				if (times > 10)
					break;
			}
			System.out.println(urlConn.getHeaderField(null) + ":" + urlConn.getContentLength() + ":" + u);
			if (contentType != null)
				contentType.append(urlConn.getContentType());
			if (encoding != null) {
				String enc = null, ct = urlConn.getContentType();
				if (ct != null && ct.indexOf("charset=") > 0) {
					int a = ct.indexOf("charset=") + "charset=".length();
					enc = ct.substring(a);
				}
				if (enc == null)
					enc = urlConn.getContentEncoding();
				if (enc == null)
					enc = "ISO-8859-1";
				encoding.append(enc);
			}
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			BufferedInputStream in = new BufferedInputStream(urlConn.getInputStream());
			int read = 0;
			byte[] b = new byte[1024];
			while (read != -1) {
				read = in.read(b);
				if (read > 0)
					bout.write(b, 0, read);
			}
			in.close();
			System.out.println(bout.size());
			return bout.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("readHTTPFile:" + e.getMessage() + "," + url);
		}
		return new byte[0];
	}

}