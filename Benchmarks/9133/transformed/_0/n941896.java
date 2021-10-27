class n941896 {
	public void convert(File ljAs4CCM, File WJZeUfMU) throws IOException {
		InputStream PexbSSQW = new BufferedInputStream(new FileInputStream(ljAs4CCM));
		DcmParser sM7twFrH = pfact.newDcmParser(PexbSSQW);
		Dataset N6WnhhyF = fact.newDataset();
		sM7twFrH.setDcmHandler(N6WnhhyF.getDcmHandler());
		try {
			FileFormat RSKgAWLE = sM7twFrH.detectFileFormat();
			if (RSKgAWLE != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ljAs4CCM + ": not an ACRNEMA stream!");
				return;
			}
			sM7twFrH.parseDcmFile(RSKgAWLE, Tags.PixelData);
			if (N6WnhhyF.contains(Tags.StudyInstanceUID) || N6WnhhyF.contains(Tags.SeriesInstanceUID)
					|| N6WnhhyF.contains(Tags.SOPInstanceUID) || N6WnhhyF.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ljAs4CCM + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean gWH3i8Pj = sM7twFrH.getReadTag() == Tags.PixelData;
			boolean B2ddfcfJ = gWH3i8Pj && N6WnhhyF.getInt(Tags.BitsAllocated, 0) == 12;
			int EYjTDNPQ = sM7twFrH.getReadLength();
			if (gWH3i8Pj) {
				if (B2ddfcfJ) {
					N6WnhhyF.putUS(Tags.BitsAllocated, 16);
					EYjTDNPQ = EYjTDNPQ * 4 / 3;
				}
				if (EYjTDNPQ != (N6WnhhyF.getInt(Tags.BitsAllocated, 0) >>> 3) * N6WnhhyF.getInt(Tags.Rows, 0)
						* N6WnhhyF.getInt(Tags.Columns, 0) * N6WnhhyF.getInt(Tags.NumberOfFrames, 1)
						* N6WnhhyF.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ljAs4CCM + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			N6WnhhyF.putUI(Tags.StudyInstanceUID, uid(studyUID));
			N6WnhhyF.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			N6WnhhyF.putUI(Tags.SOPInstanceUID, uid(instUID));
			N6WnhhyF.putUI(Tags.SOPClassUID, classUID);
			if (!N6WnhhyF.contains(Tags.NumberOfSamples)) {
				N6WnhhyF.putUS(Tags.NumberOfSamples, 1);
			}
			if (!N6WnhhyF.contains(Tags.PhotometricInterpretation)) {
				N6WnhhyF.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				N6WnhhyF.setFileMetaInfo(fact.newFileMetaInfo(N6WnhhyF, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream gUjw5ydd = new BufferedOutputStream(new FileOutputStream(WJZeUfMU));
			try {
			} finally {
				N6WnhhyF.writeFile(gUjw5ydd, encodeParam());
				if (gWH3i8Pj) {
					if (!skipGroupLen) {
						gUjw5ydd.write(PXDATA_GROUPLEN);
						int kiFqsHP4 = EYjTDNPQ + 8;
						gUjw5ydd.write((byte) kiFqsHP4);
						gUjw5ydd.write((byte) (kiFqsHP4 >> 8));
						gUjw5ydd.write((byte) (kiFqsHP4 >> 16));
						gUjw5ydd.write((byte) (kiFqsHP4 >> 24));
					}
					gUjw5ydd.write(PXDATA_TAG);
					gUjw5ydd.write((byte) EYjTDNPQ);
					gUjw5ydd.write((byte) (EYjTDNPQ >> 8));
					gUjw5ydd.write((byte) (EYjTDNPQ >> 16));
					gUjw5ydd.write((byte) (EYjTDNPQ >> 24));
				}
				if (B2ddfcfJ) {
					int kLLyE3Bx, NPnt8ivP;
					for (; EYjTDNPQ > 0; EYjTDNPQ -= 3) {
						gUjw5ydd.write(PexbSSQW.read());
						kLLyE3Bx = PexbSSQW.read();
						NPnt8ivP = PexbSSQW.read();
						gUjw5ydd.write(kLLyE3Bx & 0x0f);
						gUjw5ydd.write(kLLyE3Bx >> 4 | ((NPnt8ivP & 0x0f) << 4));
						gUjw5ydd.write(NPnt8ivP >> 4);
					}
				} else {
					for (; EYjTDNPQ > 0; --EYjTDNPQ) {
						gUjw5ydd.write(PexbSSQW.read());
					}
				}
				gUjw5ydd.close();
			}
			System.out.print('.');
		} finally {
			PexbSSQW.close();
		}
	}

}