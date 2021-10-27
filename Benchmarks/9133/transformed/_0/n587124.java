class n587124 {
	public void convert(File LWdIbFss, File W5CTlKGv) throws IOException {
		InputStream pr7g33OW = new BufferedInputStream(new FileInputStream(LWdIbFss));
		DcmParser ebtSjQWD = pfact.newDcmParser(pr7g33OW);
		Dataset xLKbDwPB = fact.newDataset();
		ebtSjQWD.setDcmHandler(xLKbDwPB.getDcmHandler());
		try {
			FileFormat rf3PXgT2 = ebtSjQWD.detectFileFormat();
			if (rf3PXgT2 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + LWdIbFss + ": not an ACRNEMA stream!");
				return;
			}
			ebtSjQWD.parseDcmFile(rf3PXgT2, Tags.PixelData);
			if (xLKbDwPB.contains(Tags.StudyInstanceUID) || xLKbDwPB.contains(Tags.SeriesInstanceUID)
					|| xLKbDwPB.contains(Tags.SOPInstanceUID) || xLKbDwPB.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + LWdIbFss + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean s9YddxRD = ebtSjQWD.getReadTag() == Tags.PixelData;
			boolean TXNwSeNc = s9YddxRD && xLKbDwPB.getInt(Tags.BitsAllocated, 0) == 12;
			int HH8YMzy4 = ebtSjQWD.getReadLength();
			if (s9YddxRD) {
				if (TXNwSeNc) {
					xLKbDwPB.putUS(Tags.BitsAllocated, 16);
					HH8YMzy4 = HH8YMzy4 * 4 / 3;
				}
				if (HH8YMzy4 != (xLKbDwPB.getInt(Tags.BitsAllocated, 0) >>> 3) * xLKbDwPB.getInt(Tags.Rows, 0)
						* xLKbDwPB.getInt(Tags.Columns, 0) * xLKbDwPB.getInt(Tags.NumberOfFrames, 1)
						* xLKbDwPB.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + LWdIbFss + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			xLKbDwPB.putUI(Tags.StudyInstanceUID, uid(studyUID));
			xLKbDwPB.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			xLKbDwPB.putUI(Tags.SOPInstanceUID, uid(instUID));
			xLKbDwPB.putUI(Tags.SOPClassUID, classUID);
			if (!xLKbDwPB.contains(Tags.NumberOfSamples)) {
				xLKbDwPB.putUS(Tags.NumberOfSamples, 1);
			}
			if (!xLKbDwPB.contains(Tags.PhotometricInterpretation)) {
				xLKbDwPB.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				xLKbDwPB.setFileMetaInfo(fact.newFileMetaInfo(xLKbDwPB, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream FpLWsjRs = new BufferedOutputStream(new FileOutputStream(W5CTlKGv));
			try {
			} finally {
				xLKbDwPB.writeFile(FpLWsjRs, encodeParam());
				if (s9YddxRD) {
					if (!skipGroupLen) {
						FpLWsjRs.write(PXDATA_GROUPLEN);
						int QGQ0UdPZ = HH8YMzy4 + 8;
						FpLWsjRs.write((byte) QGQ0UdPZ);
						FpLWsjRs.write((byte) (QGQ0UdPZ >> 8));
						FpLWsjRs.write((byte) (QGQ0UdPZ >> 16));
						FpLWsjRs.write((byte) (QGQ0UdPZ >> 24));
					}
					FpLWsjRs.write(PXDATA_TAG);
					FpLWsjRs.write((byte) HH8YMzy4);
					FpLWsjRs.write((byte) (HH8YMzy4 >> 8));
					FpLWsjRs.write((byte) (HH8YMzy4 >> 16));
					FpLWsjRs.write((byte) (HH8YMzy4 >> 24));
				}
				if (TXNwSeNc) {
					int uLDctrY6, o8basj6B;
					for (; HH8YMzy4 > 0; HH8YMzy4 -= 3) {
						FpLWsjRs.write(pr7g33OW.read());
						uLDctrY6 = pr7g33OW.read();
						o8basj6B = pr7g33OW.read();
						FpLWsjRs.write(uLDctrY6 & 0x0f);
						FpLWsjRs.write(uLDctrY6 >> 4 | ((o8basj6B & 0x0f) << 4));
						FpLWsjRs.write(o8basj6B >> 4);
					}
				} else {
					for (; HH8YMzy4 > 0; --HH8YMzy4) {
						FpLWsjRs.write(pr7g33OW.read());
					}
				}
				FpLWsjRs.close();
			}
			System.out.print('.');
		} finally {
			pr7g33OW.close();
		}
	}

}