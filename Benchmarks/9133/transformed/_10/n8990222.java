class n8990222 {
	private boolean get(String surl, File dst, Get get) throws IOException {
		InputStream is = null;
		boolean ret = false;
		OutputStream os = null;
		try {
			try {
				if (surl.startsWith("file://")) {
					is = new FileInputStream(surl.substring(7));
				} else {
					URL url = new URL(surl);
					is = url.openStream();
				}
				if (is != null) {
					int read;
					os = new FileOutputStream(dst);
					byte[] buffer = new byte[4096];
					ret = true;
					while ((read = is.read(buffer)) > 0) {
						os.write(buffer, 0, read);
					}
				}
			} catch (ConnectException ex) {
				log("Connect exception " + ex.getMessage(), ex, 3);
				if (dst.exists())
					dst.delete();
			} catch (UnknownHostException ex) {
				log("Unknown host " + ex.getMessage(), ex, 3);
			} catch (FileNotFoundException ex) {
				log("File not found: " + ex.getMessage(), 3);
			}
		} finally {
			if (is != null)
				is.close();
			is = null;
			if (os != null)
				os.close();
			os = null;
		}
		if (ret) {
			try {
				os = new FileOutputStream(getCachedFile(get));
				is = new FileInputStream(dst);
				byte[] buffer = new byte[4096];
				int read;
				while ((read = is.read(buffer)) > 0) {
					os.write(buffer, 0, read);
				}
			} finally {
				if (is != null)
					is.close();
				is = null;
				if (os != null)
					os.close();
				os = null;
			}
		}
		return ret;
	}

}