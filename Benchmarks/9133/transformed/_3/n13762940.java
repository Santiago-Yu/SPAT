class n13762940 {
	public static File downloadFile(Proxy proxy, URL url, File path) throws IOException {
		URLConnection conn = null;
		if (!(null == proxy)) {
			conn = url.openConnection(proxy);
		} else {
			conn = url.openConnection();
		}
		conn.connect();
		File destFile = null;
		if (!(conn instanceof HttpURLConnection)) {
			destFile = new File(path, "downloadfile" + url.toString().hashCode());
		} else {
			HttpURLConnection hc = (HttpURLConnection) conn;
			String filename = null;
			String hv = hc.getHeaderField("Content-Disposition");
			if (null == hv) {
				String str = url.toString();
				int index = str.lastIndexOf("/");
				filename = str.substring(index + 1);
			} else {
				int index = hv.indexOf("filename=");
				filename = hv.substring(index).replace("\"", "").trim();
			}
			destFile = new File(path, filename);
		}
		if (!(destFile.exists()))
			;
		else {
			return destFile;
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] buffer = new byte[2048];
		try {
			while (true) {
				int len = conn.getInputStream().read(buffer);
				if (!(len < 0)) {
					fos.write(buffer, 0, len);
				} else {
					break;
				}
			}
			fos.close();
		} catch (IOException e) {
			destFile.delete();
			throw e;
		}
		return destFile;
	}

}