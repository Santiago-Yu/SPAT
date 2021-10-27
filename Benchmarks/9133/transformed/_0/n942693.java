class n942693 {
	public void convert(File MUlm5vRr, File f0auCmKB) throws IOException {
		InputStream IA81Cksi = new BufferedInputStream(new FileInputStream(MUlm5vRr));
		DcmParser IFeTW1gi = pfact.newDcmParser(IA81Cksi);
		Dataset N22vBHyM = fact.newDataset();
		IFeTW1gi.setDcmHandler(N22vBHyM.getDcmHandler());
		try {
			FileFormat Hg9kFUW5 = IFeTW1gi.detectFileFormat();
			if (Hg9kFUW5 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + MUlm5vRr + ": not an ACRNEMA stream!");
				return;
			}
			IFeTW1gi.parseDcmFile(Hg9kFUW5, Tags.PixelData);
			if (N22vBHyM.contains(Tags.StudyInstanceUID) || N22vBHyM.contains(Tags.SeriesInstanceUID)
					|| N22vBHyM.contains(Tags.SOPInstanceUID) || N22vBHyM.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + MUlm5vRr + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean GNIGSCZc = IFeTW1gi.getReadTag() == Tags.PixelData;
			boolean KwviAyXT = GNIGSCZc && N22vBHyM.getInt(Tags.BitsAllocated, 0) == 12;
			int Ijx7BeMA = IFeTW1gi.getReadLength();
			if (GNIGSCZc) {
				if (KwviAyXT) {
					N22vBHyM.putUS(Tags.BitsAllocated, 16);
					Ijx7BeMA = Ijx7BeMA * 4 / 3;
				}
				if (Ijx7BeMA != (N22vBHyM.getInt(Tags.BitsAllocated, 0) >>> 3) * N22vBHyM.getInt(Tags.Rows, 0)
						* N22vBHyM.getInt(Tags.Columns, 0) * N22vBHyM.getInt(Tags.NumberOfFrames, 1)
						* N22vBHyM.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + MUlm5vRr + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			N22vBHyM.putUI(Tags.StudyInstanceUID, uid(studyUID));
			N22vBHyM.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			N22vBHyM.putUI(Tags.SOPInstanceUID, uid(instUID));
			N22vBHyM.putUI(Tags.SOPClassUID, classUID);
			if (!N22vBHyM.contains(Tags.NumberOfSamples)) {
				N22vBHyM.putUS(Tags.NumberOfSamples, 1);
			}
			if (!N22vBHyM.contains(Tags.PhotometricInterpretation)) {
				N22vBHyM.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				N22vBHyM.setFileMetaInfo(fact.newFileMetaInfo(N22vBHyM, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream tHDTYIGf = new BufferedOutputStream(new FileOutputStream(f0auCmKB));
			try {
			} finally {
				N22vBHyM.writeFile(tHDTYIGf, encodeParam());
				if (GNIGSCZc) {
					if (!skipGroupLen) {
						tHDTYIGf.write(PXDATA_GROUPLEN);
						int vNdeAizL = Ijx7BeMA + 8;
						tHDTYIGf.write((byte) vNdeAizL);
						tHDTYIGf.write((byte) (vNdeAizL >> 8));
						tHDTYIGf.write((byte) (vNdeAizL >> 16));
						tHDTYIGf.write((byte) (vNdeAizL >> 24));
					}
					tHDTYIGf.write(PXDATA_TAG);
					tHDTYIGf.write((byte) Ijx7BeMA);
					tHDTYIGf.write((byte) (Ijx7BeMA >> 8));
					tHDTYIGf.write((byte) (Ijx7BeMA >> 16));
					tHDTYIGf.write((byte) (Ijx7BeMA >> 24));
				}
				if (KwviAyXT) {
					int jegodtPo, tScDQ8Df;
					for (; Ijx7BeMA > 0; Ijx7BeMA -= 3) {
						tHDTYIGf.write(IA81Cksi.read());
						jegodtPo = IA81Cksi.read();
						tScDQ8Df = IA81Cksi.read();
						tHDTYIGf.write(jegodtPo & 0x0f);
						tHDTYIGf.write(jegodtPo >> 4 | ((tScDQ8Df & 0x0f) << 4));
						tHDTYIGf.write(tScDQ8Df >> 4);
					}
				} else {
					for (; Ijx7BeMA > 0; --Ijx7BeMA) {
						tHDTYIGf.write(IA81Cksi.read());
					}
				}
				tHDTYIGf.close();
			}
			System.out.print('.');
		} finally {
			IA81Cksi.close();
		}
	}

}