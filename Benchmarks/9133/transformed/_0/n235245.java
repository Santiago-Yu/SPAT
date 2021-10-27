class n235245 {
	public void convert(File O4RLbhJm, File QyBtxTPE) throws IOException {
		InputStream LF4Qh48f = new BufferedInputStream(new FileInputStream(O4RLbhJm));
		DcmParser IQ1vCfvL = pfact.newDcmParser(LF4Qh48f);
		Dataset rv8BoY1m = fact.newDataset();
		IQ1vCfvL.setDcmHandler(rv8BoY1m.getDcmHandler());
		try {
			FileFormat oya8jgAc = IQ1vCfvL.detectFileFormat();
			if (oya8jgAc != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + O4RLbhJm + ": not an ACRNEMA stream!");
				return;
			}
			IQ1vCfvL.parseDcmFile(oya8jgAc, Tags.PixelData);
			if (rv8BoY1m.contains(Tags.StudyInstanceUID) || rv8BoY1m.contains(Tags.SeriesInstanceUID)
					|| rv8BoY1m.contains(Tags.SOPInstanceUID) || rv8BoY1m.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + O4RLbhJm + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Tg1MaLjt = IQ1vCfvL.getReadTag() == Tags.PixelData;
			boolean N2fk4yhm = Tg1MaLjt && rv8BoY1m.getInt(Tags.BitsAllocated, 0) == 12;
			int Doe4k52G = IQ1vCfvL.getReadLength();
			if (Tg1MaLjt) {
				if (N2fk4yhm) {
					rv8BoY1m.putUS(Tags.BitsAllocated, 16);
					Doe4k52G = Doe4k52G * 4 / 3;
				}
				if (Doe4k52G != (rv8BoY1m.getInt(Tags.BitsAllocated, 0) >>> 3) * rv8BoY1m.getInt(Tags.Rows, 0)
						* rv8BoY1m.getInt(Tags.Columns, 0) * rv8BoY1m.getInt(Tags.NumberOfFrames, 1)
						* rv8BoY1m.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + O4RLbhJm + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			rv8BoY1m.putUI(Tags.StudyInstanceUID, uid(studyUID));
			rv8BoY1m.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			rv8BoY1m.putUI(Tags.SOPInstanceUID, uid(instUID));
			rv8BoY1m.putUI(Tags.SOPClassUID, classUID);
			if (!rv8BoY1m.contains(Tags.NumberOfSamples)) {
				rv8BoY1m.putUS(Tags.NumberOfSamples, 1);
			}
			if (!rv8BoY1m.contains(Tags.PhotometricInterpretation)) {
				rv8BoY1m.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				rv8BoY1m.setFileMetaInfo(fact.newFileMetaInfo(rv8BoY1m, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream V97hKWDx = new BufferedOutputStream(new FileOutputStream(QyBtxTPE));
			try {
			} finally {
				rv8BoY1m.writeFile(V97hKWDx, encodeParam());
				if (Tg1MaLjt) {
					if (!skipGroupLen) {
						V97hKWDx.write(PXDATA_GROUPLEN);
						int qvkiCWXh = Doe4k52G + 8;
						V97hKWDx.write((byte) qvkiCWXh);
						V97hKWDx.write((byte) (qvkiCWXh >> 8));
						V97hKWDx.write((byte) (qvkiCWXh >> 16));
						V97hKWDx.write((byte) (qvkiCWXh >> 24));
					}
					V97hKWDx.write(PXDATA_TAG);
					V97hKWDx.write((byte) Doe4k52G);
					V97hKWDx.write((byte) (Doe4k52G >> 8));
					V97hKWDx.write((byte) (Doe4k52G >> 16));
					V97hKWDx.write((byte) (Doe4k52G >> 24));
				}
				if (N2fk4yhm) {
					int BjRsniQI, ExuReJGf;
					for (; Doe4k52G > 0; Doe4k52G -= 3) {
						V97hKWDx.write(LF4Qh48f.read());
						BjRsniQI = LF4Qh48f.read();
						ExuReJGf = LF4Qh48f.read();
						V97hKWDx.write(BjRsniQI & 0x0f);
						V97hKWDx.write(BjRsniQI >> 4 | ((ExuReJGf & 0x0f) << 4));
						V97hKWDx.write(ExuReJGf >> 4);
					}
				} else {
					for (; Doe4k52G > 0; --Doe4k52G) {
						V97hKWDx.write(LF4Qh48f.read());
					}
				}
				V97hKWDx.close();
			}
			System.out.print('.');
		} finally {
			LF4Qh48f.close();
		}
	}

}