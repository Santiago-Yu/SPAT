class n661 {
	public void convert(File UcAinJ4n, File wN482LsJ) throws IOException {
		InputStream U3PbACZg = new BufferedInputStream(new FileInputStream(UcAinJ4n));
		DcmParser JwSdePmU = pfact.newDcmParser(U3PbACZg);
		Dataset dtAHByJa = fact.newDataset();
		JwSdePmU.setDcmHandler(dtAHByJa.getDcmHandler());
		try {
			FileFormat WgZS58bA = JwSdePmU.detectFileFormat();
			if (WgZS58bA != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + UcAinJ4n + ": not an ACRNEMA stream!");
				return;
			}
			JwSdePmU.parseDcmFile(WgZS58bA, Tags.PixelData);
			if (dtAHByJa.contains(Tags.StudyInstanceUID) || dtAHByJa.contains(Tags.SeriesInstanceUID)
					|| dtAHByJa.contains(Tags.SOPInstanceUID) || dtAHByJa.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + UcAinJ4n + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean KXmPzIWs = JwSdePmU.getReadTag() == Tags.PixelData;
			boolean wTdGTSTI = KXmPzIWs && dtAHByJa.getInt(Tags.BitsAllocated, 0) == 12;
			int lrrycDo7 = JwSdePmU.getReadLength();
			if (KXmPzIWs) {
				if (wTdGTSTI) {
					dtAHByJa.putUS(Tags.BitsAllocated, 16);
					lrrycDo7 = lrrycDo7 * 4 / 3;
				}
				if (lrrycDo7 != (dtAHByJa.getInt(Tags.BitsAllocated, 0) >>> 3) * dtAHByJa.getInt(Tags.Rows, 0)
						* dtAHByJa.getInt(Tags.Columns, 0) * dtAHByJa.getInt(Tags.NumberOfFrames, 1)
						* dtAHByJa.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + UcAinJ4n + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			dtAHByJa.putUI(Tags.StudyInstanceUID, uid(studyUID));
			dtAHByJa.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			dtAHByJa.putUI(Tags.SOPInstanceUID, uid(instUID));
			dtAHByJa.putUI(Tags.SOPClassUID, classUID);
			if (!dtAHByJa.contains(Tags.NumberOfSamples)) {
				dtAHByJa.putUS(Tags.NumberOfSamples, 1);
			}
			if (!dtAHByJa.contains(Tags.PhotometricInterpretation)) {
				dtAHByJa.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				dtAHByJa.setFileMetaInfo(fact.newFileMetaInfo(dtAHByJa, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream M5JVUsA9 = new BufferedOutputStream(new FileOutputStream(wN482LsJ));
			try {
			} finally {
				dtAHByJa.writeFile(M5JVUsA9, encodeParam());
				if (KXmPzIWs) {
					if (!skipGroupLen) {
						M5JVUsA9.write(PXDATA_GROUPLEN);
						int qpnQEXsE = lrrycDo7 + 8;
						M5JVUsA9.write((byte) qpnQEXsE);
						M5JVUsA9.write((byte) (qpnQEXsE >> 8));
						M5JVUsA9.write((byte) (qpnQEXsE >> 16));
						M5JVUsA9.write((byte) (qpnQEXsE >> 24));
					}
					M5JVUsA9.write(PXDATA_TAG);
					M5JVUsA9.write((byte) lrrycDo7);
					M5JVUsA9.write((byte) (lrrycDo7 >> 8));
					M5JVUsA9.write((byte) (lrrycDo7 >> 16));
					M5JVUsA9.write((byte) (lrrycDo7 >> 24));
				}
				if (wTdGTSTI) {
					int EroAGA4g, zTlCpLpw;
					for (; lrrycDo7 > 0; lrrycDo7 -= 3) {
						M5JVUsA9.write(U3PbACZg.read());
						EroAGA4g = U3PbACZg.read();
						zTlCpLpw = U3PbACZg.read();
						M5JVUsA9.write(EroAGA4g & 0x0f);
						M5JVUsA9.write(EroAGA4g >> 4 | ((zTlCpLpw & 0x0f) << 4));
						M5JVUsA9.write(zTlCpLpw >> 4);
					}
				} else {
					for (; lrrycDo7 > 0; --lrrycDo7) {
						M5JVUsA9.write(U3PbACZg.read());
					}
				}
				M5JVUsA9.close();
			}
			System.out.print('.');
		} finally {
			U3PbACZg.close();
		}
	}

}