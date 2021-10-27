class n460892 {
	public void convert(File at1wdI4w, File mcam7Yxm) throws IOException {
		InputStream gxPm1mAf = new BufferedInputStream(new FileInputStream(at1wdI4w));
		DcmParser XoQaQwJT = pfact.newDcmParser(gxPm1mAf);
		Dataset CJdRaUhV = fact.newDataset();
		XoQaQwJT.setDcmHandler(CJdRaUhV.getDcmHandler());
		try {
			FileFormat DbvRiH2H = XoQaQwJT.detectFileFormat();
			if (DbvRiH2H != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + at1wdI4w + ": not an ACRNEMA stream!");
				return;
			}
			XoQaQwJT.parseDcmFile(DbvRiH2H, Tags.PixelData);
			if (CJdRaUhV.contains(Tags.StudyInstanceUID) || CJdRaUhV.contains(Tags.SeriesInstanceUID)
					|| CJdRaUhV.contains(Tags.SOPInstanceUID) || CJdRaUhV.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + at1wdI4w + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean YqdG9akW = XoQaQwJT.getReadTag() == Tags.PixelData;
			boolean C4nMdXhh = YqdG9akW && CJdRaUhV.getInt(Tags.BitsAllocated, 0) == 12;
			int YfY0iZZQ = XoQaQwJT.getReadLength();
			if (YqdG9akW) {
				if (C4nMdXhh) {
					CJdRaUhV.putUS(Tags.BitsAllocated, 16);
					YfY0iZZQ = YfY0iZZQ * 4 / 3;
				}
				if (YfY0iZZQ != (CJdRaUhV.getInt(Tags.BitsAllocated, 0) >>> 3) * CJdRaUhV.getInt(Tags.Rows, 0)
						* CJdRaUhV.getInt(Tags.Columns, 0) * CJdRaUhV.getInt(Tags.NumberOfFrames, 1)
						* CJdRaUhV.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + at1wdI4w + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			CJdRaUhV.putUI(Tags.StudyInstanceUID, uid(studyUID));
			CJdRaUhV.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			CJdRaUhV.putUI(Tags.SOPInstanceUID, uid(instUID));
			CJdRaUhV.putUI(Tags.SOPClassUID, classUID);
			if (!CJdRaUhV.contains(Tags.NumberOfSamples)) {
				CJdRaUhV.putUS(Tags.NumberOfSamples, 1);
			}
			if (!CJdRaUhV.contains(Tags.PhotometricInterpretation)) {
				CJdRaUhV.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				CJdRaUhV.setFileMetaInfo(fact.newFileMetaInfo(CJdRaUhV, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream sKdC73EJ = new BufferedOutputStream(new FileOutputStream(mcam7Yxm));
			try {
			} finally {
				CJdRaUhV.writeFile(sKdC73EJ, encodeParam());
				if (YqdG9akW) {
					if (!skipGroupLen) {
						sKdC73EJ.write(PXDATA_GROUPLEN);
						int Z7bjtGE6 = YfY0iZZQ + 8;
						sKdC73EJ.write((byte) Z7bjtGE6);
						sKdC73EJ.write((byte) (Z7bjtGE6 >> 8));
						sKdC73EJ.write((byte) (Z7bjtGE6 >> 16));
						sKdC73EJ.write((byte) (Z7bjtGE6 >> 24));
					}
					sKdC73EJ.write(PXDATA_TAG);
					sKdC73EJ.write((byte) YfY0iZZQ);
					sKdC73EJ.write((byte) (YfY0iZZQ >> 8));
					sKdC73EJ.write((byte) (YfY0iZZQ >> 16));
					sKdC73EJ.write((byte) (YfY0iZZQ >> 24));
				}
				if (C4nMdXhh) {
					int dsW769DN, WTu4zjj4;
					for (; YfY0iZZQ > 0; YfY0iZZQ -= 3) {
						sKdC73EJ.write(gxPm1mAf.read());
						dsW769DN = gxPm1mAf.read();
						WTu4zjj4 = gxPm1mAf.read();
						sKdC73EJ.write(dsW769DN & 0x0f);
						sKdC73EJ.write(dsW769DN >> 4 | ((WTu4zjj4 & 0x0f) << 4));
						sKdC73EJ.write(WTu4zjj4 >> 4);
					}
				} else {
					for (; YfY0iZZQ > 0; --YfY0iZZQ) {
						sKdC73EJ.write(gxPm1mAf.read());
					}
				}
				sKdC73EJ.close();
			}
			System.out.print('.');
		} finally {
			gxPm1mAf.close();
		}
	}

}