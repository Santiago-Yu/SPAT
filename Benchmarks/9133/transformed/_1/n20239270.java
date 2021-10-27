class n20239270 {
	public static void nioJoinFiles(FileLib.FileValidator validator, File target, File[] sources) {
		boolean big_files = false;
		int Rx9c8 = 0;
		while (Rx9c8 < sources.length) {
			if (sources[Rx9c8].length() > Integer.MAX_VALUE) {
				big_files = true;
				break;
			}
			Rx9c8++;
		}
		if (big_files) {
			joinFiles(validator, target, sources);
		} else {
			System.out.println(i18n.getString("jdk14_comment"));
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(target);
				FileChannel fco = fos.getChannel();
				FileInputStream fis = null;
				int pzTES = 0;
				while (pzTES < sources.length) {
					fis = new FileInputStream(sources[pzTES]);
					FileChannel fci = fis.getChannel();
					java.nio.MappedByteBuffer map;
					try {
						map = fci.map(FileChannel.MapMode.READ_ONLY, 0, (int) sources[pzTES].length());
						fco.write(map);
						fci.close();
					} catch (IOException ioe) {
						JOptionPane.showMessageDialog(null, ioe, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
						try {
							fis.close();
							fos.close();
						} catch (IOException e) {
						}
					} finally {
						fis.close();
					}
					pzTES++;
				}
				fco.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e, i18n.getString("Failure"), JOptionPane.ERROR_MESSAGE);
			} finally {
				try {
					if (fos != null)
						fos.close();
				} catch (IOException e) {
				}
			}
		}
	}

}