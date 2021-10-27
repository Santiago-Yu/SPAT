class n310182 {
	public void convert(File UvxiOrZy, File yaJtFwtO) throws IOException {
		InputStream yoDGEgFq = new BufferedInputStream(new FileInputStream(UvxiOrZy));
		DcmParser B32nxAuF = pfact.newDcmParser(yoDGEgFq);
		Dataset RzzOwF6n = fact.newDataset();
		B32nxAuF.setDcmHandler(RzzOwF6n.getDcmHandler());
		try {
			FileFormat XyT9tSLH = B32nxAuF.detectFileFormat();
			if (XyT9tSLH != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + UvxiOrZy + ": not an ACRNEMA stream!");
				return;
			}
			B32nxAuF.parseDcmFile(XyT9tSLH, Tags.PixelData);
			if (RzzOwF6n.contains(Tags.StudyInstanceUID) || RzzOwF6n.contains(Tags.SeriesInstanceUID)
					|| RzzOwF6n.contains(Tags.SOPInstanceUID) || RzzOwF6n.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + UvxiOrZy + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean yifmlhQ6 = B32nxAuF.getReadTag() == Tags.PixelData;
			boolean yTRMEX8R = yifmlhQ6 && RzzOwF6n.getInt(Tags.BitsAllocated, 0) == 12;
			int OzAJVTio = B32nxAuF.getReadLength();
			if (yifmlhQ6) {
				if (yTRMEX8R) {
					RzzOwF6n.putUS(Tags.BitsAllocated, 16);
					OzAJVTio = OzAJVTio * 4 / 3;
				}
				if (OzAJVTio != (RzzOwF6n.getInt(Tags.BitsAllocated, 0) >>> 3) * RzzOwF6n.getInt(Tags.Rows, 0)
						* RzzOwF6n.getInt(Tags.Columns, 0) * RzzOwF6n.getInt(Tags.NumberOfFrames, 1)
						* RzzOwF6n.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + UvxiOrZy + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			RzzOwF6n.putUI(Tags.StudyInstanceUID, uid(studyUID));
			RzzOwF6n.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			RzzOwF6n.putUI(Tags.SOPInstanceUID, uid(instUID));
			RzzOwF6n.putUI(Tags.SOPClassUID, classUID);
			if (!RzzOwF6n.contains(Tags.NumberOfSamples)) {
				RzzOwF6n.putUS(Tags.NumberOfSamples, 1);
			}
			if (!RzzOwF6n.contains(Tags.PhotometricInterpretation)) {
				RzzOwF6n.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				RzzOwF6n.setFileMetaInfo(fact.newFileMetaInfo(RzzOwF6n, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream YBz0IB5C = new BufferedOutputStream(new FileOutputStream(yaJtFwtO));
			try {
			} finally {
				RzzOwF6n.writeFile(YBz0IB5C, encodeParam());
				if (yifmlhQ6) {
					if (!skipGroupLen) {
						YBz0IB5C.write(PXDATA_GROUPLEN);
						int fZ1uPt5G = OzAJVTio + 8;
						YBz0IB5C.write((byte) fZ1uPt5G);
						YBz0IB5C.write((byte) (fZ1uPt5G >> 8));
						YBz0IB5C.write((byte) (fZ1uPt5G >> 16));
						YBz0IB5C.write((byte) (fZ1uPt5G >> 24));
					}
					YBz0IB5C.write(PXDATA_TAG);
					YBz0IB5C.write((byte) OzAJVTio);
					YBz0IB5C.write((byte) (OzAJVTio >> 8));
					YBz0IB5C.write((byte) (OzAJVTio >> 16));
					YBz0IB5C.write((byte) (OzAJVTio >> 24));
				}
				if (yTRMEX8R) {
					int rYcwvJRS, vuLB8TMD;
					for (; OzAJVTio > 0; OzAJVTio -= 3) {
						YBz0IB5C.write(yoDGEgFq.read());
						rYcwvJRS = yoDGEgFq.read();
						vuLB8TMD = yoDGEgFq.read();
						YBz0IB5C.write(rYcwvJRS & 0x0f);
						YBz0IB5C.write(rYcwvJRS >> 4 | ((vuLB8TMD & 0x0f) << 4));
						YBz0IB5C.write(vuLB8TMD >> 4);
					}
				} else {
					for (; OzAJVTio > 0; --OzAJVTio) {
						YBz0IB5C.write(yoDGEgFq.read());
					}
				}
				YBz0IB5C.close();
			}
			System.out.print('.');
		} finally {
			yoDGEgFq.close();
		}
	}

}