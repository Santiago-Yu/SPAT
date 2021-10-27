class n523070 {
	public void convert(File ypSphN27, File nnLsZFxr) throws IOException {
		InputStream f2BjK3Ln = new BufferedInputStream(new FileInputStream(ypSphN27));
		DcmParser NFZFr89v = pfact.newDcmParser(f2BjK3Ln);
		Dataset Zh3wybbY = fact.newDataset();
		NFZFr89v.setDcmHandler(Zh3wybbY.getDcmHandler());
		try {
			FileFormat iiSqMXCU = NFZFr89v.detectFileFormat();
			if (iiSqMXCU != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + ypSphN27 + ": not an ACRNEMA stream!");
				return;
			}
			NFZFr89v.parseDcmFile(iiSqMXCU, Tags.PixelData);
			if (Zh3wybbY.contains(Tags.StudyInstanceUID) || Zh3wybbY.contains(Tags.SeriesInstanceUID)
					|| Zh3wybbY.contains(Tags.SOPInstanceUID) || Zh3wybbY.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + ypSphN27 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean J34HqUy2 = NFZFr89v.getReadTag() == Tags.PixelData;
			boolean YU3IR0Yu = J34HqUy2 && Zh3wybbY.getInt(Tags.BitsAllocated, 0) == 12;
			int uxhy0XQM = NFZFr89v.getReadLength();
			if (J34HqUy2) {
				if (YU3IR0Yu) {
					Zh3wybbY.putUS(Tags.BitsAllocated, 16);
					uxhy0XQM = uxhy0XQM * 4 / 3;
				}
				if (uxhy0XQM != (Zh3wybbY.getInt(Tags.BitsAllocated, 0) >>> 3) * Zh3wybbY.getInt(Tags.Rows, 0)
						* Zh3wybbY.getInt(Tags.Columns, 0) * Zh3wybbY.getInt(Tags.NumberOfFrames, 1)
						* Zh3wybbY.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + ypSphN27 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Zh3wybbY.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Zh3wybbY.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Zh3wybbY.putUI(Tags.SOPInstanceUID, uid(instUID));
			Zh3wybbY.putUI(Tags.SOPClassUID, classUID);
			if (!Zh3wybbY.contains(Tags.NumberOfSamples)) {
				Zh3wybbY.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Zh3wybbY.contains(Tags.PhotometricInterpretation)) {
				Zh3wybbY.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Zh3wybbY.setFileMetaInfo(fact.newFileMetaInfo(Zh3wybbY, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream qdNgeAKh = new BufferedOutputStream(new FileOutputStream(nnLsZFxr));
			try {
			} finally {
				Zh3wybbY.writeFile(qdNgeAKh, encodeParam());
				if (J34HqUy2) {
					if (!skipGroupLen) {
						qdNgeAKh.write(PXDATA_GROUPLEN);
						int HuZoXNLc = uxhy0XQM + 8;
						qdNgeAKh.write((byte) HuZoXNLc);
						qdNgeAKh.write((byte) (HuZoXNLc >> 8));
						qdNgeAKh.write((byte) (HuZoXNLc >> 16));
						qdNgeAKh.write((byte) (HuZoXNLc >> 24));
					}
					qdNgeAKh.write(PXDATA_TAG);
					qdNgeAKh.write((byte) uxhy0XQM);
					qdNgeAKh.write((byte) (uxhy0XQM >> 8));
					qdNgeAKh.write((byte) (uxhy0XQM >> 16));
					qdNgeAKh.write((byte) (uxhy0XQM >> 24));
				}
				if (YU3IR0Yu) {
					int evZ10t0k, Hyg8D5Fb;
					for (; uxhy0XQM > 0; uxhy0XQM -= 3) {
						qdNgeAKh.write(f2BjK3Ln.read());
						evZ10t0k = f2BjK3Ln.read();
						Hyg8D5Fb = f2BjK3Ln.read();
						qdNgeAKh.write(evZ10t0k & 0x0f);
						qdNgeAKh.write(evZ10t0k >> 4 | ((Hyg8D5Fb & 0x0f) << 4));
						qdNgeAKh.write(Hyg8D5Fb >> 4);
					}
				} else {
					for (; uxhy0XQM > 0; --uxhy0XQM) {
						qdNgeAKh.write(f2BjK3Ln.read());
					}
				}
				qdNgeAKh.close();
			}
			System.out.print('.');
		} finally {
			f2BjK3Ln.close();
		}
	}

}