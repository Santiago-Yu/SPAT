class n11092394 {
	private void copy(final File ZnkOB6nF) throws IOException {
		String KCelAbaO = targetFilename(ZnkOB6nF);
		FileInputStream XW0FpB41 = new FileInputStream(ZnkOB6nF);
		try {
			FileChannel v1N187lg = XW0FpB41.getChannel();
			try {
				FileOutputStream Mm2QCHpr = new FileOutputStream(KCelAbaO);
				try {
					FileChannel sOkbvpf5 = Mm2QCHpr.getChannel();
					try {
						sOkbvpf5.transferFrom(v1N187lg, 0, v1N187lg.size());
					} finally {
						sOkbvpf5.close();
					}
				} finally {
					Mm2QCHpr.close();
				}
			} finally {
				v1N187lg.close();
			}
		} finally {
			XW0FpB41.close();
		}
	}

}