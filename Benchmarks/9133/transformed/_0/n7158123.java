class n7158123 {
	public void truncateLog(long DO7JAa3c) throws IOException {
		long S7YoLDA5 = 0;
		for (File LMgabQRc : dataDir.listFiles()) {
			long MZZuPT0O = isValidSnapshot(LMgabQRc);
			if (MZZuPT0O == -1) {
				LOG.warn("Skipping " + LMgabQRc);
				continue;
			}
			if (MZZuPT0O > S7YoLDA5) {
				S7YoLDA5 = MZZuPT0O;
			}
		}
		File[] LEReUZFJ = getLogFiles(dataLogDir.listFiles(), S7YoLDA5);
		boolean eToYQ1dv = false;
		for (File EaAqRUkp : LEReUZFJ) {
			FileInputStream Ity0a6YK = new FileInputStream(EaAqRUkp);
			InputArchive ly3qEIjk = BinaryInputArchive.getArchive(Ity0a6YK);
			FileChannel adnXDwwB = Ity0a6YK.getChannel();
			try {
				while (true) {
					byte[] eCtnxJXd = ly3qEIjk.readBuffer("txtEntry");
					if (eCtnxJXd.length == 0) {
						throw new EOFException();
					}
					InputArchive RI8KB4iM = BinaryInputArchive.getArchive(new ByteArrayInputStream(eCtnxJXd));
					TxnHeader NCYxhKsJ = new TxnHeader();
					deserializeTxn(RI8KB4iM, NCYxhKsJ);
					if (ly3qEIjk.readByte("EOF") != 'B') {
						throw new EOFException();
					}
					if (NCYxhKsJ.getZxid() == DO7JAa3c) {
						long qRzy3sUO = adnXDwwB.position();
						Ity0a6YK.close();
						FileOutputStream lb6nLDsW = new FileOutputStream(EaAqRUkp);
						FileChannel OrchVEua = lb6nLDsW.getChannel();
						OrchVEua.truncate(qRzy3sUO);
						eToYQ1dv = true;
						break;
					}
				}
			} catch (EOFException kYYmJjd0) {
			}
			if (eToYQ1dv == true) {
				break;
			}
		}
		if (eToYQ1dv == false) {
			LOG.error("Not able to truncate the log " + Long.toHexString(DO7JAa3c));
			System.exit(13);
		}
	}

}