class n621591 {
	public void convert(File voUoW3DN, File s5CQi7Ng) throws IOException {
		InputStream GuOYTXMr = new BufferedInputStream(new FileInputStream(voUoW3DN));
		DcmParser FPzz6g96 = pfact.newDcmParser(GuOYTXMr);
		Dataset qCPQ6xXB = fact.newDataset();
		FPzz6g96.setDcmHandler(qCPQ6xXB.getDcmHandler());
		try {
			FileFormat JOXQ6lyD = FPzz6g96.detectFileFormat();
			if (JOXQ6lyD != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + voUoW3DN + ": not an ACRNEMA stream!");
				return;
			}
			FPzz6g96.parseDcmFile(JOXQ6lyD, Tags.PixelData);
			if (qCPQ6xXB.contains(Tags.StudyInstanceUID) || qCPQ6xXB.contains(Tags.SeriesInstanceUID)
					|| qCPQ6xXB.contains(Tags.SOPInstanceUID) || qCPQ6xXB.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + voUoW3DN + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean JATvjfUM = FPzz6g96.getReadTag() == Tags.PixelData;
			boolean sKfDVvrF = JATvjfUM && qCPQ6xXB.getInt(Tags.BitsAllocated, 0) == 12;
			int hCee26nS = FPzz6g96.getReadLength();
			if (JATvjfUM) {
				if (sKfDVvrF) {
					qCPQ6xXB.putUS(Tags.BitsAllocated, 16);
					hCee26nS = hCee26nS * 4 / 3;
				}
				if (hCee26nS != (qCPQ6xXB.getInt(Tags.BitsAllocated, 0) >>> 3) * qCPQ6xXB.getInt(Tags.Rows, 0)
						* qCPQ6xXB.getInt(Tags.Columns, 0) * qCPQ6xXB.getInt(Tags.NumberOfFrames, 1)
						* qCPQ6xXB.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + voUoW3DN + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			qCPQ6xXB.putUI(Tags.StudyInstanceUID, uid(studyUID));
			qCPQ6xXB.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			qCPQ6xXB.putUI(Tags.SOPInstanceUID, uid(instUID));
			qCPQ6xXB.putUI(Tags.SOPClassUID, classUID);
			if (!qCPQ6xXB.contains(Tags.NumberOfSamples)) {
				qCPQ6xXB.putUS(Tags.NumberOfSamples, 1);
			}
			if (!qCPQ6xXB.contains(Tags.PhotometricInterpretation)) {
				qCPQ6xXB.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				qCPQ6xXB.setFileMetaInfo(fact.newFileMetaInfo(qCPQ6xXB, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream XRZXuAHQ = new BufferedOutputStream(new FileOutputStream(s5CQi7Ng));
			try {
			} finally {
				qCPQ6xXB.writeFile(XRZXuAHQ, encodeParam());
				if (JATvjfUM) {
					if (!skipGroupLen) {
						XRZXuAHQ.write(PXDATA_GROUPLEN);
						int qXCuCHpj = hCee26nS + 8;
						XRZXuAHQ.write((byte) qXCuCHpj);
						XRZXuAHQ.write((byte) (qXCuCHpj >> 8));
						XRZXuAHQ.write((byte) (qXCuCHpj >> 16));
						XRZXuAHQ.write((byte) (qXCuCHpj >> 24));
					}
					XRZXuAHQ.write(PXDATA_TAG);
					XRZXuAHQ.write((byte) hCee26nS);
					XRZXuAHQ.write((byte) (hCee26nS >> 8));
					XRZXuAHQ.write((byte) (hCee26nS >> 16));
					XRZXuAHQ.write((byte) (hCee26nS >> 24));
				}
				if (sKfDVvrF) {
					int Pui2VlwO, o4qF17zv;
					for (; hCee26nS > 0; hCee26nS -= 3) {
						XRZXuAHQ.write(GuOYTXMr.read());
						Pui2VlwO = GuOYTXMr.read();
						o4qF17zv = GuOYTXMr.read();
						XRZXuAHQ.write(Pui2VlwO & 0x0f);
						XRZXuAHQ.write(Pui2VlwO >> 4 | ((o4qF17zv & 0x0f) << 4));
						XRZXuAHQ.write(o4qF17zv >> 4);
					}
				} else {
					for (; hCee26nS > 0; --hCee26nS) {
						XRZXuAHQ.write(GuOYTXMr.read());
					}
				}
				XRZXuAHQ.close();
			}
			System.out.print('.');
		} finally {
			GuOYTXMr.close();
		}
	}

}