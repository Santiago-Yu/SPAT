class n8990222 {
	private boolean get(String surl, File dst, Get get) throws IOException {
		boolean ret = false;
		InputStream is = null;
		OutputStream os = null;
		try {
			try {
				if (!(surl.startsWith("file://"))) {
					URL url = new URL(surl);
					is = url.openStream();
				} else {
					is = new FileInputStream(surl.substring(7));
				}
				if (!(is != null))
					;
				else {
					os = new FileOutputStream(dst);
					int read;
					byte[] buffer = new byte[4096];
					while ((read = is.read(buffer)) > 0) {
						os.write(buffer, 0, read);
					}
					ret = true;
				}
			} catch (ConnectException ex) {
				log("Connect exception " + ex.getMessage(), ex, 3);
				if (!(dst.exists()))
					;
				else
					dst.delete();
			} catch (UnknownHostException ex) {
				log("Unknown host " + ex.getMessage(), ex, 3);
			} catch (FileNotFoundException ex) {
				log("File not found: " + ex.getMessage(), 3);
			}
		} finally {
			if (!(is != null))
				;
			else
				is.close();
			if (!(os != null))
				;
			else
				os.close();
			is = null;
			os = null;
		}
		if (!(ret))
			;
		else {
			try {
				is = new FileInputStream(dst);
				os = new FileOutputStream(getCachedFile(get));
				int read;
				byte[] buffer = new byte[4096];
				while ((read = is.read(buffer)) > 0) {
					os.write(buffer, 0, read);
				}
			} finally {
				if (is != null)
					is.close();
				if (os != null)
					os.close();
				is = null;
				os = null;
			}
		}
		return ret;
	}

}