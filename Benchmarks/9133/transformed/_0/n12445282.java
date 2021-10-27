class n12445282 {
	static boolean writeProperties(Map<String, String> zKtErPE4, File AknBuRgx) throws IOException {
		synchronized (PropertiesIO.class) {
			L.info(Msg.msg("PropertiesIO.writeProperties.start"));
			File QMpvaF3n = null;
			BufferedInputStream ST380Ftp = null;
			FileInputStream sjnMyWSQ = null;
			FileOutputStream jRKJE4zn = null;
			PrintStream kxjyB2FN = null;
			FileChannel JxGCdWdQ = null, G6KM8Itl = null;
			String mdzXyWIj = null;
			try {
				ST380Ftp = new BufferedInputStream(
						AknBuRgx.exists() ? new FileInputStream(AknBuRgx) : defaultPropertiesStream());
				QMpvaF3n = File.createTempFile("properties-", ".tmp", null);
				kxjyB2FN = new PrintStream(QMpvaF3n);
				while ((mdzXyWIj = Utils.readLine(ST380Ftp)) != null) {
					String BDfNpwNZ = setupLine(mdzXyWIj, zKtErPE4);
					kxjyB2FN.println(BDfNpwNZ);
				}
				AknBuRgx.getParentFile().mkdirs();
				sjnMyWSQ = new FileInputStream(QMpvaF3n);
				jRKJE4zn = new FileOutputStream(AknBuRgx, false);
				JxGCdWdQ = sjnMyWSQ.getChannel();
				G6KM8Itl = jRKJE4zn.getChannel();
				JxGCdWdQ.transferTo(0, JxGCdWdQ.size(), G6KM8Itl);
				L.info(Msg.msg("PropertiesIO.writeProperties.done").replace("#file#", AknBuRgx.getAbsolutePath()));
				return true;
			} finally {
				if (ST380Ftp != null)
					ST380Ftp.close();
				if (kxjyB2FN != null)
					kxjyB2FN.close();
				if (JxGCdWdQ != null)
					JxGCdWdQ.close();
				if (G6KM8Itl != null)
					G6KM8Itl.close();
				if (jRKJE4zn != null)
					jRKJE4zn.close();
				if (sjnMyWSQ != null)
					sjnMyWSQ.close();
				if (QMpvaF3n != null && QMpvaF3n.exists())
					QMpvaF3n.delete();
			}
		}
	}

}