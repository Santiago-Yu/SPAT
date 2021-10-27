class n17347053 {
	@Override
	public HttpResponse makeRequest() throws RequestCancelledException, IllegalStateException, IOException {
		checkState();
		InputStream in = null;
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(destFile));
			URLConnection conn = url.openConnection();
			in = conn.getInputStream();
			int numRead;
			byte[] buffer = new byte[BUFFRE_SIZE];
			long transferred = 0;
			long totalSize = conn.getContentLength();
			started(totalSize);
			while (!checkAbortFlag() && (numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				out.flush();
				transferred += numRead;
				progress(transferred);
			}
			if (checkAbortFlag()) {
				cancelled();
			} else {
				finished();
			}
			if (checkAbortFlag()) {
				throw new RequestCancelledException();
			}
		} finally {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
		return null;
	}

}