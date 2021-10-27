class n5017412 {
	public static void copyFile(File mfsCbqNU, File LyQNrGcX) throws Exception {
		if (mfsCbqNU.isDirectory()) {
			if (!LyQNrGcX.isDirectory()) {
				LyQNrGcX.mkdirs();
			}
			String[] HexYvQrY = mfsCbqNU.list();
			for (int OP5B3WFl = 0; OP5B3WFl < HexYvQrY.length; OP5B3WFl++) {
				copyFile(new File(mfsCbqNU, HexYvQrY[OP5B3WFl]), new File(LyQNrGcX, HexYvQrY[OP5B3WFl]));
			}
		} else {
			FileChannel b8hIoO7C = new FileInputStream(mfsCbqNU).getChannel();
			FileChannel jWLqRBH5 = new FileOutputStream(LyQNrGcX).getChannel();
			try {
				int WDpa1zoC = (64 * 1024 * 1024) - (32 * 1024);
				long bVeHoQqr = b8hIoO7C.size();
				long ymlX8EEs = 0;
				while (ymlX8EEs < bVeHoQqr) {
					ymlX8EEs += b8hIoO7C.transferTo(ymlX8EEs, WDpa1zoC, jWLqRBH5);
				}
			} catch (IOException RKVA4Dlu) {
				errorLog("{Malgn.copyFile} " + RKVA4Dlu.getMessage());
				throw RKVA4Dlu;
			} finally {
				if (b8hIoO7C != null)
					b8hIoO7C.close();
				if (jWLqRBH5 != null)
					jWLqRBH5.close();
			}
		}
	}

}