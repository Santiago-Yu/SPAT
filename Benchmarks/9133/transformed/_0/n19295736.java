class n19295736 {
	public void setTableBraille(String pePENUXk, boolean m1BQwi5P) {
		fiConf.setProperty(OptNames.fi_braille_table, pePENUXk);
		fiConf.setProperty(OptNames.fi_is_sys_braille_table, Boolean.toString(m1BQwi5P));
		FileChannel pmlojFcG = null;
		FileChannel LuYXNX0w = null;
		try {
			String WOJPZHKM;
			if (!(pePENUXk.endsWith(".ent"))) {
				pePENUXk = pePENUXk + ".ent";
			}
			if (m1BQwi5P) {
				WOJPZHKM = ConfigNat.getInstallFolder() + "xsl/tablesBraille/" + pePENUXk;
			} else {
				WOJPZHKM = ConfigNat.getUserBrailleTableFolder() + pePENUXk;
			}
			pmlojFcG = new FileInputStream(WOJPZHKM).getChannel();
			LuYXNX0w = new FileOutputStream(getUserBrailleTableFolder() + "Brltab.ent").getChannel();
			pmlojFcG.transferTo(0, pmlojFcG.size(), LuYXNX0w);
			pmlojFcG.close();
			LuYXNX0w.close();
		} catch (IOException I47Ve4eH) {
			I47Ve4eH.printStackTrace();
		}
		try {
			String q6RwQGZz;
			if (m1BQwi5P) {
				q6RwQGZz = ConfigNat.getInstallFolder() + "/xsl/tablesEmbosseuse/" + pePENUXk;
			} else {
				q6RwQGZz = ConfigNat.getUserEmbossTableFolder() + "/" + pePENUXk;
			}
			pmlojFcG = new FileInputStream(q6RwQGZz).getChannel();
			LuYXNX0w = new FileOutputStream(ConfigNat.getUserTempFolder() + "Table_pour_chaines.ent").getChannel();
			pmlojFcG.transferTo(0, pmlojFcG.size(), LuYXNX0w);
			pmlojFcG.close();
			LuYXNX0w.close();
		} catch (IOException Lm5JjtoG) {
			Lm5JjtoG.printStackTrace();
		}
	}

}