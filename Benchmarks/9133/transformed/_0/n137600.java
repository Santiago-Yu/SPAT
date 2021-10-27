class n137600 {
	public void convert(File N2r6f4rs, File xpcEl9WV) throws IOException {
		InputStream ygWZMtA9 = new BufferedInputStream(new FileInputStream(N2r6f4rs));
		DcmParser zi6M0lJx = pfact.newDcmParser(ygWZMtA9);
		Dataset LxgAqA91 = fact.newDataset();
		zi6M0lJx.setDcmHandler(LxgAqA91.getDcmHandler());
		try {
			FileFormat yG6E35Q4 = zi6M0lJx.detectFileFormat();
			if (yG6E35Q4 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + N2r6f4rs + ": not an ACRNEMA stream!");
				return;
			}
			zi6M0lJx.parseDcmFile(yG6E35Q4, Tags.PixelData);
			if (LxgAqA91.contains(Tags.StudyInstanceUID) || LxgAqA91.contains(Tags.SeriesInstanceUID)
					|| LxgAqA91.contains(Tags.SOPInstanceUID) || LxgAqA91.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + N2r6f4rs + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean cc4M40TJ = zi6M0lJx.getReadTag() == Tags.PixelData;
			boolean BRhq1jzV = cc4M40TJ && LxgAqA91.getInt(Tags.BitsAllocated, 0) == 12;
			int BfHdurI7 = zi6M0lJx.getReadLength();
			if (cc4M40TJ) {
				if (BRhq1jzV) {
					LxgAqA91.putUS(Tags.BitsAllocated, 16);
					BfHdurI7 = BfHdurI7 * 4 / 3;
				}
				if (BfHdurI7 != (LxgAqA91.getInt(Tags.BitsAllocated, 0) >>> 3) * LxgAqA91.getInt(Tags.Rows, 0)
						* LxgAqA91.getInt(Tags.Columns, 0) * LxgAqA91.getInt(Tags.NumberOfFrames, 1)
						* LxgAqA91.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + N2r6f4rs + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			LxgAqA91.putUI(Tags.StudyInstanceUID, uid(studyUID));
			LxgAqA91.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			LxgAqA91.putUI(Tags.SOPInstanceUID, uid(instUID));
			LxgAqA91.putUI(Tags.SOPClassUID, classUID);
			if (!LxgAqA91.contains(Tags.NumberOfSamples)) {
				LxgAqA91.putUS(Tags.NumberOfSamples, 1);
			}
			if (!LxgAqA91.contains(Tags.PhotometricInterpretation)) {
				LxgAqA91.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				LxgAqA91.setFileMetaInfo(fact.newFileMetaInfo(LxgAqA91, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream M9etEHLq = new BufferedOutputStream(new FileOutputStream(xpcEl9WV));
			try {
			} finally {
				LxgAqA91.writeFile(M9etEHLq, encodeParam());
				if (cc4M40TJ) {
					if (!skipGroupLen) {
						M9etEHLq.write(PXDATA_GROUPLEN);
						int ofK7xLEU = BfHdurI7 + 8;
						M9etEHLq.write((byte) ofK7xLEU);
						M9etEHLq.write((byte) (ofK7xLEU >> 8));
						M9etEHLq.write((byte) (ofK7xLEU >> 16));
						M9etEHLq.write((byte) (ofK7xLEU >> 24));
					}
					M9etEHLq.write(PXDATA_TAG);
					M9etEHLq.write((byte) BfHdurI7);
					M9etEHLq.write((byte) (BfHdurI7 >> 8));
					M9etEHLq.write((byte) (BfHdurI7 >> 16));
					M9etEHLq.write((byte) (BfHdurI7 >> 24));
				}
				if (BRhq1jzV) {
					int lOjwrM70, UkqRgnQ9;
					for (; BfHdurI7 > 0; BfHdurI7 -= 3) {
						M9etEHLq.write(ygWZMtA9.read());
						lOjwrM70 = ygWZMtA9.read();
						UkqRgnQ9 = ygWZMtA9.read();
						M9etEHLq.write(lOjwrM70 & 0x0f);
						M9etEHLq.write(lOjwrM70 >> 4 | ((UkqRgnQ9 & 0x0f) << 4));
						M9etEHLq.write(UkqRgnQ9 >> 4);
					}
				} else {
					for (; BfHdurI7 > 0; --BfHdurI7) {
						M9etEHLq.write(ygWZMtA9.read());
					}
				}
				M9etEHLq.close();
			}
			System.out.print('.');
		} finally {
			ygWZMtA9.close();
		}
	}

}