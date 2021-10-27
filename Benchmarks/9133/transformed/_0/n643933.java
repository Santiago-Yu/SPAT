class n643933 {
	public void convert(File wvkl23xs, File qf9SpPq8) throws IOException {
		InputStream HFs6uNvc = new BufferedInputStream(new FileInputStream(wvkl23xs));
		DcmParser v7a4wze1 = pfact.newDcmParser(HFs6uNvc);
		Dataset I1zldSte = fact.newDataset();
		v7a4wze1.setDcmHandler(I1zldSte.getDcmHandler());
		try {
			FileFormat EBq4G2on = v7a4wze1.detectFileFormat();
			if (EBq4G2on != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + wvkl23xs + ": not an ACRNEMA stream!");
				return;
			}
			v7a4wze1.parseDcmFile(EBq4G2on, Tags.PixelData);
			if (I1zldSte.contains(Tags.StudyInstanceUID) || I1zldSte.contains(Tags.SeriesInstanceUID)
					|| I1zldSte.contains(Tags.SOPInstanceUID) || I1zldSte.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + wvkl23xs + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean HJPJd95c = v7a4wze1.getReadTag() == Tags.PixelData;
			boolean zrn63vEg = HJPJd95c && I1zldSte.getInt(Tags.BitsAllocated, 0) == 12;
			int EL9uW2TX = v7a4wze1.getReadLength();
			if (HJPJd95c) {
				if (zrn63vEg) {
					I1zldSte.putUS(Tags.BitsAllocated, 16);
					EL9uW2TX = EL9uW2TX * 4 / 3;
				}
				if (EL9uW2TX != (I1zldSte.getInt(Tags.BitsAllocated, 0) >>> 3) * I1zldSte.getInt(Tags.Rows, 0)
						* I1zldSte.getInt(Tags.Columns, 0) * I1zldSte.getInt(Tags.NumberOfFrames, 1)
						* I1zldSte.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + wvkl23xs + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			I1zldSte.putUI(Tags.StudyInstanceUID, uid(studyUID));
			I1zldSte.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			I1zldSte.putUI(Tags.SOPInstanceUID, uid(instUID));
			I1zldSte.putUI(Tags.SOPClassUID, classUID);
			if (!I1zldSte.contains(Tags.NumberOfSamples)) {
				I1zldSte.putUS(Tags.NumberOfSamples, 1);
			}
			if (!I1zldSte.contains(Tags.PhotometricInterpretation)) {
				I1zldSte.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				I1zldSte.setFileMetaInfo(fact.newFileMetaInfo(I1zldSte, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream zmVgSpD0 = new BufferedOutputStream(new FileOutputStream(qf9SpPq8));
			try {
			} finally {
				I1zldSte.writeFile(zmVgSpD0, encodeParam());
				if (HJPJd95c) {
					if (!skipGroupLen) {
						zmVgSpD0.write(PXDATA_GROUPLEN);
						int c0pomUpe = EL9uW2TX + 8;
						zmVgSpD0.write((byte) c0pomUpe);
						zmVgSpD0.write((byte) (c0pomUpe >> 8));
						zmVgSpD0.write((byte) (c0pomUpe >> 16));
						zmVgSpD0.write((byte) (c0pomUpe >> 24));
					}
					zmVgSpD0.write(PXDATA_TAG);
					zmVgSpD0.write((byte) EL9uW2TX);
					zmVgSpD0.write((byte) (EL9uW2TX >> 8));
					zmVgSpD0.write((byte) (EL9uW2TX >> 16));
					zmVgSpD0.write((byte) (EL9uW2TX >> 24));
				}
				if (zrn63vEg) {
					int SPHMI3SS, P1WMp1mf;
					for (; EL9uW2TX > 0; EL9uW2TX -= 3) {
						zmVgSpD0.write(HFs6uNvc.read());
						SPHMI3SS = HFs6uNvc.read();
						P1WMp1mf = HFs6uNvc.read();
						zmVgSpD0.write(SPHMI3SS & 0x0f);
						zmVgSpD0.write(SPHMI3SS >> 4 | ((P1WMp1mf & 0x0f) << 4));
						zmVgSpD0.write(P1WMp1mf >> 4);
					}
				} else {
					for (; EL9uW2TX > 0; --EL9uW2TX) {
						zmVgSpD0.write(HFs6uNvc.read());
					}
				}
				zmVgSpD0.close();
			}
			System.out.print('.');
		} finally {
			HFs6uNvc.close();
		}
	}

}