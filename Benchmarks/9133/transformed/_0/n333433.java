class n333433 {
	public void convert(File EDM4dewp, File bbsX3Ewi) throws IOException {
		InputStream oH3WOW6R = new BufferedInputStream(new FileInputStream(EDM4dewp));
		DcmParser yJxgqkQC = pfact.newDcmParser(oH3WOW6R);
		Dataset w32NvDTY = fact.newDataset();
		yJxgqkQC.setDcmHandler(w32NvDTY.getDcmHandler());
		try {
			FileFormat HrLsTR0A = yJxgqkQC.detectFileFormat();
			if (HrLsTR0A != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + EDM4dewp + ": not an ACRNEMA stream!");
				return;
			}
			yJxgqkQC.parseDcmFile(HrLsTR0A, Tags.PixelData);
			if (w32NvDTY.contains(Tags.StudyInstanceUID) || w32NvDTY.contains(Tags.SeriesInstanceUID)
					|| w32NvDTY.contains(Tags.SOPInstanceUID) || w32NvDTY.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + EDM4dewp + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean d8EjVc5F = yJxgqkQC.getReadTag() == Tags.PixelData;
			boolean Jz9oIGka = d8EjVc5F && w32NvDTY.getInt(Tags.BitsAllocated, 0) == 12;
			int Jz4QWKdf = yJxgqkQC.getReadLength();
			if (d8EjVc5F) {
				if (Jz9oIGka) {
					w32NvDTY.putUS(Tags.BitsAllocated, 16);
					Jz4QWKdf = Jz4QWKdf * 4 / 3;
				}
				if (Jz4QWKdf != (w32NvDTY.getInt(Tags.BitsAllocated, 0) >>> 3) * w32NvDTY.getInt(Tags.Rows, 0)
						* w32NvDTY.getInt(Tags.Columns, 0) * w32NvDTY.getInt(Tags.NumberOfFrames, 1)
						* w32NvDTY.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + EDM4dewp + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			w32NvDTY.putUI(Tags.StudyInstanceUID, uid(studyUID));
			w32NvDTY.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			w32NvDTY.putUI(Tags.SOPInstanceUID, uid(instUID));
			w32NvDTY.putUI(Tags.SOPClassUID, classUID);
			if (!w32NvDTY.contains(Tags.NumberOfSamples)) {
				w32NvDTY.putUS(Tags.NumberOfSamples, 1);
			}
			if (!w32NvDTY.contains(Tags.PhotometricInterpretation)) {
				w32NvDTY.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				w32NvDTY.setFileMetaInfo(fact.newFileMetaInfo(w32NvDTY, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream nkRiMJNK = new BufferedOutputStream(new FileOutputStream(bbsX3Ewi));
			try {
			} finally {
				w32NvDTY.writeFile(nkRiMJNK, encodeParam());
				if (d8EjVc5F) {
					if (!skipGroupLen) {
						nkRiMJNK.write(PXDATA_GROUPLEN);
						int Lvi3dAXX = Jz4QWKdf + 8;
						nkRiMJNK.write((byte) Lvi3dAXX);
						nkRiMJNK.write((byte) (Lvi3dAXX >> 8));
						nkRiMJNK.write((byte) (Lvi3dAXX >> 16));
						nkRiMJNK.write((byte) (Lvi3dAXX >> 24));
					}
					nkRiMJNK.write(PXDATA_TAG);
					nkRiMJNK.write((byte) Jz4QWKdf);
					nkRiMJNK.write((byte) (Jz4QWKdf >> 8));
					nkRiMJNK.write((byte) (Jz4QWKdf >> 16));
					nkRiMJNK.write((byte) (Jz4QWKdf >> 24));
				}
				if (Jz9oIGka) {
					int L9W3CVJq, ogaWGo26;
					for (; Jz4QWKdf > 0; Jz4QWKdf -= 3) {
						nkRiMJNK.write(oH3WOW6R.read());
						L9W3CVJq = oH3WOW6R.read();
						ogaWGo26 = oH3WOW6R.read();
						nkRiMJNK.write(L9W3CVJq & 0x0f);
						nkRiMJNK.write(L9W3CVJq >> 4 | ((ogaWGo26 & 0x0f) << 4));
						nkRiMJNK.write(ogaWGo26 >> 4);
					}
				} else {
					for (; Jz4QWKdf > 0; --Jz4QWKdf) {
						nkRiMJNK.write(oH3WOW6R.read());
					}
				}
				nkRiMJNK.close();
			}
			System.out.print('.');
		} finally {
			oH3WOW6R.close();
		}
	}

}