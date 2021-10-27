class n482330 {
	public void convert(File BuI0ikyX, File stE9LSTd) throws IOException {
		InputStream fBAzLxxG = new BufferedInputStream(new FileInputStream(BuI0ikyX));
		DcmParser vCjnZWJE = pfact.newDcmParser(fBAzLxxG);
		Dataset H7iAJLF1 = fact.newDataset();
		vCjnZWJE.setDcmHandler(H7iAJLF1.getDcmHandler());
		try {
			FileFormat CbTcpMHc = vCjnZWJE.detectFileFormat();
			if (CbTcpMHc != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + BuI0ikyX + ": not an ACRNEMA stream!");
				return;
			}
			vCjnZWJE.parseDcmFile(CbTcpMHc, Tags.PixelData);
			if (H7iAJLF1.contains(Tags.StudyInstanceUID) || H7iAJLF1.contains(Tags.SeriesInstanceUID)
					|| H7iAJLF1.contains(Tags.SOPInstanceUID) || H7iAJLF1.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + BuI0ikyX + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean rw8XtelB = vCjnZWJE.getReadTag() == Tags.PixelData;
			boolean bYhIQfG3 = rw8XtelB && H7iAJLF1.getInt(Tags.BitsAllocated, 0) == 12;
			int tQjjsdUl = vCjnZWJE.getReadLength();
			if (rw8XtelB) {
				if (bYhIQfG3) {
					H7iAJLF1.putUS(Tags.BitsAllocated, 16);
					tQjjsdUl = tQjjsdUl * 4 / 3;
				}
				if (tQjjsdUl != (H7iAJLF1.getInt(Tags.BitsAllocated, 0) >>> 3) * H7iAJLF1.getInt(Tags.Rows, 0)
						* H7iAJLF1.getInt(Tags.Columns, 0) * H7iAJLF1.getInt(Tags.NumberOfFrames, 1)
						* H7iAJLF1.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + BuI0ikyX + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			H7iAJLF1.putUI(Tags.StudyInstanceUID, uid(studyUID));
			H7iAJLF1.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			H7iAJLF1.putUI(Tags.SOPInstanceUID, uid(instUID));
			H7iAJLF1.putUI(Tags.SOPClassUID, classUID);
			if (!H7iAJLF1.contains(Tags.NumberOfSamples)) {
				H7iAJLF1.putUS(Tags.NumberOfSamples, 1);
			}
			if (!H7iAJLF1.contains(Tags.PhotometricInterpretation)) {
				H7iAJLF1.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				H7iAJLF1.setFileMetaInfo(fact.newFileMetaInfo(H7iAJLF1, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream upqvS8lw = new BufferedOutputStream(new FileOutputStream(stE9LSTd));
			try {
			} finally {
				H7iAJLF1.writeFile(upqvS8lw, encodeParam());
				if (rw8XtelB) {
					if (!skipGroupLen) {
						upqvS8lw.write(PXDATA_GROUPLEN);
						int X1sLp7sh = tQjjsdUl + 8;
						upqvS8lw.write((byte) X1sLp7sh);
						upqvS8lw.write((byte) (X1sLp7sh >> 8));
						upqvS8lw.write((byte) (X1sLp7sh >> 16));
						upqvS8lw.write((byte) (X1sLp7sh >> 24));
					}
					upqvS8lw.write(PXDATA_TAG);
					upqvS8lw.write((byte) tQjjsdUl);
					upqvS8lw.write((byte) (tQjjsdUl >> 8));
					upqvS8lw.write((byte) (tQjjsdUl >> 16));
					upqvS8lw.write((byte) (tQjjsdUl >> 24));
				}
				if (bYhIQfG3) {
					int McbButjC, o5ndHEee;
					for (; tQjjsdUl > 0; tQjjsdUl -= 3) {
						upqvS8lw.write(fBAzLxxG.read());
						McbButjC = fBAzLxxG.read();
						o5ndHEee = fBAzLxxG.read();
						upqvS8lw.write(McbButjC & 0x0f);
						upqvS8lw.write(McbButjC >> 4 | ((o5ndHEee & 0x0f) << 4));
						upqvS8lw.write(o5ndHEee >> 4);
					}
				} else {
					for (; tQjjsdUl > 0; --tQjjsdUl) {
						upqvS8lw.write(fBAzLxxG.read());
					}
				}
				upqvS8lw.close();
			}
			System.out.print('.');
		} finally {
			fBAzLxxG.close();
		}
	}

}