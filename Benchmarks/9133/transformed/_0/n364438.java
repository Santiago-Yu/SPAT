class n364438 {
	public void convert(File hiZxsk7r, File UQK7nIdG) throws IOException {
		InputStream HMML1U4E = new BufferedInputStream(new FileInputStream(hiZxsk7r));
		DcmParser RiknrR6X = pfact.newDcmParser(HMML1U4E);
		Dataset c6trYLPl = fact.newDataset();
		RiknrR6X.setDcmHandler(c6trYLPl.getDcmHandler());
		try {
			FileFormat cy6i1syY = RiknrR6X.detectFileFormat();
			if (cy6i1syY != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + hiZxsk7r + ": not an ACRNEMA stream!");
				return;
			}
			RiknrR6X.parseDcmFile(cy6i1syY, Tags.PixelData);
			if (c6trYLPl.contains(Tags.StudyInstanceUID) || c6trYLPl.contains(Tags.SeriesInstanceUID)
					|| c6trYLPl.contains(Tags.SOPInstanceUID) || c6trYLPl.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + hiZxsk7r + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean KLi39XjE = RiknrR6X.getReadTag() == Tags.PixelData;
			boolean CuNZkJpQ = KLi39XjE && c6trYLPl.getInt(Tags.BitsAllocated, 0) == 12;
			int tXFpJV0c = RiknrR6X.getReadLength();
			if (KLi39XjE) {
				if (CuNZkJpQ) {
					c6trYLPl.putUS(Tags.BitsAllocated, 16);
					tXFpJV0c = tXFpJV0c * 4 / 3;
				}
				if (tXFpJV0c != (c6trYLPl.getInt(Tags.BitsAllocated, 0) >>> 3) * c6trYLPl.getInt(Tags.Rows, 0)
						* c6trYLPl.getInt(Tags.Columns, 0) * c6trYLPl.getInt(Tags.NumberOfFrames, 1)
						* c6trYLPl.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + hiZxsk7r + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			c6trYLPl.putUI(Tags.StudyInstanceUID, uid(studyUID));
			c6trYLPl.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			c6trYLPl.putUI(Tags.SOPInstanceUID, uid(instUID));
			c6trYLPl.putUI(Tags.SOPClassUID, classUID);
			if (!c6trYLPl.contains(Tags.NumberOfSamples)) {
				c6trYLPl.putUS(Tags.NumberOfSamples, 1);
			}
			if (!c6trYLPl.contains(Tags.PhotometricInterpretation)) {
				c6trYLPl.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				c6trYLPl.setFileMetaInfo(fact.newFileMetaInfo(c6trYLPl, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream zjffwAqr = new BufferedOutputStream(new FileOutputStream(UQK7nIdG));
			try {
			} finally {
				c6trYLPl.writeFile(zjffwAqr, encodeParam());
				if (KLi39XjE) {
					if (!skipGroupLen) {
						zjffwAqr.write(PXDATA_GROUPLEN);
						int Jvqn8y1d = tXFpJV0c + 8;
						zjffwAqr.write((byte) Jvqn8y1d);
						zjffwAqr.write((byte) (Jvqn8y1d >> 8));
						zjffwAqr.write((byte) (Jvqn8y1d >> 16));
						zjffwAqr.write((byte) (Jvqn8y1d >> 24));
					}
					zjffwAqr.write(PXDATA_TAG);
					zjffwAqr.write((byte) tXFpJV0c);
					zjffwAqr.write((byte) (tXFpJV0c >> 8));
					zjffwAqr.write((byte) (tXFpJV0c >> 16));
					zjffwAqr.write((byte) (tXFpJV0c >> 24));
				}
				if (CuNZkJpQ) {
					int MIinyCYE, zdheMTFB;
					for (; tXFpJV0c > 0; tXFpJV0c -= 3) {
						zjffwAqr.write(HMML1U4E.read());
						MIinyCYE = HMML1U4E.read();
						zdheMTFB = HMML1U4E.read();
						zjffwAqr.write(MIinyCYE & 0x0f);
						zjffwAqr.write(MIinyCYE >> 4 | ((zdheMTFB & 0x0f) << 4));
						zjffwAqr.write(zdheMTFB >> 4);
					}
				} else {
					for (; tXFpJV0c > 0; --tXFpJV0c) {
						zjffwAqr.write(HMML1U4E.read());
					}
				}
				zjffwAqr.close();
			}
			System.out.print('.');
		} finally {
			HMML1U4E.close();
		}
	}

}