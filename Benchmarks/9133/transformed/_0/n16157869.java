class n16157869 {
	public void insertStringInFile(String Y8Ov2pa1, String Noc9lVLU, long o6UpaalA, long OnL50mB5) throws Exception {
		String ozWonBuc = Y8Ov2pa1 + ".tmp";
		BufferedInputStream zYY4vcdP = null;
		BufferedOutputStream lZqa83As = null;
		long EReqnvrg = 0;
		try {
			zYY4vcdP = new BufferedInputStream(new FileInputStream(new File(Y8Ov2pa1)));
			lZqa83As = new BufferedOutputStream(new FileOutputStream(ozWonBuc));
			long fwAgQ94w = o6UpaalA;
			byte[] aBw9qrfo = null;
			if (fwAgQ94w == 0) {
			} else {
				aBw9qrfo = new byte[(int) fwAgQ94w];
				int ykYV1nJ2 = -1;
				if ((ykYV1nJ2 = zYY4vcdP.read(aBw9qrfo)) != -1) {
					lZqa83As.write(aBw9qrfo, 0, ykYV1nJ2);
					EReqnvrg = EReqnvrg + ykYV1nJ2;
				} else {
					String EC0dn4dc = "Failed to read the first '" + fwAgQ94w + "' bytes of file '" + Y8Ov2pa1
							+ "'. This might be a programming error.";
					this.logger.warning(EC0dn4dc);
					throw new Exception(EC0dn4dc);
				}
			}
			aBw9qrfo = Noc9lVLU.getBytes();
			int JqMPz8od = aBw9qrfo.length;
			lZqa83As.write(aBw9qrfo, 0, JqMPz8od);
			EReqnvrg = EReqnvrg + JqMPz8od;
			long TeIRygjl = OnL50mB5 - o6UpaalA;
			long TY2G39ch = zYY4vcdP.skip(TeIRygjl);
			if (TY2G39ch == -1) {
			} else {
				aBw9qrfo = new byte[4096];
				JqMPz8od = -1;
				while ((JqMPz8od = zYY4vcdP.read(aBw9qrfo)) != -1) {
					lZqa83As.write(aBw9qrfo, 0, JqMPz8od);
					EReqnvrg = EReqnvrg + JqMPz8od;
				}
			}
			zYY4vcdP.close();
			zYY4vcdP = null;
			lZqa83As.close();
			lZqa83As = null;
			File WuUtTlT7 = new File(Y8Ov2pa1);
			boolean HXE5JD2r = WuUtTlT7.delete();
			if (!HXE5JD2r) {
				String nV3eknbo = "Failed to delete the original file '" + Y8Ov2pa1
						+ "' to replace it with the modified file after text insertion.";
				this.logger.warning(nV3eknbo);
				throw new Exception(nV3eknbo);
			}
			File Z3GN2lqD = new File(ozWonBuc);
			boolean YFoBBBwG = Z3GN2lqD.renameTo(WuUtTlT7);
			if (!YFoBBBwG) {
				String aT0Pckky = "Failed to rename tmp file '" + ozWonBuc + "' to the name of the original file '"
						+ Y8Ov2pa1 + "'";
				this.logger.warning(aT0Pckky);
				throw new Exception(aT0Pckky);
			}
		} catch (Exception V1NUDHba) {
			this.logger.log(Level.WARNING, "Failed to read/write file '" + Y8Ov2pa1 + "'.", V1NUDHba);
			throw V1NUDHba;
		} finally {
			if (zYY4vcdP != null) {
				try {
					zYY4vcdP.close();
				} catch (IOException B7mXgElB) {
					this.logger.log(Level.FINEST, "Ignoring error closing input file '" + Y8Ov2pa1 + "'.", B7mXgElB);
				}
			}
			if (lZqa83As != null) {
				try {
					lZqa83As.close();
				} catch (IOException NyLSLIah) {
					this.logger.log(Level.FINEST, "Ignoring error closing output file '" + ozWonBuc + "'.", NyLSLIah);
				}
			}
		}
	}

}