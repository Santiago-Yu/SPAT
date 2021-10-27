class n569269 {
	public void convert(File s5OgFFYk, File A64PQbuF) throws IOException {
		InputStream A4vCK1Av = new BufferedInputStream(new FileInputStream(s5OgFFYk));
		DcmParser cDIn3cCq = pfact.newDcmParser(A4vCK1Av);
		Dataset ljj5piA8 = fact.newDataset();
		cDIn3cCq.setDcmHandler(ljj5piA8.getDcmHandler());
		try {
			FileFormat zd15pkw1 = cDIn3cCq.detectFileFormat();
			if (zd15pkw1 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + s5OgFFYk + ": not an ACRNEMA stream!");
				return;
			}
			cDIn3cCq.parseDcmFile(zd15pkw1, Tags.PixelData);
			if (ljj5piA8.contains(Tags.StudyInstanceUID) || ljj5piA8.contains(Tags.SeriesInstanceUID)
					|| ljj5piA8.contains(Tags.SOPInstanceUID) || ljj5piA8.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + s5OgFFYk + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean qkOQveQm = cDIn3cCq.getReadTag() == Tags.PixelData;
			boolean ipyQcKJk = qkOQveQm && ljj5piA8.getInt(Tags.BitsAllocated, 0) == 12;
			int m8ts7SYj = cDIn3cCq.getReadLength();
			if (qkOQveQm) {
				if (ipyQcKJk) {
					ljj5piA8.putUS(Tags.BitsAllocated, 16);
					m8ts7SYj = m8ts7SYj * 4 / 3;
				}
				if (m8ts7SYj != (ljj5piA8.getInt(Tags.BitsAllocated, 0) >>> 3) * ljj5piA8.getInt(Tags.Rows, 0)
						* ljj5piA8.getInt(Tags.Columns, 0) * ljj5piA8.getInt(Tags.NumberOfFrames, 1)
						* ljj5piA8.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + s5OgFFYk + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			ljj5piA8.putUI(Tags.StudyInstanceUID, uid(studyUID));
			ljj5piA8.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			ljj5piA8.putUI(Tags.SOPInstanceUID, uid(instUID));
			ljj5piA8.putUI(Tags.SOPClassUID, classUID);
			if (!ljj5piA8.contains(Tags.NumberOfSamples)) {
				ljj5piA8.putUS(Tags.NumberOfSamples, 1);
			}
			if (!ljj5piA8.contains(Tags.PhotometricInterpretation)) {
				ljj5piA8.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				ljj5piA8.setFileMetaInfo(fact.newFileMetaInfo(ljj5piA8, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream aJ2JfYQY = new BufferedOutputStream(new FileOutputStream(A64PQbuF));
			try {
			} finally {
				ljj5piA8.writeFile(aJ2JfYQY, encodeParam());
				if (qkOQveQm) {
					if (!skipGroupLen) {
						aJ2JfYQY.write(PXDATA_GROUPLEN);
						int yUHpPio4 = m8ts7SYj + 8;
						aJ2JfYQY.write((byte) yUHpPio4);
						aJ2JfYQY.write((byte) (yUHpPio4 >> 8));
						aJ2JfYQY.write((byte) (yUHpPio4 >> 16));
						aJ2JfYQY.write((byte) (yUHpPio4 >> 24));
					}
					aJ2JfYQY.write(PXDATA_TAG);
					aJ2JfYQY.write((byte) m8ts7SYj);
					aJ2JfYQY.write((byte) (m8ts7SYj >> 8));
					aJ2JfYQY.write((byte) (m8ts7SYj >> 16));
					aJ2JfYQY.write((byte) (m8ts7SYj >> 24));
				}
				if (ipyQcKJk) {
					int BsWuZTwi, GhvoEpIP;
					for (; m8ts7SYj > 0; m8ts7SYj -= 3) {
						aJ2JfYQY.write(A4vCK1Av.read());
						BsWuZTwi = A4vCK1Av.read();
						GhvoEpIP = A4vCK1Av.read();
						aJ2JfYQY.write(BsWuZTwi & 0x0f);
						aJ2JfYQY.write(BsWuZTwi >> 4 | ((GhvoEpIP & 0x0f) << 4));
						aJ2JfYQY.write(GhvoEpIP >> 4);
					}
				} else {
					for (; m8ts7SYj > 0; --m8ts7SYj) {
						aJ2JfYQY.write(A4vCK1Av.read());
					}
				}
				aJ2JfYQY.close();
			}
			System.out.print('.');
		} finally {
			A4vCK1Av.close();
		}
	}

}