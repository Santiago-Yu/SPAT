class n20100809 {
	public static void copy(File wDgntuqf, File hYtddS1g) throws IOException {
		if (wDgntuqf.isDirectory()) {
			if (!hYtddS1g.exists()) {
				boolean YEX9EBP0 = hYtddS1g.mkdir();
				if (!YEX9EBP0)
					throw new IOException("Unable to create directoy: " + hYtddS1g);
			}
			String[] YbbfvTEA = wDgntuqf.list();
			for (String MwUaSWd7 : YbbfvTEA) {
				copy(new File(wDgntuqf, MwUaSWd7), new File(hYtddS1g, MwUaSWd7));
			}
		} else {
			if (wDgntuqf.exists()) {
				FileChannel JQPO354d = null;
				FileChannel wwrjFD2u = null;
				try {
					JQPO354d = new FileInputStream(wDgntuqf).getChannel();
					wwrjFD2u = new FileOutputStream(hYtddS1g).getChannel();
					long T2AnmTJ7 = JQPO354d.size();
					MappedByteBuffer fGewuuH5 = JQPO354d.map(FileChannel.MapMode.READ_ONLY, 0, T2AnmTJ7);
					wwrjFD2u.write(fGewuuH5);
				} finally {
					if (JQPO354d != null)
						JQPO354d.close();
					if (wwrjFD2u != null)
						wwrjFD2u.close();
				}
			}
		}
	}

}