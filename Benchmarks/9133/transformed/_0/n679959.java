class n679959 {
	public void convert(File TOeNM7XY, File tIlvIgPh) throws IOException {
		InputStream BorS5b74 = new BufferedInputStream(new FileInputStream(TOeNM7XY));
		DcmParser BNDcP4U6 = pfact.newDcmParser(BorS5b74);
		Dataset wADQvMQB = fact.newDataset();
		BNDcP4U6.setDcmHandler(wADQvMQB.getDcmHandler());
		try {
			FileFormat aaGwW8Hn = BNDcP4U6.detectFileFormat();
			if (aaGwW8Hn != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + TOeNM7XY + ": not an ACRNEMA stream!");
				return;
			}
			BNDcP4U6.parseDcmFile(aaGwW8Hn, Tags.PixelData);
			if (wADQvMQB.contains(Tags.StudyInstanceUID) || wADQvMQB.contains(Tags.SeriesInstanceUID)
					|| wADQvMQB.contains(Tags.SOPInstanceUID) || wADQvMQB.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + TOeNM7XY + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean wCOSuptL = BNDcP4U6.getReadTag() == Tags.PixelData;
			boolean pz01LA4y = wCOSuptL && wADQvMQB.getInt(Tags.BitsAllocated, 0) == 12;
			int PzELQzjf = BNDcP4U6.getReadLength();
			if (wCOSuptL) {
				if (pz01LA4y) {
					wADQvMQB.putUS(Tags.BitsAllocated, 16);
					PzELQzjf = PzELQzjf * 4 / 3;
				}
				if (PzELQzjf != (wADQvMQB.getInt(Tags.BitsAllocated, 0) >>> 3) * wADQvMQB.getInt(Tags.Rows, 0)
						* wADQvMQB.getInt(Tags.Columns, 0) * wADQvMQB.getInt(Tags.NumberOfFrames, 1)
						* wADQvMQB.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + TOeNM7XY + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			wADQvMQB.putUI(Tags.StudyInstanceUID, uid(studyUID));
			wADQvMQB.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			wADQvMQB.putUI(Tags.SOPInstanceUID, uid(instUID));
			wADQvMQB.putUI(Tags.SOPClassUID, classUID);
			if (!wADQvMQB.contains(Tags.NumberOfSamples)) {
				wADQvMQB.putUS(Tags.NumberOfSamples, 1);
			}
			if (!wADQvMQB.contains(Tags.PhotometricInterpretation)) {
				wADQvMQB.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				wADQvMQB.setFileMetaInfo(fact.newFileMetaInfo(wADQvMQB, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream DZmwELdU = new BufferedOutputStream(new FileOutputStream(tIlvIgPh));
			try {
			} finally {
				wADQvMQB.writeFile(DZmwELdU, encodeParam());
				if (wCOSuptL) {
					if (!skipGroupLen) {
						DZmwELdU.write(PXDATA_GROUPLEN);
						int J0xpkqVP = PzELQzjf + 8;
						DZmwELdU.write((byte) J0xpkqVP);
						DZmwELdU.write((byte) (J0xpkqVP >> 8));
						DZmwELdU.write((byte) (J0xpkqVP >> 16));
						DZmwELdU.write((byte) (J0xpkqVP >> 24));
					}
					DZmwELdU.write(PXDATA_TAG);
					DZmwELdU.write((byte) PzELQzjf);
					DZmwELdU.write((byte) (PzELQzjf >> 8));
					DZmwELdU.write((byte) (PzELQzjf >> 16));
					DZmwELdU.write((byte) (PzELQzjf >> 24));
				}
				if (pz01LA4y) {
					int Coxgs1CD, mCO55Jtw;
					for (; PzELQzjf > 0; PzELQzjf -= 3) {
						DZmwELdU.write(BorS5b74.read());
						Coxgs1CD = BorS5b74.read();
						mCO55Jtw = BorS5b74.read();
						DZmwELdU.write(Coxgs1CD & 0x0f);
						DZmwELdU.write(Coxgs1CD >> 4 | ((mCO55Jtw & 0x0f) << 4));
						DZmwELdU.write(mCO55Jtw >> 4);
					}
				} else {
					for (; PzELQzjf > 0; --PzELQzjf) {
						DZmwELdU.write(BorS5b74.read());
					}
				}
				DZmwELdU.close();
			}
			System.out.print('.');
		} finally {
			BorS5b74.close();
		}
	}

}