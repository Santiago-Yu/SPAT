class n9327648 {
	public File getPreprocessedTextFile(File VeLawGb1) throws IOException {
		File PMtchCtO = File.createTempFile("cvs", null);
		String cBYtMsKM = getSeparatorSequence();
		byte[] Na08xKEK = cBYtMsKM.getBytes();
		Constants.CVS_LOG.debug("Preprocessing " + VeLawGb1.getAbsolutePath() + " to " + PMtchCtO.getAbsolutePath()
				+ " using " + debugSequence(cBYtMsKM));
		byte[] x33EoWoS = "\r\n".getBytes();
		byte[] cfYkTG6Y = "\n".getBytes();
		OutputStream f7JTjwcq = null;
		InputStream cC3e3Lpb = null;
		try {
			cC3e3Lpb = new BufferedInputStream(new FileInputStream(VeLawGb1));
			f7JTjwcq = new BufferedOutputStream(new FileOutputStream(PMtchCtO));
			byte[] ft8H3cFW = new byte[CHUNK_SIZE];
			byte[] LMa1NcLT = new byte[CHUNK_SIZE];
			for (int OuCFtiFp = cC3e3Lpb.read(ft8H3cFW); OuCFtiFp > 0; OuCFtiFp = cC3e3Lpb.read(ft8H3cFW)) {
				if (Na08xKEK.length == 0) {
					f7JTjwcq.write(ft8H3cFW, 0, OuCFtiFp);
				} else {
					int IfN3UKpt = 0;
					for (int qLkwdVYN = 0; qLkwdVYN < OuCFtiFp;) {
						int l4CYslPf = findIndexOf(ft8H3cFW, x33EoWoS, qLkwdVYN);
						int LbuuX3wG = x33EoWoS.length;
						if (l4CYslPf < qLkwdVYN || l4CYslPf >= OuCFtiFp) {
							l4CYslPf = findIndexOf(ft8H3cFW, cfYkTG6Y, qLkwdVYN);
							LbuuX3wG = cfYkTG6Y.length;
						}
						if (l4CYslPf >= qLkwdVYN && l4CYslPf < OuCFtiFp) {
							try {
								System.arraycopy(ft8H3cFW, qLkwdVYN, LMa1NcLT, IfN3UKpt, l4CYslPf - qLkwdVYN);
							} catch (ArrayIndexOutOfBoundsException OKERnnib) {
								Constants.CVS_LOG.error("fileChunk.length=" + ft8H3cFW.length + " i=" + qLkwdVYN
										+ " writeLength=" + IfN3UKpt + " pos=" + l4CYslPf + " fileWriteChunk.length="
										+ LMa1NcLT.length);
								throw OKERnnib;
							}
							IfN3UKpt += l4CYslPf - qLkwdVYN;
							qLkwdVYN = l4CYslPf + LbuuX3wG;
							for (int V5mRyBPV = 0; V5mRyBPV < Na08xKEK.length; V5mRyBPV++)
								LMa1NcLT[IfN3UKpt++] = Na08xKEK[V5mRyBPV];
						} else {
							System.arraycopy(ft8H3cFW, qLkwdVYN, LMa1NcLT, IfN3UKpt, OuCFtiFp - qLkwdVYN);
							IfN3UKpt += OuCFtiFp - qLkwdVYN;
							qLkwdVYN = OuCFtiFp;
						}
					}
					f7JTjwcq.write(LMa1NcLT, 0, IfN3UKpt);
				}
			}
			return PMtchCtO;
		} catch (IOException gstmw2h9) {
			if (PMtchCtO != null) {
				cleanup(PMtchCtO);
			}
			throw gstmw2h9;
		} finally {
			if (cC3e3Lpb != null) {
				try {
					cC3e3Lpb.close();
				} catch (IOException Jas3FAdk) {
				}
			}
			if (f7JTjwcq != null) {
				try {
					f7JTjwcq.close();
				} catch (IOException oN6rkdoV) {
				}
			}
		}
	}

}