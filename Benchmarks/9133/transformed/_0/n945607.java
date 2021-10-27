class n945607 {
	public void convert(File DPdcFVYA, File OfaOeAI5) throws IOException {
		InputStream IgbFcXfS = new BufferedInputStream(new FileInputStream(DPdcFVYA));
		DcmParser J19mYQIG = pfact.newDcmParser(IgbFcXfS);
		Dataset eJQnucbW = fact.newDataset();
		J19mYQIG.setDcmHandler(eJQnucbW.getDcmHandler());
		try {
			FileFormat acfDk81D = J19mYQIG.detectFileFormat();
			if (acfDk81D != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + DPdcFVYA + ": not an ACRNEMA stream!");
				return;
			}
			J19mYQIG.parseDcmFile(acfDk81D, Tags.PixelData);
			if (eJQnucbW.contains(Tags.StudyInstanceUID) || eJQnucbW.contains(Tags.SeriesInstanceUID)
					|| eJQnucbW.contains(Tags.SOPInstanceUID) || eJQnucbW.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + DPdcFVYA + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean A6rVdIPW = J19mYQIG.getReadTag() == Tags.PixelData;
			boolean JcRT6Hke = A6rVdIPW && eJQnucbW.getInt(Tags.BitsAllocated, 0) == 12;
			int Ezmeb7vU = J19mYQIG.getReadLength();
			if (A6rVdIPW) {
				if (JcRT6Hke) {
					eJQnucbW.putUS(Tags.BitsAllocated, 16);
					Ezmeb7vU = Ezmeb7vU * 4 / 3;
				}
				if (Ezmeb7vU != (eJQnucbW.getInt(Tags.BitsAllocated, 0) >>> 3) * eJQnucbW.getInt(Tags.Rows, 0)
						* eJQnucbW.getInt(Tags.Columns, 0) * eJQnucbW.getInt(Tags.NumberOfFrames, 1)
						* eJQnucbW.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + DPdcFVYA + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			eJQnucbW.putUI(Tags.StudyInstanceUID, uid(studyUID));
			eJQnucbW.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			eJQnucbW.putUI(Tags.SOPInstanceUID, uid(instUID));
			eJQnucbW.putUI(Tags.SOPClassUID, classUID);
			if (!eJQnucbW.contains(Tags.NumberOfSamples)) {
				eJQnucbW.putUS(Tags.NumberOfSamples, 1);
			}
			if (!eJQnucbW.contains(Tags.PhotometricInterpretation)) {
				eJQnucbW.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				eJQnucbW.setFileMetaInfo(fact.newFileMetaInfo(eJQnucbW, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream ldh5iujB = new BufferedOutputStream(new FileOutputStream(OfaOeAI5));
			try {
			} finally {
				eJQnucbW.writeFile(ldh5iujB, encodeParam());
				if (A6rVdIPW) {
					if (!skipGroupLen) {
						ldh5iujB.write(PXDATA_GROUPLEN);
						int tsl2Gth9 = Ezmeb7vU + 8;
						ldh5iujB.write((byte) tsl2Gth9);
						ldh5iujB.write((byte) (tsl2Gth9 >> 8));
						ldh5iujB.write((byte) (tsl2Gth9 >> 16));
						ldh5iujB.write((byte) (tsl2Gth9 >> 24));
					}
					ldh5iujB.write(PXDATA_TAG);
					ldh5iujB.write((byte) Ezmeb7vU);
					ldh5iujB.write((byte) (Ezmeb7vU >> 8));
					ldh5iujB.write((byte) (Ezmeb7vU >> 16));
					ldh5iujB.write((byte) (Ezmeb7vU >> 24));
				}
				if (JcRT6Hke) {
					int rCTLTbUF, QWwPgAzw;
					for (; Ezmeb7vU > 0; Ezmeb7vU -= 3) {
						ldh5iujB.write(IgbFcXfS.read());
						rCTLTbUF = IgbFcXfS.read();
						QWwPgAzw = IgbFcXfS.read();
						ldh5iujB.write(rCTLTbUF & 0x0f);
						ldh5iujB.write(rCTLTbUF >> 4 | ((QWwPgAzw & 0x0f) << 4));
						ldh5iujB.write(QWwPgAzw >> 4);
					}
				} else {
					for (; Ezmeb7vU > 0; --Ezmeb7vU) {
						ldh5iujB.write(IgbFcXfS.read());
					}
				}
				ldh5iujB.close();
			}
			System.out.print('.');
		} finally {
			IgbFcXfS.close();
		}
	}

}