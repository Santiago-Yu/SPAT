class n615902 {
	public void convert(File vsiWIh0E, File Krc1fjsY) throws IOException {
		InputStream Th9mHLyg = new BufferedInputStream(new FileInputStream(vsiWIh0E));
		DcmParser wSfi4Bbw = pfact.newDcmParser(Th9mHLyg);
		Dataset mIbY3t2a = fact.newDataset();
		wSfi4Bbw.setDcmHandler(mIbY3t2a.getDcmHandler());
		try {
			FileFormat Z43jcI8q = wSfi4Bbw.detectFileFormat();
			if (Z43jcI8q != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + vsiWIh0E + ": not an ACRNEMA stream!");
				return;
			}
			wSfi4Bbw.parseDcmFile(Z43jcI8q, Tags.PixelData);
			if (mIbY3t2a.contains(Tags.StudyInstanceUID) || mIbY3t2a.contains(Tags.SeriesInstanceUID)
					|| mIbY3t2a.contains(Tags.SOPInstanceUID) || mIbY3t2a.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + vsiWIh0E + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean qOtc8e9W = wSfi4Bbw.getReadTag() == Tags.PixelData;
			boolean z6HMo0LP = qOtc8e9W && mIbY3t2a.getInt(Tags.BitsAllocated, 0) == 12;
			int f4UXOTJJ = wSfi4Bbw.getReadLength();
			if (qOtc8e9W) {
				if (z6HMo0LP) {
					mIbY3t2a.putUS(Tags.BitsAllocated, 16);
					f4UXOTJJ = f4UXOTJJ * 4 / 3;
				}
				if (f4UXOTJJ != (mIbY3t2a.getInt(Tags.BitsAllocated, 0) >>> 3) * mIbY3t2a.getInt(Tags.Rows, 0)
						* mIbY3t2a.getInt(Tags.Columns, 0) * mIbY3t2a.getInt(Tags.NumberOfFrames, 1)
						* mIbY3t2a.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + vsiWIh0E + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			mIbY3t2a.putUI(Tags.StudyInstanceUID, uid(studyUID));
			mIbY3t2a.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			mIbY3t2a.putUI(Tags.SOPInstanceUID, uid(instUID));
			mIbY3t2a.putUI(Tags.SOPClassUID, classUID);
			if (!mIbY3t2a.contains(Tags.NumberOfSamples)) {
				mIbY3t2a.putUS(Tags.NumberOfSamples, 1);
			}
			if (!mIbY3t2a.contains(Tags.PhotometricInterpretation)) {
				mIbY3t2a.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				mIbY3t2a.setFileMetaInfo(fact.newFileMetaInfo(mIbY3t2a, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream KVhkYCAk = new BufferedOutputStream(new FileOutputStream(Krc1fjsY));
			try {
			} finally {
				mIbY3t2a.writeFile(KVhkYCAk, encodeParam());
				if (qOtc8e9W) {
					if (!skipGroupLen) {
						KVhkYCAk.write(PXDATA_GROUPLEN);
						int Bu1fTbi2 = f4UXOTJJ + 8;
						KVhkYCAk.write((byte) Bu1fTbi2);
						KVhkYCAk.write((byte) (Bu1fTbi2 >> 8));
						KVhkYCAk.write((byte) (Bu1fTbi2 >> 16));
						KVhkYCAk.write((byte) (Bu1fTbi2 >> 24));
					}
					KVhkYCAk.write(PXDATA_TAG);
					KVhkYCAk.write((byte) f4UXOTJJ);
					KVhkYCAk.write((byte) (f4UXOTJJ >> 8));
					KVhkYCAk.write((byte) (f4UXOTJJ >> 16));
					KVhkYCAk.write((byte) (f4UXOTJJ >> 24));
				}
				if (z6HMo0LP) {
					int F3YlfI9N, r4ITyNs5;
					for (; f4UXOTJJ > 0; f4UXOTJJ -= 3) {
						KVhkYCAk.write(Th9mHLyg.read());
						F3YlfI9N = Th9mHLyg.read();
						r4ITyNs5 = Th9mHLyg.read();
						KVhkYCAk.write(F3YlfI9N & 0x0f);
						KVhkYCAk.write(F3YlfI9N >> 4 | ((r4ITyNs5 & 0x0f) << 4));
						KVhkYCAk.write(r4ITyNs5 >> 4);
					}
				} else {
					for (; f4UXOTJJ > 0; --f4UXOTJJ) {
						KVhkYCAk.write(Th9mHLyg.read());
					}
				}
				KVhkYCAk.close();
			}
			System.out.print('.');
		} finally {
			Th9mHLyg.close();
		}
	}

}