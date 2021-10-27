class n11238287 {
	public static void main(final String[] VaPsLJnV) throws RecognitionException, TokenStreamException, IOException,
			IllegalOptionValueException, UnknownOptionException {
		try {
			CmdLineParser zuJ3KFIf = new CmdLineParser();
			Option Z30t2aPm = zuJ3KFIf.addStringOption('f', "format");
			Option ISVgpRSf = zuJ3KFIf.addStringOption('c', "charset");
			zuJ3KFIf.parse(VaPsLJnV);
			String kPBQcUZJ = (String) zuJ3KFIf.getOptionValue(Z30t2aPm);
			String WgFFah5x = (String) zuJ3KFIf.getOptionValue(ISVgpRSf);
			if (WgFFah5x == null || WgFFah5x.trim().equals("")) {
				WgFFah5x = "utf-8";
				System.out.println("Defaulting to output charset utf-8 as argument -c is missing or not valid.");
			}
			String[] ymC6AqE7 = zuJ3KFIf.getRemainingArgs();
			if (ymC6AqE7.length != 2) {
				printUsage("Input and output file are not specified correctly. ");
			}
			File ANihXBTw = new File(ymC6AqE7[0]);
			if (!ANihXBTw.exists()) {
				printUsage("Input file " + ymC6AqE7[0] + " does not exist. ");
			}
			File Lip9RHV2 = new File(ymC6AqE7[1]);
			if (!Lip9RHV2.exists()) {
				Lip9RHV2.createNewFile();
			}
			if (kPBQcUZJ == null || kPBQcUZJ.trim().equals("")) {
				kPBQcUZJ = (String) FileUtil.cutExtension(Lip9RHV2.getName()).getValue();
			}
			if ("tex".equals(kPBQcUZJ)) {
				Reader kAQoretu = new LatexEncoderReader(new FileReader(ANihXBTw));
				OutputStreamWriter Q0O7lWc1 = new OutputStreamWriter(new FileOutputStream(Lip9RHV2), WgFFah5x);
				char[] oJa9rTnL = new char[1024];
				int oS9UoiTJ;
				do {
					oS9UoiTJ = kAQoretu.read(oJa9rTnL);
					if (oS9UoiTJ > 0) {
						Q0O7lWc1.write(oJa9rTnL, 0, oS9UoiTJ);
					}
				} while (oS9UoiTJ != -1);
				Q0O7lWc1.flush();
				Q0O7lWc1.close();
			} else {
				printUsage("Format not specified via argument -f. Also guessing for the extension of output file "
						+ Lip9RHV2.getName() + " failed");
			}
		} catch (Exception ER0oCXbx) {
			ER0oCXbx.printStackTrace();
			printUsage(ER0oCXbx.getMessage());
		}
	}

}