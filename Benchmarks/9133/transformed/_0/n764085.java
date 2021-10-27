class n764085 {
	public void convert(File BpHk0nUi, File PVUKlGBs) throws IOException {
		InputStream fI4CEIOE = new BufferedInputStream(new FileInputStream(BpHk0nUi));
		DcmParser jAKb7GKZ = pfact.newDcmParser(fI4CEIOE);
		Dataset aauwZNXF = fact.newDataset();
		jAKb7GKZ.setDcmHandler(aauwZNXF.getDcmHandler());
		try {
			FileFormat J0QHkrlo = jAKb7GKZ.detectFileFormat();
			if (J0QHkrlo != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + BpHk0nUi + ": not an ACRNEMA stream!");
				return;
			}
			jAKb7GKZ.parseDcmFile(J0QHkrlo, Tags.PixelData);
			if (aauwZNXF.contains(Tags.StudyInstanceUID) || aauwZNXF.contains(Tags.SeriesInstanceUID)
					|| aauwZNXF.contains(Tags.SOPInstanceUID) || aauwZNXF.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + BpHk0nUi + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean RXlhoN1Q = jAKb7GKZ.getReadTag() == Tags.PixelData;
			boolean sVdG15Ev = RXlhoN1Q && aauwZNXF.getInt(Tags.BitsAllocated, 0) == 12;
			int uPI8i9yj = jAKb7GKZ.getReadLength();
			if (RXlhoN1Q) {
				if (sVdG15Ev) {
					aauwZNXF.putUS(Tags.BitsAllocated, 16);
					uPI8i9yj = uPI8i9yj * 4 / 3;
				}
				if (uPI8i9yj != (aauwZNXF.getInt(Tags.BitsAllocated, 0) >>> 3) * aauwZNXF.getInt(Tags.Rows, 0)
						* aauwZNXF.getInt(Tags.Columns, 0) * aauwZNXF.getInt(Tags.NumberOfFrames, 1)
						* aauwZNXF.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + BpHk0nUi + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			aauwZNXF.putUI(Tags.StudyInstanceUID, uid(studyUID));
			aauwZNXF.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			aauwZNXF.putUI(Tags.SOPInstanceUID, uid(instUID));
			aauwZNXF.putUI(Tags.SOPClassUID, classUID);
			if (!aauwZNXF.contains(Tags.NumberOfSamples)) {
				aauwZNXF.putUS(Tags.NumberOfSamples, 1);
			}
			if (!aauwZNXF.contains(Tags.PhotometricInterpretation)) {
				aauwZNXF.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				aauwZNXF.setFileMetaInfo(fact.newFileMetaInfo(aauwZNXF, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream J0eNiJKJ = new BufferedOutputStream(new FileOutputStream(PVUKlGBs));
			try {
			} finally {
				aauwZNXF.writeFile(J0eNiJKJ, encodeParam());
				if (RXlhoN1Q) {
					if (!skipGroupLen) {
						J0eNiJKJ.write(PXDATA_GROUPLEN);
						int CbWVEx1w = uPI8i9yj + 8;
						J0eNiJKJ.write((byte) CbWVEx1w);
						J0eNiJKJ.write((byte) (CbWVEx1w >> 8));
						J0eNiJKJ.write((byte) (CbWVEx1w >> 16));
						J0eNiJKJ.write((byte) (CbWVEx1w >> 24));
					}
					J0eNiJKJ.write(PXDATA_TAG);
					J0eNiJKJ.write((byte) uPI8i9yj);
					J0eNiJKJ.write((byte) (uPI8i9yj >> 8));
					J0eNiJKJ.write((byte) (uPI8i9yj >> 16));
					J0eNiJKJ.write((byte) (uPI8i9yj >> 24));
				}
				if (sVdG15Ev) {
					int WILbRSh0, kb1Vs3VH;
					for (; uPI8i9yj > 0; uPI8i9yj -= 3) {
						J0eNiJKJ.write(fI4CEIOE.read());
						WILbRSh0 = fI4CEIOE.read();
						kb1Vs3VH = fI4CEIOE.read();
						J0eNiJKJ.write(WILbRSh0 & 0x0f);
						J0eNiJKJ.write(WILbRSh0 >> 4 | ((kb1Vs3VH & 0x0f) << 4));
						J0eNiJKJ.write(kb1Vs3VH >> 4);
					}
				} else {
					for (; uPI8i9yj > 0; --uPI8i9yj) {
						J0eNiJKJ.write(fI4CEIOE.read());
					}
				}
				J0eNiJKJ.close();
			}
			System.out.print('.');
		} finally {
			fI4CEIOE.close();
		}
	}

}