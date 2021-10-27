class n689011 {
	public void convert(File BLbTA7Vm, File j1SmOHzH) throws IOException {
		InputStream YlJupAnu = new BufferedInputStream(new FileInputStream(BLbTA7Vm));
		DcmParser gC1jiMcf = pfact.newDcmParser(YlJupAnu);
		Dataset DVLSnW1C = fact.newDataset();
		gC1jiMcf.setDcmHandler(DVLSnW1C.getDcmHandler());
		try {
			FileFormat ZC0TIInu = gC1jiMcf.detectFileFormat();
			if (ZC0TIInu != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + BLbTA7Vm + ": not an ACRNEMA stream!");
				return;
			}
			gC1jiMcf.parseDcmFile(ZC0TIInu, Tags.PixelData);
			if (DVLSnW1C.contains(Tags.StudyInstanceUID) || DVLSnW1C.contains(Tags.SeriesInstanceUID)
					|| DVLSnW1C.contains(Tags.SOPInstanceUID) || DVLSnW1C.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + BLbTA7Vm + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean hEwuRbXl = gC1jiMcf.getReadTag() == Tags.PixelData;
			boolean LSVudx02 = hEwuRbXl && DVLSnW1C.getInt(Tags.BitsAllocated, 0) == 12;
			int bOChWabk = gC1jiMcf.getReadLength();
			if (hEwuRbXl) {
				if (LSVudx02) {
					DVLSnW1C.putUS(Tags.BitsAllocated, 16);
					bOChWabk = bOChWabk * 4 / 3;
				}
				if (bOChWabk != (DVLSnW1C.getInt(Tags.BitsAllocated, 0) >>> 3) * DVLSnW1C.getInt(Tags.Rows, 0)
						* DVLSnW1C.getInt(Tags.Columns, 0) * DVLSnW1C.getInt(Tags.NumberOfFrames, 1)
						* DVLSnW1C.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + BLbTA7Vm + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			DVLSnW1C.putUI(Tags.StudyInstanceUID, uid(studyUID));
			DVLSnW1C.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			DVLSnW1C.putUI(Tags.SOPInstanceUID, uid(instUID));
			DVLSnW1C.putUI(Tags.SOPClassUID, classUID);
			if (!DVLSnW1C.contains(Tags.NumberOfSamples)) {
				DVLSnW1C.putUS(Tags.NumberOfSamples, 1);
			}
			if (!DVLSnW1C.contains(Tags.PhotometricInterpretation)) {
				DVLSnW1C.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				DVLSnW1C.setFileMetaInfo(fact.newFileMetaInfo(DVLSnW1C, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream cJvNkLhs = new BufferedOutputStream(new FileOutputStream(j1SmOHzH));
			try {
			} finally {
				DVLSnW1C.writeFile(cJvNkLhs, encodeParam());
				if (hEwuRbXl) {
					if (!skipGroupLen) {
						cJvNkLhs.write(PXDATA_GROUPLEN);
						int QtH5Z6vb = bOChWabk + 8;
						cJvNkLhs.write((byte) QtH5Z6vb);
						cJvNkLhs.write((byte) (QtH5Z6vb >> 8));
						cJvNkLhs.write((byte) (QtH5Z6vb >> 16));
						cJvNkLhs.write((byte) (QtH5Z6vb >> 24));
					}
					cJvNkLhs.write(PXDATA_TAG);
					cJvNkLhs.write((byte) bOChWabk);
					cJvNkLhs.write((byte) (bOChWabk >> 8));
					cJvNkLhs.write((byte) (bOChWabk >> 16));
					cJvNkLhs.write((byte) (bOChWabk >> 24));
				}
				if (LSVudx02) {
					int gtYInkgb, VYnzXIlE;
					for (; bOChWabk > 0; bOChWabk -= 3) {
						cJvNkLhs.write(YlJupAnu.read());
						gtYInkgb = YlJupAnu.read();
						VYnzXIlE = YlJupAnu.read();
						cJvNkLhs.write(gtYInkgb & 0x0f);
						cJvNkLhs.write(gtYInkgb >> 4 | ((VYnzXIlE & 0x0f) << 4));
						cJvNkLhs.write(VYnzXIlE >> 4);
					}
				} else {
					for (; bOChWabk > 0; --bOChWabk) {
						cJvNkLhs.write(YlJupAnu.read());
					}
				}
				cJvNkLhs.close();
			}
			System.out.print('.');
		} finally {
			YlJupAnu.close();
		}
	}

}