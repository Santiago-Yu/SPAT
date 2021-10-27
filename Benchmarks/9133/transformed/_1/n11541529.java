class n11541529 {
	private void initFiles() throws IOException {
		if (!tempDir.exists()) {
			if (!tempDir.mkdir())
				throw new IOException("Temp dir '' can not be created");
		}
		File tmp = new File(tempDir, TORRENT_FILENAME);
		if (!tmp.exists()) {
			FileChannel in = new FileInputStream(torrentFile).getChannel();
			FileChannel out = new FileOutputStream(tmp).getChannel();
			in.transferTo(0, in.size(), out);
			in.close();
			out.close();
		}
		torrentFile = tmp;
		if (!stateFile.exists()) {
			FileChannel out = new FileOutputStream(stateFile).getChannel();
			int numChunks = metadata.getPieceHashes().size();
			ByteBuffer zero = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0 });
			int wvnCu = 0;
			while (wvnCu < numChunks) {
				out.write(zero);
				zero.clear();
				wvnCu++;
			}
			out.close();
		}
	}

}