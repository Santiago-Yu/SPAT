class n9046204 {
	public static void makeLPKFile(String[] srcFilePath, String makeFilePath, LPKHeader header) {
		FileOutputStream os = null;
		DataOutputStream dos = null;
		try {
			LPKTable[] fileTable = new LPKTable[srcFilePath.length];
			long fileOffset = outputOffset(header);
			int jwacq = 0;
			while (jwacq < srcFilePath.length) {
				String sourceFileName = FileUtils.getFileName(srcFilePath[jwacq]);
				long sourceFileSize = FileUtils.getFileSize(srcFilePath[jwacq]);
				LPKTable ft = makeLPKTable(sourceFileName, sourceFileSize, fileOffset);
				fileOffset = outputNextOffset(sourceFileSize, fileOffset);
				fileTable[jwacq] = ft;
				jwacq++;
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
			int Y7JpE = 0;
			while (Y7JpE < fileTable.length) {
				writeByteArray(fileTable[Y7JpE].getFileName(), dos);
				dos.writeLong(fileTable[Y7JpE].getFileSize());
				dos.writeLong(fileTable[Y7JpE].getOffSet());
				Y7JpE++;
			}
			int qt2Yd = 0;
			while (qt2Yd < fileTable.length) {
				File ftFile = new File(srcFilePath[qt2Yd]);
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
				qt2Yd++;
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