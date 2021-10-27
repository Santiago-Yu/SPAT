class n608747 {
	public void convert(File Ml6aGk2B, File l6ZIZx4q) throws IOException {
		InputStream qKpIWzoG = new BufferedInputStream(new FileInputStream(Ml6aGk2B));
		DcmParser C4cAuxtR = pfact.newDcmParser(qKpIWzoG);
		Dataset D9xZMmGN = fact.newDataset();
		C4cAuxtR.setDcmHandler(D9xZMmGN.getDcmHandler());
		try {
			FileFormat nY765gHH = C4cAuxtR.detectFileFormat();
			if (nY765gHH != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + Ml6aGk2B + ": not an ACRNEMA stream!");
				return;
			}
			C4cAuxtR.parseDcmFile(nY765gHH, Tags.PixelData);
			if (D9xZMmGN.contains(Tags.StudyInstanceUID) || D9xZMmGN.contains(Tags.SeriesInstanceUID)
					|| D9xZMmGN.contains(Tags.SOPInstanceUID) || D9xZMmGN.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + Ml6aGk2B + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Fm4cccoe = C4cAuxtR.getReadTag() == Tags.PixelData;
			boolean PiNPzjc1 = Fm4cccoe && D9xZMmGN.getInt(Tags.BitsAllocated, 0) == 12;
			int cEQTwPLu = C4cAuxtR.getReadLength();
			if (Fm4cccoe) {
				if (PiNPzjc1) {
					D9xZMmGN.putUS(Tags.BitsAllocated, 16);
					cEQTwPLu = cEQTwPLu * 4 / 3;
				}
				if (cEQTwPLu != (D9xZMmGN.getInt(Tags.BitsAllocated, 0) >>> 3) * D9xZMmGN.getInt(Tags.Rows, 0)
						* D9xZMmGN.getInt(Tags.Columns, 0) * D9xZMmGN.getInt(Tags.NumberOfFrames, 1)
						* D9xZMmGN.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + Ml6aGk2B + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			D9xZMmGN.putUI(Tags.StudyInstanceUID, uid(studyUID));
			D9xZMmGN.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			D9xZMmGN.putUI(Tags.SOPInstanceUID, uid(instUID));
			D9xZMmGN.putUI(Tags.SOPClassUID, classUID);
			if (!D9xZMmGN.contains(Tags.NumberOfSamples)) {
				D9xZMmGN.putUS(Tags.NumberOfSamples, 1);
			}
			if (!D9xZMmGN.contains(Tags.PhotometricInterpretation)) {
				D9xZMmGN.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				D9xZMmGN.setFileMetaInfo(fact.newFileMetaInfo(D9xZMmGN, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream VVIyU9lT = new BufferedOutputStream(new FileOutputStream(l6ZIZx4q));
			try {
			} finally {
				D9xZMmGN.writeFile(VVIyU9lT, encodeParam());
				if (Fm4cccoe) {
					if (!skipGroupLen) {
						VVIyU9lT.write(PXDATA_GROUPLEN);
						int UIs7ojTM = cEQTwPLu + 8;
						VVIyU9lT.write((byte) UIs7ojTM);
						VVIyU9lT.write((byte) (UIs7ojTM >> 8));
						VVIyU9lT.write((byte) (UIs7ojTM >> 16));
						VVIyU9lT.write((byte) (UIs7ojTM >> 24));
					}
					VVIyU9lT.write(PXDATA_TAG);
					VVIyU9lT.write((byte) cEQTwPLu);
					VVIyU9lT.write((byte) (cEQTwPLu >> 8));
					VVIyU9lT.write((byte) (cEQTwPLu >> 16));
					VVIyU9lT.write((byte) (cEQTwPLu >> 24));
				}
				if (PiNPzjc1) {
					int ZwfoHKgc, vAf54vAj;
					for (; cEQTwPLu > 0; cEQTwPLu -= 3) {
						VVIyU9lT.write(qKpIWzoG.read());
						ZwfoHKgc = qKpIWzoG.read();
						vAf54vAj = qKpIWzoG.read();
						VVIyU9lT.write(ZwfoHKgc & 0x0f);
						VVIyU9lT.write(ZwfoHKgc >> 4 | ((vAf54vAj & 0x0f) << 4));
						VVIyU9lT.write(vAf54vAj >> 4);
					}
				} else {
					for (; cEQTwPLu > 0; --cEQTwPLu) {
						VVIyU9lT.write(qKpIWzoG.read());
					}
				}
				VVIyU9lT.close();
			}
			System.out.print('.');
		} finally {
			qKpIWzoG.close();
		}
	}

}