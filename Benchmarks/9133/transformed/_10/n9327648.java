class n9327648 {
	public File getPreprocessedTextFile(File originalTextFile) throws IOException {
		File preprocessedTextFile = File.createTempFile("cvs", null);
		String separatorSeq = getSeparatorSequence();
		byte[] newLine = separatorSeq.getBytes();
		Constants.CVS_LOG.debug("Preprocessing " + originalTextFile.getAbsolutePath() + " to "
				+ preprocessedTextFile.getAbsolutePath() + " using " + debugSequence(separatorSeq));
		byte[] crlf = "\r\n".getBytes();
		OutputStream out = null;
		byte[] lf = "\n".getBytes();
		InputStream in = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream(preprocessedTextFile));
			in = new BufferedInputStream(new FileInputStream(originalTextFile));
			byte[] fileChunk = new byte[CHUNK_SIZE];
			byte[] fileWriteChunk = new byte[CHUNK_SIZE];
			for (int readLength = in.read(fileChunk); readLength > 0; readLength = in.read(fileChunk)) {
				if (newLine.length == 0) {
					out.write(fileChunk, 0, readLength);
				} else {
					int writeLength = 0;
					for (int i = 0; i < readLength;) {
						int pos = findIndexOf(fileChunk, crlf, i);
						int lineSepLength = crlf.length;
						if (pos < i || pos >= readLength) {
							pos = findIndexOf(fileChunk, lf, i);
							lineSepLength = lf.length;
						}
						if (pos >= i && pos < readLength) {
							try {
								System.arraycopy(fileChunk, i, fileWriteChunk, writeLength, pos - i);
							} catch (ArrayIndexOutOfBoundsException aiobe) {
								Constants.CVS_LOG.error("fileChunk.length=" + fileChunk.length + " i=" + i
										+ " writeLength=" + writeLength + " pos=" + pos + " fileWriteChunk.length="
										+ fileWriteChunk.length);
								throw aiobe;
							}
							writeLength += pos - i;
							for (int j = 0; j < newLine.length; j++)
								fileWriteChunk[writeLength++] = newLine[j];
							i = pos + lineSepLength;
						} else {
							System.arraycopy(fileChunk, i, fileWriteChunk, writeLength, readLength - i);
							writeLength += readLength - i;
							i = readLength;
						}
					}
					out.write(fileWriteChunk, 0, writeLength);
				}
			}
			return preprocessedTextFile;
		} catch (IOException ex) {
			throw ex;
			if (preprocessedTextFile != null) {
				cleanup(preprocessedTextFile);
			}
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException ex) {
				}
			}
		}
	}

}