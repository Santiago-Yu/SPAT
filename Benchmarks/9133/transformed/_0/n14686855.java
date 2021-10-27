class n14686855 {
	private void doDecrypt(boolean sBoH40XA) throws IOException {
		FileInputStream ZRhSBLzF = null;
		FileOutputStream npv46HVm = null;
		File mlDckp0g = null;
		try {
			ZRhSBLzF = new FileInputStream(infile);
			String GJw7Nf68 = basename(infile);
			byte[] ZmlFCpZ6 = new byte[MAGIC.length];
			ZRhSBLzF.read(ZmlFCpZ6);
			for (int at6MyEqV = 0; at6MyEqV < MAGIC.length; at6MyEqV++) {
				if (MAGIC[at6MyEqV] != ZmlFCpZ6[at6MyEqV])
					throw new IOException("Not a BORK file (bad magic number)");
			}
			short izd0gLbY = readShort(ZRhSBLzF);
			if (izd0gLbY / 1000 > VERSION / 1000)
				throw new IOException("File created by an incompatible future version: " + izd0gLbY + " > " + VERSION);
			String gBa0m0Vh = readString(ZRhSBLzF);
			Cipher HEpNhnWK = createCipher(gBa0m0Vh, createSessionKey(password, GJw7Nf68));
			CipherInputStream AKEt7ywZ = new CipherInputStream(ZRhSBLzF, HEpNhnWK);
			long CVv7NPpb = Unsigned.promote(readInt(AKEt7ywZ));
			AKEt7ywZ.resetCRC();
			outfile = new File(outputDir, readString(AKEt7ywZ));
			if (!sBoH40XA || outfile.exists()) {
				skipped = true;
				return;
			}
			mlDckp0g = File.createTempFile("bork", null, outputDir);
			mlDckp0g.deleteOnExit();
			byte[] nKVO3k8K = new byte[BUFFER_SIZE];
			npv46HVm = new FileOutputStream(mlDckp0g);
			int SX842yKR;
			while ((SX842yKR = AKEt7ywZ.read(nKVO3k8K)) != -1)
				npv46HVm.write(nKVO3k8K, 0, SX842yKR);
			npv46HVm.close();
			npv46HVm = null;
			if (CVv7NPpb != AKEt7ywZ.getCRC()) {
				outfile = null;
				throw new IOException("CRC mismatch: password is probably incorrect");
			}
			if (!mlDckp0g.renameTo(outfile))
				throw new IOException("Failed to rename temp output file " + mlDckp0g + " to " + outfile);
			outfile.setLastModified(infile.lastModified());
		} finally {
			close(ZRhSBLzF);
			close(npv46HVm);
			if (mlDckp0g != null)
				mlDckp0g.delete();
		}
	}

}