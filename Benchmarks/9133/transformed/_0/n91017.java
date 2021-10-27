class n91017 {
	public void convert(File e5oZHVPu, File tcIwwow9) throws IOException {
		InputStream jNwrEVUQ = new BufferedInputStream(new FileInputStream(e5oZHVPu));
		DcmParser gCiksJQ0 = pfact.newDcmParser(jNwrEVUQ);
		Dataset H76nX6K7 = fact.newDataset();
		gCiksJQ0.setDcmHandler(H76nX6K7.getDcmHandler());
		try {
			FileFormat FHk0mGBo = gCiksJQ0.detectFileFormat();
			if (FHk0mGBo != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + e5oZHVPu + ": not an ACRNEMA stream!");
				return;
			}
			gCiksJQ0.parseDcmFile(FHk0mGBo, Tags.PixelData);
			if (H76nX6K7.contains(Tags.StudyInstanceUID) || H76nX6K7.contains(Tags.SeriesInstanceUID)
					|| H76nX6K7.contains(Tags.SOPInstanceUID) || H76nX6K7.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + e5oZHVPu + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean bvwWz4dh = gCiksJQ0.getReadTag() == Tags.PixelData;
			boolean wJgykx5F = bvwWz4dh && H76nX6K7.getInt(Tags.BitsAllocated, 0) == 12;
			int UwKXzc7L = gCiksJQ0.getReadLength();
			if (bvwWz4dh) {
				if (wJgykx5F) {
					H76nX6K7.putUS(Tags.BitsAllocated, 16);
					UwKXzc7L = UwKXzc7L * 4 / 3;
				}
				if (UwKXzc7L != (H76nX6K7.getInt(Tags.BitsAllocated, 0) >>> 3) * H76nX6K7.getInt(Tags.Rows, 0)
						* H76nX6K7.getInt(Tags.Columns, 0) * H76nX6K7.getInt(Tags.NumberOfFrames, 1)
						* H76nX6K7.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + e5oZHVPu + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			H76nX6K7.putUI(Tags.StudyInstanceUID, uid(studyUID));
			H76nX6K7.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			H76nX6K7.putUI(Tags.SOPInstanceUID, uid(instUID));
			H76nX6K7.putUI(Tags.SOPClassUID, classUID);
			if (!H76nX6K7.contains(Tags.NumberOfSamples)) {
				H76nX6K7.putUS(Tags.NumberOfSamples, 1);
			}
			if (!H76nX6K7.contains(Tags.PhotometricInterpretation)) {
				H76nX6K7.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				H76nX6K7.setFileMetaInfo(fact.newFileMetaInfo(H76nX6K7, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream fLnIage1 = new BufferedOutputStream(new FileOutputStream(tcIwwow9));
			try {
			} finally {
				H76nX6K7.writeFile(fLnIage1, encodeParam());
				if (bvwWz4dh) {
					if (!skipGroupLen) {
						fLnIage1.write(PXDATA_GROUPLEN);
						int HnOYF6h3 = UwKXzc7L + 8;
						fLnIage1.write((byte) HnOYF6h3);
						fLnIage1.write((byte) (HnOYF6h3 >> 8));
						fLnIage1.write((byte) (HnOYF6h3 >> 16));
						fLnIage1.write((byte) (HnOYF6h3 >> 24));
					}
					fLnIage1.write(PXDATA_TAG);
					fLnIage1.write((byte) UwKXzc7L);
					fLnIage1.write((byte) (UwKXzc7L >> 8));
					fLnIage1.write((byte) (UwKXzc7L >> 16));
					fLnIage1.write((byte) (UwKXzc7L >> 24));
				}
				if (wJgykx5F) {
					int vwvb2ctI, lDp3kQFE;
					for (; UwKXzc7L > 0; UwKXzc7L -= 3) {
						fLnIage1.write(jNwrEVUQ.read());
						vwvb2ctI = jNwrEVUQ.read();
						lDp3kQFE = jNwrEVUQ.read();
						fLnIage1.write(vwvb2ctI & 0x0f);
						fLnIage1.write(vwvb2ctI >> 4 | ((lDp3kQFE & 0x0f) << 4));
						fLnIage1.write(lDp3kQFE >> 4);
					}
				} else {
					for (; UwKXzc7L > 0; --UwKXzc7L) {
						fLnIage1.write(jNwrEVUQ.read());
					}
				}
				fLnIage1.close();
			}
			System.out.print('.');
		} finally {
			jNwrEVUQ.close();
		}
	}

}