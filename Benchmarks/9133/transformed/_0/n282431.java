class n282431 {
	public void convert(File PbhKgYCh, File aAsljhdN) throws IOException {
		InputStream ATo1r8Wj = new BufferedInputStream(new FileInputStream(PbhKgYCh));
		DcmParser DEeHFMlZ = pfact.newDcmParser(ATo1r8Wj);
		Dataset BrvQA0wG = fact.newDataset();
		DEeHFMlZ.setDcmHandler(BrvQA0wG.getDcmHandler());
		try {
			FileFormat cNIClmD5 = DEeHFMlZ.detectFileFormat();
			if (cNIClmD5 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + PbhKgYCh + ": not an ACRNEMA stream!");
				return;
			}
			DEeHFMlZ.parseDcmFile(cNIClmD5, Tags.PixelData);
			if (BrvQA0wG.contains(Tags.StudyInstanceUID) || BrvQA0wG.contains(Tags.SeriesInstanceUID)
					|| BrvQA0wG.contains(Tags.SOPInstanceUID) || BrvQA0wG.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + PbhKgYCh + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean RbmKOXVC = DEeHFMlZ.getReadTag() == Tags.PixelData;
			boolean g4OTZDDK = RbmKOXVC && BrvQA0wG.getInt(Tags.BitsAllocated, 0) == 12;
			int wXwHBqn8 = DEeHFMlZ.getReadLength();
			if (RbmKOXVC) {
				if (g4OTZDDK) {
					BrvQA0wG.putUS(Tags.BitsAllocated, 16);
					wXwHBqn8 = wXwHBqn8 * 4 / 3;
				}
				if (wXwHBqn8 != (BrvQA0wG.getInt(Tags.BitsAllocated, 0) >>> 3) * BrvQA0wG.getInt(Tags.Rows, 0)
						* BrvQA0wG.getInt(Tags.Columns, 0) * BrvQA0wG.getInt(Tags.NumberOfFrames, 1)
						* BrvQA0wG.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + PbhKgYCh + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			BrvQA0wG.putUI(Tags.StudyInstanceUID, uid(studyUID));
			BrvQA0wG.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			BrvQA0wG.putUI(Tags.SOPInstanceUID, uid(instUID));
			BrvQA0wG.putUI(Tags.SOPClassUID, classUID);
			if (!BrvQA0wG.contains(Tags.NumberOfSamples)) {
				BrvQA0wG.putUS(Tags.NumberOfSamples, 1);
			}
			if (!BrvQA0wG.contains(Tags.PhotometricInterpretation)) {
				BrvQA0wG.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				BrvQA0wG.setFileMetaInfo(fact.newFileMetaInfo(BrvQA0wG, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Kebeto8J = new BufferedOutputStream(new FileOutputStream(aAsljhdN));
			try {
			} finally {
				BrvQA0wG.writeFile(Kebeto8J, encodeParam());
				if (RbmKOXVC) {
					if (!skipGroupLen) {
						Kebeto8J.write(PXDATA_GROUPLEN);
						int HrRFTenY = wXwHBqn8 + 8;
						Kebeto8J.write((byte) HrRFTenY);
						Kebeto8J.write((byte) (HrRFTenY >> 8));
						Kebeto8J.write((byte) (HrRFTenY >> 16));
						Kebeto8J.write((byte) (HrRFTenY >> 24));
					}
					Kebeto8J.write(PXDATA_TAG);
					Kebeto8J.write((byte) wXwHBqn8);
					Kebeto8J.write((byte) (wXwHBqn8 >> 8));
					Kebeto8J.write((byte) (wXwHBqn8 >> 16));
					Kebeto8J.write((byte) (wXwHBqn8 >> 24));
				}
				if (g4OTZDDK) {
					int mpfDAbk2, NvDBPv86;
					for (; wXwHBqn8 > 0; wXwHBqn8 -= 3) {
						Kebeto8J.write(ATo1r8Wj.read());
						mpfDAbk2 = ATo1r8Wj.read();
						NvDBPv86 = ATo1r8Wj.read();
						Kebeto8J.write(mpfDAbk2 & 0x0f);
						Kebeto8J.write(mpfDAbk2 >> 4 | ((NvDBPv86 & 0x0f) << 4));
						Kebeto8J.write(NvDBPv86 >> 4);
					}
				} else {
					for (; wXwHBqn8 > 0; --wXwHBqn8) {
						Kebeto8J.write(ATo1r8Wj.read());
					}
				}
				Kebeto8J.close();
			}
			System.out.print('.');
		} finally {
			ATo1r8Wj.close();
		}
	}

}