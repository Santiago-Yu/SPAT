class n210006 {
	public void convert(File PJjYIuyN, File M3AA7xpU) throws IOException {
		InputStream zSWRORXH = new BufferedInputStream(new FileInputStream(PJjYIuyN));
		DcmParser qqkwwIaI = pfact.newDcmParser(zSWRORXH);
		Dataset GckpH3r4 = fact.newDataset();
		qqkwwIaI.setDcmHandler(GckpH3r4.getDcmHandler());
		try {
			FileFormat D3PEpXtP = qqkwwIaI.detectFileFormat();
			if (D3PEpXtP != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + PJjYIuyN + ": not an ACRNEMA stream!");
				return;
			}
			qqkwwIaI.parseDcmFile(D3PEpXtP, Tags.PixelData);
			if (GckpH3r4.contains(Tags.StudyInstanceUID) || GckpH3r4.contains(Tags.SeriesInstanceUID)
					|| GckpH3r4.contains(Tags.SOPInstanceUID) || GckpH3r4.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + PJjYIuyN + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean vQ3Ho9Cc = qqkwwIaI.getReadTag() == Tags.PixelData;
			boolean f1ijTsTX = vQ3Ho9Cc && GckpH3r4.getInt(Tags.BitsAllocated, 0) == 12;
			int vQYBRi4R = qqkwwIaI.getReadLength();
			if (vQ3Ho9Cc) {
				if (f1ijTsTX) {
					GckpH3r4.putUS(Tags.BitsAllocated, 16);
					vQYBRi4R = vQYBRi4R * 4 / 3;
				}
				if (vQYBRi4R != (GckpH3r4.getInt(Tags.BitsAllocated, 0) >>> 3) * GckpH3r4.getInt(Tags.Rows, 0)
						* GckpH3r4.getInt(Tags.Columns, 0) * GckpH3r4.getInt(Tags.NumberOfFrames, 1)
						* GckpH3r4.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + PJjYIuyN + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			GckpH3r4.putUI(Tags.StudyInstanceUID, uid(studyUID));
			GckpH3r4.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			GckpH3r4.putUI(Tags.SOPInstanceUID, uid(instUID));
			GckpH3r4.putUI(Tags.SOPClassUID, classUID);
			if (!GckpH3r4.contains(Tags.NumberOfSamples)) {
				GckpH3r4.putUS(Tags.NumberOfSamples, 1);
			}
			if (!GckpH3r4.contains(Tags.PhotometricInterpretation)) {
				GckpH3r4.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				GckpH3r4.setFileMetaInfo(fact.newFileMetaInfo(GckpH3r4, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream ZCT0c89T = new BufferedOutputStream(new FileOutputStream(M3AA7xpU));
			try {
			} finally {
				GckpH3r4.writeFile(ZCT0c89T, encodeParam());
				if (vQ3Ho9Cc) {
					if (!skipGroupLen) {
						ZCT0c89T.write(PXDATA_GROUPLEN);
						int ujW1Czkq = vQYBRi4R + 8;
						ZCT0c89T.write((byte) ujW1Czkq);
						ZCT0c89T.write((byte) (ujW1Czkq >> 8));
						ZCT0c89T.write((byte) (ujW1Czkq >> 16));
						ZCT0c89T.write((byte) (ujW1Czkq >> 24));
					}
					ZCT0c89T.write(PXDATA_TAG);
					ZCT0c89T.write((byte) vQYBRi4R);
					ZCT0c89T.write((byte) (vQYBRi4R >> 8));
					ZCT0c89T.write((byte) (vQYBRi4R >> 16));
					ZCT0c89T.write((byte) (vQYBRi4R >> 24));
				}
				if (f1ijTsTX) {
					int LQeoWb1i, KJbbxMbb;
					for (; vQYBRi4R > 0; vQYBRi4R -= 3) {
						ZCT0c89T.write(zSWRORXH.read());
						LQeoWb1i = zSWRORXH.read();
						KJbbxMbb = zSWRORXH.read();
						ZCT0c89T.write(LQeoWb1i & 0x0f);
						ZCT0c89T.write(LQeoWb1i >> 4 | ((KJbbxMbb & 0x0f) << 4));
						ZCT0c89T.write(KJbbxMbb >> 4);
					}
				} else {
					for (; vQYBRi4R > 0; --vQYBRi4R) {
						ZCT0c89T.write(zSWRORXH.read());
					}
				}
				ZCT0c89T.close();
			}
			System.out.print('.');
		} finally {
			zSWRORXH.close();
		}
	}

}