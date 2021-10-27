class n765103 {
	public void convert(File ZmYGSzZN, File PxMlAUhs) throws IOException {
		InputStream JjAWmBXw = new BufferedInputStream(new FileInputStream(ZmYGSzZN));
		DcmParser h2AzJs6e = pfact.newDcmParser(JjAWmBXw);
		Dataset Gg5efN88 = fact.newDataset();
		h2AzJs6e.setDcmHandler(Gg5efN88.getDcmHandler());
		try {
			FileFormat sBcKJ47g = h2AzJs6e.detectFileFormat();
			if (sBcKJ47g != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ZmYGSzZN + ": not an ACRNEMA stream!");
				return;
			}
			h2AzJs6e.parseDcmFile(sBcKJ47g, Tags.PixelData);
			if (Gg5efN88.contains(Tags.StudyInstanceUID) || Gg5efN88.contains(Tags.SeriesInstanceUID)
					|| Gg5efN88.contains(Tags.SOPInstanceUID) || Gg5efN88.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ZmYGSzZN + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean cjC45ag6 = h2AzJs6e.getReadTag() == Tags.PixelData;
			boolean u7mh0JOe = cjC45ag6 && Gg5efN88.getInt(Tags.BitsAllocated, 0) == 12;
			int C6QG8pKG = h2AzJs6e.getReadLength();
			if (cjC45ag6) {
				if (u7mh0JOe) {
					Gg5efN88.putUS(Tags.BitsAllocated, 16);
					C6QG8pKG = C6QG8pKG * 4 / 3;
				}
				if (C6QG8pKG != (Gg5efN88.getInt(Tags.BitsAllocated, 0) >>> 3) * Gg5efN88.getInt(Tags.Rows, 0)
						* Gg5efN88.getInt(Tags.Columns, 0) * Gg5efN88.getInt(Tags.NumberOfFrames, 1)
						* Gg5efN88.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ZmYGSzZN + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Gg5efN88.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Gg5efN88.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Gg5efN88.putUI(Tags.SOPInstanceUID, uid(instUID));
			Gg5efN88.putUI(Tags.SOPClassUID, classUID);
			if (!Gg5efN88.contains(Tags.NumberOfSamples)) {
				Gg5efN88.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Gg5efN88.contains(Tags.PhotometricInterpretation)) {
				Gg5efN88.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Gg5efN88.setFileMetaInfo(fact.newFileMetaInfo(Gg5efN88, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream C6tRkxPi = new BufferedOutputStream(new FileOutputStream(PxMlAUhs));
			try {
			} finally {
				Gg5efN88.writeFile(C6tRkxPi, encodeParam());
				if (cjC45ag6) {
					if (!skipGroupLen) {
						C6tRkxPi.write(PXDATA_GROUPLEN);
						int kijevOOH = C6QG8pKG + 8;
						C6tRkxPi.write((byte) kijevOOH);
						C6tRkxPi.write((byte) (kijevOOH >> 8));
						C6tRkxPi.write((byte) (kijevOOH >> 16));
						C6tRkxPi.write((byte) (kijevOOH >> 24));
					}
					C6tRkxPi.write(PXDATA_TAG);
					C6tRkxPi.write((byte) C6QG8pKG);
					C6tRkxPi.write((byte) (C6QG8pKG >> 8));
					C6tRkxPi.write((byte) (C6QG8pKG >> 16));
					C6tRkxPi.write((byte) (C6QG8pKG >> 24));
				}
				if (u7mh0JOe) {
					int LhBoyQP8, A4GoOgHz;
					for (; C6QG8pKG > 0; C6QG8pKG -= 3) {
						C6tRkxPi.write(JjAWmBXw.read());
						LhBoyQP8 = JjAWmBXw.read();
						A4GoOgHz = JjAWmBXw.read();
						C6tRkxPi.write(LhBoyQP8 & 0x0f);
						C6tRkxPi.write(LhBoyQP8 >> 4 | ((A4GoOgHz & 0x0f) << 4));
						C6tRkxPi.write(A4GoOgHz >> 4);
					}
				} else {
					for (; C6QG8pKG > 0; --C6QG8pKG) {
						C6tRkxPi.write(JjAWmBXw.read());
					}
				}
				C6tRkxPi.close();
			}
			System.out.print('.');
		} finally {
			JjAWmBXw.close();
		}
	}

}