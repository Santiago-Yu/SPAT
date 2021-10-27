class n272355 {
	public void convert(File gYPMorj9, File RbKwBeST) throws IOException {
		InputStream wjIOBYr8 = new BufferedInputStream(new FileInputStream(gYPMorj9));
		DcmParser RNOp1XPn = pfact.newDcmParser(wjIOBYr8);
		Dataset BtpHaaXp = fact.newDataset();
		RNOp1XPn.setDcmHandler(BtpHaaXp.getDcmHandler());
		try {
			FileFormat S5iv9WVU = RNOp1XPn.detectFileFormat();
			if (S5iv9WVU != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + gYPMorj9 + ": not an ACRNEMA stream!");
				return;
			}
			RNOp1XPn.parseDcmFile(S5iv9WVU, Tags.PixelData);
			if (BtpHaaXp.contains(Tags.StudyInstanceUID) || BtpHaaXp.contains(Tags.SeriesInstanceUID)
					|| BtpHaaXp.contains(Tags.SOPInstanceUID) || BtpHaaXp.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + gYPMorj9 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean BEbsPa1A = RNOp1XPn.getReadTag() == Tags.PixelData;
			boolean rzRgKlfC = BEbsPa1A && BtpHaaXp.getInt(Tags.BitsAllocated, 0) == 12;
			int JSfx7ZLz = RNOp1XPn.getReadLength();
			if (BEbsPa1A) {
				if (rzRgKlfC) {
					BtpHaaXp.putUS(Tags.BitsAllocated, 16);
					JSfx7ZLz = JSfx7ZLz * 4 / 3;
				}
				if (JSfx7ZLz != (BtpHaaXp.getInt(Tags.BitsAllocated, 0) >>> 3) * BtpHaaXp.getInt(Tags.Rows, 0)
						* BtpHaaXp.getInt(Tags.Columns, 0) * BtpHaaXp.getInt(Tags.NumberOfFrames, 1)
						* BtpHaaXp.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + gYPMorj9 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			BtpHaaXp.putUI(Tags.StudyInstanceUID, uid(studyUID));
			BtpHaaXp.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			BtpHaaXp.putUI(Tags.SOPInstanceUID, uid(instUID));
			BtpHaaXp.putUI(Tags.SOPClassUID, classUID);
			if (!BtpHaaXp.contains(Tags.NumberOfSamples)) {
				BtpHaaXp.putUS(Tags.NumberOfSamples, 1);
			}
			if (!BtpHaaXp.contains(Tags.PhotometricInterpretation)) {
				BtpHaaXp.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				BtpHaaXp.setFileMetaInfo(fact.newFileMetaInfo(BtpHaaXp, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream TIq0jQ4q = new BufferedOutputStream(new FileOutputStream(RbKwBeST));
			try {
			} finally {
				BtpHaaXp.writeFile(TIq0jQ4q, encodeParam());
				if (BEbsPa1A) {
					if (!skipGroupLen) {
						TIq0jQ4q.write(PXDATA_GROUPLEN);
						int vgtvzljk = JSfx7ZLz + 8;
						TIq0jQ4q.write((byte) vgtvzljk);
						TIq0jQ4q.write((byte) (vgtvzljk >> 8));
						TIq0jQ4q.write((byte) (vgtvzljk >> 16));
						TIq0jQ4q.write((byte) (vgtvzljk >> 24));
					}
					TIq0jQ4q.write(PXDATA_TAG);
					TIq0jQ4q.write((byte) JSfx7ZLz);
					TIq0jQ4q.write((byte) (JSfx7ZLz >> 8));
					TIq0jQ4q.write((byte) (JSfx7ZLz >> 16));
					TIq0jQ4q.write((byte) (JSfx7ZLz >> 24));
				}
				if (rzRgKlfC) {
					int WJD2075B, PnAg88EP;
					for (; JSfx7ZLz > 0; JSfx7ZLz -= 3) {
						TIq0jQ4q.write(wjIOBYr8.read());
						WJD2075B = wjIOBYr8.read();
						PnAg88EP = wjIOBYr8.read();
						TIq0jQ4q.write(WJD2075B & 0x0f);
						TIq0jQ4q.write(WJD2075B >> 4 | ((PnAg88EP & 0x0f) << 4));
						TIq0jQ4q.write(PnAg88EP >> 4);
					}
				} else {
					for (; JSfx7ZLz > 0; --JSfx7ZLz) {
						TIq0jQ4q.write(wjIOBYr8.read());
					}
				}
				TIq0jQ4q.close();
			}
			System.out.print('.');
		} finally {
			wjIOBYr8.close();
		}
	}

}