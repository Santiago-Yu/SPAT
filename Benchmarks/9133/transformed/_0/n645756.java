class n645756 {
	public void convert(File GwMPVjqb, File qbA7nWek) throws IOException {
		InputStream wArkjOvB = new BufferedInputStream(new FileInputStream(GwMPVjqb));
		DcmParser qpG5vnno = pfact.newDcmParser(wArkjOvB);
		Dataset pxMWArZz = fact.newDataset();
		qpG5vnno.setDcmHandler(pxMWArZz.getDcmHandler());
		try {
			FileFormat Agd2HL8f = qpG5vnno.detectFileFormat();
			if (Agd2HL8f != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + GwMPVjqb + ": not an ACRNEMA stream!");
				return;
			}
			qpG5vnno.parseDcmFile(Agd2HL8f, Tags.PixelData);
			if (pxMWArZz.contains(Tags.StudyInstanceUID) || pxMWArZz.contains(Tags.SeriesInstanceUID)
					|| pxMWArZz.contains(Tags.SOPInstanceUID) || pxMWArZz.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + GwMPVjqb + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean FCr7K1yF = qpG5vnno.getReadTag() == Tags.PixelData;
			boolean nrczAla0 = FCr7K1yF && pxMWArZz.getInt(Tags.BitsAllocated, 0) == 12;
			int FmyxSSJe = qpG5vnno.getReadLength();
			if (FCr7K1yF) {
				if (nrczAla0) {
					pxMWArZz.putUS(Tags.BitsAllocated, 16);
					FmyxSSJe = FmyxSSJe * 4 / 3;
				}
				if (FmyxSSJe != (pxMWArZz.getInt(Tags.BitsAllocated, 0) >>> 3) * pxMWArZz.getInt(Tags.Rows, 0)
						* pxMWArZz.getInt(Tags.Columns, 0) * pxMWArZz.getInt(Tags.NumberOfFrames, 1)
						* pxMWArZz.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + GwMPVjqb + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			pxMWArZz.putUI(Tags.StudyInstanceUID, uid(studyUID));
			pxMWArZz.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			pxMWArZz.putUI(Tags.SOPInstanceUID, uid(instUID));
			pxMWArZz.putUI(Tags.SOPClassUID, classUID);
			if (!pxMWArZz.contains(Tags.NumberOfSamples)) {
				pxMWArZz.putUS(Tags.NumberOfSamples, 1);
			}
			if (!pxMWArZz.contains(Tags.PhotometricInterpretation)) {
				pxMWArZz.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				pxMWArZz.setFileMetaInfo(fact.newFileMetaInfo(pxMWArZz, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream U1MJjh7a = new BufferedOutputStream(new FileOutputStream(qbA7nWek));
			try {
			} finally {
				pxMWArZz.writeFile(U1MJjh7a, encodeParam());
				if (FCr7K1yF) {
					if (!skipGroupLen) {
						U1MJjh7a.write(PXDATA_GROUPLEN);
						int OX9tRVrK = FmyxSSJe + 8;
						U1MJjh7a.write((byte) OX9tRVrK);
						U1MJjh7a.write((byte) (OX9tRVrK >> 8));
						U1MJjh7a.write((byte) (OX9tRVrK >> 16));
						U1MJjh7a.write((byte) (OX9tRVrK >> 24));
					}
					U1MJjh7a.write(PXDATA_TAG);
					U1MJjh7a.write((byte) FmyxSSJe);
					U1MJjh7a.write((byte) (FmyxSSJe >> 8));
					U1MJjh7a.write((byte) (FmyxSSJe >> 16));
					U1MJjh7a.write((byte) (FmyxSSJe >> 24));
				}
				if (nrczAla0) {
					int bLmt8VIq, SMbBa2IA;
					for (; FmyxSSJe > 0; FmyxSSJe -= 3) {
						U1MJjh7a.write(wArkjOvB.read());
						bLmt8VIq = wArkjOvB.read();
						SMbBa2IA = wArkjOvB.read();
						U1MJjh7a.write(bLmt8VIq & 0x0f);
						U1MJjh7a.write(bLmt8VIq >> 4 | ((SMbBa2IA & 0x0f) << 4));
						U1MJjh7a.write(SMbBa2IA >> 4);
					}
				} else {
					for (; FmyxSSJe > 0; --FmyxSSJe) {
						U1MJjh7a.write(wArkjOvB.read());
					}
				}
				U1MJjh7a.close();
			}
			System.out.print('.');
		} finally {
			wArkjOvB.close();
		}
	}

}