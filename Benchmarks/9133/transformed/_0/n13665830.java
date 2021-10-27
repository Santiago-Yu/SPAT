class n13665830 {
	public static void main(String[] Q0f0JJsV) {
		Usage feMFffoX = new ccngetmeta();
		for (int XZZeE8VR = 0; XZZeE8VR < Q0f0JJsV.length - 3; XZZeE8VR++) {
			if (!CommonArguments.parseArguments(Q0f0JJsV, XZZeE8VR, feMFffoX)) {
				feMFffoX.usage();
				System.exit(1);
			}
			if (CommonParameters.startArg > XZZeE8VR + 1)
				XZZeE8VR = CommonParameters.startArg - 1;
		}
		if (Q0f0JJsV.length != CommonParameters.startArg + 3) {
			feMFffoX.usage();
			System.exit(1);
		}
		try {
			int T7Kdb8WB = 1024;
			CCNHandle SHAp4nb4 = CCNHandle.open();
			String HDSC8ZvX = Q0f0JJsV[CommonParameters.startArg + 1];
			if (!HDSC8ZvX.startsWith("/"))
				HDSC8ZvX = "/" + HDSC8ZvX;
			ContentName MPR9qjBn = MetadataProfile.getLatestVersion(
					ContentName.fromURI(Q0f0JJsV[CommonParameters.startArg]), ContentName.fromNative(HDSC8ZvX),
					CommonParameters.timeout, SHAp4nb4);
			if (MPR9qjBn == null) {
				System.out.println("File " + Q0f0JJsV[CommonParameters.startArg] + " does not exist");
				System.exit(1);
			}
			if (VersioningProfile.hasTerminalVersion(MPR9qjBn)) {
			} else {
				System.out.println("File " + MPR9qjBn + " does not exist...  exiting");
				System.exit(1);
			}
			File zxd6hgd1 = new File(Q0f0JJsV[CommonParameters.startArg + 2]);
			if (zxd6hgd1.exists()) {
				System.out.println("Overwriting file: " + Q0f0JJsV[CommonParameters.startArg + 1]);
			}
			FileOutputStream vqIahWEJ = new FileOutputStream(zxd6hgd1);
			long zOlRLlLi = System.currentTimeMillis();
			CCNInputStream gDJyld0t;
			if (CommonParameters.unversioned)
				gDJyld0t = new CCNInputStream(MPR9qjBn, SHAp4nb4);
			else
				gDJyld0t = new CCNFileInputStream(MPR9qjBn, SHAp4nb4);
			if (CommonParameters.timeout != null) {
				gDJyld0t.setTimeout(CommonParameters.timeout);
			}
			byte[] PxKlwbV4 = new byte[T7Kdb8WB];
			int w1SAATp6 = 0;
			long UF3RLCaC = 0;
			while ((w1SAATp6 = gDJyld0t.read(PxKlwbV4)) != -1) {
				UF3RLCaC += w1SAATp6;
				vqIahWEJ.write(PxKlwbV4, 0, w1SAATp6);
				vqIahWEJ.flush();
			}
			if (CommonParameters.verbose)
				System.out.println("ccngetfile took: " + (System.currentTimeMillis() - zOlRLlLi) + "ms");
			System.out.println(
					"Retrieved content " + Q0f0JJsV[CommonParameters.startArg + 1] + " got " + UF3RLCaC + " bytes.");
			System.exit(0);
		} catch (ConfigurationException YJmTojbh) {
			System.out.println("Configuration exception in ccngetfile: " + YJmTojbh.getMessage());
			YJmTojbh.printStackTrace();
		} catch (MalformedContentNameStringException GZCSlcFp) {
			System.out.println("Malformed name: " + Q0f0JJsV[CommonParameters.startArg] + " " + GZCSlcFp.getMessage());
			GZCSlcFp.printStackTrace();
		} catch (IOException T1YodFCy) {
			System.out.println("Cannot write file or read content. " + T1YodFCy.getMessage());
			T1YodFCy.printStackTrace();
		}
		System.exit(1);
	}

}