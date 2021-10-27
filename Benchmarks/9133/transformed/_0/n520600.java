class n520600 {
	public void convert(File cm0WFZXF, File n6BFZAil) throws IOException {
		InputStream W1Vl6jUL = new BufferedInputStream(new FileInputStream(cm0WFZXF));
		DcmParser IIdCxzr0 = pfact.newDcmParser(W1Vl6jUL);
		Dataset BVpP6yBo = fact.newDataset();
		IIdCxzr0.setDcmHandler(BVpP6yBo.getDcmHandler());
		try {
			FileFormat jVNSilN7 = IIdCxzr0.detectFileFormat();
			if (jVNSilN7 != FileFormat.ACRNEMA_STREAM) {
				System.out.println("\n" + cm0WFZXF + ": not an ACRNEMA stream!");
				return;
			}
			IIdCxzr0.parseDcmFile(jVNSilN7, Tags.PixelData);
			if (BVpP6yBo.contains(Tags.StudyInstanceUID) || BVpP6yBo.contains(Tags.SeriesInstanceUID)
					|| BVpP6yBo.contains(Tags.SOPInstanceUID) || BVpP6yBo.contains(Tags.SOPClassUID)) {
				System.out
						.println("\n" + cm0WFZXF + ": contains UIDs!" + " => probable already DICOM - do not convert");
				return;
			}
			boolean MjuAMCpj = IIdCxzr0.getReadTag() == Tags.PixelData;
			boolean rW0duoMj = MjuAMCpj && BVpP6yBo.getInt(Tags.BitsAllocated, 0) == 12;
			int hs1zgh0N = IIdCxzr0.getReadLength();
			if (MjuAMCpj) {
				if (rW0duoMj) {
					BVpP6yBo.putUS(Tags.BitsAllocated, 16);
					hs1zgh0N = hs1zgh0N * 4 / 3;
				}
				if (hs1zgh0N != (BVpP6yBo.getInt(Tags.BitsAllocated, 0) >>> 3) * BVpP6yBo.getInt(Tags.Rows, 0)
						* BVpP6yBo.getInt(Tags.Columns, 0) * BVpP6yBo.getInt(Tags.NumberOfFrames, 1)
						* BVpP6yBo.getInt(Tags.NumberOfSamples, 1)) {
					System.out.println("\n" + cm0WFZXF + ": mismatch pixel data length!" + " => do not convert");
					return;
				}
			}
			BVpP6yBo.putUI(Tags.StudyInstanceUID, uid(studyUID));
			BVpP6yBo.putUI(Tags.SeriesInstanceUID, uid(seriesUID));
			BVpP6yBo.putUI(Tags.SOPInstanceUID, uid(instUID));
			BVpP6yBo.putUI(Tags.SOPClassUID, classUID);
			if (!BVpP6yBo.contains(Tags.NumberOfSamples)) {
				BVpP6yBo.putUS(Tags.NumberOfSamples, 1);
			}
			if (!BVpP6yBo.contains(Tags.PhotometricInterpretation)) {
				BVpP6yBo.putCS(Tags.PhotometricInterpretation, "MONOCHROME2");
			}
			if (fmi) {
				BVpP6yBo.setFileMetaInfo(fact.newFileMetaInfo(BVpP6yBo, UIDs.ImplicitVRLittleEndian));
			}
			OutputStream w6vLubvb = new BufferedOutputStream(new FileOutputStream(n6BFZAil));
			try {
			} finally {
				BVpP6yBo.writeFile(w6vLubvb, encodeParam());
				if (MjuAMCpj) {
					if (!skipGroupLen) {
						w6vLubvb.write(PXDATA_GROUPLEN);
						int cbQbCbCM = hs1zgh0N + 8;
						w6vLubvb.write((byte) cbQbCbCM);
						w6vLubvb.write((byte) (cbQbCbCM >> 8));
						w6vLubvb.write((byte) (cbQbCbCM >> 16));
						w6vLubvb.write((byte) (cbQbCbCM >> 24));
					}
					w6vLubvb.write(PXDATA_TAG);
					w6vLubvb.write((byte) hs1zgh0N);
					w6vLubvb.write((byte) (hs1zgh0N >> 8));
					w6vLubvb.write((byte) (hs1zgh0N >> 16));
					w6vLubvb.write((byte) (hs1zgh0N >> 24));
				}
				if (rW0duoMj) {
					int rjqg1dTb, eEC8U9w5;
					for (; hs1zgh0N > 0; hs1zgh0N -= 3) {
						w6vLubvb.write(W1Vl6jUL.read());
						rjqg1dTb = W1Vl6jUL.read();
						eEC8U9w5 = W1Vl6jUL.read();
						w6vLubvb.write(rjqg1dTb & 0x0f);
						w6vLubvb.write(rjqg1dTb >> 4 | ((eEC8U9w5 & 0x0f) << 4));
						w6vLubvb.write(eEC8U9w5 >> 4);
					}
				} else {
					for (; hs1zgh0N > 0; --hs1zgh0N) {
						w6vLubvb.write(W1Vl6jUL.read());
					}
				}
				w6vLubvb.close();
			}
			System.out.print('.');
		} finally {
			W1Vl6jUL.close();
		}
	}

}