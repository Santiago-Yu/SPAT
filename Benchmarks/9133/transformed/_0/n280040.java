class n280040 {
	public void convert(File d2loAcaZ, File pSwpHNVT) throws IOException {
		InputStream WmiqgfGC = new BufferedInputStream(new FileInputStream(d2loAcaZ));
		DcmParser SgI0rmMU = pfact.newDcmParser(WmiqgfGC);
		Dataset xT0oY67N = fact.newDataset();
		SgI0rmMU.setDcmHandler(xT0oY67N.getDcmHandler());
		try {
			FileFormat cy5As631 = SgI0rmMU.detectFileFormat();
			if (cy5As631 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + d2loAcaZ + ": not an ACRNEMA stream!");
				return;
			}
			SgI0rmMU.parseDcmFile(cy5As631, Tags.PixelData);
			if (xT0oY67N.contains(Tags.StudyInstanceUID) || xT0oY67N.contains(Tags.SeriesInstanceUID)
					|| xT0oY67N.contains(Tags.SOPInstanceUID) || xT0oY67N.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + d2loAcaZ + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean K5vWjPKN = SgI0rmMU.getReadTag() == Tags.PixelData;
			boolean s2fsdJ57 = K5vWjPKN && xT0oY67N.getInt(Tags.BitsAllocated, 0) == 12;
			int jiglkkf6 = SgI0rmMU.getReadLength();
			if (K5vWjPKN) {
				if (s2fsdJ57) {
					xT0oY67N.putUS(Tags.BitsAllocated, 16);
					jiglkkf6 = jiglkkf6 * 4 / 3;
				}
				if (jiglkkf6 != (xT0oY67N.getInt(Tags.BitsAllocated, 0) >>> 3) * xT0oY67N.getInt(Tags.Rows, 0)
						* xT0oY67N.getInt(Tags.Columns, 0) * xT0oY67N.getInt(Tags.NumberOfFrames, 1)
						* xT0oY67N.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + d2loAcaZ + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			xT0oY67N.putUI(Tags.StudyInstanceUID, uid(studyUID));
			xT0oY67N.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			xT0oY67N.putUI(Tags.SOPInstanceUID, uid(instUID));
			xT0oY67N.putUI(Tags.SOPClassUID, classUID);
			if (!xT0oY67N.contains(Tags.NumberOfSamples)) {
				xT0oY67N.putUS(Tags.NumberOfSamples, 1);
			}
			if (!xT0oY67N.contains(Tags.PhotometricInterpretation)) {
				xT0oY67N.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				xT0oY67N.setFileMetaInfo(fact.newFileMetaInfo(xT0oY67N, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream YZYRtiZE = new BufferedOutputStream(new FileOutputStream(pSwpHNVT));
			try {
			} finally {
				xT0oY67N.writeFile(YZYRtiZE, encodeParam());
				if (K5vWjPKN) {
					if (!skipGroupLen) {
						YZYRtiZE.write(PXDATA_GROUPLEN);
						int BuvsVsrr = jiglkkf6 + 8;
						YZYRtiZE.write((byte) BuvsVsrr);
						YZYRtiZE.write((byte) (BuvsVsrr >> 8));
						YZYRtiZE.write((byte) (BuvsVsrr >> 16));
						YZYRtiZE.write((byte) (BuvsVsrr >> 24));
					}
					YZYRtiZE.write(PXDATA_TAG);
					YZYRtiZE.write((byte) jiglkkf6);
					YZYRtiZE.write((byte) (jiglkkf6 >> 8));
					YZYRtiZE.write((byte) (jiglkkf6 >> 16));
					YZYRtiZE.write((byte) (jiglkkf6 >> 24));
				}
				if (s2fsdJ57) {
					int TuXFAzHo, Y9t8K2Xy;
					for (; jiglkkf6 > 0; jiglkkf6 -= 3) {
						YZYRtiZE.write(WmiqgfGC.read());
						TuXFAzHo = WmiqgfGC.read();
						Y9t8K2Xy = WmiqgfGC.read();
						YZYRtiZE.write(TuXFAzHo & 0x0f);
						YZYRtiZE.write(TuXFAzHo >> 4 | ((Y9t8K2Xy & 0x0f) << 4));
						YZYRtiZE.write(Y9t8K2Xy >> 4);
					}
				} else {
					for (; jiglkkf6 > 0; --jiglkkf6) {
						YZYRtiZE.write(WmiqgfGC.read());
					}
				}
				YZYRtiZE.close();
			}
			System.out.print('.');
		} finally {
			WmiqgfGC.close();
		}
	}

}