class n120730 {
	public void convert(File zHS5GrWL, File je82Agfr) throws IOException {
		InputStream aB0DkiHC = new BufferedInputStream(new FileInputStream(zHS5GrWL));
		DcmParser rNTfvzxM = pfact.newDcmParser(aB0DkiHC);
		Dataset Qf0vhZRU = fact.newDataset();
		rNTfvzxM.setDcmHandler(Qf0vhZRU.getDcmHandler());
		try {
			FileFormat GyS2GHaI = rNTfvzxM.detectFileFormat();
			if (GyS2GHaI != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + zHS5GrWL + ": not an ACRNEMA stream!");
				return;
			}
			rNTfvzxM.parseDcmFile(GyS2GHaI, Tags.PixelData);
			if (Qf0vhZRU.contains(Tags.StudyInstanceUID) || Qf0vhZRU.contains(Tags.SeriesInstanceUID)
					|| Qf0vhZRU.contains(Tags.SOPInstanceUID) || Qf0vhZRU.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + zHS5GrWL + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean eAqcUBB1 = rNTfvzxM.getReadTag() == Tags.PixelData;
			boolean yO82fdLw = eAqcUBB1 && Qf0vhZRU.getInt(Tags.BitsAllocated, 0) == 12;
			int K603A2Xy = rNTfvzxM.getReadLength();
			if (eAqcUBB1) {
				if (yO82fdLw) {
					Qf0vhZRU.putUS(Tags.BitsAllocated, 16);
					K603A2Xy = K603A2Xy * 4 / 3;
				}
				if (K603A2Xy != (Qf0vhZRU.getInt(Tags.BitsAllocated, 0) >>> 3) * Qf0vhZRU.getInt(Tags.Rows, 0)
						* Qf0vhZRU.getInt(Tags.Columns, 0) * Qf0vhZRU.getInt(Tags.NumberOfFrames, 1)
						* Qf0vhZRU.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + zHS5GrWL + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Qf0vhZRU.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Qf0vhZRU.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Qf0vhZRU.putUI(Tags.SOPInstanceUID, uid(instUID));
			Qf0vhZRU.putUI(Tags.SOPClassUID, classUID);
			if (!Qf0vhZRU.contains(Tags.NumberOfSamples)) {
				Qf0vhZRU.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Qf0vhZRU.contains(Tags.PhotometricInterpretation)) {
				Qf0vhZRU.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Qf0vhZRU.setFileMetaInfo(fact.newFileMetaInfo(Qf0vhZRU, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream dNReNifw = new BufferedOutputStream(new FileOutputStream(je82Agfr));
			try {
			} finally {
				Qf0vhZRU.writeFile(dNReNifw, encodeParam());
				if (eAqcUBB1) {
					if (!skipGroupLen) {
						dNReNifw.write(PXDATA_GROUPLEN);
						int Eu3LaB1W = K603A2Xy + 8;
						dNReNifw.write((byte) Eu3LaB1W);
						dNReNifw.write((byte) (Eu3LaB1W >> 8));
						dNReNifw.write((byte) (Eu3LaB1W >> 16));
						dNReNifw.write((byte) (Eu3LaB1W >> 24));
					}
					dNReNifw.write(PXDATA_TAG);
					dNReNifw.write((byte) K603A2Xy);
					dNReNifw.write((byte) (K603A2Xy >> 8));
					dNReNifw.write((byte) (K603A2Xy >> 16));
					dNReNifw.write((byte) (K603A2Xy >> 24));
				}
				if (yO82fdLw) {
					int FsnXh9Cu, eM1iIunL;
					for (; K603A2Xy > 0; K603A2Xy -= 3) {
						dNReNifw.write(aB0DkiHC.read());
						FsnXh9Cu = aB0DkiHC.read();
						eM1iIunL = aB0DkiHC.read();
						dNReNifw.write(FsnXh9Cu & 0x0f);
						dNReNifw.write(FsnXh9Cu >> 4 | ((eM1iIunL & 0x0f) << 4));
						dNReNifw.write(eM1iIunL >> 4);
					}
				} else {
					for (; K603A2Xy > 0; --K603A2Xy) {
						dNReNifw.write(aB0DkiHC.read());
					}
				}
				dNReNifw.close();
			}
			System.out.print('.');
		} finally {
			aB0DkiHC.close();
		}
	}

}