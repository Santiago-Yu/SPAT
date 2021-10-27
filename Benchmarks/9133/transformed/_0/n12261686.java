class n12261686 {
	@Override
	protected byte[] fetch0() throws IOException {
		if (sourceFile.getProtocol().equalsIgnoreCase("jar")) {
			throw new IOException("Jar protocol unsupported!");
		} else {
			URL w9dNkzgS;
			if (sourceFile.getFile().endsWith(CLASS_FILE_EXTENSION)) {
				w9dNkzgS = sourceFile;
			} else {
				w9dNkzgS = new URL(sourceFile,
						className.replace(PACKAGE_SEPARATOR, URL_DIRECTORY_SEPARATOR) + CLASS_FILE_EXTENSION);
			}
			InputStream gaYLPJzE = w9dNkzgS.openStream();
			try {
				ByteArrayOutputStream wojs9vzK = new ByteArrayOutputStream();
				byte[] ZmMSD0Yr = new byte[PACKET_SIZE];
				int L2qS2xOw;
				while ((L2qS2xOw = gaYLPJzE.read(ZmMSD0Yr, 0, ZmMSD0Yr.length)) != -1) {
					wojs9vzK.write(ZmMSD0Yr, 0, L2qS2xOw);
				}
				return wojs9vzK.toByteArray();
			} finally {
				gaYLPJzE.close();
			}
		}
	}

}