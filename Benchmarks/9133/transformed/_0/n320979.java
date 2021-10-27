class n320979 {
	public void convert(File U4SX18t1, File HSz7kWSq) throws IOException {
		InputStream LlXOFmhB = new BufferedInputStream(new FileInputStream(U4SX18t1));
		DcmParser IeprpiaI = pfact.newDcmParser(LlXOFmhB);
		Dataset TdO0VNL4 = fact.newDataset();
		IeprpiaI.setDcmHandler(TdO0VNL4.getDcmHandler());
		try {
			FileFormat hZ2wifw7 = IeprpiaI.detectFileFormat();
			if (hZ2wifw7 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + U4SX18t1 + ": not an ACRNEMA stream!");
				return;
			}
			IeprpiaI.parseDcmFile(hZ2wifw7, Tags.PixelData);
			if (TdO0VNL4.contains(Tags.StudyInstanceUID) || TdO0VNL4.contains(Tags.SeriesInstanceUID)
					|| TdO0VNL4.contains(Tags.SOPInstanceUID) || TdO0VNL4.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + U4SX18t1 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Cuwt5DuA = IeprpiaI.getReadTag() == Tags.PixelData;
			boolean sOWgX1J1 = Cuwt5DuA && TdO0VNL4.getInt(Tags.BitsAllocated, 0) == 12;
			int iwpt6uyT = IeprpiaI.getReadLength();
			if (Cuwt5DuA) {
				if (sOWgX1J1) {
					TdO0VNL4.putUS(Tags.BitsAllocated, 16);
					iwpt6uyT = iwpt6uyT * 4 / 3;
				}
				if (iwpt6uyT != (TdO0VNL4.getInt(Tags.BitsAllocated, 0) >>> 3) * TdO0VNL4.getInt(Tags.Rows, 0)
						* TdO0VNL4.getInt(Tags.Columns, 0) * TdO0VNL4.getInt(Tags.NumberOfFrames, 1)
						* TdO0VNL4.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + U4SX18t1 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			TdO0VNL4.putUI(Tags.StudyInstanceUID, uid(studyUID));
			TdO0VNL4.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			TdO0VNL4.putUI(Tags.SOPInstanceUID, uid(instUID));
			TdO0VNL4.putUI(Tags.SOPClassUID, classUID);
			if (!TdO0VNL4.contains(Tags.NumberOfSamples)) {
				TdO0VNL4.putUS(Tags.NumberOfSamples, 1);
			}
			if (!TdO0VNL4.contains(Tags.PhotometricInterpretation)) {
				TdO0VNL4.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				TdO0VNL4.setFileMetaInfo(fact.newFileMetaInfo(TdO0VNL4, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream sNa431zo = new BufferedOutputStream(new FileOutputStream(HSz7kWSq));
			try {
			} finally {
				TdO0VNL4.writeFile(sNa431zo, encodeParam());
				if (Cuwt5DuA) {
					if (!skipGroupLen) {
						sNa431zo.write(PXDATA_GROUPLEN);
						int DzF7oCif = iwpt6uyT + 8;
						sNa431zo.write((byte) DzF7oCif);
						sNa431zo.write((byte) (DzF7oCif >> 8));
						sNa431zo.write((byte) (DzF7oCif >> 16));
						sNa431zo.write((byte) (DzF7oCif >> 24));
					}
					sNa431zo.write(PXDATA_TAG);
					sNa431zo.write((byte) iwpt6uyT);
					sNa431zo.write((byte) (iwpt6uyT >> 8));
					sNa431zo.write((byte) (iwpt6uyT >> 16));
					sNa431zo.write((byte) (iwpt6uyT >> 24));
				}
				if (sOWgX1J1) {
					int gHDTRpp9, rgzOrUmv;
					for (; iwpt6uyT > 0; iwpt6uyT -= 3) {
						sNa431zo.write(LlXOFmhB.read());
						gHDTRpp9 = LlXOFmhB.read();
						rgzOrUmv = LlXOFmhB.read();
						sNa431zo.write(gHDTRpp9 & 0x0f);
						sNa431zo.write(gHDTRpp9 >> 4 | ((rgzOrUmv & 0x0f) << 4));
						sNa431zo.write(rgzOrUmv >> 4);
					}
				} else {
					for (; iwpt6uyT > 0; --iwpt6uyT) {
						sNa431zo.write(LlXOFmhB.read());
					}
				}
				sNa431zo.close();
			}
			System.out.print('.');
		} finally {
			LlXOFmhB.close();
		}
	}

}