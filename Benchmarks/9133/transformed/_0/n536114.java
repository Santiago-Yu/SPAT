class n536114 {
	public void convert(File dF4IzLly, File oz3BdKbc) throws IOException {
		InputStream HS3COp7g = new BufferedInputStream(new FileInputStream(dF4IzLly));
		DcmParser JoQXExeG = pfact.newDcmParser(HS3COp7g);
		Dataset EF6Zrcx1 = fact.newDataset();
		JoQXExeG.setDcmHandler(EF6Zrcx1.getDcmHandler());
		try {
			FileFormat vfi7Vxcl = JoQXExeG.detectFileFormat();
			if (vfi7Vxcl != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + dF4IzLly + ": not an ACRNEMA stream!");
				return;
			}
			JoQXExeG.parseDcmFile(vfi7Vxcl, Tags.PixelData);
			if (EF6Zrcx1.contains(Tags.StudyInstanceUID) || EF6Zrcx1.contains(Tags.SeriesInstanceUID)
					|| EF6Zrcx1.contains(Tags.SOPInstanceUID) || EF6Zrcx1.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + dF4IzLly + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean tq6le8l3 = JoQXExeG.getReadTag() == Tags.PixelData;
			boolean NyS9wKNq = tq6le8l3 && EF6Zrcx1.getInt(Tags.BitsAllocated, 0) == 12;
			int KY5aOWdd = JoQXExeG.getReadLength();
			if (tq6le8l3) {
				if (NyS9wKNq) {
					EF6Zrcx1.putUS(Tags.BitsAllocated, 16);
					KY5aOWdd = KY5aOWdd * 4 / 3;
				}
				if (KY5aOWdd != (EF6Zrcx1.getInt(Tags.BitsAllocated, 0) >>> 3) * EF6Zrcx1.getInt(Tags.Rows, 0)
						* EF6Zrcx1.getInt(Tags.Columns, 0) * EF6Zrcx1.getInt(Tags.NumberOfFrames, 1)
						* EF6Zrcx1.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + dF4IzLly + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			EF6Zrcx1.putUI(Tags.StudyInstanceUID, uid(studyUID));
			EF6Zrcx1.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			EF6Zrcx1.putUI(Tags.SOPInstanceUID, uid(instUID));
			EF6Zrcx1.putUI(Tags.SOPClassUID, classUID);
			if (!EF6Zrcx1.contains(Tags.NumberOfSamples)) {
				EF6Zrcx1.putUS(Tags.NumberOfSamples, 1);
			}
			if (!EF6Zrcx1.contains(Tags.PhotometricInterpretation)) {
				EF6Zrcx1.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				EF6Zrcx1.setFileMetaInfo(fact.newFileMetaInfo(EF6Zrcx1, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream V3Fi89Ep = new BufferedOutputStream(new FileOutputStream(oz3BdKbc));
			try {
			} finally {
				EF6Zrcx1.writeFile(V3Fi89Ep, encodeParam());
				if (tq6le8l3) {
					if (!skipGroupLen) {
						V3Fi89Ep.write(PXDATA_GROUPLEN);
						int XJFyRwUe = KY5aOWdd + 8;
						V3Fi89Ep.write((byte) XJFyRwUe);
						V3Fi89Ep.write((byte) (XJFyRwUe >> 8));
						V3Fi89Ep.write((byte) (XJFyRwUe >> 16));
						V3Fi89Ep.write((byte) (XJFyRwUe >> 24));
					}
					V3Fi89Ep.write(PXDATA_TAG);
					V3Fi89Ep.write((byte) KY5aOWdd);
					V3Fi89Ep.write((byte) (KY5aOWdd >> 8));
					V3Fi89Ep.write((byte) (KY5aOWdd >> 16));
					V3Fi89Ep.write((byte) (KY5aOWdd >> 24));
				}
				if (NyS9wKNq) {
					int PywdBNHp, SY9ZGFij;
					for (; KY5aOWdd > 0; KY5aOWdd -= 3) {
						V3Fi89Ep.write(HS3COp7g.read());
						PywdBNHp = HS3COp7g.read();
						SY9ZGFij = HS3COp7g.read();
						V3Fi89Ep.write(PywdBNHp & 0x0f);
						V3Fi89Ep.write(PywdBNHp >> 4 | ((SY9ZGFij & 0x0f) << 4));
						V3Fi89Ep.write(SY9ZGFij >> 4);
					}
				} else {
					for (; KY5aOWdd > 0; --KY5aOWdd) {
						V3Fi89Ep.write(HS3COp7g.read());
					}
				}
				V3Fi89Ep.close();
			}
			System.out.print('.');
		} finally {
			HS3COp7g.close();
		}
	}

}