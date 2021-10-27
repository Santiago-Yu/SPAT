class n20239270 {
	public static void nioJoinFiles(FileLib.FileValidator validator, File target, File[] sources) {
		boolean big_files = false;
		for (int i = 0; i < sources.length; i++) {
			if (sources[i].length() > Integer.MAX_VALUE) {
				big_files = true;
				break;
			}
		}
		if (big_files) {
			joinFiles(validator, target, sources);
		} else {
			System.out.println(i18n.getString("jdk14_comment"));
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(target);
				FileInputStream fis = null;
				FileChannel fco = fos.getChannel();
				for (int i = 0; i < sources.length; i++) {
					fis = new FileInputStream(sources[i]);
					java.nio.MappedByteBuffer map;
					FileChannel fci = fis.getChannel();
					try {
						map = fci.map(FileChannel.MapMode.READ_ONLY, 0, (int) sources[i].length());
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