class n62362 {
	public void convert(File heci67zo, File reNUE8KB) throws IOException {
		InputStream Igeyp1cu = new BufferedInputStream(new FileInputStream(heci67zo));
		DcmParser d9lmIPR0 = pfact.newDcmParser(Igeyp1cu);
		Dataset JjLakB44 = fact.newDataset();
		d9lmIPR0.setDcmHandler(JjLakB44.getDcmHandler());
		try {
			FileFormat yMHFKcWm = d9lmIPR0.detectFileFormat();
			if (yMHFKcWm != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + heci67zo + ": not an ACRNEMA stream!");
				return;
			}
			d9lmIPR0.parseDcmFile(yMHFKcWm, Tags.PixelData);
			if (JjLakB44.contains(Tags.StudyInstanceUID) || JjLakB44.contains(Tags.SeriesInstanceUID)
					|| JjLakB44.contains(Tags.SOPInstanceUID) || JjLakB44.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + heci67zo + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean zpwprhf8 = d9lmIPR0.getReadTag() == Tags.PixelData;
			boolean g7g33LA2 = zpwprhf8 && JjLakB44.getInt(Tags.BitsAllocated, 0) == 12;
			int hYCO09Mi = d9lmIPR0.getReadLength();
			if (zpwprhf8) {
				if (g7g33LA2) {
					JjLakB44.putUS(Tags.BitsAllocated, 16);
					hYCO09Mi = hYCO09Mi * 4 / 3;
				}
				if (hYCO09Mi != (JjLakB44.getInt(Tags.BitsAllocated, 0) >>> 3) * JjLakB44.getInt(Tags.Rows, 0)
						* JjLakB44.getInt(Tags.Columns, 0) * JjLakB44.getInt(Tags.NumberOfFrames, 1)
						* JjLakB44.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + heci67zo + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			JjLakB44.putUI(Tags.StudyInstanceUID, uid(studyUID));
			JjLakB44.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			JjLakB44.putUI(Tags.SOPInstanceUID, uid(instUID));
			JjLakB44.putUI(Tags.SOPClassUID, classUID);
			if (!JjLakB44.contains(Tags.NumberOfSamples)) {
				JjLakB44.putUS(Tags.NumberOfSamples, 1);
			}
			if (!JjLakB44.contains(Tags.PhotometricInterpretation)) {
				JjLakB44.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				JjLakB44.setFileMetaInfo(fact.newFileMetaInfo(JjLakB44, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream VEDeZyss = new BufferedOutputStream(new FileOutputStream(reNUE8KB));
			try {
			} finally {
				JjLakB44.writeFile(VEDeZyss, encodeParam());
				if (zpwprhf8) {
					if (!skipGroupLen) {
						VEDeZyss.write(PXDATA_GROUPLEN);
						int mJz7MY7p = hYCO09Mi + 8;
						VEDeZyss.write((byte) mJz7MY7p);
						VEDeZyss.write((byte) (mJz7MY7p >> 8));
						VEDeZyss.write((byte) (mJz7MY7p >> 16));
						VEDeZyss.write((byte) (mJz7MY7p >> 24));
					}
					VEDeZyss.write(PXDATA_TAG);
					VEDeZyss.write((byte) hYCO09Mi);
					VEDeZyss.write((byte) (hYCO09Mi >> 8));
					VEDeZyss.write((byte) (hYCO09Mi >> 16));
					VEDeZyss.write((byte) (hYCO09Mi >> 24));
				}
				if (g7g33LA2) {
					int RMmnjj5q, Owmz7v5X;
					for (; hYCO09Mi > 0; hYCO09Mi -= 3) {
						VEDeZyss.write(Igeyp1cu.read());
						RMmnjj5q = Igeyp1cu.read();
						Owmz7v5X = Igeyp1cu.read();
						VEDeZyss.write(RMmnjj5q & 0x0f);
						VEDeZyss.write(RMmnjj5q >> 4 | ((Owmz7v5X & 0x0f) << 4));
						VEDeZyss.write(Owmz7v5X >> 4);
					}
				} else {
					for (; hYCO09Mi > 0; --hYCO09Mi) {
						VEDeZyss.write(Igeyp1cu.read());
					}
				}
				VEDeZyss.close();
			}
			System.out.print('.');
		} finally {
			Igeyp1cu.close();
		}
	}

}