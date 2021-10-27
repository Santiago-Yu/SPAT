class n756962 {
	public void convert(File xpHPjuk2, File eX5z5I10) throws IOException {
		InputStream lmTyrlhX = new BufferedInputStream(new FileInputStream(xpHPjuk2));
		DcmParser FExHxfit = pfact.newDcmParser(lmTyrlhX);
		Dataset j0RDuAa8 = fact.newDataset();
		FExHxfit.setDcmHandler(j0RDuAa8.getDcmHandler());
		try {
			FileFormat vahuXidl = FExHxfit.detectFileFormat();
			if (vahuXidl != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + xpHPjuk2 + ": not an ACRNEMA stream!");
				return;
			}
			FExHxfit.parseDcmFile(vahuXidl, Tags.PixelData);
			if (j0RDuAa8.contains(Tags.StudyInstanceUID) || j0RDuAa8.contains(Tags.SeriesInstanceUID)
					|| j0RDuAa8.contains(Tags.SOPInstanceUID) || j0RDuAa8.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + xpHPjuk2 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean EpNsSAr9 = FExHxfit.getReadTag() == Tags.PixelData;
			boolean KzxYjxNN = EpNsSAr9 && j0RDuAa8.getInt(Tags.BitsAllocated, 0) == 12;
			int dVws9dpB = FExHxfit.getReadLength();
			if (EpNsSAr9) {
				if (KzxYjxNN) {
					j0RDuAa8.putUS(Tags.BitsAllocated, 16);
					dVws9dpB = dVws9dpB * 4 / 3;
				}
				if (dVws9dpB != (j0RDuAa8.getInt(Tags.BitsAllocated, 0) >>> 3) * j0RDuAa8.getInt(Tags.Rows, 0)
						* j0RDuAa8.getInt(Tags.Columns, 0) * j0RDuAa8.getInt(Tags.NumberOfFrames, 1)
						* j0RDuAa8.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + xpHPjuk2 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			j0RDuAa8.putUI(Tags.StudyInstanceUID, uid(studyUID));
			j0RDuAa8.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			j0RDuAa8.putUI(Tags.SOPInstanceUID, uid(instUID));
			j0RDuAa8.putUI(Tags.SOPClassUID, classUID);
			if (!j0RDuAa8.contains(Tags.NumberOfSamples)) {
				j0RDuAa8.putUS(Tags.NumberOfSamples, 1);
			}
			if (!j0RDuAa8.contains(Tags.PhotometricInterpretation)) {
				j0RDuAa8.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				j0RDuAa8.setFileMetaInfo(fact.newFileMetaInfo(j0RDuAa8, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream e7g9vK4d = new BufferedOutputStream(new FileOutputStream(eX5z5I10));
			try {
			} finally {
				j0RDuAa8.writeFile(e7g9vK4d, encodeParam());
				if (EpNsSAr9) {
					if (!skipGroupLen) {
						e7g9vK4d.write(PXDATA_GROUPLEN);
						int bfjb4GRi = dVws9dpB + 8;
						e7g9vK4d.write((byte) bfjb4GRi);
						e7g9vK4d.write((byte) (bfjb4GRi >> 8));
						e7g9vK4d.write((byte) (bfjb4GRi >> 16));
						e7g9vK4d.write((byte) (bfjb4GRi >> 24));
					}
					e7g9vK4d.write(PXDATA_TAG);
					e7g9vK4d.write((byte) dVws9dpB);
					e7g9vK4d.write((byte) (dVws9dpB >> 8));
					e7g9vK4d.write((byte) (dVws9dpB >> 16));
					e7g9vK4d.write((byte) (dVws9dpB >> 24));
				}
				if (KzxYjxNN) {
					int DkNi9Ahw, OG3rmwX5;
					for (; dVws9dpB > 0; dVws9dpB -= 3) {
						e7g9vK4d.write(lmTyrlhX.read());
						DkNi9Ahw = lmTyrlhX.read();
						OG3rmwX5 = lmTyrlhX.read();
						e7g9vK4d.write(DkNi9Ahw & 0x0f);
						e7g9vK4d.write(DkNi9Ahw >> 4 | ((OG3rmwX5 & 0x0f) << 4));
						e7g9vK4d.write(OG3rmwX5 >> 4);
					}
				} else {
					for (; dVws9dpB > 0; --dVws9dpB) {
						e7g9vK4d.write(lmTyrlhX.read());
					}
				}
				e7g9vK4d.close();
			}
			System.out.print('.');
		} finally {
			lmTyrlhX.close();
		}
	}

}