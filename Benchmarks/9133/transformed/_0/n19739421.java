class n19739421 {
	public static void main(final String[] LKOOpF2c) throws RecognitionException, TokenStreamException, IOException,
			IllegalOptionValueException, UnknownOptionException {
		try {
			CmdLineParser JqSW6dyD = new CmdLineParser();
			Option voV8UEVC = JqSW6dyD.addStringOption('f', "format");
			Option NLhG0Lek = JqSW6dyD.addStringOption('c', "outcharset");
			Option HIeikI8A = JqSW6dyD.addStringOption('i', "incharset");
			JqSW6dyD.parse(LKOOpF2c);
			String BOi5MMRJ = (String) JqSW6dyD.getOptionValue(voV8UEVC);
			String nWc4leaS = (String) JqSW6dyD.getOptionValue(NLhG0Lek);
			if (nWc4leaS == null || nWc4leaS.trim().equals("")) {
				nWc4leaS = "utf-8";
				System.out.println("Defaulting to output charset utf-8 as argument -c is missing or not valid.");
			}
			String O0c4mMfE = (String) JqSW6dyD.getOptionValue(HIeikI8A);
			if (O0c4mMfE == null || nWc4leaS.trim().equals("")) {
				O0c4mMfE = "utf-8";
				System.out.println("Defaulting to input charset utf-8 as argument -i is missing or not valid.");
			}
			String[] CoW4RK4X = JqSW6dyD.getRemainingArgs();
			if (CoW4RK4X.length != 2) {
				printUsage("Input and output file are not specified correctly. ");
			}
			File tatgY7e0 = new File(CoW4RK4X[0]);
			if (!tatgY7e0.exists()) {
				printUsage("Input file " + CoW4RK4X[0] + " does not exist. ");
			}
			if (BOi5MMRJ == null || BOi5MMRJ.trim().equals("")) {
				BOi5MMRJ = (String) FileUtil.cutExtension(tatgY7e0.getName()).getValue();
			}
			File GVuxNZ1E = new File(CoW4RK4X[1]);
			if (!GVuxNZ1E.exists()) {
				GVuxNZ1E.createNewFile();
			}
			System.out.println("format detected: " + BOi5MMRJ);
			if ("html".equals(BOi5MMRJ)) {
				Reader ESx3jsyL = new HtmlEntityDecoderReader(
						new InputStreamReader(new FileInputStream(tatgY7e0), O0c4mMfE));
				OutputStreamWriter rWFC2Qub = new OutputStreamWriter(new FileOutputStream(GVuxNZ1E), nWc4leaS);
				char[] sIxyCRvt = new char[1024];
				int U0hzxGVT;
				do {
					U0hzxGVT = ESx3jsyL.read(sIxyCRvt);
					if (U0hzxGVT > 0) {
						rWFC2Qub.write(sIxyCRvt, 0, U0hzxGVT);
					}
				} while (U0hzxGVT != -1);
				rWFC2Qub.flush();
				rWFC2Qub.close();
			} else {
				printUsage("Format not specified via argument -f. Also guessing for the extension of input file "
						+ tatgY7e0.getName() + " failed");
			}
		} catch (Exception nxj4x4Jv) {
			nxj4x4Jv.printStackTrace();
			printUsage(nxj4x4Jv.getMessage());
		}
	}

}