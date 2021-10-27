class n628819 {
	public void convert(File NRVsENQl, File vKKI8fNL) throws IOException {
		InputStream RQ8dwHFF = new BufferedInputStream(new FileInputStream(NRVsENQl));
		DcmParser uKbTbQCc = pfact.newDcmParser(RQ8dwHFF);
		Dataset GHnya1Bc = fact.newDataset();
		uKbTbQCc.setDcmHandler(GHnya1Bc.getDcmHandler());
		try {
			FileFormat QJ4sgjSb = uKbTbQCc.detectFileFormat();
			if (QJ4sgjSb != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + NRVsENQl + ": not an ACRNEMA stream!");
				return;
			}
			uKbTbQCc.parseDcmFile(QJ4sgjSb, Tags.PixelData);
			if (GHnya1Bc.contains(Tags.StudyInstanceUID) || GHnya1Bc.contains(Tags.SeriesInstanceUID)
					|| GHnya1Bc.contains(Tags.SOPInstanceUID) || GHnya1Bc.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + NRVsENQl + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean VG8SlLmB = uKbTbQCc.getReadTag() == Tags.PixelData;
			boolean hLwr1BC1 = VG8SlLmB && GHnya1Bc.getInt(Tags.BitsAllocated, 0) == 12;
			int q8LwHmlA = uKbTbQCc.getReadLength();
			if (VG8SlLmB) {
				if (hLwr1BC1) {
					GHnya1Bc.putUS(Tags.BitsAllocated, 16);
					q8LwHmlA = q8LwHmlA * 4 / 3;
				}
				if (q8LwHmlA != (GHnya1Bc.getInt(Tags.BitsAllocated, 0) >>> 3) * GHnya1Bc.getInt(Tags.Rows, 0)
						* GHnya1Bc.getInt(Tags.Columns, 0) * GHnya1Bc.getInt(Tags.NumberOfFrames, 1)
						* GHnya1Bc.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + NRVsENQl + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			GHnya1Bc.putUI(Tags.StudyInstanceUID, uid(studyUID));
			GHnya1Bc.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			GHnya1Bc.putUI(Tags.SOPInstanceUID, uid(instUID));
			GHnya1Bc.putUI(Tags.SOPClassUID, classUID);
			if (!GHnya1Bc.contains(Tags.NumberOfSamples)) {
				GHnya1Bc.putUS(Tags.NumberOfSamples, 1);
			}
			if (!GHnya1Bc.contains(Tags.PhotometricInterpretation)) {
				GHnya1Bc.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				GHnya1Bc.setFileMetaInfo(fact.newFileMetaInfo(GHnya1Bc, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream xFZ8Oqmf = new BufferedOutputStream(new FileOutputStream(vKKI8fNL));
			try {
			} finally {
				GHnya1Bc.writeFile(xFZ8Oqmf, encodeParam());
				if (VG8SlLmB) {
					if (!skipGroupLen) {
						xFZ8Oqmf.write(PXDATA_GROUPLEN);
						int aWCXFjJr = q8LwHmlA + 8;
						xFZ8Oqmf.write((byte) aWCXFjJr);
						xFZ8Oqmf.write((byte) (aWCXFjJr >> 8));
						xFZ8Oqmf.write((byte) (aWCXFjJr >> 16));
						xFZ8Oqmf.write((byte) (aWCXFjJr >> 24));
					}
					xFZ8Oqmf.write(PXDATA_TAG);
					xFZ8Oqmf.write((byte) q8LwHmlA);
					xFZ8Oqmf.write((byte) (q8LwHmlA >> 8));
					xFZ8Oqmf.write((byte) (q8LwHmlA >> 16));
					xFZ8Oqmf.write((byte) (q8LwHmlA >> 24));
				}
				if (hLwr1BC1) {
					int ff50Xjfs, yQI6f5IP;
					for (; q8LwHmlA > 0; q8LwHmlA -= 3) {
						xFZ8Oqmf.write(RQ8dwHFF.read());
						ff50Xjfs = RQ8dwHFF.read();
						yQI6f5IP = RQ8dwHFF.read();
						xFZ8Oqmf.write(ff50Xjfs & 0x0f);
						xFZ8Oqmf.write(ff50Xjfs >> 4 | ((yQI6f5IP & 0x0f) << 4));
						xFZ8Oqmf.write(yQI6f5IP >> 4);
					}
				} else {
					for (; q8LwHmlA > 0; --q8LwHmlA) {
						xFZ8Oqmf.write(RQ8dwHFF.read());
					}
				}
				xFZ8Oqmf.close();
			}
			System.out.print('.');
		} finally {
			RQ8dwHFF.close();
		}
	}

}