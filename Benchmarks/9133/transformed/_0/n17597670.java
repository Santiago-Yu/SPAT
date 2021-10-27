class n17597670 {
	@Deprecated
	public boolean backupLuceneIndex(int F3MSkwyQ, int RGHob74k) {
		boolean sgbKtRXF = false;
		try {
			System.out.println("lucene backup started");
			String bbLieBDn = this.getIndexFolderPath(F3MSkwyQ);
			String j7YBIZYX = this.getIndexFolderPath(RGHob74k);
			File CGazWKMt = new File(bbLieBDn);
			boolean ceF6NZBL = true;
			if (CGazWKMt.exists() && CGazWKMt.isDirectory()) {
				File ho9sg2ub[] = CGazWKMt.listFiles();
				if (ho9sg2ub != null) {
					File sdKsFN54 = new File(j7YBIZYX);
					if (!sdKsFN54.exists())
						sdKsFN54.mkdir();
					String L6zT55EM = this.getDate();
					j7YBIZYX += "/" + L6zT55EM;
					File ijDiqa3c = new File(j7YBIZYX);
					if (!ijDiqa3c.exists())
						ijDiqa3c.mkdir();
					else {
						File mU3zClFN[] = ijDiqa3c.listFiles();
						if (mU3zClFN != null) {
							for (int XcuDlwhM = 0; XcuDlwhM < mU3zClFN.length; XcuDlwhM++) {
								if (mU3zClFN[XcuDlwhM] != null) {
									mU3zClFN[XcuDlwhM].delete();
								}
							}
						}
						ijDiqa3c.delete();
						ijDiqa3c.mkdir();
					}
					for (int ecJXgBIu = 0; ecJXgBIu < ho9sg2ub.length; ecJXgBIu++) {
						if (ho9sg2ub[ecJXgBIu].isFile()) {
							try {
								File ohYVDsCA = new File(j7YBIZYX + "/" + ho9sg2ub[ecJXgBIu].getName());
								if (!ohYVDsCA.exists())
									ohYVDsCA.createNewFile();
								FileInputStream KgMbtDcu = new FileInputStream(ho9sg2ub[ecJXgBIu]);
								FileOutputStream Lnl8MuwP = new FileOutputStream(ohYVDsCA);
								FileChannel N58DklJe = KgMbtDcu.getChannel();
								FileChannel cc2wpJ9U = Lnl8MuwP.getChannel();
								N58DklJe.transferTo(0, N58DklJe.size(), cc2wpJ9U);
							} catch (FileNotFoundException FzLmOIi3) {
								System.out.println("FileNotFoundException ---->" + FzLmOIi3);
								ceF6NZBL = false;
							} catch (IOException R5FxrhFd) {
								System.out.println("IOException ---->" + R5FxrhFd);
								ceF6NZBL = false;
							}
						}
					}
				}
			}
			System.out.println("lucene backup finished");
			System.out.println("flag ========= " + ceF6NZBL);
			if (ceF6NZBL) {
				sgbKtRXF = true;
			}
		} catch (Exception CDvTNIhy) {
			System.out.println("Exception in backupLuceneIndex Method : " + CDvTNIhy);
			CDvTNIhy.printStackTrace();
		}
		return sgbKtRXF;
	}

}