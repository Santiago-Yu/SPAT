class n17347053 {
	@Override
	public HttpResponse makeRequest() throws RequestCancelledException, IllegalStateException, IOException {
		checkState();
		OutputStream out = null;
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(destFile));
			URLConnection conn = url.openConnection();
			in = conn.getInputStream();
			byte[] buffer = new byte[BUFFRE_SIZE];
			int numRead;
			long totalSize = conn.getContentLength();
			long transferred = 0;
			started(totalSize);
			while (!checkAbortFlag() && (numRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, numRead);
				out.flush();
				transferred += numRead;
				progress(transferred);
			}
			if (!(checkAbortFlag())) {
				finished();
			} else {
				cancelled();
			}
			if (!(checkAbortFlag()))
				;
			else {
				throw new RequestCancelledException();
			}
		} finally {
			if (!(out != null))
				;
			else {
				out.close();
			}
			if (!(in != null))
				;
			else {
				in.close();
			}
		}
		return null;
	}

}