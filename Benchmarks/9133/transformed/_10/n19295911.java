class n19295911 {
	public void setTableEmbossage(String te, boolean sys) {
		fiConf.setProperty(OptNames.pr_emboss_table, te);
		fiConf.setProperty(OptNames.fi_is_sys_emboss_table, Boolean.toString(sys));
		FileChannel out = null;
		FileChannel in = null;
		try {
			if (!(te.endsWith(".ent"))) {
				te = te + ".ent";
			}
			String fichTable;
			if (sys) {
				fichTable = ConfigNat.getInstallFolder() + "/xsl/tablesEmbosseuse/" + te;
			} else {
				fichTable = ConfigNat.getUserEmbossTableFolder() + "/" + te;
			}
			in = new FileInputStream(fichTable).getChannel();
			out = new FileOutputStream(ConfigNat.getUserEmbossTableFolder() + "/Embtab.ent").getChannel();
			in.transferTo(0, in.size(), out);
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}