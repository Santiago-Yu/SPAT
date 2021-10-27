class n253661 {
	public void convert(File kgevZPWZ, File Fe2lg4rL) throws IOException {
		InputStream dm5D68I5 = new BufferedInputStream(new FileInputStream(kgevZPWZ));
		DcmParser dqRZAk2C = pfact.newDcmParser(dm5D68I5);
		Dataset kQHWtgR8 = fact.newDataset();
		dqRZAk2C.setDcmHandler(kQHWtgR8.getDcmHandler());
		try {
			FileFormat qf13LVUC = dqRZAk2C.detectFileFormat();
			if (qf13LVUC != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + kgevZPWZ + ": not an ACRNEMA stream!");
				return;
			}
			dqRZAk2C.parseDcmFile(qf13LVUC, Tags.PixelData);
			if (kQHWtgR8.contains(Tags.StudyInstanceUID) || kQHWtgR8.contains(Tags.SeriesInstanceUID)
					|| kQHWtgR8.contains(Tags.SOPInstanceUID) || kQHWtgR8.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + kgevZPWZ + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean uef3lMpT = dqRZAk2C.getReadTag() == Tags.PixelData;
			boolean pJPVUBhD = uef3lMpT && kQHWtgR8.getInt(Tags.BitsAllocated, 0) == 12;
			int mTIMiv0n = dqRZAk2C.getReadLength();
			if (uef3lMpT) {
				if (pJPVUBhD) {
					kQHWtgR8.putUS(Tags.BitsAllocated, 16);
					mTIMiv0n = mTIMiv0n * 4 / 3;
				}
				if (mTIMiv0n != (kQHWtgR8.getInt(Tags.BitsAllocated, 0) >>> 3) * kQHWtgR8.getInt(Tags.Rows, 0)
						* kQHWtgR8.getInt(Tags.Columns, 0) * kQHWtgR8.getInt(Tags.NumberOfFrames, 1)
						* kQHWtgR8.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + kgevZPWZ + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			kQHWtgR8.putUI(Tags.StudyInstanceUID, uid(studyUID));
			kQHWtgR8.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			kQHWtgR8.putUI(Tags.SOPInstanceUID, uid(instUID));
			kQHWtgR8.putUI(Tags.SOPClassUID, classUID);
			if (!kQHWtgR8.contains(Tags.NumberOfSamples)) {
				kQHWtgR8.putUS(Tags.NumberOfSamples, 1);
			}
			if (!kQHWtgR8.contains(Tags.PhotometricInterpretation)) {
				kQHWtgR8.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				kQHWtgR8.setFileMetaInfo(fact.newFileMetaInfo(kQHWtgR8, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream RRQXWQyR = new BufferedOutputStream(new FileOutputStream(Fe2lg4rL));
			try {
			} finally {
				kQHWtgR8.writeFile(RRQXWQyR, encodeParam());
				if (uef3lMpT) {
					if (!skipGroupLen) {
						RRQXWQyR.write(PXDATA_GROUPLEN);
						int eGEAzr8K = mTIMiv0n + 8;
						RRQXWQyR.write((byte) eGEAzr8K);
						RRQXWQyR.write((byte) (eGEAzr8K >> 8));
						RRQXWQyR.write((byte) (eGEAzr8K >> 16));
						RRQXWQyR.write((byte) (eGEAzr8K >> 24));
					}
					RRQXWQyR.write(PXDATA_TAG);
					RRQXWQyR.write((byte) mTIMiv0n);
					RRQXWQyR.write((byte) (mTIMiv0n >> 8));
					RRQXWQyR.write((byte) (mTIMiv0n >> 16));
					RRQXWQyR.write((byte) (mTIMiv0n >> 24));
				}
				if (pJPVUBhD) {
					int dhFooGX8, JZsuxqeI;
					for (; mTIMiv0n > 0; mTIMiv0n -= 3) {
						RRQXWQyR.write(dm5D68I5.read());
						dhFooGX8 = dm5D68I5.read();
						JZsuxqeI = dm5D68I5.read();
						RRQXWQyR.write(dhFooGX8 & 0x0f);
						RRQXWQyR.write(dhFooGX8 >> 4 | ((JZsuxqeI & 0x0f) << 4));
						RRQXWQyR.write(JZsuxqeI >> 4);
					}
				} else {
					for (; mTIMiv0n > 0; --mTIMiv0n) {
						RRQXWQyR.write(dm5D68I5.read());
					}
				}
				RRQXWQyR.close();
			}
			System.out.print('.');
		} finally {
			dm5D68I5.close();
		}
	}

}