class n14768963 {
	public static boolean exec_applet(String jR6YpLrK, VarContainer HYb3jp4L, ActionContainer h59yvoNd,
			ThingTypeContainer SRj2GbuE, Output Ln2Rx9cH, InputStream u09cUkjy, boolean QmazE8Q6, Statement wTEWcEXs,
			String[] WJkNLTB2) {
		if (!urlpath.endsWith("/")) {
			urlpath = urlpath + '/';
		}
		if (!urlpath.startsWith("http://")) {
			urlpath = "http://" + urlpath;
		}
		String spPZjqmQ = urlpath;
		if (jR6YpLrK.startsWith("dusty_")) {
			spPZjqmQ = spPZjqmQ + "libraries/" + jR6YpLrK;
		} else {
			spPZjqmQ = spPZjqmQ + "users/" + jR6YpLrK;
		}
		StringBuffer o70JO2Z9 = new StringBuffer(2400);
		try {
			String OIgcr0wP;
			BufferedReader yTfHSU6G = new BufferedReader(new InputStreamReader(new URL(spPZjqmQ).openStream()));
			while ((OIgcr0wP = yTfHSU6G.readLine()) != null) {
				o70JO2Z9.append(OIgcr0wP).append('\n');
			}
			yTfHSU6G.close();
		} catch (Exception dDu9mkl3) {
			Ln2Rx9cH.println(
					new DSOut(DSOut.ERR_OUT, -1,
							"Dustyscript failed at reading the file'" + jR6YpLrK + "'\n\t...for 'use' statement"),
					HYb3jp4L, QmazE8Q6);
			return false;
		}
		fork(o70JO2Z9, HYb3jp4L, h59yvoNd, SRj2GbuE, Ln2Rx9cH, u09cUkjy, QmazE8Q6, wTEWcEXs, WJkNLTB2);
		return true;
	}

}