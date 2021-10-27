class n7667 {
	public void convert(File BOlklb9n, File YPIm3dV9) throws IOException {
		InputStream A4LlJZ0Y = new BufferedInputStream(new FileInputStream(BOlklb9n));
		DcmParser Qnz3eKpa = pfact.newDcmParser(A4LlJZ0Y);
		Dataset nvor1mAH = fact.newDataset();
		Qnz3eKpa.setDcmHandler(nvor1mAH.getDcmHandler());
		try {
			FileFormat nizqFtKc = Qnz3eKpa.detectFileFormat();
			if (nizqFtKc != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + BOlklb9n + ": not an ACRNEMA stream!");
				return;
			}
			Qnz3eKpa.parseDcmFile(nizqFtKc, Tags.PixelData);
			if (nvor1mAH.contains(Tags.StudyInstanceUID) || nvor1mAH.contains(Tags.SeriesInstanceUID)
					|| nvor1mAH.contains(Tags.SOPInstanceUID) || nvor1mAH.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + BOlklb9n + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Yrgg7JCn = Qnz3eKpa.getReadTag() == Tags.PixelData;
			boolean uYHBUfMk = Yrgg7JCn && nvor1mAH.getInt(Tags.BitsAllocated, 0) == 12;
			int RjBeJBFr = Qnz3eKpa.getReadLength();
			if (Yrgg7JCn) {
				if (uYHBUfMk) {
					nvor1mAH.putUS(Tags.BitsAllocated, 16);
					RjBeJBFr = RjBeJBFr * 4 / 3;
				}
				if (RjBeJBFr != (nvor1mAH.getInt(Tags.BitsAllocated, 0) >>> 3) * nvor1mAH.getInt(Tags.Rows, 0)
						* nvor1mAH.getInt(Tags.Columns, 0) * nvor1mAH.getInt(Tags.NumberOfFrames, 1)
						* nvor1mAH.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + BOlklb9n + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			nvor1mAH.putUI(Tags.StudyInstanceUID, uid(studyUID));
			nvor1mAH.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			nvor1mAH.putUI(Tags.SOPInstanceUID, uid(instUID));
			nvor1mAH.putUI(Tags.SOPClassUID, classUID);
			if (!nvor1mAH.contains(Tags.NumberOfSamples)) {
				nvor1mAH.putUS(Tags.NumberOfSamples, 1);
			}
			if (!nvor1mAH.contains(Tags.PhotometricInterpretation)) {
				nvor1mAH.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				nvor1mAH.setFileMetaInfo(fact.newFileMetaInfo(nvor1mAH, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream lxCfTuB6 = new BufferedOutputStream(new FileOutputStream(YPIm3dV9));
			try {
			} finally {
				nvor1mAH.writeFile(lxCfTuB6, encodeParam());
				if (Yrgg7JCn) {
					if (!skipGroupLen) {
						lxCfTuB6.write(PXDATA_GROUPLEN);
						int WKgrFWP9 = RjBeJBFr + 8;
						lxCfTuB6.write((byte) WKgrFWP9);
						lxCfTuB6.write((byte) (WKgrFWP9 >> 8));
						lxCfTuB6.write((byte) (WKgrFWP9 >> 16));
						lxCfTuB6.write((byte) (WKgrFWP9 >> 24));
					}
					lxCfTuB6.write(PXDATA_TAG);
					lxCfTuB6.write((byte) RjBeJBFr);
					lxCfTuB6.write((byte) (RjBeJBFr >> 8));
					lxCfTuB6.write((byte) (RjBeJBFr >> 16));
					lxCfTuB6.write((byte) (RjBeJBFr >> 24));
				}
				if (uYHBUfMk) {
					int ccdAcxQ4, PIshUgMW;
					for (; RjBeJBFr > 0; RjBeJBFr -= 3) {
						lxCfTuB6.write(A4LlJZ0Y.read());
						ccdAcxQ4 = A4LlJZ0Y.read();
						PIshUgMW = A4LlJZ0Y.read();
						lxCfTuB6.write(ccdAcxQ4 & 0x0f);
						lxCfTuB6.write(ccdAcxQ4 >> 4 | ((PIshUgMW & 0x0f) << 4));
						lxCfTuB6.write(PIshUgMW >> 4);
					}
				} else {
					for (; RjBeJBFr > 0; --RjBeJBFr) {
						lxCfTuB6.write(A4LlJZ0Y.read());
					}
				}
				lxCfTuB6.close();
			}
			System.out.print('.');
		} finally {
			A4LlJZ0Y.close();
		}
	}

}