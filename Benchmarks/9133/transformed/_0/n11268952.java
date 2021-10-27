class n11268952 {
	public Vector split() {
		File IPL74HvG = new File(filename);
		long CFGIwuA1 = IPL74HvG.length();
		long vATkA4la = CFGIwuA1 / splitSize;
		Vector SvmTsRL5 = new Vector(new Long(vATkA4la).intValue());
		if (debug) {
			System.out.println("File: " + IPL74HvG.getName() + "\nfileSize: " + CFGIwuA1 + "\nsplitSize: " + splitSize
					+ "\nparts: " + vATkA4la);
		}
		if (CFGIwuA1 % splitSize > 0) {
			vATkA4la++;
		}
		try {
			FileInputStream Dao3wKoD = new FileInputStream(IPL74HvG);
			DataInputStream MlfjoOtL = new DataInputStream(Dao3wKoD);
			long mrDOkhgV = 0;
			File CY5OeO82 = new File(IPL74HvG.getParent());
			if (!CY5OeO82.exists()) {
				CY5OeO82.mkdir();
			}
			for (long oPjIZ7gT = 0; oPjIZ7gT < vATkA4la; oPjIZ7gT++) {
				if (debug) {
					System.out.println("Splitting parts: " + IPL74HvG.getName() + " into part " + oPjIZ7gT);
				}
				String h2w4Br85 = IPL74HvG.getName();
				h2w4Br85 = h2w4Br85 + "." + String.valueOf(oPjIZ7gT);
				File Vcu1vTzz = new File(CY5OeO82, h2w4Br85);
				FileOutputStream DVOUIN46 = new FileOutputStream(Vcu1vTzz);
				DataOutputStream WIcC75Hr = new DataOutputStream(DVOUIN46);
				long HW0sLM8N = 0;
				while ((HW0sLM8N < splitSize) && (mrDOkhgV < CFGIwuA1)) {
					WIcC75Hr.writeByte(MlfjoOtL.readByte());
					mrDOkhgV++;
					HW0sLM8N++;
				}
				WIcC75Hr.close();
				SvmTsRL5.addElement(Vcu1vTzz.getAbsolutePath());
				if (debug) {
					System.out.println("Wrote " + HW0sLM8N + " bytes." + Vcu1vTzz.getName() + " created.");
				}
			}
		} catch (FileNotFoundException KNg1T6nF) {
			System.err.println("FileNotFoundException: " + KNg1T6nF.getMessage());
			SvmTsRL5 = null;
		} catch (IOException C66vvbJD) {
			System.err.println("IOException: " + C66vvbJD.getMessage());
			SvmTsRL5 = null;
		}
		return SvmTsRL5;
	}

}