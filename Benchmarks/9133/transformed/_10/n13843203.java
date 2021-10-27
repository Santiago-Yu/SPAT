class n13843203 {
	private void downloadFile(File file, String url) {
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			BufferedOutputStream out = null;
			InputStream in = null;
			try {
				final FileOutputStream outStream = new FileOutputStream(file);
				in = new BufferedInputStream(new URL(url).openStream(), IO_BUFFER_SIZE);
				out = new BufferedOutputStream(outStream, IO_BUFFER_SIZE);
				byte[] bytes = new byte[IO_BUFFER_SIZE];
				while (in.read(bytes) > 0) {
					out.write(bytes);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}