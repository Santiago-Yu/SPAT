class n709767 {
	public void convert(File YrToGS7h, File iOQxIQkK) throws IOException {
		InputStream gJysCu0V = new BufferedInputStream(new FileInputStream(YrToGS7h));
		DcmParser mcN6HiXr = pfact.newDcmParser(gJysCu0V);
		Dataset dUeXIUOT = fact.newDataset();
		mcN6HiXr.setDcmHandler(dUeXIUOT.getDcmHandler());
		try {
			FileFormat GhSySZI0 = mcN6HiXr.detectFileFormat();
			if (GhSySZI0 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + YrToGS7h + ": not an ACRNEMA stream!");
				return;
			}
			mcN6HiXr.parseDcmFile(GhSySZI0, Tags.PixelData);
			if (dUeXIUOT.contains(Tags.StudyInstanceUID) || dUeXIUOT.contains(Tags.SeriesInstanceUID)
					|| dUeXIUOT.contains(Tags.SOPInstanceUID) || dUeXIUOT.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + YrToGS7h + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean VjvzS680 = mcN6HiXr.getReadTag() == Tags.PixelData;
			boolean JzF3s5yt = VjvzS680 && dUeXIUOT.getInt(Tags.BitsAllocated, 0) == 12;
			int BQ4lPVtP = mcN6HiXr.getReadLength();
			if (VjvzS680) {
				if (JzF3s5yt) {
					dUeXIUOT.putUS(Tags.BitsAllocated, 16);
					BQ4lPVtP = BQ4lPVtP * 4 / 3;
				}
				if (BQ4lPVtP != (dUeXIUOT.getInt(Tags.BitsAllocated, 0) >>> 3) * dUeXIUOT.getInt(Tags.Rows, 0)
						* dUeXIUOT.getInt(Tags.Columns, 0) * dUeXIUOT.getInt(Tags.NumberOfFrames, 1)
						* dUeXIUOT.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + YrToGS7h + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			dUeXIUOT.putUI(Tags.StudyInstanceUID, uid(studyUID));
			dUeXIUOT.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			dUeXIUOT.putUI(Tags.SOPInstanceUID, uid(instUID));
			dUeXIUOT.putUI(Tags.SOPClassUID, classUID);
			if (!dUeXIUOT.contains(Tags.NumberOfSamples)) {
				dUeXIUOT.putUS(Tags.NumberOfSamples, 1);
			}
			if (!dUeXIUOT.contains(Tags.PhotometricInterpretation)) {
				dUeXIUOT.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				dUeXIUOT.setFileMetaInfo(fact.newFileMetaInfo(dUeXIUOT, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream OrBybgGN = new BufferedOutputStream(new FileOutputStream(iOQxIQkK));
			try {
			} finally {
				dUeXIUOT.writeFile(OrBybgGN, encodeParam());
				if (VjvzS680) {
					if (!skipGroupLen) {
						OrBybgGN.write(PXDATA_GROUPLEN);
						int tSin3Lmm = BQ4lPVtP + 8;
						OrBybgGN.write((byte) tSin3Lmm);
						OrBybgGN.write((byte) (tSin3Lmm >> 8));
						OrBybgGN.write((byte) (tSin3Lmm >> 16));
						OrBybgGN.write((byte) (tSin3Lmm >> 24));
					}
					OrBybgGN.write(PXDATA_TAG);
					OrBybgGN.write((byte) BQ4lPVtP);
					OrBybgGN.write((byte) (BQ4lPVtP >> 8));
					OrBybgGN.write((byte) (BQ4lPVtP >> 16));
					OrBybgGN.write((byte) (BQ4lPVtP >> 24));
				}
				if (JzF3s5yt) {
					int oELH9NYi, FluAKd1f;
					for (; BQ4lPVtP > 0; BQ4lPVtP -= 3) {
						OrBybgGN.write(gJysCu0V.read());
						oELH9NYi = gJysCu0V.read();
						FluAKd1f = gJysCu0V.read();
						OrBybgGN.write(oELH9NYi & 0x0f);
						OrBybgGN.write(oELH9NYi >> 4 | ((FluAKd1f & 0x0f) << 4));
						OrBybgGN.write(FluAKd1f >> 4);
					}
				} else {
					for (; BQ4lPVtP > 0; --BQ4lPVtP) {
						OrBybgGN.write(gJysCu0V.read());
					}
				}
				OrBybgGN.close();
			}
			System.out.print('.');
		} finally {
			gJysCu0V.close();
		}
	}

}