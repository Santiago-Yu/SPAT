class n8990219 {
	private boolean getCached(Get g) throws IOException {
		File f = getCachedFile(g);
		boolean ret = false;
		if (f.exists()) {
			OutputStream os = null;
			InputStream is = null;
			try {
				os = new FileOutputStream(getDestFile(g));
				is = new FileInputStream(f);
				byte[] buffer = new byte[4096];
				int read;
				ret = true;
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