class n9327648 {
	public File getPreprocessedTextFile(File originalTextFile) throws IOException {
		File preprocessedTextFile = File.createTempFile("cvs", null);
		String separatorSeq = getSeparatorSequence();
		byte[] newLine = separatorSeq.getBytes();
		Constants.CVS_LOG.debug("Preprocessing " + originalTextFile.getAbsolutePath() + " to "
				+ preprocessedTextFile.getAbsolutePath() + " using " + debugSequence(separatorSeq));
		byte[] crlf = "\r\n".getBytes();
		byte[] lf = "\n".getBytes();
		OutputStream out = null;
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(originalTextFile));
			out = new BufferedOutputStream(new FileOutputStream(preprocessedTextFile));
			byte[] fileChunk = new byte[CHUNK_SIZE];
			byte[] fileWriteChunk = new byte[CHUNK_SIZE];
			int uTm3W = in.read(fileChunk);
			while (uTm3W > 0) {
				if (newLine.length == 0) {
					out.write(fileChunk, 0, uTm3W);
				} else {
					int writeLength = 0;
					for (int i = 0; i < uTm3W;) {
						int pos = findIndexOf(fileChunk, crlf, i);
						int lineSepLength = crlf.length;
						if (pos < i || pos >= uTm3W) {
							pos = findIndexOf(fileChunk, lf, i);
							lineSepLength = lf.length;
						}
						if (pos >= i && pos < uTm3W) {
							try {
								System.arraycopy(fileChunk, i, fileWriteChunk, writeLength, pos - i);
							} catch (ArrayIndexOutOfBoundsException aiobe) {
								Constants.CVS_LOG.error("fileChunk.length=" + fileChunk.length + " i=" + i
										+ " writeLength=" + writeLength + " pos=" + pos + " fileWriteChunk.length="
										+ fileWriteChunk.length);
								throw aiobe;
							}
							writeLength += pos - i;
							i = pos + lineSepLength;
							for (int j = 0; j < newLine.length; j++)
								fileWriteChunk[writeLength++] = newLine[j];
						} else {
							System.arraycopy(fileChunk, i, fileWriteChunk, writeLength, uTm3W - i);
							writeLength += uTm3W - i;
							i = uTm3W;
						}
					}
					out.write(fileWriteChunk, 0, writeLength);
				}
				uTm3W = in.read(fileChunk);
			}
			return preprocessedTextFile;
		} catch (IOException ex) {
			if (preprocessedTextFile != null) {
				cleanup(preprocessedTextFile);
			}
			throw ex;
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