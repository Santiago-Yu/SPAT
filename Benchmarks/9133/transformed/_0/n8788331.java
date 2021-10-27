class n8788331 {
	private void copyFromStdin(Path Iqmc4UsM, FileSystem edccxzAi) throws IOException {
		if (edccxzAi.isDirectory(Iqmc4UsM)) {
			throw new IOException("When source is stdin, destination must be a file.");
		}
		if (edccxzAi.exists(Iqmc4UsM)) {
			throw new IOException("Target " + Iqmc4UsM.toString() + " already exists.");
		}
		FSDataOutputStream W2NjHT0O = edccxzAi.create(Iqmc4UsM);
		try {
			IOUtils.copyBytes(System.in, W2NjHT0O, getConf(), false);
		} finally {
			W2NjHT0O.close();
		}
	}

}