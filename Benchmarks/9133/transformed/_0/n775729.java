class n775729 {
	public void convert(File pbuMblOQ, File GyIFQiGq) throws IOException {
		InputStream n27rdiqL = new BufferedInputStream(new FileInputStream(pbuMblOQ));
		DcmParser UiALYxHl = pfact.newDcmParser(n27rdiqL);
		Dataset X5O6LoXL = fact.newDataset();
		UiALYxHl.setDcmHandler(X5O6LoXL.getDcmHandler());
		try {
			FileFormat IB9K0gbY = UiALYxHl.detectFileFormat();
			if (IB9K0gbY != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + pbuMblOQ + ": not an ACRNEMA stream!");
				return;
			}
			UiALYxHl.parseDcmFile(IB9K0gbY, Tags.PixelData);
			if (X5O6LoXL.contains(Tags.StudyInstanceUID) || X5O6LoXL.contains(Tags.SeriesInstanceUID)
					|| X5O6LoXL.contains(Tags.SOPInstanceUID) || X5O6LoXL.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + pbuMblOQ + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean dPQnrbIb = UiALYxHl.getReadTag() == Tags.PixelData;
			boolean DshoVbyM = dPQnrbIb && X5O6LoXL.getInt(Tags.BitsAllocated, 0) == 12;
			int NKJe1Wgs = UiALYxHl.getReadLength();
			if (dPQnrbIb) {
				if (DshoVbyM) {
					X5O6LoXL.putUS(Tags.BitsAllocated, 16);
					NKJe1Wgs = NKJe1Wgs * 4 / 3;
				}
				if (NKJe1Wgs != (X5O6LoXL.getInt(Tags.BitsAllocated, 0) >>> 3) * X5O6LoXL.getInt(Tags.Rows, 0)
						* X5O6LoXL.getInt(Tags.Columns, 0) * X5O6LoXL.getInt(Tags.NumberOfFrames, 1)
						* X5O6LoXL.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + pbuMblOQ + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			X5O6LoXL.putUI(Tags.StudyInstanceUID, uid(studyUID));
			X5O6LoXL.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			X5O6LoXL.putUI(Tags.SOPInstanceUID, uid(instUID));
			X5O6LoXL.putUI(Tags.SOPClassUID, classUID);
			if (!X5O6LoXL.contains(Tags.NumberOfSamples)) {
				X5O6LoXL.putUS(Tags.NumberOfSamples, 1);
			}
			if (!X5O6LoXL.contains(Tags.PhotometricInterpretation)) {
				X5O6LoXL.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				X5O6LoXL.setFileMetaInfo(fact.newFileMetaInfo(X5O6LoXL, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Uz9LPCSL = new BufferedOutputStream(new FileOutputStream(GyIFQiGq));
			try {
			} finally {
				X5O6LoXL.writeFile(Uz9LPCSL, encodeParam());
				if (dPQnrbIb) {
					if (!skipGroupLen) {
						Uz9LPCSL.write(PXDATA_GROUPLEN);
						int uO3KKsdP = NKJe1Wgs + 8;
						Uz9LPCSL.write((byte) uO3KKsdP);
						Uz9LPCSL.write((byte) (uO3KKsdP >> 8));
						Uz9LPCSL.write((byte) (uO3KKsdP >> 16));
						Uz9LPCSL.write((byte) (uO3KKsdP >> 24));
					}
					Uz9LPCSL.write(PXDATA_TAG);
					Uz9LPCSL.write((byte) NKJe1Wgs);
					Uz9LPCSL.write((byte) (NKJe1Wgs >> 8));
					Uz9LPCSL.write((byte) (NKJe1Wgs >> 16));
					Uz9LPCSL.write((byte) (NKJe1Wgs >> 24));
				}
				if (DshoVbyM) {
					int HQysnUzy, rdwQEaPT;
					for (; NKJe1Wgs > 0; NKJe1Wgs -= 3) {
						Uz9LPCSL.write(n27rdiqL.read());
						HQysnUzy = n27rdiqL.read();
						rdwQEaPT = n27rdiqL.read();
						Uz9LPCSL.write(HQysnUzy & 0x0f);
						Uz9LPCSL.write(HQysnUzy >> 4 | ((rdwQEaPT & 0x0f) << 4));
						Uz9LPCSL.write(rdwQEaPT >> 4);
					}
				} else {
					for (; NKJe1Wgs > 0; --NKJe1Wgs) {
						Uz9LPCSL.write(n27rdiqL.read());
					}
				}
				Uz9LPCSL.close();
			}
			System.out.print('.');
		} finally {
			n27rdiqL.close();
		}
	}

}