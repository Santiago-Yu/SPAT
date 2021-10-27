class n778641 {
	public void convert(File CSj8Gr0w, File n7nv5mrc) throws IOException {
		InputStream R4Sa1uNn = new BufferedInputStream(new FileInputStream(CSj8Gr0w));
		DcmParser mt9Hrwb2 = pfact.newDcmParser(R4Sa1uNn);
		Dataset MNjQEfdQ = fact.newDataset();
		mt9Hrwb2.setDcmHandler(MNjQEfdQ.getDcmHandler());
		try {
			FileFormat jfODEROe = mt9Hrwb2.detectFileFormat();
			if (jfODEROe != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + CSj8Gr0w + ": not an ACRNEMA stream!");
				return;
			}
			mt9Hrwb2.parseDcmFile(jfODEROe, Tags.PixelData);
			if (MNjQEfdQ.contains(Tags.StudyInstanceUID) || MNjQEfdQ.contains(Tags.SeriesInstanceUID)
					|| MNjQEfdQ.contains(Tags.SOPInstanceUID) || MNjQEfdQ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + CSj8Gr0w + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean pdJtM0Bl = mt9Hrwb2.getReadTag() == Tags.PixelData;
			boolean r9TJIBIp = pdJtM0Bl && MNjQEfdQ.getInt(Tags.BitsAllocated, 0) == 12;
			int TWCotbuP = mt9Hrwb2.getReadLength();
			if (pdJtM0Bl) {
				if (r9TJIBIp) {
					MNjQEfdQ.putUS(Tags.BitsAllocated, 16);
					TWCotbuP = TWCotbuP * 4 / 3;
				}
				if (TWCotbuP != (MNjQEfdQ.getInt(Tags.BitsAllocated, 0) >>> 3) * MNjQEfdQ.getInt(Tags.Rows, 0)
						* MNjQEfdQ.getInt(Tags.Columns, 0) * MNjQEfdQ.getInt(Tags.NumberOfFrames, 1)
						* MNjQEfdQ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + CSj8Gr0w + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			MNjQEfdQ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			MNjQEfdQ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			MNjQEfdQ.putUI(Tags.SOPInstanceUID, uid(instUID));
			MNjQEfdQ.putUI(Tags.SOPClassUID, classUID);
			if (!MNjQEfdQ.contains(Tags.NumberOfSamples)) {
				MNjQEfdQ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!MNjQEfdQ.contains(Tags.PhotometricInterpretation)) {
				MNjQEfdQ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				MNjQEfdQ.setFileMetaInfo(fact.newFileMetaInfo(MNjQEfdQ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream pzUMrsKZ = new BufferedOutputStream(new FileOutputStream(n7nv5mrc));
			try {
			} finally {
				MNjQEfdQ.writeFile(pzUMrsKZ, encodeParam());
				if (pdJtM0Bl) {
					if (!skipGroupLen) {
						pzUMrsKZ.write(PXDATA_GROUPLEN);
						int W26oAGwf = TWCotbuP + 8;
						pzUMrsKZ.write((byte) W26oAGwf);
						pzUMrsKZ.write((byte) (W26oAGwf >> 8));
						pzUMrsKZ.write((byte) (W26oAGwf >> 16));
						pzUMrsKZ.write((byte) (W26oAGwf >> 24));
					}
					pzUMrsKZ.write(PXDATA_TAG);
					pzUMrsKZ.write((byte) TWCotbuP);
					pzUMrsKZ.write((byte) (TWCotbuP >> 8));
					pzUMrsKZ.write((byte) (TWCotbuP >> 16));
					pzUMrsKZ.write((byte) (TWCotbuP >> 24));
				}
				if (r9TJIBIp) {
					int Y5fOTSuq, qWrXppMB;
					for (; TWCotbuP > 0; TWCotbuP -= 3) {
						pzUMrsKZ.write(R4Sa1uNn.read());
						Y5fOTSuq = R4Sa1uNn.read();
						qWrXppMB = R4Sa1uNn.read();
						pzUMrsKZ.write(Y5fOTSuq & 0x0f);
						pzUMrsKZ.write(Y5fOTSuq >> 4 | ((qWrXppMB & 0x0f) << 4));
						pzUMrsKZ.write(qWrXppMB >> 4);
					}
				} else {
					for (; TWCotbuP > 0; --TWCotbuP) {
						pzUMrsKZ.write(R4Sa1uNn.read());
					}
				}
				pzUMrsKZ.close();
			}
			System.out.print('.');
		} finally {
			R4Sa1uNn.close();
		}
	}

}