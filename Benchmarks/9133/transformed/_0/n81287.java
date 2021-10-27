class n81287 {
	public void convert(File Eyj2nLQn, File FIWLllXA) throws IOException {
		InputStream EkTAg0O3 = new BufferedInputStream(new FileInputStream(Eyj2nLQn));
		DcmParser Sf7UXRyb = pfact.newDcmParser(EkTAg0O3);
		Dataset D7tIDYsW = fact.newDataset();
		Sf7UXRyb.setDcmHandler(D7tIDYsW.getDcmHandler());
		try {
			FileFormat fIRRgioi = Sf7UXRyb.detectFileFormat();
			if (fIRRgioi != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + Eyj2nLQn + ": not an ACRNEMA stream!");
				return;
			}
			Sf7UXRyb.parseDcmFile(fIRRgioi, Tags.PixelData);
			if (D7tIDYsW.contains(Tags.StudyInstanceUID) || D7tIDYsW.contains(Tags.SeriesInstanceUID)
					|| D7tIDYsW.contains(Tags.SOPInstanceUID) || D7tIDYsW.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + Eyj2nLQn + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Fs2m0Wmo = Sf7UXRyb.getReadTag() == Tags.PixelData;
			boolean pJ3p7DbJ = Fs2m0Wmo && D7tIDYsW.getInt(Tags.BitsAllocated, 0) == 12;
			int BM6wB0Dn = Sf7UXRyb.getReadLength();
			if (Fs2m0Wmo) {
				if (pJ3p7DbJ) {
					D7tIDYsW.putUS(Tags.BitsAllocated, 16);
					BM6wB0Dn = BM6wB0Dn * 4 / 3;
				}
				if (BM6wB0Dn != (D7tIDYsW.getInt(Tags.BitsAllocated, 0) >>> 3) * D7tIDYsW.getInt(Tags.Rows, 0)
						* D7tIDYsW.getInt(Tags.Columns, 0) * D7tIDYsW.getInt(Tags.NumberOfFrames, 1)
						* D7tIDYsW.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + Eyj2nLQn + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			D7tIDYsW.putUI(Tags.StudyInstanceUID, uid(studyUID));
			D7tIDYsW.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			D7tIDYsW.putUI(Tags.SOPInstanceUID, uid(instUID));
			D7tIDYsW.putUI(Tags.SOPClassUID, classUID);
			if (!D7tIDYsW.contains(Tags.NumberOfSamples)) {
				D7tIDYsW.putUS(Tags.NumberOfSamples, 1);
			}
			if (!D7tIDYsW.contains(Tags.PhotometricInterpretation)) {
				D7tIDYsW.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				D7tIDYsW.setFileMetaInfo(fact.newFileMetaInfo(D7tIDYsW, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream bJSHkZ9I = new BufferedOutputStream(new FileOutputStream(FIWLllXA));
			try {
			} finally {
				D7tIDYsW.writeFile(bJSHkZ9I, encodeParam());
				if (Fs2m0Wmo) {
					if (!skipGroupLen) {
						bJSHkZ9I.write(PXDATA_GROUPLEN);
						int texn1mvH = BM6wB0Dn + 8;
						bJSHkZ9I.write((byte) texn1mvH);
						bJSHkZ9I.write((byte) (texn1mvH >> 8));
						bJSHkZ9I.write((byte) (texn1mvH >> 16));
						bJSHkZ9I.write((byte) (texn1mvH >> 24));
					}
					bJSHkZ9I.write(PXDATA_TAG);
					bJSHkZ9I.write((byte) BM6wB0Dn);
					bJSHkZ9I.write((byte) (BM6wB0Dn >> 8));
					bJSHkZ9I.write((byte) (BM6wB0Dn >> 16));
					bJSHkZ9I.write((byte) (BM6wB0Dn >> 24));
				}
				if (pJ3p7DbJ) {
					int hLhjTJPj, O7oEauHR;
					for (; BM6wB0Dn > 0; BM6wB0Dn -= 3) {
						bJSHkZ9I.write(EkTAg0O3.read());
						hLhjTJPj = EkTAg0O3.read();
						O7oEauHR = EkTAg0O3.read();
						bJSHkZ9I.write(hLhjTJPj & 0x0f);
						bJSHkZ9I.write(hLhjTJPj >> 4 | ((O7oEauHR & 0x0f) << 4));
						bJSHkZ9I.write(O7oEauHR >> 4);
					}
				} else {
					for (; BM6wB0Dn > 0; --BM6wB0Dn) {
						bJSHkZ9I.write(EkTAg0O3.read());
					}
				}
				bJSHkZ9I.close();
			}
			System.out.print('.');
		} finally {
			EkTAg0O3.close();
		}
	}

}