class n9257487 {
	public static boolean downloadFile(String hopjfZDq, String TVYwGSA1, ProgressMonitor bvMC6L2V) {
		try {
			FileOutputStream EUeAMumJ = new FileOutputStream(TVYwGSA1);
			URL MfHdOX9U = new URL(hopjfZDq);
			URLConnection zCNL2V18 = MfHdOX9U.openConnection();
			InputStream AWTGxffU = zCNL2V18.getInputStream();
			byte[] LUlJfDfe = new byte[1024];
			int wyFGLach = 0;
			while ((wyFGLach = AWTGxffU.read(LUlJfDfe)) != -1) {
				EUeAMumJ.write(LUlJfDfe, 0, wyFGLach);
				if (bvMC6L2V != null)
					bvMC6L2V.addToProgress(wyFGLach);
			}
			EUeAMumJ.close();
			AWTGxffU.close();
		} catch (Exception LfhZEcYC) {
			Installer.getInstance().getLogger().log(StringUtils.getStackTrace(LfhZEcYC));
			return false;
		}
		return true;
	}

}