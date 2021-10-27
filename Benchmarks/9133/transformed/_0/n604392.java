class n604392 {
	public void convert(File Qi0VEKqU, File u7rZvIAp) throws IOException {
		InputStream snnyCeUs = new BufferedInputStream(new FileInputStream(Qi0VEKqU));
		DcmParser gthBnE41 = pfact.newDcmParser(snnyCeUs);
		Dataset omjIrf5C = fact.newDataset();
		gthBnE41.setDcmHandler(omjIrf5C.getDcmHandler());
		try {
			FileFormat tOsE4GKc = gthBnE41.detectFileFormat();
			if (tOsE4GKc != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + Qi0VEKqU + ": not an ACRNEMA stream!");
				return;
			}
			gthBnE41.parseDcmFile(tOsE4GKc, Tags.PixelData);
			if (omjIrf5C.contains(Tags.StudyInstanceUID) || omjIrf5C.contains(Tags.SeriesInstanceUID)
					|| omjIrf5C.contains(Tags.SOPInstanceUID) || omjIrf5C.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + Qi0VEKqU + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean lLKHaoE5 = gthBnE41.getReadTag() == Tags.PixelData;
			boolean kipFwmPX = lLKHaoE5 && omjIrf5C.getInt(Tags.BitsAllocated, 0) == 12;
			int dcdJZbwj = gthBnE41.getReadLength();
			if (lLKHaoE5) {
				if (kipFwmPX) {
					omjIrf5C.putUS(Tags.BitsAllocated, 16);
					dcdJZbwj = dcdJZbwj * 4 / 3;
				}
				if (dcdJZbwj != (omjIrf5C.getInt(Tags.BitsAllocated, 0) >>> 3) * omjIrf5C.getInt(Tags.Rows, 0)
						* omjIrf5C.getInt(Tags.Columns, 0) * omjIrf5C.getInt(Tags.NumberOfFrames, 1)
						* omjIrf5C.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + Qi0VEKqU + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			omjIrf5C.putUI(Tags.StudyInstanceUID, uid(studyUID));
			omjIrf5C.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			omjIrf5C.putUI(Tags.SOPInstanceUID, uid(instUID));
			omjIrf5C.putUI(Tags.SOPClassUID, classUID);
			if (!omjIrf5C.contains(Tags.NumberOfSamples)) {
				omjIrf5C.putUS(Tags.NumberOfSamples, 1);
			}
			if (!omjIrf5C.contains(Tags.PhotometricInterpretation)) {
				omjIrf5C.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				omjIrf5C.setFileMetaInfo(fact.newFileMetaInfo(omjIrf5C, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream HtH3CRA0 = new BufferedOutputStream(new FileOutputStream(u7rZvIAp));
			try {
			} finally {
				omjIrf5C.writeFile(HtH3CRA0, encodeParam());
				if (lLKHaoE5) {
					if (!skipGroupLen) {
						HtH3CRA0.write(PXDATA_GROUPLEN);
						int riGHD4UG = dcdJZbwj + 8;
						HtH3CRA0.write((byte) riGHD4UG);
						HtH3CRA0.write((byte) (riGHD4UG >> 8));
						HtH3CRA0.write((byte) (riGHD4UG >> 16));
						HtH3CRA0.write((byte) (riGHD4UG >> 24));
					}
					HtH3CRA0.write(PXDATA_TAG);
					HtH3CRA0.write((byte) dcdJZbwj);
					HtH3CRA0.write((byte) (dcdJZbwj >> 8));
					HtH3CRA0.write((byte) (dcdJZbwj >> 16));
					HtH3CRA0.write((byte) (dcdJZbwj >> 24));
				}
				if (kipFwmPX) {
					int Pm9j8yrx, VB0tBaJ4;
					for (; dcdJZbwj > 0; dcdJZbwj -= 3) {
						HtH3CRA0.write(snnyCeUs.read());
						Pm9j8yrx = snnyCeUs.read();
						VB0tBaJ4 = snnyCeUs.read();
						HtH3CRA0.write(Pm9j8yrx & 0x0f);
						HtH3CRA0.write(Pm9j8yrx >> 4 | ((VB0tBaJ4 & 0x0f) << 4));
						HtH3CRA0.write(VB0tBaJ4 >> 4);
					}
				} else {
					for (; dcdJZbwj > 0; --dcdJZbwj) {
						HtH3CRA0.write(snnyCeUs.read());
					}
				}
				HtH3CRA0.close();
			}
			System.out.print('.');
		} finally {
			snnyCeUs.close();
		}
	}

}