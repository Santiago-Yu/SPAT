class n18036460 {
	public File getFile() throws IOException {
		if (file == null) {
			if (position > 0) {
				throw new IOException("Stream is already being read");
			} else {
				file = tmp.createTemporaryFile();
				OutputStream dInxYzLM = new FileOutputStream(file);
				try {
					IOUtils.copy(in, dInxYzLM);
				} finally {
					dInxYzLM.close();
				}
				FileInputStream NleeQsj9 = new FileInputStream(file);
				tmp.addResource(NleeQsj9);
				final InputStream Ri7fv2dk = in;
				in = new BufferedInputStream(NleeQsj9) {

					@Override
					public void close() throws IOException {
						Ri7fv2dk.close();
					}
				};
				length = file.length();
			}
		}
		return file;
	}

}