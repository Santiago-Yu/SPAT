class n9563 {
	public void convert(File ztdVeFd6, File tOJwQglw) throws IOException {
		InputStream cNt7OCqi = new BufferedInputStream(new FileInputStream(ztdVeFd6));
		DcmParser m0dNHacz = pfact.newDcmParser(cNt7OCqi);
		Dataset JRJ47cfP = fact.newDataset();
		m0dNHacz.setDcmHandler(JRJ47cfP.getDcmHandler());
		try {
			FileFormat VsiYaefu = m0dNHacz.detectFileFormat();
			if (VsiYaefu != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ztdVeFd6 + ": not an ACRNEMA stream!");
				return;
			}
			m0dNHacz.parseDcmFile(VsiYaefu, Tags.PixelData);
			if (JRJ47cfP.contains(Tags.StudyInstanceUID) || JRJ47cfP.contains(Tags.SeriesInstanceUID)
					|| JRJ47cfP.contains(Tags.SOPInstanceUID) || JRJ47cfP.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ztdVeFd6 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean EOOSVF9r = m0dNHacz.getReadTag() == Tags.PixelData;
			boolean JNvSXjw1 = EOOSVF9r && JRJ47cfP.getInt(Tags.BitsAllocated, 0) == 12;
			int mnbZWvgs = m0dNHacz.getReadLength();
			if (EOOSVF9r) {
				if (JNvSXjw1) {
					JRJ47cfP.putUS(Tags.BitsAllocated, 16);
					mnbZWvgs = mnbZWvgs * 4 / 3;
				}
				if (mnbZWvgs != (JRJ47cfP.getInt(Tags.BitsAllocated, 0) >>> 3) * JRJ47cfP.getInt(Tags.Rows, 0)
						* JRJ47cfP.getInt(Tags.Columns, 0) * JRJ47cfP.getInt(Tags.NumberOfFrames, 1)
						* JRJ47cfP.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ztdVeFd6 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			JRJ47cfP.putUI(Tags.StudyInstanceUID, uid(studyUID));
			JRJ47cfP.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			JRJ47cfP.putUI(Tags.SOPInstanceUID, uid(instUID));
			JRJ47cfP.putUI(Tags.SOPClassUID, classUID);
			if (!JRJ47cfP.contains(Tags.NumberOfSamples)) {
				JRJ47cfP.putUS(Tags.NumberOfSamples, 1);
			}
			if (!JRJ47cfP.contains(Tags.PhotometricInterpretation)) {
				JRJ47cfP.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				JRJ47cfP.setFileMetaInfo(fact.newFileMetaInfo(JRJ47cfP, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream DwqSXUNt = new BufferedOutputStream(new FileOutputStream(tOJwQglw));
			try {
			} finally {
				JRJ47cfP.writeFile(DwqSXUNt, encodeParam());
				if (EOOSVF9r) {
					if (!skipGroupLen) {
						DwqSXUNt.write(PXDATA_GROUPLEN);
						int oToAJmLC = mnbZWvgs + 8;
						DwqSXUNt.write((byte) oToAJmLC);
						DwqSXUNt.write((byte) (oToAJmLC >> 8));
						DwqSXUNt.write((byte) (oToAJmLC >> 16));
						DwqSXUNt.write((byte) (oToAJmLC >> 24));
					}
					DwqSXUNt.write(PXDATA_TAG);
					DwqSXUNt.write((byte) mnbZWvgs);
					DwqSXUNt.write((byte) (mnbZWvgs >> 8));
					DwqSXUNt.write((byte) (mnbZWvgs >> 16));
					DwqSXUNt.write((byte) (mnbZWvgs >> 24));
				}
				if (JNvSXjw1) {
					int ugevy8KN, qmQGzUP9;
					for (; mnbZWvgs > 0; mnbZWvgs -= 3) {
						DwqSXUNt.write(cNt7OCqi.read());
						ugevy8KN = cNt7OCqi.read();
						qmQGzUP9 = cNt7OCqi.read();
						DwqSXUNt.write(ugevy8KN & 0x0f);
						DwqSXUNt.write(ugevy8KN >> 4 | ((qmQGzUP9 & 0x0f) << 4));
						DwqSXUNt.write(qmQGzUP9 >> 4);
					}
				} else {
					for (; mnbZWvgs > 0; --mnbZWvgs) {
						DwqSXUNt.write(cNt7OCqi.read());
					}
				}
				DwqSXUNt.close();
			}
			System.out.print('.');
		} finally {
			cNt7OCqi.close();
		}
	}

}