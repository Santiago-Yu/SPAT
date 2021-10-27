class n467550 {
	public void convert(File uT97MRrw, File S1MABxIz) throws IOException {
		InputStream jDI02emV = new BufferedInputStream(new FileInputStream(uT97MRrw));
		DcmParser umAkEx1X = pfact.newDcmParser(jDI02emV);
		Dataset XBmcxNxq = fact.newDataset();
		umAkEx1X.setDcmHandler(XBmcxNxq.getDcmHandler());
		try {
			FileFormat MlrA5ez0 = umAkEx1X.detectFileFormat();
			if (MlrA5ez0 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + uT97MRrw + ": not an ACRNEMA stream!");
				return;
			}
			umAkEx1X.parseDcmFile(MlrA5ez0, Tags.PixelData);
			if (XBmcxNxq.contains(Tags.StudyInstanceUID) || XBmcxNxq.contains(Tags.SeriesInstanceUID)
					|| XBmcxNxq.contains(Tags.SOPInstanceUID) || XBmcxNxq.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + uT97MRrw + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean nGFj7Uaq = umAkEx1X.getReadTag() == Tags.PixelData;
			boolean e7f4O8E3 = nGFj7Uaq && XBmcxNxq.getInt(Tags.BitsAllocated, 0) == 12;
			int xbm39f5C = umAkEx1X.getReadLength();
			if (nGFj7Uaq) {
				if (e7f4O8E3) {
					XBmcxNxq.putUS(Tags.BitsAllocated, 16);
					xbm39f5C = xbm39f5C * 4 / 3;
				}
				if (xbm39f5C != (XBmcxNxq.getInt(Tags.BitsAllocated, 0) >>> 3) * XBmcxNxq.getInt(Tags.Rows, 0)
						* XBmcxNxq.getInt(Tags.Columns, 0) * XBmcxNxq.getInt(Tags.NumberOfFrames, 1)
						* XBmcxNxq.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + uT97MRrw + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			XBmcxNxq.putUI(Tags.StudyInstanceUID, uid(studyUID));
			XBmcxNxq.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			XBmcxNxq.putUI(Tags.SOPInstanceUID, uid(instUID));
			XBmcxNxq.putUI(Tags.SOPClassUID, classUID);
			if (!XBmcxNxq.contains(Tags.NumberOfSamples)) {
				XBmcxNxq.putUS(Tags.NumberOfSamples, 1);
			}
			if (!XBmcxNxq.contains(Tags.PhotometricInterpretation)) {
				XBmcxNxq.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				XBmcxNxq.setFileMetaInfo(fact.newFileMetaInfo(XBmcxNxq, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream aKeGGn2y = new BufferedOutputStream(new FileOutputStream(S1MABxIz));
			try {
			} finally {
				XBmcxNxq.writeFile(aKeGGn2y, encodeParam());
				if (nGFj7Uaq) {
					if (!skipGroupLen) {
						aKeGGn2y.write(PXDATA_GROUPLEN);
						int SnVpHMmp = xbm39f5C + 8;
						aKeGGn2y.write((byte) SnVpHMmp);
						aKeGGn2y.write((byte) (SnVpHMmp >> 8));
						aKeGGn2y.write((byte) (SnVpHMmp >> 16));
						aKeGGn2y.write((byte) (SnVpHMmp >> 24));
					}
					aKeGGn2y.write(PXDATA_TAG);
					aKeGGn2y.write((byte) xbm39f5C);
					aKeGGn2y.write((byte) (xbm39f5C >> 8));
					aKeGGn2y.write((byte) (xbm39f5C >> 16));
					aKeGGn2y.write((byte) (xbm39f5C >> 24));
				}
				if (e7f4O8E3) {
					int m1xrTHNe, a8tqOMjT;
					for (; xbm39f5C > 0; xbm39f5C -= 3) {
						aKeGGn2y.write(jDI02emV.read());
						m1xrTHNe = jDI02emV.read();
						a8tqOMjT = jDI02emV.read();
						aKeGGn2y.write(m1xrTHNe & 0x0f);
						aKeGGn2y.write(m1xrTHNe >> 4 | ((a8tqOMjT & 0x0f) << 4));
						aKeGGn2y.write(a8tqOMjT >> 4);
					}
				} else {
					for (; xbm39f5C > 0; --xbm39f5C) {
						aKeGGn2y.write(jDI02emV.read());
					}
				}
				aKeGGn2y.close();
			}
			System.out.print('.');
		} finally {
			jDI02emV.close();
		}
	}

}