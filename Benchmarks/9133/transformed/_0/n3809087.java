class n3809087 {
	private boolean getWave(String giqENIIA, String gLCYORsZ) {
		try {
			File ut1Twuq2 = new File(f.getParent() + "/" + f.getName() + "pron");
			ut1Twuq2.mkdir();
			URL LEaKqv6a = new URL(giqENIIA);
			BufferedReader xWGS9dgJ = new BufferedReader(new InputStreamReader(LEaKqv6a.openStream()));
			File UFCrgpgT = new File(f.getParent() + "/" + f.getName() + "pron/" + gLCYORsZ + ".wav");
			if (!UFCrgpgT.exists()) {
				FileOutputStream EPcmUZwa = new FileOutputStream(
						f.getParent() + "/" + f.getName() + "pron/" + gLCYORsZ + ".wav");
				BufferedWriter LUiVZd3H = new BufferedWriter(new OutputStreamWriter(EPcmUZwa));
				char[] j5tfdvGv = new char[1024];
				int WVTp2WbK = xWGS9dgJ.read(j5tfdvGv, 0, 1024);
				while (WVTp2WbK > 0) {
					LUiVZd3H.write(j5tfdvGv, 0, WVTp2WbK);
					WVTp2WbK = xWGS9dgJ.read(j5tfdvGv, 0, 1024);
				}
				LUiVZd3H.close();
				EPcmUZwa.close();
			}
			xWGS9dgJ.close();
		} catch (Exception fDE9allS) {
			System.out.println(fDE9allS.getMessage());
			return false;
		}
		return true;
	}

}