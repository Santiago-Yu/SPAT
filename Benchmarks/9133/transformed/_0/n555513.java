class n555513 {
	public void convert(File PkLoFuU4, File GCzV3S8O) throws IOException {
		InputStream yUmAIxh3 = new BufferedInputStream(new FileInputStream(PkLoFuU4));
		DcmParser G4PsqaUK = pfact.newDcmParser(yUmAIxh3);
		Dataset y3fsVfOw = fact.newDataset();
		G4PsqaUK.setDcmHandler(y3fsVfOw.getDcmHandler());
		try {
			FileFormat UG6sZljZ = G4PsqaUK.detectFileFormat();
			if (UG6sZljZ != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + PkLoFuU4 + ": not an ACRNEMA stream!");
				return;
			}
			G4PsqaUK.parseDcmFile(UG6sZljZ, Tags.PixelData);
			if (y3fsVfOw.contains(Tags.StudyInstanceUID) || y3fsVfOw.contains(Tags.SeriesInstanceUID)
					|| y3fsVfOw.contains(Tags.SOPInstanceUID) || y3fsVfOw.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + PkLoFuU4 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean SRBYM1yY = G4PsqaUK.getReadTag() == Tags.PixelData;
			boolean zXCjtmoA = SRBYM1yY && y3fsVfOw.getInt(Tags.BitsAllocated, 0) == 12;
			int F3ttxGRO = G4PsqaUK.getReadLength();
			if (SRBYM1yY) {
				if (zXCjtmoA) {
					y3fsVfOw.putUS(Tags.BitsAllocated, 16);
					F3ttxGRO = F3ttxGRO * 4 / 3;
				}
				if (F3ttxGRO != (y3fsVfOw.getInt(Tags.BitsAllocated, 0) >>> 3) * y3fsVfOw.getInt(Tags.Rows, 0)
						* y3fsVfOw.getInt(Tags.Columns, 0) * y3fsVfOw.getInt(Tags.NumberOfFrames, 1)
						* y3fsVfOw.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + PkLoFuU4 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			y3fsVfOw.putUI(Tags.StudyInstanceUID, uid(studyUID));
			y3fsVfOw.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			y3fsVfOw.putUI(Tags.SOPInstanceUID, uid(instUID));
			y3fsVfOw.putUI(Tags.SOPClassUID, classUID);
			if (!y3fsVfOw.contains(Tags.NumberOfSamples)) {
				y3fsVfOw.putUS(Tags.NumberOfSamples, 1);
			}
			if (!y3fsVfOw.contains(Tags.PhotometricInterpretation)) {
				y3fsVfOw.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				y3fsVfOw.setFileMetaInfo(fact.newFileMetaInfo(y3fsVfOw, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream n67zFPxO = new BufferedOutputStream(new FileOutputStream(GCzV3S8O));
			try {
			} finally {
				y3fsVfOw.writeFile(n67zFPxO, encodeParam());
				if (SRBYM1yY) {
					if (!skipGroupLen) {
						n67zFPxO.write(PXDATA_GROUPLEN);
						int KKg6ryGs = F3ttxGRO + 8;
						n67zFPxO.write((byte) KKg6ryGs);
						n67zFPxO.write((byte) (KKg6ryGs >> 8));
						n67zFPxO.write((byte) (KKg6ryGs >> 16));
						n67zFPxO.write((byte) (KKg6ryGs >> 24));
					}
					n67zFPxO.write(PXDATA_TAG);
					n67zFPxO.write((byte) F3ttxGRO);
					n67zFPxO.write((byte) (F3ttxGRO >> 8));
					n67zFPxO.write((byte) (F3ttxGRO >> 16));
					n67zFPxO.write((byte) (F3ttxGRO >> 24));
				}
				if (zXCjtmoA) {
					int jBPZi2i5, Q0DGGpu9;
					for (; F3ttxGRO > 0; F3ttxGRO -= 3) {
						n67zFPxO.write(yUmAIxh3.read());
						jBPZi2i5 = yUmAIxh3.read();
						Q0DGGpu9 = yUmAIxh3.read();
						n67zFPxO.write(jBPZi2i5 & 0x0f);
						n67zFPxO.write(jBPZi2i5 >> 4 | ((Q0DGGpu9 & 0x0f) << 4));
						n67zFPxO.write(Q0DGGpu9 >> 4);
					}
				} else {
					for (; F3ttxGRO > 0; --F3ttxGRO) {
						n67zFPxO.write(yUmAIxh3.read());
					}
				}
				n67zFPxO.close();
			}
			System.out.print('.');
		} finally {
			yUmAIxh3.close();
		}
	}

}