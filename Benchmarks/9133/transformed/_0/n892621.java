class n892621 {
	public void convert(File jjTqVCnK, File jvc8QBeT) throws IOException {
		InputStream ABq2tBSw = new BufferedInputStream(new FileInputStream(jjTqVCnK));
		DcmParser vY8nGIrl = pfact.newDcmParser(ABq2tBSw);
		Dataset S5axYLAQ = fact.newDataset();
		vY8nGIrl.setDcmHandler(S5axYLAQ.getDcmHandler());
		try {
			FileFormat YA2ATQwd = vY8nGIrl.detectFileFormat();
			if (YA2ATQwd != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + jjTqVCnK + ": not an ACRNEMA stream!");
				return;
			}
			vY8nGIrl.parseDcmFile(YA2ATQwd, Tags.PixelData);
			if (S5axYLAQ.contains(Tags.StudyInstanceUID) || S5axYLAQ.contains(Tags.SeriesInstanceUID)
					|| S5axYLAQ.contains(Tags.SOPInstanceUID) || S5axYLAQ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + jjTqVCnK + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean H4ACpZIO = vY8nGIrl.getReadTag() == Tags.PixelData;
			boolean mQJK6SW3 = H4ACpZIO && S5axYLAQ.getInt(Tags.BitsAllocated, 0) == 12;
			int duKoduJb = vY8nGIrl.getReadLength();
			if (H4ACpZIO) {
				if (mQJK6SW3) {
					S5axYLAQ.putUS(Tags.BitsAllocated, 16);
					duKoduJb = duKoduJb * 4 / 3;
				}
				if (duKoduJb != (S5axYLAQ.getInt(Tags.BitsAllocated, 0) >>> 3) * S5axYLAQ.getInt(Tags.Rows, 0)
						* S5axYLAQ.getInt(Tags.Columns, 0) * S5axYLAQ.getInt(Tags.NumberOfFrames, 1)
						* S5axYLAQ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + jjTqVCnK + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			S5axYLAQ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			S5axYLAQ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			S5axYLAQ.putUI(Tags.SOPInstanceUID, uid(instUID));
			S5axYLAQ.putUI(Tags.SOPClassUID, classUID);
			if (!S5axYLAQ.contains(Tags.NumberOfSamples)) {
				S5axYLAQ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!S5axYLAQ.contains(Tags.PhotometricInterpretation)) {
				S5axYLAQ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				S5axYLAQ.setFileMetaInfo(fact.newFileMetaInfo(S5axYLAQ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream CeiNhKqJ = new BufferedOutputStream(new FileOutputStream(jvc8QBeT));
			try {
			} finally {
				S5axYLAQ.writeFile(CeiNhKqJ, encodeParam());
				if (H4ACpZIO) {
					if (!skipGroupLen) {
						CeiNhKqJ.write(PXDATA_GROUPLEN);
						int xvjwJwG0 = duKoduJb + 8;
						CeiNhKqJ.write((byte) xvjwJwG0);
						CeiNhKqJ.write((byte) (xvjwJwG0 >> 8));
						CeiNhKqJ.write((byte) (xvjwJwG0 >> 16));
						CeiNhKqJ.write((byte) (xvjwJwG0 >> 24));
					}
					CeiNhKqJ.write(PXDATA_TAG);
					CeiNhKqJ.write((byte) duKoduJb);
					CeiNhKqJ.write((byte) (duKoduJb >> 8));
					CeiNhKqJ.write((byte) (duKoduJb >> 16));
					CeiNhKqJ.write((byte) (duKoduJb >> 24));
				}
				if (mQJK6SW3) {
					int wejOpm4E, SXNf0vdx;
					for (; duKoduJb > 0; duKoduJb -= 3) {
						CeiNhKqJ.write(ABq2tBSw.read());
						wejOpm4E = ABq2tBSw.read();
						SXNf0vdx = ABq2tBSw.read();
						CeiNhKqJ.write(wejOpm4E & 0x0f);
						CeiNhKqJ.write(wejOpm4E >> 4 | ((SXNf0vdx & 0x0f) << 4));
						CeiNhKqJ.write(SXNf0vdx >> 4);
					}
				} else {
					for (; duKoduJb > 0; --duKoduJb) {
						CeiNhKqJ.write(ABq2tBSw.read());
					}
				}
				CeiNhKqJ.close();
			}
			System.out.print('.');
		} finally {
			ABq2tBSw.close();
		}
	}

}