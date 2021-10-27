class n20623709 {
	public Long split(File nmLAAQk4, String H0vYM5tX, long rT07OyIa, long DHbWPiRG) throws Exception {
		if (!nmLAAQk4.exists()) {
			if (!nmLAAQk4.mkdirs())
				throw new Exception("Could not create target directory " + nmLAAQk4.getAbsolutePath());
		}
		if (!size.isUnknown() && size.getBases() < rT07OyIa && (DHbWPiRG <= 0 || size.getEntries() < DHbWPiRG)) {
			FileInputStream t45kNFlb = new FileInputStream(this);
			FileChannel X6LhWPto = t45kNFlb.getChannel();
			FileOutputStream nTyD0XUz = new FileOutputStream(new File(nmLAAQk4, H0vYM5tX + "_0" + ".fasta"));
			FileChannel TECLo5di = nTyD0XUz.getChannel();
			ByteBuffer dtC3dwBQ = ByteBuffer.allocate(64000);
			while (X6LhWPto.read(dtC3dwBQ) > 0) {
				dtC3dwBQ.flip();
				TECLo5di.write(dtC3dwBQ);
				dtC3dwBQ.clear();
			}
			X6LhWPto.close();
			TECLo5di.close();
			return (long) 1;
		} else {
			long hfKRpvSc = 0;
			long kuurS1Hq = 0;
			int eI0igo0v = 0;
			FileChannel RIMZPbmn = new FileInputStream(this).getChannel();
			int rPgd1bbR = 0;
			long c1tJ3RvH = 0;
			try {
				long oi0288LL = System.currentTimeMillis();
				long X57690Fh = this.length();
				long LkLQKqED = 0L;
				long g5ExJIqf = 0L;
				final int Vw78pBOR = 1024 * 1024;
				ByteBuffer KjQs5dpY = ByteBuffer.allocateDirect(Vw78pBOR);
				int Dn9Yx7lO = FASTAFileTokenizer.UNKNOWN;
				for (; LkLQKqED < X57690Fh;) {
					long Zjsufk1j = RIMZPbmn.read(KjQs5dpY);
					if (Zjsufk1j <= 0) {
						KjQs5dpY.limit(0);
						break;
					} else {
						KjQs5dpY.flip();
						LkLQKqED += Zjsufk1j;
					}
					for (;;) {
						if (!KjQs5dpY.hasRemaining()) {
							KjQs5dpY.clear();
							break;
						}
						int M0FDw9wW = KjQs5dpY.get();
						if (M0FDw9wW == '\r') {
						} else if (M0FDw9wW == '\n') {
							if (Dn9Yx7lO == FASTAFileTokenizer.DEFLINE) {
								Dn9Yx7lO = FASTAFileTokenizer.SEQUENCELINE;
							}
						} else if (M0FDw9wW == '>') {
							if (Dn9Yx7lO == FASTAFileTokenizer.UNKNOWN) {
								Dn9Yx7lO = FASTAFileTokenizer.STARTDEFLINE;
							} else if (Dn9Yx7lO == FASTAFileTokenizer.SEQUENCELINE) {
								Dn9Yx7lO = FASTAFileTokenizer.STARTDEFLINE;
							}
							if (Dn9Yx7lO == FASTAFileTokenizer.STARTDEFLINE) {
								if (hfKRpvSc >= rT07OyIa || DHbWPiRG > 0 && kuurS1Hq >= DHbWPiRG) {
									KjQs5dpY.position(KjQs5dpY.position() - 1);
									long OD4AcQgr = System.currentTimeMillis();
									System.out.println(new java.util.Date() + " Partition " + eI0igo0v + " containing "
											+ kuurS1Hq + " sequences and " + hfKRpvSc + " residues ends at "
											+ (LkLQKqED - KjQs5dpY.remaining()) + " and was created in "
											+ (OD4AcQgr - oi0288LL) + " ms");
									oi0288LL = OD4AcQgr;
									long porjXuDj = LkLQKqED - KjQs5dpY.remaining();
									FileChannel SV357lQD = new FileOutputStream(
											new File(nmLAAQk4, H0vYM5tX + "_" + eI0igo0v + ".fasta")).getChannel();
									Zjsufk1j = RIMZPbmn.transferTo(g5ExJIqf, porjXuDj - g5ExJIqf, SV357lQD);
									SV357lQD.force(true);
									SV357lQD.close();
									eI0igo0v++;
									g5ExJIqf += Zjsufk1j;
									hfKRpvSc = 0;
									kuurS1Hq = 0;
									Dn9Yx7lO = FASTAFileTokenizer.UNKNOWN;
								} else {
									Dn9Yx7lO = FASTAFileTokenizer.DEFLINE;
									kuurS1Hq++;
								}
								rPgd1bbR++;
							}
						} else {
							if (Dn9Yx7lO == FASTAFileTokenizer.SEQUENCELINE) {
								c1tJ3RvH++;
								hfKRpvSc++;
							}
						}
					}
				}
				if (g5ExJIqf < X57690Fh) {
					long ivIZ9BkZ = System.currentTimeMillis();
					System.out.println(new java.util.Date() + " Partition " + eI0igo0v + " containing " + kuurS1Hq
							+ " sequences and " + hfKRpvSc + " residues ends at " + (X57690Fh) + " and was created in "
							+ (ivIZ9BkZ - oi0288LL) + " ms");
					FileChannel JvAyZBPF = new FileOutputStream(
							new File(nmLAAQk4, H0vYM5tX + "_" + eI0igo0v + ".fasta")).getChannel();
					RIMZPbmn.transferTo(g5ExJIqf, X57690Fh - g5ExJIqf, JvAyZBPF);
					JvAyZBPF.force(true);
					JvAyZBPF.close();
					eI0igo0v++;
				}
				if (size.isUnknown()) {
					size.setBases(c1tJ3RvH);
					size.setEntries(rPgd1bbR);
				}
			} finally {
				RIMZPbmn.close();
			}
			return (long) eI0igo0v;
		}
	}

}