class n543096 {
	public void convert(File byFqtUVL, File VzuMt2yQ) throws IOException {
		InputStream qnow11qt = new BufferedInputStream(new FileInputStream(byFqtUVL));
		DcmParser gaMRNXKG = pfact.newDcmParser(qnow11qt);
		Dataset gDw5PWMF = fact.newDataset();
		gaMRNXKG.setDcmHandler(gDw5PWMF.getDcmHandler());
		try {
			FileFormat IuqodRb3 = gaMRNXKG.detectFileFormat();
			if (IuqodRb3 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + byFqtUVL + ": not an ACRNEMA stream!");
				return;
			}
			gaMRNXKG.parseDcmFile(IuqodRb3, Tags.PixelData);
			if (gDw5PWMF.contains(Tags.StudyInstanceUID) || gDw5PWMF.contains(Tags.SeriesInstanceUID)
					|| gDw5PWMF.contains(Tags.SOPInstanceUID) || gDw5PWMF.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + byFqtUVL + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean zhmwkHQS = gaMRNXKG.getReadTag() == Tags.PixelData;
			boolean S5UjTJMo = zhmwkHQS && gDw5PWMF.getInt(Tags.BitsAllocated, 0) == 12;
			int mh11mvh8 = gaMRNXKG.getReadLength();
			if (zhmwkHQS) {
				if (S5UjTJMo) {
					gDw5PWMF.putUS(Tags.BitsAllocated, 16);
					mh11mvh8 = mh11mvh8 * 4 / 3;
				}
				if (mh11mvh8 != (gDw5PWMF.getInt(Tags.BitsAllocated, 0) >>> 3) * gDw5PWMF.getInt(Tags.Rows, 0)
						* gDw5PWMF.getInt(Tags.Columns, 0) * gDw5PWMF.getInt(Tags.NumberOfFrames, 1)
						* gDw5PWMF.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + byFqtUVL + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			gDw5PWMF.putUI(Tags.StudyInstanceUID, uid(studyUID));
			gDw5PWMF.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			gDw5PWMF.putUI(Tags.SOPInstanceUID, uid(instUID));
			gDw5PWMF.putUI(Tags.SOPClassUID, classUID);
			if (!gDw5PWMF.contains(Tags.NumberOfSamples)) {
				gDw5PWMF.putUS(Tags.NumberOfSamples, 1);
			}
			if (!gDw5PWMF.contains(Tags.PhotometricInterpretation)) {
				gDw5PWMF.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				gDw5PWMF.setFileMetaInfo(fact.newFileMetaInfo(gDw5PWMF, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream yYyPiPgI = new BufferedOutputStream(new FileOutputStream(VzuMt2yQ));
			try {
			} finally {
				gDw5PWMF.writeFile(yYyPiPgI, encodeParam());
				if (zhmwkHQS) {
					if (!skipGroupLen) {
						yYyPiPgI.write(PXDATA_GROUPLEN);
						int LeQn4IEz = mh11mvh8 + 8;
						yYyPiPgI.write((byte) LeQn4IEz);
						yYyPiPgI.write((byte) (LeQn4IEz >> 8));
						yYyPiPgI.write((byte) (LeQn4IEz >> 16));
						yYyPiPgI.write((byte) (LeQn4IEz >> 24));
					}
					yYyPiPgI.write(PXDATA_TAG);
					yYyPiPgI.write((byte) mh11mvh8);
					yYyPiPgI.write((byte) (mh11mvh8 >> 8));
					yYyPiPgI.write((byte) (mh11mvh8 >> 16));
					yYyPiPgI.write((byte) (mh11mvh8 >> 24));
				}
				if (S5UjTJMo) {
					int p6dUnx8G, MU80Diob;
					for (; mh11mvh8 > 0; mh11mvh8 -= 3) {
						yYyPiPgI.write(qnow11qt.read());
						p6dUnx8G = qnow11qt.read();
						MU80Diob = qnow11qt.read();
						yYyPiPgI.write(p6dUnx8G & 0x0f);
						yYyPiPgI.write(p6dUnx8G >> 4 | ((MU80Diob & 0x0f) << 4));
						yYyPiPgI.write(MU80Diob >> 4);
					}
				} else {
					for (; mh11mvh8 > 0; --mh11mvh8) {
						yYyPiPgI.write(qnow11qt.read());
					}
				}
				yYyPiPgI.close();
			}
			System.out.print('.');
		} finally {
			qnow11qt.close();
		}
	}

}