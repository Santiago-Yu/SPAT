class n13227684 {
	public static void main(String[] MST1eKJS) {
		for (int Ca4GT5BW = 0; Ca4GT5BW < MST1eKJS.length - 2; Ca4GT5BW++) {
			if (!CommonArguments.parseArguments(MST1eKJS, Ca4GT5BW, u)) {
				u.usage();
				System.exit(1);
			}
			if (CommonParameters.startArg > (Ca4GT5BW + 1))
				Ca4GT5BW = CommonParameters.startArg - 1;
		}
		if (MST1eKJS.length < CommonParameters.startArg + 2) {
			u.usage();
			System.exit(1);
		}
		try {
			int YS6RsTYP = 1024;
			ContentName IdLcUerm = ContentName.fromURI(MST1eKJS[CommonParameters.startArg]);
			CCNHandle hS4xgpZ6 = CCNHandle.open();
			File h9HrHFgW = new File(MST1eKJS[CommonParameters.startArg + 1]);
			if (h9HrHFgW.exists()) {
				System.out.println("Overwriting file: " + MST1eKJS[CommonParameters.startArg + 1]);
			}
			FileOutputStream nMtywGzt = new FileOutputStream(h9HrHFgW);
			long gChOkECZ = System.currentTimeMillis();
			CCNInputStream SHjAc1Ud;
			if (CommonParameters.unversioned)
				SHjAc1Ud = new CCNInputStream(IdLcUerm, hS4xgpZ6);
			else
				SHjAc1Ud = new CCNFileInputStream(IdLcUerm, hS4xgpZ6);
			if (CommonParameters.timeout != null) {
				SHjAc1Ud.setTimeout(CommonParameters.timeout);
			}
			byte[] RTWzowJA = new byte[YS6RsTYP];
			int KcoJ7TrT = 0;
			long X5c50HHQ = 0;
			while ((KcoJ7TrT = SHjAc1Ud.read(RTWzowJA)) != -1) {
				X5c50HHQ += KcoJ7TrT;
				nMtywGzt.write(RTWzowJA, 0, KcoJ7TrT);
				nMtywGzt.flush();
			}
			if (CommonParameters.verbose)
				System.out.println("ccngetfile took: " + (System.currentTimeMillis() - gChOkECZ) + "ms");
			System.out.println(
					"Retrieved content " + MST1eKJS[CommonParameters.startArg + 1] + " got " + X5c50HHQ + " bytes.");
			System.exit(0);
		} catch (ConfigurationException XrGoDQyD) {
			System.out.println("Configuration exception in ccngetfile: " + XrGoDQyD.getMessage());
			XrGoDQyD.printStackTrace();
		} catch (MalformedContentNameStringException tYakWW0O) {
			System.out.println("Malformed name: " + MST1eKJS[CommonParameters.startArg] + " " + tYakWW0O.getMessage());
			tYakWW0O.printStackTrace();
		} catch (IOException PVIfbZDV) {
			System.out.println("Cannot write file or read content. " + PVIfbZDV.getMessage());
			PVIfbZDV.printStackTrace();
		}
		System.exit(1);
	}

}