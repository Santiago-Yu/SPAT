class n649639 {
	public void convert(File kUf8pBxg, File oIv2UzYd) throws IOException {
		InputStream EzZOdzlx = new BufferedInputStream(new FileInputStream(kUf8pBxg));
		DcmParser L2LdvneB = pfact.newDcmParser(EzZOdzlx);
		Dataset R19zJJp6 = fact.newDataset();
		L2LdvneB.setDcmHandler(R19zJJp6.getDcmHandler());
		try {
			FileFormat W5lEOTFw = L2LdvneB.detectFileFormat();
			if (W5lEOTFw != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + kUf8pBxg + ": not an ACRNEMA stream!");
				return;
			}
			L2LdvneB.parseDcmFile(W5lEOTFw, Tags.PixelData);
			if (R19zJJp6.contains(Tags.StudyInstanceUID) || R19zJJp6.contains(Tags.SeriesInstanceUID)
					|| R19zJJp6.contains(Tags.SOPInstanceUID) || R19zJJp6.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + kUf8pBxg + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean O9Oqb5hf = L2LdvneB.getReadTag() == Tags.PixelData;
			boolean GEZljMW5 = O9Oqb5hf && R19zJJp6.getInt(Tags.BitsAllocated, 0) == 12;
			int JOVoDsMG = L2LdvneB.getReadLength();
			if (O9Oqb5hf) {
				if (GEZljMW5) {
					R19zJJp6.putUS(Tags.BitsAllocated, 16);
					JOVoDsMG = JOVoDsMG * 4 / 3;
				}
				if (JOVoDsMG != (R19zJJp6.getInt(Tags.BitsAllocated, 0) >>> 3) * R19zJJp6.getInt(Tags.Rows, 0)
						* R19zJJp6.getInt(Tags.Columns, 0) * R19zJJp6.getInt(Tags.NumberOfFrames, 1)
						* R19zJJp6.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + kUf8pBxg + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			R19zJJp6.putUI(Tags.StudyInstanceUID, uid(studyUID));
			R19zJJp6.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			R19zJJp6.putUI(Tags.SOPInstanceUID, uid(instUID));
			R19zJJp6.putUI(Tags.SOPClassUID, classUID);
			if (!R19zJJp6.contains(Tags.NumberOfSamples)) {
				R19zJJp6.putUS(Tags.NumberOfSamples, 1);
			}
			if (!R19zJJp6.contains(Tags.PhotometricInterpretation)) {
				R19zJJp6.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				R19zJJp6.setFileMetaInfo(fact.newFileMetaInfo(R19zJJp6, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream ouojFRJL = new BufferedOutputStream(new FileOutputStream(oIv2UzYd));
			try {
			} finally {
				R19zJJp6.writeFile(ouojFRJL, encodeParam());
				if (O9Oqb5hf) {
					if (!skipGroupLen) {
						ouojFRJL.write(PXDATA_GROUPLEN);
						int tAsXFwTk = JOVoDsMG + 8;
						ouojFRJL.write((byte) tAsXFwTk);
						ouojFRJL.write((byte) (tAsXFwTk >> 8));
						ouojFRJL.write((byte) (tAsXFwTk >> 16));
						ouojFRJL.write((byte) (tAsXFwTk >> 24));
					}
					ouojFRJL.write(PXDATA_TAG);
					ouojFRJL.write((byte) JOVoDsMG);
					ouojFRJL.write((byte) (JOVoDsMG >> 8));
					ouojFRJL.write((byte) (JOVoDsMG >> 16));
					ouojFRJL.write((byte) (JOVoDsMG >> 24));
				}
				if (GEZljMW5) {
					int q6tYWGw7, W74H7X1Y;
					for (; JOVoDsMG > 0; JOVoDsMG -= 3) {
						ouojFRJL.write(EzZOdzlx.read());
						q6tYWGw7 = EzZOdzlx.read();
						W74H7X1Y = EzZOdzlx.read();
						ouojFRJL.write(q6tYWGw7 & 0x0f);
						ouojFRJL.write(q6tYWGw7 >> 4 | ((W74H7X1Y & 0x0f) << 4));
						ouojFRJL.write(W74H7X1Y >> 4);
					}
				} else {
					for (; JOVoDsMG > 0; --JOVoDsMG) {
						ouojFRJL.write(EzZOdzlx.read());
					}
				}
				ouojFRJL.close();
			}
			System.out.print('.');
		} finally {
			EzZOdzlx.close();
		}
	}

}