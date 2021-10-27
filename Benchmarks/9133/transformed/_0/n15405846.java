class n15405846 {
	public DataSet guessAtUnknowns(String rD7Gle61) {
		TasselFileType iBz2d1RH = TasselFileType.Sequence;
		DataSet jDLRJQQi = null;
		try {
			BufferedReader n83RAAko = null;
			if (rD7Gle61.startsWith("http")) {
				URL EsKnwuz8 = new URL(rD7Gle61);
				n83RAAko = new BufferedReader(new InputStreamReader(EsKnwuz8.openStream()));
			} else {
				n83RAAko = new BufferedReader(new FileReader(rD7Gle61));
			}
			String t2RJhsNX = n83RAAko.readLine().trim();
			String[] Y7R8SCu7 = t2RJhsNX.split("\\s");
			String ShdiDXBX = n83RAAko.readLine().trim();
			String[] pOWImXpE = ShdiDXBX.split("\\s");
			boolean ukVU2VTW = false;
			if (!Y7R8SCu7[0].startsWith("<") && (Y7R8SCu7.length == 2) && (t2RJhsNX.indexOf(':') < 0)) {
				int juiJYMsh = Integer.parseInt(Y7R8SCu7[1]);
				if (juiJYMsh == pOWImXpE.length) {
					ukVU2VTW = true;
				}
			}
			if (Y7R8SCu7[0].equalsIgnoreCase("<Annotated>")) {
				iBz2d1RH = TasselFileType.Annotated;
			} else if (t2RJhsNX.startsWith("<") || t2RJhsNX.startsWith("#")) {
				boolean XutMRJsd = false;
				boolean IV0TOlXl = false;
				boolean tuGcP3ae = false;
				boolean RG6Fmtja = false;
				Pattern T2ZJ2beJ = Pattern.compile("[<>\\s]+");
				String[] y9yNIL0p = T2ZJ2beJ.split(t2RJhsNX);
				String[] vIdjbGPy = T2ZJ2beJ.split(ShdiDXBX);
				if (y9yNIL0p.length > 1) {
					if (y9yNIL0p[1].toUpperCase().startsWith("MARKER")) {
						IV0TOlXl = true;
					} else if (y9yNIL0p[1].toUpperCase().startsWith("TRAIT")) {
						XutMRJsd = true;
					} else if (y9yNIL0p[1].toUpperCase().startsWith("NUMER")) {
						tuGcP3ae = true;
					} else if (y9yNIL0p[1].toUpperCase().startsWith("MAP")) {
						RG6Fmtja = true;
					}
				}
				if (vIdjbGPy.length > 1) {
					if (vIdjbGPy[1].toUpperCase().startsWith("MARKER")) {
						IV0TOlXl = true;
					} else if (vIdjbGPy[1].toUpperCase().startsWith("TRAIT")) {
						XutMRJsd = true;
					} else if (vIdjbGPy[1].toUpperCase().startsWith("NUMER")) {
						tuGcP3ae = true;
					} else if (vIdjbGPy[1].toUpperCase().startsWith("MAP")) {
						RG6Fmtja = true;
					}
				} else {
					iBz2d1RH = null;
					String KmeQF97D = n83RAAko.readLine();
					while (iBz2d1RH == null && KmeQF97D != null
							&& (KmeQF97D.startsWith("#") || KmeQF97D.startsWith("<"))) {
						if (KmeQF97D.startsWith("<")) {
							String[] CoHrpPQr = T2ZJ2beJ.split(KmeQF97D);
							if (CoHrpPQr[1].toUpperCase().startsWith("MARKER")) {
								IV0TOlXl = true;
							} else if (CoHrpPQr[1].toUpperCase().startsWith("TRAIT")) {
								XutMRJsd = true;
							} else if (CoHrpPQr[1].toUpperCase().startsWith("NUMER")) {
								tuGcP3ae = true;
							} else if (CoHrpPQr[1].toUpperCase().startsWith("MAP")) {
								RG6Fmtja = true;
							}
						}
					}
				}
				if (XutMRJsd || (IV0TOlXl && tuGcP3ae)) {
					iBz2d1RH = TasselFileType.Phenotype;
				} else if (IV0TOlXl) {
					iBz2d1RH = TasselFileType.Polymorphism;
				} else if (RG6Fmtja) {
					iBz2d1RH = TasselFileType.GeneticMap;
				} else {
					throw new IOException("Improperly formatted header. Data will not be imported.");
				}
			} else if ((t2RJhsNX.startsWith(">")) || (t2RJhsNX.startsWith(";"))) {
				iBz2d1RH = TasselFileType.Fasta;
			} else if (Y7R8SCu7.length == 1) {
				iBz2d1RH = TasselFileType.SqrMatrix;
			} else if (t2RJhsNX.indexOf(':') > 0) {
				iBz2d1RH = TasselFileType.Polymorphism;
			} else if ((Y7R8SCu7.length == 2) && (ukVU2VTW)) {
				iBz2d1RH = TasselFileType.Polymorphism;
			} else if ((t2RJhsNX.startsWith("#Nexus")) || (t2RJhsNX.startsWith("#NEXUS"))
					|| (t2RJhsNX.startsWith("CLUSTAL")) || ((Y7R8SCu7.length == 2) && (pOWImXpE.length == 2))) {
				iBz2d1RH = TasselFileType.Sequence;
			} else if (Y7R8SCu7.length == 3) {
				iBz2d1RH = TasselFileType.Numerical;
			}
			myLogger.info("guessAtUnknowns: type: " + iBz2d1RH);
			jDLRJQQi = processDatum(rD7Gle61, iBz2d1RH);
			n83RAAko.close();
		} catch (Exception MITaGdQR) {
		}
		return jDLRJQQi;
	}

}