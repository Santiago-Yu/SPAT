class n119263 {
	public void convert(File JA6HBLQb, File pnPBEIv6) throws IOException {
		InputStream yP6Ld0wd = new BufferedInputStream(new FileInputStream(JA6HBLQb));
		DcmParser IwrkpGoa = pfact.newDcmParser(yP6Ld0wd);
		Dataset CJF7kxjs = fact.newDataset();
		IwrkpGoa.setDcmHandler(CJF7kxjs.getDcmHandler());
		try {
			FileFormat vAKHXzGz = IwrkpGoa.detectFileFormat();
			if (vAKHXzGz != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + JA6HBLQb + ": not an ACRNEMA stream!");
				return;
			}
			IwrkpGoa.parseDcmFile(vAKHXzGz, Tags.PixelData);
			if (CJF7kxjs.contains(Tags.StudyInstanceUID) || CJF7kxjs.contains(Tags.SeriesInstanceUID)
					|| CJF7kxjs.contains(Tags.SOPInstanceUID) || CJF7kxjs.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + JA6HBLQb + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean SY9mCPqJ = IwrkpGoa.getReadTag() == Tags.PixelData;
			boolean rmmR92ZD = SY9mCPqJ && CJF7kxjs.getInt(Tags.BitsAllocated, 0) == 12;
			int RWWOhLee = IwrkpGoa.getReadLength();
			if (SY9mCPqJ) {
				if (rmmR92ZD) {
					CJF7kxjs.putUS(Tags.BitsAllocated, 16);
					RWWOhLee = RWWOhLee * 4 / 3;
				}
				if (RWWOhLee != (CJF7kxjs.getInt(Tags.BitsAllocated, 0) >>> 3) * CJF7kxjs.getInt(Tags.Rows, 0)
						* CJF7kxjs.getInt(Tags.Columns, 0) * CJF7kxjs.getInt(Tags.NumberOfFrames, 1)
						* CJF7kxjs.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + JA6HBLQb + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			CJF7kxjs.putUI(Tags.StudyInstanceUID, uid(studyUID));
			CJF7kxjs.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			CJF7kxjs.putUI(Tags.SOPInstanceUID, uid(instUID));
			CJF7kxjs.putUI(Tags.SOPClassUID, classUID);
			if (!CJF7kxjs.contains(Tags.NumberOfSamples)) {
				CJF7kxjs.putUS(Tags.NumberOfSamples, 1);
			}
			if (!CJF7kxjs.contains(Tags.PhotometricInterpretation)) {
				CJF7kxjs.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				CJF7kxjs.setFileMetaInfo(fact.newFileMetaInfo(CJF7kxjs, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream kzGiSONu = new BufferedOutputStream(new FileOutputStream(pnPBEIv6));
			try {
			} finally {
				CJF7kxjs.writeFile(kzGiSONu, encodeParam());
				if (SY9mCPqJ) {
					if (!skipGroupLen) {
						kzGiSONu.write(PXDATA_GROUPLEN);
						int DpuQhHO6 = RWWOhLee + 8;
						kzGiSONu.write((byte) DpuQhHO6);
						kzGiSONu.write((byte) (DpuQhHO6 >> 8));
						kzGiSONu.write((byte) (DpuQhHO6 >> 16));
						kzGiSONu.write((byte) (DpuQhHO6 >> 24));
					}
					kzGiSONu.write(PXDATA_TAG);
					kzGiSONu.write((byte) RWWOhLee);
					kzGiSONu.write((byte) (RWWOhLee >> 8));
					kzGiSONu.write((byte) (RWWOhLee >> 16));
					kzGiSONu.write((byte) (RWWOhLee >> 24));
				}
				if (rmmR92ZD) {
					int L4PCyNzU, yCckQAYh;
					for (; RWWOhLee > 0; RWWOhLee -= 3) {
						kzGiSONu.write(yP6Ld0wd.read());
						L4PCyNzU = yP6Ld0wd.read();
						yCckQAYh = yP6Ld0wd.read();
						kzGiSONu.write(L4PCyNzU & 0x0f);
						kzGiSONu.write(L4PCyNzU >> 4 | ((yCckQAYh & 0x0f) << 4));
						kzGiSONu.write(yCckQAYh >> 4);
					}
				} else {
					for (; RWWOhLee > 0; --RWWOhLee) {
						kzGiSONu.write(yP6Ld0wd.read());
					}
				}
				kzGiSONu.close();
			}
			System.out.print('.');
		} finally {
			yP6Ld0wd.close();
		}
	}

}