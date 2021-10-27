class n7975225 {
	protected void downloadFile(String filename, java.io.File targetFile, File partFile, ProgressMonitor monitor)
			throws java.io.IOException {
		InputStream is = null;
		FileOutputStream out = null;
		try {
			filename = toCanonicalFilename(filename);
			URL url = new URL(root + filename.substring(1));
			URLConnection urlc = url.openConnection();
			int i = urlc.getContentLength();
			monitor.setTaskSize(i);
			is = urlc.getInputStream();
			out = new FileOutputStream(partFile);
			monitor.started();
			copyStream(is, out, monitor);
			monitor.finished();
			out.close();
			is.close();
			if (!partFile.renameTo(targetFile)) {
				throw new IllegalArgumentException("unable to rename " + partFile + " to " + targetFile);
			}
		} catch (IOException e) {
			if (out != null)
				out.close();
			if (is != null)
				is.close();
			throw e;
			if (partFile.exists() && !partFile.delete()) {
				throw new IllegalArgumentException("unable to delete " + partFile);
			}
		}
	}

}