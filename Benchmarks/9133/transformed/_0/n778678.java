class n778678 {
	public void convert(File pupRKDdq, File zNd78eMr) throws IOException {
		InputStream y026Xk6c = new BufferedInputStream(new FileInputStream(pupRKDdq));
		DcmParser nbRSnAwd = pfact.newDcmParser(y026Xk6c);
		Dataset ASlqVl2q = fact.newDataset();
		nbRSnAwd.setDcmHandler(ASlqVl2q.getDcmHandler());
		try {
			FileFormat klpPAbF4 = nbRSnAwd.detectFileFormat();
			if (klpPAbF4 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + pupRKDdq + ": not an ACRNEMA stream!");
				return;
			}
			nbRSnAwd.parseDcmFile(klpPAbF4, Tags.PixelData);
			if (ASlqVl2q.contains(Tags.StudyInstanceUID) || ASlqVl2q.contains(Tags.SeriesInstanceUID)
					|| ASlqVl2q.contains(Tags.SOPInstanceUID) || ASlqVl2q.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + pupRKDdq + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean jtQTeFgt = nbRSnAwd.getReadTag() == Tags.PixelData;
			boolean UEU29YaE = jtQTeFgt && ASlqVl2q.getInt(Tags.BitsAllocated, 0) == 12;
			int zyoa8Ezr = nbRSnAwd.getReadLength();
			if (jtQTeFgt) {
				if (UEU29YaE) {
					ASlqVl2q.putUS(Tags.BitsAllocated, 16);
					zyoa8Ezr = zyoa8Ezr * 4 / 3;
				}
				if (zyoa8Ezr != (ASlqVl2q.getInt(Tags.BitsAllocated, 0) >>> 3) * ASlqVl2q.getInt(Tags.Rows, 0)
						* ASlqVl2q.getInt(Tags.Columns, 0) * ASlqVl2q.getInt(Tags.NumberOfFrames, 1)
						* ASlqVl2q.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + pupRKDdq + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			ASlqVl2q.putUI(Tags.StudyInstanceUID, uid(studyUID));
			ASlqVl2q.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			ASlqVl2q.putUI(Tags.SOPInstanceUID, uid(instUID));
			ASlqVl2q.putUI(Tags.SOPClassUID, classUID);
			if (!ASlqVl2q.contains(Tags.NumberOfSamples)) {
				ASlqVl2q.putUS(Tags.NumberOfSamples, 1);
			}
			if (!ASlqVl2q.contains(Tags.PhotometricInterpretation)) {
				ASlqVl2q.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				ASlqVl2q.setFileMetaInfo(fact.newFileMetaInfo(ASlqVl2q, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Q47cXP6U = new BufferedOutputStream(new FileOutputStream(zNd78eMr));
			try {
			} finally {
				ASlqVl2q.writeFile(Q47cXP6U, encodeParam());
				if (jtQTeFgt) {
					if (!skipGroupLen) {
						Q47cXP6U.write(PXDATA_GROUPLEN);
						int glzdxzAL = zyoa8Ezr + 8;
						Q47cXP6U.write((byte) glzdxzAL);
						Q47cXP6U.write((byte) (glzdxzAL >> 8));
						Q47cXP6U.write((byte) (glzdxzAL >> 16));
						Q47cXP6U.write((byte) (glzdxzAL >> 24));
					}
					Q47cXP6U.write(PXDATA_TAG);
					Q47cXP6U.write((byte) zyoa8Ezr);
					Q47cXP6U.write((byte) (zyoa8Ezr >> 8));
					Q47cXP6U.write((byte) (zyoa8Ezr >> 16));
					Q47cXP6U.write((byte) (zyoa8Ezr >> 24));
				}
				if (UEU29YaE) {
					int WLn9BEjp, sLhcpLY3;
					for (; zyoa8Ezr > 0; zyoa8Ezr -= 3) {
						Q47cXP6U.write(y026Xk6c.read());
						WLn9BEjp = y026Xk6c.read();
						sLhcpLY3 = y026Xk6c.read();
						Q47cXP6U.write(WLn9BEjp & 0x0f);
						Q47cXP6U.write(WLn9BEjp >> 4 | ((sLhcpLY3 & 0x0f) << 4));
						Q47cXP6U.write(sLhcpLY3 >> 4);
					}
				} else {
					for (; zyoa8Ezr > 0; --zyoa8Ezr) {
						Q47cXP6U.write(y026Xk6c.read());
					}
				}
				Q47cXP6U.close();
			}
			System.out.print('.');
		} finally {
			y026Xk6c.close();
		}
	}

}