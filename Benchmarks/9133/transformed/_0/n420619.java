class n420619 {
	public void convert(File PTyaR1S4, File MqiP4ZEB) throws IOException {
		InputStream rnUo5d5F = new BufferedInputStream(new FileInputStream(PTyaR1S4));
		DcmParser K2AZEfzu = pfact.newDcmParser(rnUo5d5F);
		Dataset VN0FJgtF = fact.newDataset();
		K2AZEfzu.setDcmHandler(VN0FJgtF.getDcmHandler());
		try {
			FileFormat J6V0rOwJ = K2AZEfzu.detectFileFormat();
			if (J6V0rOwJ != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + PTyaR1S4 + ": not an ACRNEMA stream!");
				return;
			}
			K2AZEfzu.parseDcmFile(J6V0rOwJ, Tags.PixelData);
			if (VN0FJgtF.contains(Tags.StudyInstanceUID) || VN0FJgtF.contains(Tags.SeriesInstanceUID)
					|| VN0FJgtF.contains(Tags.SOPInstanceUID) || VN0FJgtF.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + PTyaR1S4 + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean drThhDnz = K2AZEfzu.getReadTag() == Tags.PixelData;
			boolean p3mRh2wB = drThhDnz && VN0FJgtF.getInt(Tags.BitsAllocated, 0) == 12;
			int vnP1uHFK = K2AZEfzu.getReadLength();
			if (drThhDnz) {
				if (p3mRh2wB) {
					VN0FJgtF.putUS(Tags.BitsAllocated, 16);
					vnP1uHFK = vnP1uHFK * 4 / 3;
				}
				if (vnP1uHFK != (VN0FJgtF.getInt(Tags.BitsAllocated, 0) >>> 3) * VN0FJgtF.getInt(Tags.Rows, 0)
						* VN0FJgtF.getInt(Tags.Columns, 0) * VN0FJgtF.getInt(Tags.NumberOfFrames, 1)
						* VN0FJgtF.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + PTyaR1S4 + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			VN0FJgtF.putUI(Tags.StudyInstanceUID, uid(studyUID));
			VN0FJgtF.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			VN0FJgtF.putUI(Tags.SOPInstanceUID, uid(instUID));
			VN0FJgtF.putUI(Tags.SOPClassUID, classUID);
			if (!VN0FJgtF.contains(Tags.NumberOfSamples)) {
				VN0FJgtF.putUS(Tags.NumberOfSamples, 1);
			}
			if (!VN0FJgtF.contains(Tags.PhotometricInterpretation)) {
				VN0FJgtF.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				VN0FJgtF.setFileMetaInfo(fact.newFileMetaInfo(VN0FJgtF, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream aIIvujtI = new BufferedOutputStream(new FileOutputStream(MqiP4ZEB));
			try {
			} finally {
				VN0FJgtF.writeFile(aIIvujtI, encodeParam());
				if (drThhDnz) {
					if (!skipGroupLen) {
						aIIvujtI.write(PXDATA_GROUPLEN);
						int nRvVbgCH = vnP1uHFK + 8;
						aIIvujtI.write((byte) nRvVbgCH);
						aIIvujtI.write((byte) (nRvVbgCH >> 8));
						aIIvujtI.write((byte) (nRvVbgCH >> 16));
						aIIvujtI.write((byte) (nRvVbgCH >> 24));
					}
					aIIvujtI.write(PXDATA_TAG);
					aIIvujtI.write((byte) vnP1uHFK);
					aIIvujtI.write((byte) (vnP1uHFK >> 8));
					aIIvujtI.write((byte) (vnP1uHFK >> 16));
					aIIvujtI.write((byte) (vnP1uHFK >> 24));
				}
				if (p3mRh2wB) {
					int EaTlvqxM, tNdQvihV;
					for (; vnP1uHFK > 0; vnP1uHFK -= 3) {
						aIIvujtI.write(rnUo5d5F.read());
						EaTlvqxM = rnUo5d5F.read();
						tNdQvihV = rnUo5d5F.read();
						aIIvujtI.write(EaTlvqxM & 0x0f);
						aIIvujtI.write(EaTlvqxM >> 4 | ((tNdQvihV & 0x0f) << 4));
						aIIvujtI.write(tNdQvihV >> 4);
					}
				} else {
					for (; vnP1uHFK > 0; --vnP1uHFK) {
						aIIvujtI.write(rnUo5d5F.read());
					}
				}
				aIIvujtI.close();
			}
			System.out.print('.');
		} finally {
			rnUo5d5F.close();
		}
	}

}