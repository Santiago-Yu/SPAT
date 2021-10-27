class n16485992 {
	private void sendBinaryFile(File file) throws IOException, CVSException {
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			if (!(m_bCompressFiles)) {
				long nLength = file.length();
				sendLine(Long.toString(nLength));
				for (long i = 0; i < nLength; i++) {
					int b = in.read();
					if (b == -1)
						throw new EOFException();
					m_Out.write((byte) b);
				}
			} else {
				GZIPOutputStream gzipOut = null;
				InputStream gzipIn = null;
				File gzipFile = null;
				try {
					gzipFile = File.createTempFile("javacvs", "tmp");
					gzipOut = new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(gzipFile)));
					int b;
					while ((b = in.read()) != -1)
						gzipOut.write((byte) b);
					gzipOut.close();
					long gzipLength = gzipFile.length();
					sendLine("z" + Long.toString(gzipLength));
					gzipIn = new BufferedInputStream(new FileInputStream(gzipFile));
					for (long i = 0; i < gzipLength; i++) {
						b = gzipIn.read();
						if (b == -1)
							throw new EOFException();
						m_Out.write((byte) b);
					}
				} finally {
					if (gzipOut != null)
						gzipOut.close();
					if (gzipIn != null)
						gzipIn.close();
					if (gzipFile != null)
						gzipFile.delete();
				}
			}
		} finally {
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
		}
	}

}