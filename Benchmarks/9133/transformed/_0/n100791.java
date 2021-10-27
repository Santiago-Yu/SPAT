class n100791 {
	public void convert(File aOvfXg3c, File uSnElcoK) throws IOException {
		InputStream KGo8JReF = new BufferedInputStream(new FileInputStream(aOvfXg3c));
		DcmParser DN4bFj1l = pfact.newDcmParser(KGo8JReF);
		Dataset E2gfGQng = fact.newDataset();
		DN4bFj1l.setDcmHandler(E2gfGQng.getDcmHandler());
		try {
			FileFormat JIRfo7sm = DN4bFj1l.detectFileFormat();
			if (JIRfo7sm != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + aOvfXg3c + ": not an ACRNEMA stream!");
				return;
			}
			DN4bFj1l.parseDcmFile(JIRfo7sm, Tags.PixelData);
			if (E2gfGQng.contains(Tags.StudyInstanceUID) || E2gfGQng.contains(Tags.SeriesInstanceUID)
					|| E2gfGQng.contains(Tags.SOPInstanceUID) || E2gfGQng.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + aOvfXg3c + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Of54Of2D = DN4bFj1l.getReadTag() == Tags.PixelData;
			boolean yRkT8Lwb = Of54Of2D && E2gfGQng.getInt(Tags.BitsAllocated, 0) == 12;
			int Wa7faoF9 = DN4bFj1l.getReadLength();
			if (Of54Of2D) {
				if (yRkT8Lwb) {
					E2gfGQng.putUS(Tags.BitsAllocated, 16);
					Wa7faoF9 = Wa7faoF9 * 4 / 3;
				}
				if (Wa7faoF9 != (E2gfGQng.getInt(Tags.BitsAllocated, 0) >>> 3) * E2gfGQng.getInt(Tags.Rows, 0)
						* E2gfGQng.getInt(Tags.Columns, 0) * E2gfGQng.getInt(Tags.NumberOfFrames, 1)
						* E2gfGQng.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + aOvfXg3c + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			E2gfGQng.putUI(Tags.StudyInstanceUID, uid(studyUID));
			E2gfGQng.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			E2gfGQng.putUI(Tags.SOPInstanceUID, uid(instUID));
			E2gfGQng.putUI(Tags.SOPClassUID, classUID);
			if (!E2gfGQng.contains(Tags.NumberOfSamples)) {
				E2gfGQng.putUS(Tags.NumberOfSamples, 1);
			}
			if (!E2gfGQng.contains(Tags.PhotometricInterpretation)) {
				E2gfGQng.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				E2gfGQng.setFileMetaInfo(fact.newFileMetaInfo(E2gfGQng, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream OyLDCfTy = new BufferedOutputStream(new FileOutputStream(uSnElcoK));
			try {
			} finally {
				E2gfGQng.writeFile(OyLDCfTy, encodeParam());
				if (Of54Of2D) {
					if (!skipGroupLen) {
						OyLDCfTy.write(PXDATA_GROUPLEN);
						int H88zWln5 = Wa7faoF9 + 8;
						OyLDCfTy.write((byte) H88zWln5);
						OyLDCfTy.write((byte) (H88zWln5 >> 8));
						OyLDCfTy.write((byte) (H88zWln5 >> 16));
						OyLDCfTy.write((byte) (H88zWln5 >> 24));
					}
					OyLDCfTy.write(PXDATA_TAG);
					OyLDCfTy.write((byte) Wa7faoF9);
					OyLDCfTy.write((byte) (Wa7faoF9 >> 8));
					OyLDCfTy.write((byte) (Wa7faoF9 >> 16));
					OyLDCfTy.write((byte) (Wa7faoF9 >> 24));
				}
				if (yRkT8Lwb) {
					int RweOpIQi, lVOdBjDI;
					for (; Wa7faoF9 > 0; Wa7faoF9 -= 3) {
						OyLDCfTy.write(KGo8JReF.read());
						RweOpIQi = KGo8JReF.read();
						lVOdBjDI = KGo8JReF.read();
						OyLDCfTy.write(RweOpIQi & 0x0f);
						OyLDCfTy.write(RweOpIQi >> 4 | ((lVOdBjDI & 0x0f) << 4));
						OyLDCfTy.write(lVOdBjDI >> 4);
					}
				} else {
					for (; Wa7faoF9 > 0; --Wa7faoF9) {
						OyLDCfTy.write(KGo8JReF.read());
					}
				}
				OyLDCfTy.close();
			}
			System.out.print('.');
		} finally {
			KGo8JReF.close();
		}
	}

}