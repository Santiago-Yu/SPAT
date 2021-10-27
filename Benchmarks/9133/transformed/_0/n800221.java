class n800221 {
	public void convert(File sI8oSbUp, File mjH9DZ8k) throws IOException {
		InputStream IlkMF4FZ = new BufferedInputStream(new FileInputStream(sI8oSbUp));
		DcmParser Uo5McTBc = pfact.newDcmParser(IlkMF4FZ);
		Dataset TamVjGUT = fact.newDataset();
		Uo5McTBc.setDcmHandler(TamVjGUT.getDcmHandler());
		try {
			FileFormat Joa4EEPV = Uo5McTBc.detectFileFormat();
			if (Joa4EEPV != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + sI8oSbUp + ": not an ACRNEMA stream!");
				return;
			}
			Uo5McTBc.parseDcmFile(Joa4EEPV, Tags.PixelData);
			if (TamVjGUT.contains(Tags.StudyInstanceUID) || TamVjGUT.contains(Tags.SeriesInstanceUID)
					|| TamVjGUT.contains(Tags.SOPInstanceUID) || TamVjGUT.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + sI8oSbUp + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean k7QJXE1R = Uo5McTBc.getReadTag() == Tags.PixelData;
			boolean VmvoPIxk = k7QJXE1R && TamVjGUT.getInt(Tags.BitsAllocated, 0) == 12;
			int sQiqhmfa = Uo5McTBc.getReadLength();
			if (k7QJXE1R) {
				if (VmvoPIxk) {
					TamVjGUT.putUS(Tags.BitsAllocated, 16);
					sQiqhmfa = sQiqhmfa * 4 / 3;
				}
				if (sQiqhmfa != (TamVjGUT.getInt(Tags.BitsAllocated, 0) >>> 3) * TamVjGUT.getInt(Tags.Rows, 0)
						* TamVjGUT.getInt(Tags.Columns, 0) * TamVjGUT.getInt(Tags.NumberOfFrames, 1)
						* TamVjGUT.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + sI8oSbUp + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			TamVjGUT.putUI(Tags.StudyInstanceUID, uid(studyUID));
			TamVjGUT.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			TamVjGUT.putUI(Tags.SOPInstanceUID, uid(instUID));
			TamVjGUT.putUI(Tags.SOPClassUID, classUID);
			if (!TamVjGUT.contains(Tags.NumberOfSamples)) {
				TamVjGUT.putUS(Tags.NumberOfSamples, 1);
			}
			if (!TamVjGUT.contains(Tags.PhotometricInterpretation)) {
				TamVjGUT.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				TamVjGUT.setFileMetaInfo(fact.newFileMetaInfo(TamVjGUT, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream Cm4NkuWh = new BufferedOutputStream(new FileOutputStream(mjH9DZ8k));
			try {
			} finally {
				TamVjGUT.writeFile(Cm4NkuWh, encodeParam());
				if (k7QJXE1R) {
					if (!skipGroupLen) {
						Cm4NkuWh.write(PXDATA_GROUPLEN);
						int jxSrnCtO = sQiqhmfa + 8;
						Cm4NkuWh.write((byte) jxSrnCtO);
						Cm4NkuWh.write((byte) (jxSrnCtO >> 8));
						Cm4NkuWh.write((byte) (jxSrnCtO >> 16));
						Cm4NkuWh.write((byte) (jxSrnCtO >> 24));
					}
					Cm4NkuWh.write(PXDATA_TAG);
					Cm4NkuWh.write((byte) sQiqhmfa);
					Cm4NkuWh.write((byte) (sQiqhmfa >> 8));
					Cm4NkuWh.write((byte) (sQiqhmfa >> 16));
					Cm4NkuWh.write((byte) (sQiqhmfa >> 24));
				}
				if (VmvoPIxk) {
					int v2rTGV9I, B6hafMQs;
					for (; sQiqhmfa > 0; sQiqhmfa -= 3) {
						Cm4NkuWh.write(IlkMF4FZ.read());
						v2rTGV9I = IlkMF4FZ.read();
						B6hafMQs = IlkMF4FZ.read();
						Cm4NkuWh.write(v2rTGV9I & 0x0f);
						Cm4NkuWh.write(v2rTGV9I >> 4 | ((B6hafMQs & 0x0f) << 4));
						Cm4NkuWh.write(B6hafMQs >> 4);
					}
				} else {
					for (; sQiqhmfa > 0; --sQiqhmfa) {
						Cm4NkuWh.write(IlkMF4FZ.read());
					}
				}
				Cm4NkuWh.close();
			}
			System.out.print('.');
		} finally {
			IlkMF4FZ.close();
		}
	}

}