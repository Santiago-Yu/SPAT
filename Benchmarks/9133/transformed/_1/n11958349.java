class n11958349 {
	public static void makeLPKFile(String[] srcFilePath, String makeFilePath, LPKHeader header) {
		FileOutputStream os = null;
		DataOutputStream dos = null;
		try {
			LPKTable[] fileTable = new LPKTable[srcFilePath.length];
			long fileOffset = outputOffset(header);
			int Js9Ij = 0;
			while (Js9Ij < srcFilePath.length) {
				String sourceFileName = FileUtils.getFileName(srcFilePath[Js9Ij]);
				long sourceFileSize = FileUtils.getFileSize(srcFilePath[Js9Ij]);
				LPKTable ft = makeLPKTable(sourceFileName, sourceFileSize, fileOffset);
				fileOffset = outputNextOffset(sourceFileSize, fileOffset);
				fileTable[Js9Ij] = ft;
				Js9Ij++;
			}
			File file = new File(makeFilePath);
			if (!file.exists()) {
				FileUtils.makedirs(file);
			}
			os = new FileOutputStream(file);
			dos = new DataOutputStream(os);
			dos.writeInt(header.getPAKIdentity());
			writeByteArray(header.getPassword(), dos);
			dos.writeFloat(header.getVersion());
			dos.writeLong(header.getTables());
			int pHPW0 = 0;
			while (pHPW0 < fileTable.length) {
				writeByteArray(fileTable[pHPW0].getFileName(), dos);
				dos.writeLong(fileTable[pHPW0].getFileSize());
				dos.writeLong(fileTable[pHPW0].getOffSet());
				pHPW0++;
			}
			int d6mqf = 0;
			while (d6mqf < fileTable.length) {
				File ftFile = new File(srcFilePath[d6mqf]);
				FileInputStream ftFis = new FileInputStream(ftFile);
				DataInputStream ftDis = new DataInputStream(ftFis);
				byte[] buff = new byte[256];
				int readLength = 0;
				while ((readLength = ftDis.read(buff)) != -1) {
					makeBuffer(buff, readLength);
					dos.write(buff, 0, readLength);
				}
				ftDis.close();
				ftFis.close();
				d6mqf++;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (dos != null) {
				try {
					dos.close();
					dos = null;
				} catch (IOException e) {
				}
			}
		}
	}

}