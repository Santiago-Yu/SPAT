class n433062 {
	public void convert(File BKbc0W41, File Y6gROvZt) throws IOException {
		InputStream oivV19aX = new BufferedInputStream(new FileInputStream(BKbc0W41));
		DcmParser ug8NLi1v = pfact.newDcmParser(oivV19aX);
		Dataset n6ifnewy = fact.newDataset();
		ug8NLi1v.setDcmHandler(n6ifnewy.getDcmHandler());
		try {
			FileFormat Ab3ER7aF = ug8NLi1v.detectFileFormat();
			if (Ab3ER7aF != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + BKbc0W41 + ": not an ACRNEMA stream!");
				return;
			}
			ug8NLi1v.parseDcmFile(Ab3ER7aF, Tags.PixelData);
			if (n6ifnewy.contains(Tags.StudyInstanceUID) || n6ifnewy.contains(Tags.SeriesInstanceUID)
					|| n6ifnewy.contains(Tags.SOPInstanceUID) || n6ifnewy.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + BKbc0W41 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean dc9micZr = ug8NLi1v.getReadTag() == Tags.PixelData;
			boolean eeQop84L = dc9micZr && n6ifnewy.getInt(Tags.BitsAllocated, 0) == 12;
			int MEucmoVG = ug8NLi1v.getReadLength();
			if (dc9micZr) {
				if (eeQop84L) {
					n6ifnewy.putUS(Tags.BitsAllocated, 16);
					MEucmoVG = MEucmoVG * 4 / 3;
				}
				if (MEucmoVG != (n6ifnewy.getInt(Tags.BitsAllocated, 0) >>> 3) * n6ifnewy.getInt(Tags.Rows, 0)
						* n6ifnewy.getInt(Tags.Columns, 0) * n6ifnewy.getInt(Tags.NumberOfFrames, 1)
						* n6ifnewy.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + BKbc0W41 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			n6ifnewy.putUI(Tags.StudyInstanceUID, uid(studyUID));
			n6ifnewy.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			n6ifnewy.putUI(Tags.SOPInstanceUID, uid(instUID));
			n6ifnewy.putUI(Tags.SOPClassUID, classUID);
			if (!n6ifnewy.contains(Tags.NumberOfSamples)) {
				n6ifnewy.putUS(Tags.NumberOfSamples, 1);
			}
			if (!n6ifnewy.contains(Tags.PhotometricInterpretation)) {
				n6ifnewy.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				n6ifnewy.setFileMetaInfo(fact.newFileMetaInfo(n6ifnewy, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream rz1RlLu1 = new BufferedOutputStream(new FileOutputStream(Y6gROvZt));
			try {
			} finally {
				n6ifnewy.writeFile(rz1RlLu1, encodeParam());
				if (dc9micZr) {
					if (!skipGroupLen) {
						rz1RlLu1.write(PXDATA_GROUPLEN);
						int FmMpk9Ru = MEucmoVG + 8;
						rz1RlLu1.write((byte) FmMpk9Ru);
						rz1RlLu1.write((byte) (FmMpk9Ru >> 8));
						rz1RlLu1.write((byte) (FmMpk9Ru >> 16));
						rz1RlLu1.write((byte) (FmMpk9Ru >> 24));
					}
					rz1RlLu1.write(PXDATA_TAG);
					rz1RlLu1.write((byte) MEucmoVG);
					rz1RlLu1.write((byte) (MEucmoVG >> 8));
					rz1RlLu1.write((byte) (MEucmoVG >> 16));
					rz1RlLu1.write((byte) (MEucmoVG >> 24));
				}
				if (eeQop84L) {
					int aIToVbCl, gtIiryC2;
					for (; MEucmoVG > 0; MEucmoVG -= 3) {
						rz1RlLu1.write(oivV19aX.read());
						aIToVbCl = oivV19aX.read();
						gtIiryC2 = oivV19aX.read();
						rz1RlLu1.write(aIToVbCl & 0x0f);
						rz1RlLu1.write(aIToVbCl >> 4 | ((gtIiryC2 & 0x0f) << 4));
						rz1RlLu1.write(gtIiryC2 >> 4);
					}
				} else {
					for (; MEucmoVG > 0; --MEucmoVG) {
						rz1RlLu1.write(oivV19aX.read());
					}
				}
				rz1RlLu1.close();
			}
			System.out.print('.');
		} finally {
			oivV19aX.close();
		}
	}

}