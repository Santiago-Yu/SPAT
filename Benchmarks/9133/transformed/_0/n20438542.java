class n20438542 {
	public static Shader loadShader(String j05x1dLK, String HOWiMCHV, int N0KEPklB, boolean izdFWw9D, boolean plKVbbAJ)
			throws ShaderProgramProcessException {
		if (j05x1dLK == "" || HOWiMCHV == "")
			return null;
		BufferedReader GaXtGMhD;
		String oSCtF8Rf = "", eZhwxdRd = "";
		try {
			URL mKCp6XpZ = Graphics.class.getClass().getResource("/eu/cherrytree/paj/graphics/shaders/" + j05x1dLK);
			String R3HtIx1E = AppDefinition.getDefaultDataPackagePath() + "/shaders/" + j05x1dLK;
			if (mKCp6XpZ != null)
				GaXtGMhD = new BufferedReader(new InputStreamReader(mKCp6XpZ.openStream()));
			else
				GaXtGMhD = new BufferedReader(new InputStreamReader(new FileReader(R3HtIx1E).getInputStream()));
			boolean LQzfSE1M = true;
			String xZl95Yr8;
			while (LQzfSE1M) {
				xZl95Yr8 = GaXtGMhD.readLine();
				if (xZl95Yr8 != null)
					oSCtF8Rf += xZl95Yr8 + "\n";
				else
					LQzfSE1M = false;
			}
			GaXtGMhD.close();
		} catch (Exception HQwIiPSO) {
			System.err.println("Couldn't read in vertex shader \"" + j05x1dLK + "\".");
			throw new ShaderNotLoadedException(j05x1dLK, HOWiMCHV);
		}
		try {
			URL YgSVlRw6 = Graphics.class.getClass().getResource("/eu/cherrytree/paj/graphics/shaders/" + HOWiMCHV);
			String RLQwIcOV = AppDefinition.getDefaultDataPackagePath() + "/shaders/" + HOWiMCHV;
			if (YgSVlRw6 != null)
				GaXtGMhD = new BufferedReader(new InputStreamReader(YgSVlRw6.openStream()));
			else
				GaXtGMhD = new BufferedReader(new InputStreamReader(new FileReader(RLQwIcOV).getInputStream()));
			boolean QWRoIeFe = true;
			String d0FwKOWZ;
			while (QWRoIeFe) {
				d0FwKOWZ = GaXtGMhD.readLine();
				if (d0FwKOWZ != null)
					eZhwxdRd += d0FwKOWZ + "\n";
				else
					QWRoIeFe = false;
			}
			GaXtGMhD.close();
		} catch (Exception H3Q7eGCb) {
			System.err.println("Couldn't read in fragment shader \"" + HOWiMCHV + "\".");
			throw new ShaderNotLoadedException(j05x1dLK, HOWiMCHV);
		}
		return loadShaderFromSource(oSCtF8Rf, eZhwxdRd, N0KEPklB, izdFWw9D, plKVbbAJ);
	}

}