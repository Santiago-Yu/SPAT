class n737699 {
	public void convert(File sUFfUuty, File aruXBByB) throws IOException {
		InputStream jVn7gcty = new BufferedInputStream(new FileInputStream(sUFfUuty));
		DcmParser Lq0UkPXA = pfact.newDcmParser(jVn7gcty);
		Dataset Dl6AH6tr = fact.newDataset();
		Lq0UkPXA.setDcmHandler(Dl6AH6tr.getDcmHandler());
		try {
			FileFormat HcvL2Wni = Lq0UkPXA.detectFileFormat();
			if (HcvL2Wni != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + sUFfUuty + ": not an ACRNEMA stream!");
				return;
			}
			Lq0UkPXA.parseDcmFile(HcvL2Wni, Tags.PixelData);
			if (Dl6AH6tr.contains(Tags.StudyInstanceUID) || Dl6AH6tr.contains(Tags.SeriesInstanceUID)
					|| Dl6AH6tr.contains(Tags.SOPInstanceUID) || Dl6AH6tr.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + sUFfUuty + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean Cb2zQ5zl = Lq0UkPXA.getReadTag() == Tags.PixelData;
			boolean kAG9rSTH = Cb2zQ5zl && Dl6AH6tr.getInt(Tags.BitsAllocated, 0) == 12;
			int HvBuLtwH = Lq0UkPXA.getReadLength();
			if (Cb2zQ5zl) {
				if (kAG9rSTH) {
					Dl6AH6tr.putUS(Tags.BitsAllocated, 16);
					HvBuLtwH = HvBuLtwH * 4 / 3;
				}
				if (HvBuLtwH != (Dl6AH6tr.getInt(Tags.BitsAllocated, 0) >>> 3) * Dl6AH6tr.getInt(Tags.Rows, 0)
						* Dl6AH6tr.getInt(Tags.Columns, 0) * Dl6AH6tr.getInt(Tags.NumberOfFrames, 1)
						* Dl6AH6tr.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + sUFfUuty + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			Dl6AH6tr.putUI(Tags.StudyInstanceUID, uid(studyUID));
			Dl6AH6tr.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			Dl6AH6tr.putUI(Tags.SOPInstanceUID, uid(instUID));
			Dl6AH6tr.putUI(Tags.SOPClassUID, classUID);
			if (!Dl6AH6tr.contains(Tags.NumberOfSamples)) {
				Dl6AH6tr.putUS(Tags.NumberOfSamples, 1);
			}
			if (!Dl6AH6tr.contains(Tags.PhotometricInterpretation)) {
				Dl6AH6tr.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				Dl6AH6tr.setFileMetaInfo(fact.newFileMetaInfo(Dl6AH6tr, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream hwD462eP = new BufferedOutputStream(new FileOutputStream(aruXBByB));
			try {
			} finally {
				Dl6AH6tr.writeFile(hwD462eP, encodeParam());
				if (Cb2zQ5zl) {
					if (!skipGroupLen) {
						hwD462eP.write(PXDATA_GROUPLEN);
						int KwNcOeWE = HvBuLtwH + 8;
						hwD462eP.write((byte) KwNcOeWE);
						hwD462eP.write((byte) (KwNcOeWE >> 8));
						hwD462eP.write((byte) (KwNcOeWE >> 16));
						hwD462eP.write((byte) (KwNcOeWE >> 24));
					}
					hwD462eP.write(PXDATA_TAG);
					hwD462eP.write((byte) HvBuLtwH);
					hwD462eP.write((byte) (HvBuLtwH >> 8));
					hwD462eP.write((byte) (HvBuLtwH >> 16));
					hwD462eP.write((byte) (HvBuLtwH >> 24));
				}
				if (kAG9rSTH) {
					int krLxa9tM, aflS9r4J;
					for (; HvBuLtwH > 0; HvBuLtwH -= 3) {
						hwD462eP.write(jVn7gcty.read());
						krLxa9tM = jVn7gcty.read();
						aflS9r4J = jVn7gcty.read();
						hwD462eP.write(krLxa9tM & 0x0f);
						hwD462eP.write(krLxa9tM >> 4 | ((aflS9r4J & 0x0f) << 4));
						hwD462eP.write(aflS9r4J >> 4);
					}
				} else {
					for (; HvBuLtwH > 0; --HvBuLtwH) {
						hwD462eP.write(jVn7gcty.read());
					}
				}
				hwD462eP.close();
			}
			System.out.print('.');
		} finally {
			jVn7gcty.close();
		}
	}

}