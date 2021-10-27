class n441377 {
	public void convert(File qzsHKsdv, File l5FTic9P) throws IOException {
		InputStream mgIDKZIK = new BufferedInputStream(new FileInputStream(qzsHKsdv));
		DcmParser aj2PUN2E = pfact.newDcmParser(mgIDKZIK);
		Dataset C7UpvCxJ = fact.newDataset();
		aj2PUN2E.setDcmHandler(C7UpvCxJ.getDcmHandler());
		try {
			FileFormat jeRZn9tG = aj2PUN2E.detectFileFormat();
			if (jeRZn9tG != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + qzsHKsdv + ": not an ACRNEMA stream!");
				return;
			}
			aj2PUN2E.parseDcmFile(jeRZn9tG, Tags.PixelData);
			if (C7UpvCxJ.contains(Tags.StudyInstanceUID) || C7UpvCxJ.contains(Tags.SeriesInstanceUID)
					|| C7UpvCxJ.contains(Tags.SOPInstanceUID) || C7UpvCxJ.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + qzsHKsdv + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean XUaSpA3O = aj2PUN2E.getReadTag() == Tags.PixelData;
			boolean Ta9cbqiU = XUaSpA3O && C7UpvCxJ.getInt(Tags.BitsAllocated, 0) == 12;
			int JQj6iy3l = aj2PUN2E.getReadLength();
			if (XUaSpA3O) {
				if (Ta9cbqiU) {
					C7UpvCxJ.putUS(Tags.BitsAllocated, 16);
					JQj6iy3l = JQj6iy3l * 4 / 3;
				}
				if (JQj6iy3l != (C7UpvCxJ.getInt(Tags.BitsAllocated, 0) >>> 3) * C7UpvCxJ.getInt(Tags.Rows, 0)
						* C7UpvCxJ.getInt(Tags.Columns, 0) * C7UpvCxJ.getInt(Tags.NumberOfFrames, 1)
						* C7UpvCxJ.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + qzsHKsdv + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			C7UpvCxJ.putUI(Tags.StudyInstanceUID, uid(studyUID));
			C7UpvCxJ.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			C7UpvCxJ.putUI(Tags.SOPInstanceUID, uid(instUID));
			C7UpvCxJ.putUI(Tags.SOPClassUID, classUID);
			if (!C7UpvCxJ.contains(Tags.NumberOfSamples)) {
				C7UpvCxJ.putUS(Tags.NumberOfSamples, 1);
			}
			if (!C7UpvCxJ.contains(Tags.PhotometricInterpretation)) {
				C7UpvCxJ.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				C7UpvCxJ.setFileMetaInfo(fact.newFileMetaInfo(C7UpvCxJ, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream kEpqIcPM = new BufferedOutputStream(new FileOutputStream(l5FTic9P));
			try {
			} finally {
				C7UpvCxJ.writeFile(kEpqIcPM, encodeParam());
				if (XUaSpA3O) {
					if (!skipGroupLen) {
						kEpqIcPM.write(PXDATA_GROUPLEN);
						int De97qcBE = JQj6iy3l + 8;
						kEpqIcPM.write((byte) De97qcBE);
						kEpqIcPM.write((byte) (De97qcBE >> 8));
						kEpqIcPM.write((byte) (De97qcBE >> 16));
						kEpqIcPM.write((byte) (De97qcBE >> 24));
					}
					kEpqIcPM.write(PXDATA_TAG);
					kEpqIcPM.write((byte) JQj6iy3l);
					kEpqIcPM.write((byte) (JQj6iy3l >> 8));
					kEpqIcPM.write((byte) (JQj6iy3l >> 16));
					kEpqIcPM.write((byte) (JQj6iy3l >> 24));
				}
				if (Ta9cbqiU) {
					int z7Vd3BZx, PzJ8wtuB;
					for (; JQj6iy3l > 0; JQj6iy3l -= 3) {
						kEpqIcPM.write(mgIDKZIK.read());
						z7Vd3BZx = mgIDKZIK.read();
						PzJ8wtuB = mgIDKZIK.read();
						kEpqIcPM.write(z7Vd3BZx & 0x0f);
						kEpqIcPM.write(z7Vd3BZx >> 4 | ((PzJ8wtuB & 0x0f) << 4));
						kEpqIcPM.write(PzJ8wtuB >> 4);
					}
				} else {
					for (; JQj6iy3l > 0; --JQj6iy3l) {
						kEpqIcPM.write(mgIDKZIK.read());
					}
				}
				kEpqIcPM.close();
			}
			System.out.print('.');
		} finally {
			mgIDKZIK.close();
		}
	}

}