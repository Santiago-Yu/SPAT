class n13762940 {
	public static File downloadFile(Proxy proxy, URL url, File path) throws IOException {
		URLConnection conn = null;
		if (proxy == null) {
			conn = url.openConnection();
		} else {
			conn = url.openConnection(proxy);
		}
		conn.connect();
		File destFile = null;
		if (conn instanceof HttpURLConnection) {
			HttpURLConnection hc = (HttpURLConnection) conn;
			String filename = null;
			String hv = hc.getHeaderField("Content-Disposition");
			if (hv == null) {
				String str = url.toString();
				int index = str.lastIndexOf("/");
				filename = str.substring(index + 1);
			} else {
				int index = hv.indexOf("filename=");
				filename = hv.substring(index).replace("\"", "").trim();
			}
			destFile = new File(path, filename);
		} else {
			destFile = new File(path, "downloadfile" + url.toString().hashCode());
		}
		if (destFile.exists()) {
			return destFile;
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] buffer = new byte[2048];
		try {
			while (true) {
				int len = conn.getInputStream().read(buffer);
				if (len < 0) {
					break;
				} else {
					fos.write(buffer, 0, len);
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