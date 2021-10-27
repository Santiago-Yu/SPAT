class n204078 {
	public void convert(File tq6hDG1y, File pg8Ae1hL) throws IOException {
		InputStream HsBhBnTC = new BufferedInputStream(new FileInputStream(tq6hDG1y));
		DcmParser XyE1B44Q = pfact.newDcmParser(HsBhBnTC);
		Dataset JpXJuUb3 = fact.newDataset();
		XyE1B44Q.setDcmHandler(JpXJuUb3.getDcmHandler());
		try {
			FileFormat VUl9jC2r = XyE1B44Q.detectFileFormat();
			if (VUl9jC2r != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + tq6hDG1y + ": not an ACRNEMA stream!");
				return;
			}
			XyE1B44Q.parseDcmFile(VUl9jC2r, Tags.PixelData);
			if (JpXJuUb3.contains(Tags.StudyInstanceUID) || JpXJuUb3.contains(Tags.SeriesInstanceUID)
					|| JpXJuUb3.contains(Tags.SOPInstanceUID) || JpXJuUb3.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + tq6hDG1y + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean fvzWwhAc = XyE1B44Q.getReadTag() == Tags.PixelData;
			boolean QRudsYrI = fvzWwhAc && JpXJuUb3.getInt(Tags.BitsAllocated, 0) == 12;
			int tArc90kp = XyE1B44Q.getReadLength();
			if (fvzWwhAc) {
				if (QRudsYrI) {
					JpXJuUb3.putUS(Tags.BitsAllocated, 16);
					tArc90kp = tArc90kp * 4 / 3;
				}
				if (tArc90kp != (JpXJuUb3.getInt(Tags.BitsAllocated, 0) >>> 3) * JpXJuUb3.getInt(Tags.Rows, 0)
						* JpXJuUb3.getInt(Tags.Columns, 0) * JpXJuUb3.getInt(Tags.NumberOfFrames, 1)
						* JpXJuUb3.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + tq6hDG1y + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			JpXJuUb3.putUI(Tags.StudyInstanceUID, uid(studyUID));
			JpXJuUb3.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			JpXJuUb3.putUI(Tags.SOPInstanceUID, uid(instUID));
			JpXJuUb3.putUI(Tags.SOPClassUID, classUID);
			if (!JpXJuUb3.contains(Tags.NumberOfSamples)) {
				JpXJuUb3.putUS(Tags.NumberOfSamples, 1);
			}
			if (!JpXJuUb3.contains(Tags.PhotometricInterpretation)) {
				JpXJuUb3.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				JpXJuUb3.setFileMetaInfo(fact.newFileMetaInfo(JpXJuUb3, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream GCyID0QF = new BufferedOutputStream(new FileOutputStream(pg8Ae1hL));
			try {
			} finally {
				JpXJuUb3.writeFile(GCyID0QF, encodeParam());
				if (fvzWwhAc) {
					if (!skipGroupLen) {
						GCyID0QF.write(PXDATA_GROUPLEN);
						int mmoCQgi3 = tArc90kp + 8;
						GCyID0QF.write((byte) mmoCQgi3);
						GCyID0QF.write((byte) (mmoCQgi3 >> 8));
						GCyID0QF.write((byte) (mmoCQgi3 >> 16));
						GCyID0QF.write((byte) (mmoCQgi3 >> 24));
					}
					GCyID0QF.write(PXDATA_TAG);
					GCyID0QF.write((byte) tArc90kp);
					GCyID0QF.write((byte) (tArc90kp >> 8));
					GCyID0QF.write((byte) (tArc90kp >> 16));
					GCyID0QF.write((byte) (tArc90kp >> 24));
				}
				if (QRudsYrI) {
					int XbXpQXrF, fQsKeowo;
					for (; tArc90kp > 0; tArc90kp -= 3) {
						GCyID0QF.write(HsBhBnTC.read());
						XbXpQXrF = HsBhBnTC.read();
						fQsKeowo = HsBhBnTC.read();
						GCyID0QF.write(XbXpQXrF & 0x0f);
						GCyID0QF.write(XbXpQXrF >> 4 | ((fQsKeowo & 0x0f) << 4));
						GCyID0QF.write(fQsKeowo >> 4);
					}
				} else {
					for (; tArc90kp > 0; --tArc90kp) {
						GCyID0QF.write(HsBhBnTC.read());
					}
				}
				GCyID0QF.close();
			}
			System.out.print('.');
		} finally {
			HsBhBnTC.close();
		}
	}

}