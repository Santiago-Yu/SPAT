class n19295911 {
	public void setTableEmbossage(String P8HreKpg, boolean tEDUJhAl) {
		fiConf.setProperty(OptNames.pr_emboss_table, P8HreKpg);
		fiConf.setProperty(OptNames.fi_is_sys_emboss_table, Boolean.toString(tEDUJhAl));
		FileChannel dzNkkiJC = null;
		FileChannel Ps0QRA0W = null;
		try {
			String FPftZBgV;
			if (!(P8HreKpg.endsWith(".ent"))) {
				P8HreKpg = P8HreKpg + ".ent";
			}
			if (tEDUJhAl) {
				FPftZBgV = ConfigNat.getInstallFolder() + "/xsl/tablesEmbosseuse/" + P8HreKpg;
			} else {
				FPftZBgV = ConfigNat.getUserEmbossTableFolder() + "/" + P8HreKpg;
			}
			dzNkkiJC = new FileInputStream(FPftZBgV).getChannel();
			Ps0QRA0W = new FileOutputStream(ConfigNat.getUserEmbossTableFolder() + "/Embtab.ent").getChannel();
			dzNkkiJC.transferTo(0, dzNkkiJC.size(), Ps0QRA0W);
			dzNkkiJC.close();
			Ps0QRA0W.close();
		} catch (IOException yRXsDxqc) {
			yRXsDxqc.printStackTrace();
		}
	}

}