class n480017 {
	public void convert(File H3emu46c, File CtMtMdyt) throws IOException {
		InputStream f00cu2hx = new BufferedInputStream(new FileInputStream(H3emu46c));
		DcmParser J6mv4vFO = pfact.newDcmParser(f00cu2hx);
		Dataset W8luPEtv = fact.newDataset();
		J6mv4vFO.setDcmHandler(W8luPEtv.getDcmHandler());
		try {
			FileFormat zkudjofu = J6mv4vFO.detectFileFormat();
			if (zkudjofu != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + H3emu46c + ": not an ACRNEMA stream!");
				return;
			}
			J6mv4vFO.parseDcmFile(zkudjofu, Tags.PixelData);
			if (W8luPEtv.contains(Tags.StudyInstanceUID) || W8luPEtv.contains(Tags.SeriesInstanceUID)
					|| W8luPEtv.contains(Tags.SOPInstanceUID) || W8luPEtv.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + H3emu46c + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean vd9FRUDf = J6mv4vFO.getReadTag() == Tags.PixelData;
			boolean MDcFY3it = vd9FRUDf && W8luPEtv.getInt(Tags.BitsAllocated, 0) == 12;
			int SWL0Wng5 = J6mv4vFO.getReadLength();
			if (vd9FRUDf) {
				if (MDcFY3it) {
					W8luPEtv.putUS(Tags.BitsAllocated, 16);
					SWL0Wng5 = SWL0Wng5 * 4 / 3;
				}
				if (SWL0Wng5 != (W8luPEtv.getInt(Tags.BitsAllocated, 0) >>> 3) * W8luPEtv.getInt(Tags.Rows, 0)
						* W8luPEtv.getInt(Tags.Columns, 0) * W8luPEtv.getInt(Tags.NumberOfFrames, 1)
						* W8luPEtv.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + H3emu46c + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			W8luPEtv.putUI(Tags.StudyInstanceUID, uid(studyUID));
			W8luPEtv.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			W8luPEtv.putUI(Tags.SOPInstanceUID, uid(instUID));
			W8luPEtv.putUI(Tags.SOPClassUID, classUID);
			if (!W8luPEtv.contains(Tags.NumberOfSamples)) {
				W8luPEtv.putUS(Tags.NumberOfSamples, 1);
			}
			if (!W8luPEtv.contains(Tags.PhotometricInterpretation)) {
				W8luPEtv.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				W8luPEtv.setFileMetaInfo(fact.newFileMetaInfo(W8luPEtv, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream uroAZyjN = new BufferedOutputStream(new FileOutputStream(CtMtMdyt));
			try {
			} finally {
				W8luPEtv.writeFile(uroAZyjN, encodeParam());
				if (vd9FRUDf) {
					if (!skipGroupLen) {
						uroAZyjN.write(PXDATA_GROUPLEN);
						int b3qam0fv = SWL0Wng5 + 8;
						uroAZyjN.write((byte) b3qam0fv);
						uroAZyjN.write((byte) (b3qam0fv >> 8));
						uroAZyjN.write((byte) (b3qam0fv >> 16));
						uroAZyjN.write((byte) (b3qam0fv >> 24));
					}
					uroAZyjN.write(PXDATA_TAG);
					uroAZyjN.write((byte) SWL0Wng5);
					uroAZyjN.write((byte) (SWL0Wng5 >> 8));
					uroAZyjN.write((byte) (SWL0Wng5 >> 16));
					uroAZyjN.write((byte) (SWL0Wng5 >> 24));
				}
				if (MDcFY3it) {
					int Ki1gjLD6, hPjPwBTE;
					for (; SWL0Wng5 > 0; SWL0Wng5 -= 3) {
						uroAZyjN.write(f00cu2hx.read());
						Ki1gjLD6 = f00cu2hx.read();
						hPjPwBTE = f00cu2hx.read();
						uroAZyjN.write(Ki1gjLD6 & 0x0f);
						uroAZyjN.write(Ki1gjLD6 >> 4 | ((hPjPwBTE & 0x0f) << 4));
						uroAZyjN.write(hPjPwBTE >> 4);
					}
				} else {
					for (; SWL0Wng5 > 0; --SWL0Wng5) {
						uroAZyjN.write(f00cu2hx.read());
					}
				}
				uroAZyjN.close();
			}
			System.out.print('.');
		} finally {
			f00cu2hx.close();
		}
	}

}