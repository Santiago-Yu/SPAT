class n145197 {
	public void convert(File j2qq0omi, File FNLzbZKd) throws IOException {
		InputStream SESQ7RzE = new BufferedInputStream(new FileInputStream(j2qq0omi));
		DcmParser vQd7DOxN = pfact.newDcmParser(SESQ7RzE);
		Dataset xyuPHrwb = fact.newDataset();
		vQd7DOxN.setDcmHandler(xyuPHrwb.getDcmHandler());
		try {
			FileFormat C6eMa6Qm = vQd7DOxN.detectFileFormat();
			if (C6eMa6Qm != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + j2qq0omi + ": not an ACRNEMA stream!");
				return;
			}
			vQd7DOxN.parseDcmFile(C6eMa6Qm, Tags.PixelData);
			if (xyuPHrwb.contains(Tags.StudyInstanceUID) || xyuPHrwb.contains(Tags.SeriesInstanceUID)
					|| xyuPHrwb.contains(Tags.SOPInstanceUID) || xyuPHrwb.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + j2qq0omi + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean GuPap4xT = vQd7DOxN.getReadTag() == Tags.PixelData;
			boolean eHu9HTO8 = GuPap4xT && xyuPHrwb.getInt(Tags.BitsAllocated, 0) == 12;
			int HN0rH6dr = vQd7DOxN.getReadLength();
			if (GuPap4xT) {
				if (eHu9HTO8) {
					xyuPHrwb.putUS(Tags.BitsAllocated, 16);
					HN0rH6dr = HN0rH6dr * 4 / 3;
				}
				if (HN0rH6dr != (xyuPHrwb.getInt(Tags.BitsAllocated, 0) >>> 3) * xyuPHrwb.getInt(Tags.Rows, 0)
						* xyuPHrwb.getInt(Tags.Columns, 0) * xyuPHrwb.getInt(Tags.NumberOfFrames, 1)
						* xyuPHrwb.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + j2qq0omi + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			xyuPHrwb.putUI(Tags.StudyInstanceUID, uid(studyUID));
			xyuPHrwb.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			xyuPHrwb.putUI(Tags.SOPInstanceUID, uid(instUID));
			xyuPHrwb.putUI(Tags.SOPClassUID, classUID);
			if (!xyuPHrwb.contains(Tags.NumberOfSamples)) {
				xyuPHrwb.putUS(Tags.NumberOfSamples, 1);
			}
			if (!xyuPHrwb.contains(Tags.PhotometricInterpretation)) {
				xyuPHrwb.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				xyuPHrwb.setFileMetaInfo(fact.newFileMetaInfo(xyuPHrwb, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream lcY3Pfbr = new BufferedOutputStream(new FileOutputStream(FNLzbZKd));
			try {
			} finally {
				xyuPHrwb.writeFile(lcY3Pfbr, encodeParam());
				if (GuPap4xT) {
					if (!skipGroupLen) {
						lcY3Pfbr.write(PXDATA_GROUPLEN);
						int gwGqJn4S = HN0rH6dr + 8;
						lcY3Pfbr.write((byte) gwGqJn4S);
						lcY3Pfbr.write((byte) (gwGqJn4S >> 8));
						lcY3Pfbr.write((byte) (gwGqJn4S >> 16));
						lcY3Pfbr.write((byte) (gwGqJn4S >> 24));
					}
					lcY3Pfbr.write(PXDATA_TAG);
					lcY3Pfbr.write((byte) HN0rH6dr);
					lcY3Pfbr.write((byte) (HN0rH6dr >> 8));
					lcY3Pfbr.write((byte) (HN0rH6dr >> 16));
					lcY3Pfbr.write((byte) (HN0rH6dr >> 24));
				}
				if (eHu9HTO8) {
					int a86cj14S, beldkI0z;
					for (; HN0rH6dr > 0; HN0rH6dr -= 3) {
						lcY3Pfbr.write(SESQ7RzE.read());
						a86cj14S = SESQ7RzE.read();
						beldkI0z = SESQ7RzE.read();
						lcY3Pfbr.write(a86cj14S & 0x0f);
						lcY3Pfbr.write(a86cj14S >> 4 | ((beldkI0z & 0x0f) << 4));
						lcY3Pfbr.write(beldkI0z >> 4);
					}
				} else {
					for (; HN0rH6dr > 0; --HN0rH6dr) {
						lcY3Pfbr.write(SESQ7RzE.read());
					}
				}
				lcY3Pfbr.close();
			}
			System.out.print('.');
		} finally {
			SESQ7RzE.close();
		}
	}

}