class n7600378 {
	public void setTableBraille(String iLouaILW, boolean QlSKwV9a) {
		fiConf.setProperty(OptNames.fi_braille_table, iLouaILW);
		fiConf.setProperty(OptNames.fi_is_sys_braille_table, Boolean.toString(QlSKwV9a));
		FileChannel FB6aCgH4 = null;
		FileChannel OHnCCmVf = null;
		try {
			String m7v0J6Zn;
			if (!(iLouaILW.endsWith(".ent"))) {
				iLouaILW = iLouaILW + ".ent";
			}
			if (QlSKwV9a) {
				m7v0J6Zn = ConfigNat.getInstallFolder() + "xsl/tablesBraille/" + iLouaILW;
			} else {
				m7v0J6Zn = ConfigNat.getUserBrailleTableFolder() + iLouaILW;
			}
			FB6aCgH4 = new FileInputStream(m7v0J6Zn).getChannel();
			OHnCCmVf = new FileOutputStream(getUserBrailleTableFolder() + "Brltab.ent").getChannel();
			FB6aCgH4.transferTo(0, FB6aCgH4.size(), OHnCCmVf);
			FB6aCgH4.close();
			OHnCCmVf.close();
		} catch (IOException uFfLLY9i) {
			uFfLLY9i.printStackTrace();
		}
	}

}