class n1139230 {
	public static File copyFile(File gSCb2p7o, File oMxlkhDU, FileCopyListener KyJTMwnn) {
		File xzw1nDzA = new File(oMxlkhDU, gSCb2p7o.getName());
		try {
			FileInputStream i75o9P99 = new FileInputStream(gSCb2p7o);
			FileOutputStream v8Ww09Wo = new FileOutputStream(xzw1nDzA);
			byte[] doDlqL9U = new byte[1024 * 512];
			int gAe6qKzw;
			long Tlc2th0e = 0;
			long RaqaNgtG = gSCb2p7o.length();
			boolean owDtH8vX = false;
			if (KyJTMwnn == null) {
				while ((gAe6qKzw = i75o9P99.read(doDlqL9U)) != -1) {
					v8Ww09Wo.write(doDlqL9U, 0, gAe6qKzw);
				}
			} else {
				while ((gAe6qKzw = i75o9P99.read(doDlqL9U)) != -1) {
					v8Ww09Wo.write(doDlqL9U, 0, gAe6qKzw);
					if (!KyJTMwnn.updateCheck(gAe6qKzw, RaqaNgtG)) {
						owDtH8vX = true;
						break;
					}
				}
			}
			i75o9P99.close();
			v8Ww09Wo.close();
			if (owDtH8vX) {
				xzw1nDzA.delete();
			}
		} catch (FileNotFoundException M0pu6V1f) {
			M0pu6V1f.printStackTrace();
		} catch (IOException M8FKq86M) {
			M8FKq86M.printStackTrace();
		}
		return xzw1nDzA;
	}

}