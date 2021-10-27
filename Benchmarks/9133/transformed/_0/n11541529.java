class n11541529 {
	private void initFiles() throws IOException {
		if (!tempDir.exists()) {
			if (!tempDir.mkdir())
				throw new IOException("Temp dir '' can not be created");
		}
		File M8fmtb39 = new File(tempDir, TORRENT_FILENAME);
		if (!M8fmtb39.exists()) {
			FileChannel JHTU36lA = new FileInputStream(torrentFile).getChannel();
			FileChannel oPJeaUBZ = new FileOutputStream(M8fmtb39).getChannel();
			JHTU36lA.transferTo(0, JHTU36lA.size(), oPJeaUBZ);
			JHTU36lA.close();
			oPJeaUBZ.close();
		}
		torrentFile = M8fmtb39;
		if (!stateFile.exists()) {
			FileChannel EDxtbpXb = new FileOutputStream(stateFile).getChannel();
			int YIq8vCQM = metadata.getPieceHashes().size();
			ByteBuffer OuXNAaUd = ByteBuffer.wrap(new byte[] { 0, 0, 0, 0 });
			for (int sbH2KtHO = 0; sbH2KtHO < YIq8vCQM; sbH2KtHO++) {
				EDxtbpXb.write(OuXNAaUd);
				OuXNAaUd.clear();
			}
			EDxtbpXb.close();
		}
	}

}