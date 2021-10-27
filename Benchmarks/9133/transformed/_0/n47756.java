class n47756 {
	public void convert(File rxl4QGVL, File C6fm44sx) throws IOException {
		InputStream xuH5pcYD = new BufferedInputStream(new FileInputStream(rxl4QGVL));
		DcmParser lZBeZvOV = pfact.newDcmParser(xuH5pcYD);
		Dataset YMrPFPM0 = fact.newDataset();
		lZBeZvOV.setDcmHandler(YMrPFPM0.getDcmHandler());
		try {
			FileFormat igrHrLqg = lZBeZvOV.detectFileFormat();
			if (igrHrLqg != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + rxl4QGVL + ": not an ACRNEMA stream!");
				return;
			}
			lZBeZvOV.parseDcmFile(igrHrLqg, Tags.PixelData);
			if (YMrPFPM0.contains(Tags.StudyInstanceUID) || YMrPFPM0.contains(Tags.SeriesInstanceUID)
					|| YMrPFPM0.contains(Tags.SOPInstanceUID) || YMrPFPM0.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + rxl4QGVL + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean D78KgVCD = lZBeZvOV.getReadTag() == Tags.PixelData;
			boolean TSGOgpTy = D78KgVCD && YMrPFPM0.getInt(Tags.BitsAllocated, 0) == 12;
			int DNN4Kpca = lZBeZvOV.getReadLength();
			if (D78KgVCD) {
				if (TSGOgpTy) {
					YMrPFPM0.putUS(Tags.BitsAllocated, 16);
					DNN4Kpca = DNN4Kpca * 4 / 3;
				}
				if (DNN4Kpca != (YMrPFPM0.getInt(Tags.BitsAllocated, 0) >>> 3) * YMrPFPM0.getInt(Tags.Rows, 0)
						* YMrPFPM0.getInt(Tags.Columns, 0) * YMrPFPM0.getInt(Tags.NumberOfFrames, 1)
						* YMrPFPM0.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + rxl4QGVL + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			YMrPFPM0.putUI(Tags.StudyInstanceUID, uid(studyUID));
			YMrPFPM0.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			YMrPFPM0.putUI(Tags.SOPInstanceUID, uid(instUID));
			YMrPFPM0.putUI(Tags.SOPClassUID, classUID);
			if (!YMrPFPM0.contains(Tags.NumberOfSamples)) {
				YMrPFPM0.putUS(Tags.NumberOfSamples, 1);
			}
			if (!YMrPFPM0.contains(Tags.PhotometricInterpretation)) {
				YMrPFPM0.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				YMrPFPM0.setFileMetaInfo(fact.newFileMetaInfo(YMrPFPM0, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream GQt0spW3 = new BufferedOutputStream(new FileOutputStream(C6fm44sx));
			try {
			} finally {
				YMrPFPM0.writeFile(GQt0spW3, encodeParam());
				if (D78KgVCD) {
					if (!skipGroupLen) {
						GQt0spW3.write(PXDATA_GROUPLEN);
						int M330ETsa = DNN4Kpca + 8;
						GQt0spW3.write((byte) M330ETsa);
						GQt0spW3.write((byte) (M330ETsa >> 8));
						GQt0spW3.write((byte) (M330ETsa >> 16));
						GQt0spW3.write((byte) (M330ETsa >> 24));
					}
					GQt0spW3.write(PXDATA_TAG);
					GQt0spW3.write((byte) DNN4Kpca);
					GQt0spW3.write((byte) (DNN4Kpca >> 8));
					GQt0spW3.write((byte) (DNN4Kpca >> 16));
					GQt0spW3.write((byte) (DNN4Kpca >> 24));
				}
				if (TSGOgpTy) {
					int xorulWGv, xZzaee0K;
					for (; DNN4Kpca > 0; DNN4Kpca -= 3) {
						GQt0spW3.write(xuH5pcYD.read());
						xorulWGv = xuH5pcYD.read();
						xZzaee0K = xuH5pcYD.read();
						GQt0spW3.write(xorulWGv & 0x0f);
						GQt0spW3.write(xorulWGv >> 4 | ((xZzaee0K & 0x0f) << 4));
						GQt0spW3.write(xZzaee0K >> 4);
					}
				} else {
					for (; DNN4Kpca > 0; --DNN4Kpca) {
						GQt0spW3.write(xuH5pcYD.read());
					}
				}
				GQt0spW3.close();
			}
			System.out.print('.');
		} finally {
			xuH5pcYD.close();
		}
	}

}