class n492619 {
	public void convert(File wdo7rkPa, File Fu5jctzp) throws IOException {
		InputStream ZUjUTxi6 = new BufferedInputStream(new FileInputStream(wdo7rkPa));
		DcmParser NIL6iH7P = pfact.newDcmParser(ZUjUTxi6);
		Dataset hZnHBG8P = fact.newDataset();
		NIL6iH7P.setDcmHandler(hZnHBG8P.getDcmHandler());
		try {
			FileFormat WPoDvqAh = NIL6iH7P.detectFileFormat();
			if (WPoDvqAh != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + wdo7rkPa + ": not an ACRNEMA stream!");
				return;
			}
			NIL6iH7P.parseDcmFile(WPoDvqAh, Tags.PixelData);
			if (hZnHBG8P.contains(Tags.StudyInstanceUID) || hZnHBG8P.contains(Tags.SeriesInstanceUID)
					|| hZnHBG8P.contains(Tags.SOPInstanceUID) || hZnHBG8P.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + wdo7rkPa + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean zai2xXiB = NIL6iH7P.getReadTag() == Tags.PixelData;
			boolean qJHfElBV = zai2xXiB && hZnHBG8P.getInt(Tags.BitsAllocated, 0) == 12;
			int GEqbx988 = NIL6iH7P.getReadLength();
			if (zai2xXiB) {
				if (qJHfElBV) {
					hZnHBG8P.putUS(Tags.BitsAllocated, 16);
					GEqbx988 = GEqbx988 * 4 / 3;
				}
				if (GEqbx988 != (hZnHBG8P.getInt(Tags.BitsAllocated, 0) >>> 3) * hZnHBG8P.getInt(Tags.Rows, 0)
						* hZnHBG8P.getInt(Tags.Columns, 0) * hZnHBG8P.getInt(Tags.NumberOfFrames, 1)
						* hZnHBG8P.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + wdo7rkPa + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			hZnHBG8P.putUI(Tags.StudyInstanceUID, uid(studyUID));
			hZnHBG8P.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			hZnHBG8P.putUI(Tags.SOPInstanceUID, uid(instUID));
			hZnHBG8P.putUI(Tags.SOPClassUID, classUID);
			if (!hZnHBG8P.contains(Tags.NumberOfSamples)) {
				hZnHBG8P.putUS(Tags.NumberOfSamples, 1);
			}
			if (!hZnHBG8P.contains(Tags.PhotometricInterpretation)) {
				hZnHBG8P.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				hZnHBG8P.setFileMetaInfo(fact.newFileMetaInfo(hZnHBG8P, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream YnKT9O4h = new BufferedOutputStream(new FileOutputStream(Fu5jctzp));
			try {
			} finally {
				hZnHBG8P.writeFile(YnKT9O4h, encodeParam());
				if (zai2xXiB) {
					if (!skipGroupLen) {
						YnKT9O4h.write(PXDATA_GROUPLEN);
						int ApRTl0GR = GEqbx988 + 8;
						YnKT9O4h.write((byte) ApRTl0GR);
						YnKT9O4h.write((byte) (ApRTl0GR >> 8));
						YnKT9O4h.write((byte) (ApRTl0GR >> 16));
						YnKT9O4h.write((byte) (ApRTl0GR >> 24));
					}
					YnKT9O4h.write(PXDATA_TAG);
					YnKT9O4h.write((byte) GEqbx988);
					YnKT9O4h.write((byte) (GEqbx988 >> 8));
					YnKT9O4h.write((byte) (GEqbx988 >> 16));
					YnKT9O4h.write((byte) (GEqbx988 >> 24));
				}
				if (qJHfElBV) {
					int jGLyPwWd, lPsOAAQF;
					for (; GEqbx988 > 0; GEqbx988 -= 3) {
						YnKT9O4h.write(ZUjUTxi6.read());
						jGLyPwWd = ZUjUTxi6.read();
						lPsOAAQF = ZUjUTxi6.read();
						YnKT9O4h.write(jGLyPwWd & 0x0f);
						YnKT9O4h.write(jGLyPwWd >> 4 | ((lPsOAAQF & 0x0f) << 4));
						YnKT9O4h.write(lPsOAAQF >> 4);
					}
				} else {
					for (; GEqbx988 > 0; --GEqbx988) {
						YnKT9O4h.write(ZUjUTxi6.read());
					}
				}
				YnKT9O4h.close();
			}
			System.out.print('.');
		} finally {
			ZUjUTxi6.close();
		}
	}

}