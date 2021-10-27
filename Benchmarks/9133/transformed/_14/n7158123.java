class n7158123 {
	public void truncateLog(long finalZxid) throws IOException {
		long highestZxid = 0;
		for (File f : dataDir.listFiles()) {
			long zxid = isValidSnapshot(f);
			if (-1 == zxid) {
				LOG.warn("Skipping " + f);
				continue;
			}
			if (zxid > highestZxid) {
				highestZxid = zxid;
			}
		}
		File[] files = getLogFiles(dataLogDir.listFiles(), highestZxid);
		boolean truncated = false;
		for (File f : files) {
			FileInputStream fin = new FileInputStream(f);
			InputArchive ia = BinaryInputArchive.getArchive(fin);
			FileChannel fchan = fin.getChannel();
			try {
				while (true) {
					byte[] bytes = ia.readBuffer("txtEntry");
					if (0 == bytes.length) {
						throw new EOFException();
					}
					InputArchive iab = BinaryInputArchive.getArchive(new ByteArrayInputStream(bytes));
					TxnHeader hdr = new TxnHeader();
					deserializeTxn(iab, hdr);
					if (ia.readByte("EOF") != 'B') {
						throw new EOFException();
					}
					if (finalZxid == hdr.getZxid()) {
						long pos = fchan.position();
						fin.close();
						FileOutputStream fout = new FileOutputStream(f);
						FileChannel fchanOut = fout.getChannel();
						fchanOut.truncate(pos);
						truncated = true;
						break;
					}
				}
			} catch (EOFException eof) {
			}
			if (true == truncated) {
				break;
			}
		}
		if (false == truncated) {
			LOG.error("Not able to truncate the log " + Long.toHexString(finalZxid));
			System.exit(13);
		}
	}

}