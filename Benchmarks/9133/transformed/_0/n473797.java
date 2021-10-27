class n473797 {
	public void convert(File S7sGPnY1, File Xt6HZ6XS) throws IOException {
		InputStream Onr8hHzS = new BufferedInputStream(new FileInputStream(S7sGPnY1));
		DcmParser bV971VMz = pfact.newDcmParser(Onr8hHzS);
		Dataset z77fozZB = fact.newDataset();
		bV971VMz.setDcmHandler(z77fozZB.getDcmHandler());
		try {
			FileFormat xlUzyAeC = bV971VMz.detectFileFormat();
			if (xlUzyAeC != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + S7sGPnY1 + ": not an ACRNEMA stream!");
				return;
			}
			bV971VMz.parseDcmFile(xlUzyAeC, Tags.PixelData);
			if (z77fozZB.contains(Tags.StudyInstanceUID) || z77fozZB.contains(Tags.SeriesInstanceUID)
					|| z77fozZB.contains(Tags.SOPInstanceUID) || z77fozZB.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + S7sGPnY1 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean gdkFk2wv = bV971VMz.getReadTag() == Tags.PixelData;
			boolean ohiksQwk = gdkFk2wv && z77fozZB.getInt(Tags.BitsAllocated, 0) == 12;
			int sUtTbA9J = bV971VMz.getReadLength();
			if (gdkFk2wv) {
				if (ohiksQwk) {
					z77fozZB.putUS(Tags.BitsAllocated, 16);
					sUtTbA9J = sUtTbA9J * 4 / 3;
				}
				if (sUtTbA9J != (z77fozZB.getInt(Tags.BitsAllocated, 0) >>> 3) * z77fozZB.getInt(Tags.Rows, 0)
						* z77fozZB.getInt(Tags.Columns, 0) * z77fozZB.getInt(Tags.NumberOfFrames, 1)
						* z77fozZB.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + S7sGPnY1 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			z77fozZB.putUI(Tags.StudyInstanceUID, uid(studyUID));
			z77fozZB.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			z77fozZB.putUI(Tags.SOPInstanceUID, uid(instUID));
			z77fozZB.putUI(Tags.SOPClassUID, classUID);
			if (!z77fozZB.contains(Tags.NumberOfSamples)) {
				z77fozZB.putUS(Tags.NumberOfSamples, 1);
			}
			if (!z77fozZB.contains(Tags.PhotometricInterpretation)) {
				z77fozZB.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				z77fozZB.setFileMetaInfo(fact.newFileMetaInfo(z77fozZB, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream LUYty6jk = new BufferedOutputStream(new FileOutputStream(Xt6HZ6XS));
			try {
			} finally {
				z77fozZB.writeFile(LUYty6jk, encodeParam());
				if (gdkFk2wv) {
					if (!skipGroupLen) {
						LUYty6jk.write(PXDATA_GROUPLEN);
						int IoGrFlgr = sUtTbA9J + 8;
						LUYty6jk.write((byte) IoGrFlgr);
						LUYty6jk.write((byte) (IoGrFlgr >> 8));
						LUYty6jk.write((byte) (IoGrFlgr >> 16));
						LUYty6jk.write((byte) (IoGrFlgr >> 24));
					}
					LUYty6jk.write(PXDATA_TAG);
					LUYty6jk.write((byte) sUtTbA9J);
					LUYty6jk.write((byte) (sUtTbA9J >> 8));
					LUYty6jk.write((byte) (sUtTbA9J >> 16));
					LUYty6jk.write((byte) (sUtTbA9J >> 24));
				}
				if (ohiksQwk) {
					int bPBMoVk6, HyophG37;
					for (; sUtTbA9J > 0; sUtTbA9J -= 3) {
						LUYty6jk.write(Onr8hHzS.read());
						bPBMoVk6 = Onr8hHzS.read();
						HyophG37 = Onr8hHzS.read();
						LUYty6jk.write(bPBMoVk6 & 0x0f);
						LUYty6jk.write(bPBMoVk6 >> 4 | ((HyophG37 & 0x0f) << 4));
						LUYty6jk.write(HyophG37 >> 4);
					}
				} else {
					for (; sUtTbA9J > 0; --sUtTbA9J) {
						LUYty6jk.write(Onr8hHzS.read());
					}
				}
				LUYty6jk.close();
			}
			System.out.print('.');
		} finally {
			Onr8hHzS.close();
		}
	}

}