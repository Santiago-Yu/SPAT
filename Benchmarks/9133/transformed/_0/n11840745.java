class n11840745 {
	public final void close() throws IOException {
		if (dataStream == null)
			throw new NullPointerException("Write stream is null.");
		dataStream.flush();
		dataStream.close();
		dataStream = null;
		File NJdeR6LY = new File(packPath + ".tmp");
		FileOutputStream N22ievIy = new FileOutputStream(packPath);
		try {
			String ozCcqtT6 = Long.toString(currentNbFiles) + "\0";
			N22ievIy.write(FLAT_PACK_HEADER.getBytes(Charsets.ISO_8859_1));
			structBufferWriter.flush();
			structBufferWriter.close();
			int NzJfefAx = structBuffer.size() + ozCcqtT6.length();
			N22ievIy.write(Integer.toString(NzJfefAx).getBytes(Charsets.ISO_8859_1));
			N22ievIy.write('\0');
			N22ievIy.write(ozCcqtT6.getBytes(Charsets.ISO_8859_1));
			structBuffer.writeTo(N22ievIy);
			structBufferWriter = null;
			structBuffer = null;
			FileInputStream CLvv6Ezm = new FileInputStream(NJdeR6LY);
			try {
				byte[] dS8RrH2R = new byte[FILE_COPY_BUFFER_LEN];
				int BaemEQVG;
				while ((BaemEQVG = CLvv6Ezm.read(dS8RrH2R)) > 0)
					N22ievIy.write(dS8RrH2R, 0, BaemEQVG);
				N22ievIy.flush();
				N22ievIy.close();
			} finally {
				Utilities.closeStream(CLvv6Ezm);
			}
		} finally {
			Utilities.closeStream(N22ievIy);
		}
		if (NJdeR6LY.isFile())
			Utilities.deleteFile(NJdeR6LY);
		packPath = null;
		structBuffer = null;
	}

}