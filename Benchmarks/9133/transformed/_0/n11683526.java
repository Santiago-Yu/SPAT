class n11683526 {
	private static boolean moveFiles(String NwSUJbIv, String VB5vERnw) {
		boolean j9CBPjZI = false;
		boolean KUwWKp2i = false;
		File h8Zfl7mf = new File(NwSUJbIv);
		if (!h8Zfl7mf.exists()) {
			System.out.println(getTimeStamp() + "ERROR - source directory does not exist.");
			return true;
		}
		if (h8Zfl7mf.listFiles() == null) {
			System.out.println(getTimeStamp()
					+ "ERROR - Empty file list. Possible permission error on source directory " + NwSUJbIv);
			return true;
		}
		File[] aMoqp758 = h8Zfl7mf.listFiles();
		for (int dw2Ts3IC = 0; dw2Ts3IC < aMoqp758.length; dw2Ts3IC++) {
			File zW72Y190 = aMoqp758[dw2Ts3IC];
			if (zW72Y190.getName().startsWith(".")) {
				continue;
			}
			String rC3lvBz3 = VB5vERnw + File.separator + zW72Y190.getName();
			String lJG5EXki = "move";
			boolean YZ1NgxtU = zW72Y190.renameTo(new File(rC3lvBz3));
			if (YZ1NgxtU) {
				KUwWKp2i = true;
			} else {
				lJG5EXki = "mv";
				try {
					Process g2GWNwrP = Runtime.getRuntime()
							.exec(new String[] { "mv", zW72Y190.getCanonicalPath(), rC3lvBz3 });
					g2GWNwrP.waitFor();
					g2GWNwrP.destroy();
					if (!new File(rC3lvBz3).exists()) {
						YZ1NgxtU = false;
					} else {
						YZ1NgxtU = true;
						KUwWKp2i = true;
					}
				} catch (Exception ELZDQT2h) {
					YZ1NgxtU = false;
				}
				if (!YZ1NgxtU) {
					lJG5EXki = "copy";
					FileChannel tupsvrW9 = null;
					FileChannel dT5Cz9Gh = null;
					try {
						tupsvrW9 = new FileInputStream(zW72Y190).getChannel();
						File gml24s9o = new File(rC3lvBz3);
						dT5Cz9Gh = new FileOutputStream(gml24s9o).getChannel();
						tupsvrW9.transferTo(0, tupsvrW9.size(), dT5Cz9Gh);
						tupsvrW9.close();
						tupsvrW9 = null;
						dT5Cz9Gh.close();
						dT5Cz9Gh = null;
						zW72Y190.delete();
						YZ1NgxtU = true;
					} catch (Exception C6rW5Ope) {
						YZ1NgxtU = false;
					} finally {
						if (tupsvrW9 != null) {
							try {
								tupsvrW9.close();
							} catch (Exception sjmIVFCv) {
							}
						}
						if (dT5Cz9Gh != null) {
							try {
								dT5Cz9Gh.close();
							} catch (Exception mglsmNQG) {
							}
						}
					}
				}
			}
			if (YZ1NgxtU) {
				System.out.println(getTimeStamp() + lJG5EXki + " " + zW72Y190.getAbsolutePath() + " to " + VB5vERnw);
				KUwWKp2i = true;
			} else {
				System.out.println(getTimeStamp() + "ERROR - " + lJG5EXki + " " + zW72Y190.getName() + " to " + rC3lvBz3
						+ " failed.");
				j9CBPjZI = true;
			}
		}
		if (KUwWKp2i && !j9CBPjZI) {
			try {
				currentLastActivity = System.currentTimeMillis();
				updateLastActivity(currentLastActivity);
			} catch (NumberFormatException TAVuItSw) {
				System.out.println(getTimeStamp() + "ERROR: NumberFormatException when trying to update lastActivity.");
				j9CBPjZI = true;
			} catch (IOException lgoKTR56) {
				System.out.println(getTimeStamp() + "ERROR: IOException when trying to update lastActivity. "
						+ lgoKTR56.toString());
				j9CBPjZI = true;
			}
		}
		return j9CBPjZI;
	}

}