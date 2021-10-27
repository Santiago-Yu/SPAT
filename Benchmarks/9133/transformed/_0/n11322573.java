class n11322573 {
	private void preprocessObjects(GeoObject[] FNOGyPkf) throws IOException {
		System.out.println("objects.length " + FNOGyPkf.length);
		for (int eq5PgMCy = 0; eq5PgMCy < FNOGyPkf.length; eq5PgMCy++) {
			String DCcicdZD = FNOGyPkf[eq5PgMCy].getPath();
			int UwHWy1Fb = DCcicdZD.lastIndexOf(".");
			UwHWy1Fb = UwHWy1Fb < 0 ? 0 : UwHWy1Fb;
			String i6Cg7ECD = UwHWy1Fb < 1 ? DCcicdZD : DCcicdZD.substring(0, UwHWy1Fb + 3) + "w";
			System.out.println("i: " + " world filename " + i6Cg7ECD);
			File INumN8E1 = new File(i6Cg7ECD);
			if (INumN8E1.exists()) {
				BufferedReader EaoCZrn9 = new BufferedReader(new InputStreamReader(new FileInputStream(INumN8E1)));
				if (staticDebugOn)
					debug("b4nextline: ");
				line = EaoCZrn9.readLine();
				if (staticDebugOn)
					debug("line: " + line);
				if (line != null) {
					line = EaoCZrn9.readLine();
					if (staticDebugOn)
						debug("line: " + line);
					tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
					FNOGyPkf[eq5PgMCy].setLon(Double.valueOf(tokenizer.nextToken()).doubleValue());
					line = EaoCZrn9.readLine();
					if (staticDebugOn)
						debug("line: " + line);
					tokenizer = new StringTokenizer(line, " \n\t\r\"", false);
					FNOGyPkf[eq5PgMCy].setLat(Double.valueOf(tokenizer.nextToken()).doubleValue());
				}
			}
			File KZGel0jX = new File(FNOGyPkf[eq5PgMCy].getPath());
			if (KZGel0jX.exists()) {
				System.out.println("object src file found ");
				int dlAfXPoq = DCcicdZD.lastIndexOf(java.io.File.separator);
				dlAfXPoq = dlAfXPoq < 0 ? 0 : dlAfXPoq;
				if (dlAfXPoq == 0) {
					dlAfXPoq = DCcicdZD.lastIndexOf("/");
					dlAfXPoq = dlAfXPoq < 0 ? 0 : dlAfXPoq;
				}
				i6Cg7ECD = dlAfXPoq < 1 ? DCcicdZD : DCcicdZD.substring(dlAfXPoq + 1, DCcicdZD.length());
				System.out.println("filename " + destinationDirectory + XPlat.fileSep + i6Cg7ECD);
				FNOGyPkf[eq5PgMCy].setPath(i6Cg7ECD);
				KZGel0jX = new File(DCcicdZD);
				if (KZGel0jX.exists()) {
					DataInputStream xAOZe9rp = new DataInputStream(
							new BufferedInputStream(new FileInputStream(DCcicdZD)));
					DataOutputStream wTUzNEiM = new DataOutputStream(new BufferedOutputStream(
							new FileOutputStream(destinationDirectory + XPlat.fileSep + i6Cg7ECD)));
					System.out.println("copying to " + destinationDirectory + XPlat.fileSep + i6Cg7ECD);
					for (;;) {
						try {
							wTUzNEiM.writeShort(xAOZe9rp.readShort());
						} catch (EOFException tPTOKefB) {
							break;
						} catch (IOException mxUuvD8t) {
							break;
						}
					}
					wTUzNEiM.close();
				}
			}
		}
	}

}