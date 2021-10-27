class n860848 {
	public void convert(File blKABFJE, File TAi57Q3P) throws IOException {
		InputStream LhlSa518 = new BufferedInputStream(new FileInputStream(blKABFJE));
		DcmParser E5R7GKHn = pfact.newDcmParser(LhlSa518);
		Dataset iF8dEhfY = fact.newDataset();
		E5R7GKHn.setDcmHandler(iF8dEhfY.getDcmHandler());
		try {
			FileFormat Cjq5dIov = E5R7GKHn.detectFileFormat();
			if (Cjq5dIov != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + blKABFJE + ": not an ACRNEMA stream!");
				return;
			}
			E5R7GKHn.parseDcmFile(Cjq5dIov, Tags.PixelData);
			if (iF8dEhfY.contains(Tags.StudyInstanceUID) || iF8dEhfY.contains(Tags.SeriesInstanceUID)
					|| iF8dEhfY.contains(Tags.SOPInstanceUID) || iF8dEhfY.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + blKABFJE + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean bqYZ5b99 = E5R7GKHn.getReadTag() == Tags.PixelData;
			boolean gvW8HQSq = bqYZ5b99 && iF8dEhfY.getInt(Tags.BitsAllocated, 0) == 12;
			int YULuacIm = E5R7GKHn.getReadLength();
			if (bqYZ5b99) {
				if (gvW8HQSq) {
					iF8dEhfY.putUS(Tags.BitsAllocated, 16);
					YULuacIm = YULuacIm * 4 / 3;
				}
				if (YULuacIm != (iF8dEhfY.getInt(Tags.BitsAllocated, 0) >>> 3) * iF8dEhfY.getInt(Tags.Rows, 0)
						* iF8dEhfY.getInt(Tags.Columns, 0) * iF8dEhfY.getInt(Tags.NumberOfFrames, 1)
						* iF8dEhfY.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + blKABFJE + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			iF8dEhfY.putUI(Tags.StudyInstanceUID, uid(studyUID));
			iF8dEhfY.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			iF8dEhfY.putUI(Tags.SOPInstanceUID, uid(instUID));
			iF8dEhfY.putUI(Tags.SOPClassUID, classUID);
			if (!iF8dEhfY.contains(Tags.NumberOfSamples)) {
				iF8dEhfY.putUS(Tags.NumberOfSamples, 1);
			}
			if (!iF8dEhfY.contains(Tags.PhotometricInterpretation)) {
				iF8dEhfY.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				iF8dEhfY.setFileMetaInfo(fact.newFileMetaInfo(iF8dEhfY, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream doe5WICO = new BufferedOutputStream(new FileOutputStream(TAi57Q3P));
			try {
			} finally {
				iF8dEhfY.writeFile(doe5WICO, encodeParam());
				if (bqYZ5b99) {
					if (!skipGroupLen) {
						doe5WICO.write(PXDATA_GROUPLEN);
						int ea3eJIXw = YULuacIm + 8;
						doe5WICO.write((byte) ea3eJIXw);
						doe5WICO.write((byte) (ea3eJIXw >> 8));
						doe5WICO.write((byte) (ea3eJIXw >> 16));
						doe5WICO.write((byte) (ea3eJIXw >> 24));
					}
					doe5WICO.write(PXDATA_TAG);
					doe5WICO.write((byte) YULuacIm);
					doe5WICO.write((byte) (YULuacIm >> 8));
					doe5WICO.write((byte) (YULuacIm >> 16));
					doe5WICO.write((byte) (YULuacIm >> 24));
				}
				if (gvW8HQSq) {
					int xWkC98yZ, MozshgOO;
					for (; YULuacIm > 0; YULuacIm -= 3) {
						doe5WICO.write(LhlSa518.read());
						xWkC98yZ = LhlSa518.read();
						MozshgOO = LhlSa518.read();
						doe5WICO.write(xWkC98yZ & 0x0f);
						doe5WICO.write(xWkC98yZ >> 4 | ((MozshgOO & 0x0f) << 4));
						doe5WICO.write(MozshgOO >> 4);
					}
				} else {
					for (; YULuacIm > 0; --YULuacIm) {
						doe5WICO.write(LhlSa518.read());
					}
				}
				doe5WICO.close();
			}
			System.out.print('.');
		} finally {
			LhlSa518.close();
		}
	}

}