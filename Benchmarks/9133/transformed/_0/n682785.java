class n682785 {
	public void convert(File h3hMcddW, File nJTDBV5y) throws IOException {
		InputStream Bk7Sude3 = new BufferedInputStream(new FileInputStream(h3hMcddW));
		DcmParser PNEelgur = pfact.newDcmParser(Bk7Sude3);
		Dataset KxDZv0mC = fact.newDataset();
		PNEelgur.setDcmHandler(KxDZv0mC.getDcmHandler());
		try {
			FileFormat lqSdGM2x = PNEelgur.detectFileFormat();
			if (lqSdGM2x != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + h3hMcddW + ": not an ACRNEMA stream!");
				return;
			}
			PNEelgur.parseDcmFile(lqSdGM2x, Tags.PixelData);
			if (KxDZv0mC.contains(Tags.StudyInstanceUID) || KxDZv0mC.contains(Tags.SeriesInstanceUID)
					|| KxDZv0mC.contains(Tags.SOPInstanceUID) || KxDZv0mC.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + h3hMcddW + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean T4B4742d = PNEelgur.getReadTag() == Tags.PixelData;
			boolean RtJlPtd0 = T4B4742d && KxDZv0mC.getInt(Tags.BitsAllocated, 0) == 12;
			int QCSAMe5E = PNEelgur.getReadLength();
			if (T4B4742d) {
				if (RtJlPtd0) {
					KxDZv0mC.putUS(Tags.BitsAllocated, 16);
					QCSAMe5E = QCSAMe5E * 4 / 3;
				}
				if (QCSAMe5E != (KxDZv0mC.getInt(Tags.BitsAllocated, 0) >>> 3) * KxDZv0mC.getInt(Tags.Rows, 0)
						* KxDZv0mC.getInt(Tags.Columns, 0) * KxDZv0mC.getInt(Tags.NumberOfFrames, 1)
						* KxDZv0mC.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + h3hMcddW + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			KxDZv0mC.putUI(Tags.StudyInstanceUID, uid(studyUID));
			KxDZv0mC.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			KxDZv0mC.putUI(Tags.SOPInstanceUID, uid(instUID));
			KxDZv0mC.putUI(Tags.SOPClassUID, classUID);
			if (!KxDZv0mC.contains(Tags.NumberOfSamples)) {
				KxDZv0mC.putUS(Tags.NumberOfSamples, 1);
			}
			if (!KxDZv0mC.contains(Tags.PhotometricInterpretation)) {
				KxDZv0mC.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				KxDZv0mC.setFileMetaInfo(fact.newFileMetaInfo(KxDZv0mC, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream yvDnk3HP = new BufferedOutputStream(new FileOutputStream(nJTDBV5y));
			try {
			} finally {
				KxDZv0mC.writeFile(yvDnk3HP, encodeParam());
				if (T4B4742d) {
					if (!skipGroupLen) {
						yvDnk3HP.write(PXDATA_GROUPLEN);
						int o5fLKa12 = QCSAMe5E + 8;
						yvDnk3HP.write((byte) o5fLKa12);
						yvDnk3HP.write((byte) (o5fLKa12 >> 8));
						yvDnk3HP.write((byte) (o5fLKa12 >> 16));
						yvDnk3HP.write((byte) (o5fLKa12 >> 24));
					}
					yvDnk3HP.write(PXDATA_TAG);
					yvDnk3HP.write((byte) QCSAMe5E);
					yvDnk3HP.write((byte) (QCSAMe5E >> 8));
					yvDnk3HP.write((byte) (QCSAMe5E >> 16));
					yvDnk3HP.write((byte) (QCSAMe5E >> 24));
				}
				if (RtJlPtd0) {
					int UcJW4Xdr, hrkSN0mq;
					for (; QCSAMe5E > 0; QCSAMe5E -= 3) {
						yvDnk3HP.write(Bk7Sude3.read());
						UcJW4Xdr = Bk7Sude3.read();
						hrkSN0mq = Bk7Sude3.read();
						yvDnk3HP.write(UcJW4Xdr & 0x0f);
						yvDnk3HP.write(UcJW4Xdr >> 4 | ((hrkSN0mq & 0x0f) << 4));
						yvDnk3HP.write(hrkSN0mq >> 4);
					}
				} else {
					for (; QCSAMe5E > 0; --QCSAMe5E) {
						yvDnk3HP.write(Bk7Sude3.read());
					}
				}
				yvDnk3HP.close();
			}
			System.out.print('.');
		} finally {
			Bk7Sude3.close();
		}
	}

}