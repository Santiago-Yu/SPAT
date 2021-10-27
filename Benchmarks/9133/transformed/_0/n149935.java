class n149935 {
	public void convert(File K5C4EVKh, File Hz8m0wNK) throws IOException {
		InputStream mdoXRBJA = new BufferedInputStream(new FileInputStream(K5C4EVKh));
		DcmParser Gr7jGAm0 = pfact.newDcmParser(mdoXRBJA);
		Dataset MNRS9xl2 = fact.newDataset();
		Gr7jGAm0.setDcmHandler(MNRS9xl2.getDcmHandler());
		try {
			FileFormat wMpSsZ0z = Gr7jGAm0.detectFileFormat();
			if (wMpSsZ0z != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + K5C4EVKh + ": not an ACRNEMA stream!");
				return;
			}
			Gr7jGAm0.parseDcmFile(wMpSsZ0z, Tags.PixelData);
			if (MNRS9xl2.contains(Tags.StudyInstanceUID) || MNRS9xl2.contains(Tags.SeriesInstanceUID)
					|| MNRS9xl2.contains(Tags.SOPInstanceUID) || MNRS9xl2.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + K5C4EVKh + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean NmCv5mGl = Gr7jGAm0.getReadTag() == Tags.PixelData;
			boolean fGXqmc6R = NmCv5mGl && MNRS9xl2.getInt(Tags.BitsAllocated, 0) == 12;
			int v4kZH8oJ = Gr7jGAm0.getReadLength();
			if (NmCv5mGl) {
				if (fGXqmc6R) {
					MNRS9xl2.putUS(Tags.BitsAllocated, 16);
					v4kZH8oJ = v4kZH8oJ * 4 / 3;
				}
				if (v4kZH8oJ != (MNRS9xl2.getInt(Tags.BitsAllocated, 0) >>> 3) * MNRS9xl2.getInt(Tags.Rows, 0)
						* MNRS9xl2.getInt(Tags.Columns, 0) * MNRS9xl2.getInt(Tags.NumberOfFrames, 1)
						* MNRS9xl2.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + K5C4EVKh + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			MNRS9xl2.putUI(Tags.StudyInstanceUID, uid(studyUID));
			MNRS9xl2.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			MNRS9xl2.putUI(Tags.SOPInstanceUID, uid(instUID));
			MNRS9xl2.putUI(Tags.SOPClassUID, classUID);
			if (!MNRS9xl2.contains(Tags.NumberOfSamples)) {
				MNRS9xl2.putUS(Tags.NumberOfSamples, 1);
			}
			if (!MNRS9xl2.contains(Tags.PhotometricInterpretation)) {
				MNRS9xl2.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				MNRS9xl2.setFileMetaInfo(fact.newFileMetaInfo(MNRS9xl2, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream rxwfCoRx = new BufferedOutputStream(new FileOutputStream(Hz8m0wNK));
			try {
			} finally {
				MNRS9xl2.writeFile(rxwfCoRx, encodeParam());
				if (NmCv5mGl) {
					if (!skipGroupLen) {
						rxwfCoRx.write(PXDATA_GROUPLEN);
						int ZE2PVKHg = v4kZH8oJ + 8;
						rxwfCoRx.write((byte) ZE2PVKHg);
						rxwfCoRx.write((byte) (ZE2PVKHg >> 8));
						rxwfCoRx.write((byte) (ZE2PVKHg >> 16));
						rxwfCoRx.write((byte) (ZE2PVKHg >> 24));
					}
					rxwfCoRx.write(PXDATA_TAG);
					rxwfCoRx.write((byte) v4kZH8oJ);
					rxwfCoRx.write((byte) (v4kZH8oJ >> 8));
					rxwfCoRx.write((byte) (v4kZH8oJ >> 16));
					rxwfCoRx.write((byte) (v4kZH8oJ >> 24));
				}
				if (fGXqmc6R) {
					int cW0bmpwA, WhYZ7pTk;
					for (; v4kZH8oJ > 0; v4kZH8oJ -= 3) {
						rxwfCoRx.write(mdoXRBJA.read());
						cW0bmpwA = mdoXRBJA.read();
						WhYZ7pTk = mdoXRBJA.read();
						rxwfCoRx.write(cW0bmpwA & 0x0f);
						rxwfCoRx.write(cW0bmpwA >> 4 | ((WhYZ7pTk & 0x0f) << 4));
						rxwfCoRx.write(WhYZ7pTk >> 4);
					}
				} else {
					for (; v4kZH8oJ > 0; --v4kZH8oJ) {
						rxwfCoRx.write(mdoXRBJA.read());
					}
				}
				rxwfCoRx.close();
			}
			System.out.print('.');
		} finally {
			mdoXRBJA.close();
		}
	}

}