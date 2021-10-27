class n340064 {
	public void convert(File ImYvtKHH, File g4Hn60z1) throws IOException {
		InputStream zbruVDIv = new BufferedInputStream(new FileInputStream(ImYvtKHH));
		DcmParser J9jNypt1 = pfact.newDcmParser(zbruVDIv);
		Dataset QS0nBhIx = fact.newDataset();
		J9jNypt1.setDcmHandler(QS0nBhIx.getDcmHandler());
		try {
			FileFormat cWl5rxv2 = J9jNypt1.detectFileFormat();
			if (cWl5rxv2 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ImYvtKHH + ": not an ACRNEMA stream!");
				return;
			}
			J9jNypt1.parseDcmFile(cWl5rxv2, Tags.PixelData);
			if (QS0nBhIx.contains(Tags.StudyInstanceUID) || QS0nBhIx.contains(Tags.SeriesInstanceUID)
					|| QS0nBhIx.contains(Tags.SOPInstanceUID) || QS0nBhIx.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ImYvtKHH + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean nvYqiMk3 = J9jNypt1.getReadTag() == Tags.PixelData;
			boolean n3BvXHNH = nvYqiMk3 && QS0nBhIx.getInt(Tags.BitsAllocated, 0) == 12;
			int QsQtfXM8 = J9jNypt1.getReadLength();
			if (nvYqiMk3) {
				if (n3BvXHNH) {
					QS0nBhIx.putUS(Tags.BitsAllocated, 16);
					QsQtfXM8 = QsQtfXM8 * 4 / 3;
				}
				if (QsQtfXM8 != (QS0nBhIx.getInt(Tags.BitsAllocated, 0) >>> 3) * QS0nBhIx.getInt(Tags.Rows, 0)
						* QS0nBhIx.getInt(Tags.Columns, 0) * QS0nBhIx.getInt(Tags.NumberOfFrames, 1)
						* QS0nBhIx.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ImYvtKHH + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			QS0nBhIx.putUI(Tags.StudyInstanceUID, uid(studyUID));
			QS0nBhIx.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			QS0nBhIx.putUI(Tags.SOPInstanceUID, uid(instUID));
			QS0nBhIx.putUI(Tags.SOPClassUID, classUID);
			if (!QS0nBhIx.contains(Tags.NumberOfSamples)) {
				QS0nBhIx.putUS(Tags.NumberOfSamples, 1);
			}
			if (!QS0nBhIx.contains(Tags.PhotometricInterpretation)) {
				QS0nBhIx.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				QS0nBhIx.setFileMetaInfo(fact.newFileMetaInfo(QS0nBhIx, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream zqbsfs0x = new BufferedOutputStream(new FileOutputStream(g4Hn60z1));
			try {
			} finally {
				QS0nBhIx.writeFile(zqbsfs0x, encodeParam());
				if (nvYqiMk3) {
					if (!skipGroupLen) {
						zqbsfs0x.write(PXDATA_GROUPLEN);
						int V8tq6GkI = QsQtfXM8 + 8;
						zqbsfs0x.write((byte) V8tq6GkI);
						zqbsfs0x.write((byte) (V8tq6GkI >> 8));
						zqbsfs0x.write((byte) (V8tq6GkI >> 16));
						zqbsfs0x.write((byte) (V8tq6GkI >> 24));
					}
					zqbsfs0x.write(PXDATA_TAG);
					zqbsfs0x.write((byte) QsQtfXM8);
					zqbsfs0x.write((byte) (QsQtfXM8 >> 8));
					zqbsfs0x.write((byte) (QsQtfXM8 >> 16));
					zqbsfs0x.write((byte) (QsQtfXM8 >> 24));
				}
				if (n3BvXHNH) {
					int pfYxqmMF, y3f65al0;
					for (; QsQtfXM8 > 0; QsQtfXM8 -= 3) {
						zqbsfs0x.write(zbruVDIv.read());
						pfYxqmMF = zbruVDIv.read();
						y3f65al0 = zbruVDIv.read();
						zqbsfs0x.write(pfYxqmMF & 0x0f);
						zqbsfs0x.write(pfYxqmMF >> 4 | ((y3f65al0 & 0x0f) << 4));
						zqbsfs0x.write(y3f65al0 >> 4);
					}
				} else {
					for (; QsQtfXM8 > 0; --QsQtfXM8) {
						zqbsfs0x.write(zbruVDIv.read());
					}
				}
				zqbsfs0x.close();
			}
			System.out.print('.');
		} finally {
			zbruVDIv.close();
		}
	}

}