class n975289 {
	public static void copy(File BwBIGYtp, File jU8YVzRa, CopyMode pIfSbjbS) throws IOException {
		if (!BwBIGYtp.exists()) {
			IllegalArgumentException KUkZFSfT = new IllegalArgumentException(
					"Source doesn't exist: " + BwBIGYtp.getCanonicalFile());
			log.throwing("Utils", "copy", KUkZFSfT);
			throw KUkZFSfT;
		}
		if (BwBIGYtp.isFile()) {
			if (!jU8YVzRa.canWrite()) {
				IllegalArgumentException v4MD9XUB = new IllegalArgumentException(
						"Cannot write to target location: " + jU8YVzRa.getCanonicalFile());
				log.throwing("Utils", "copy", v4MD9XUB);
				throw v4MD9XUB;
			}
		}
		if (jU8YVzRa.exists()) {
			if ((pIfSbjbS.val & CopyMode.OverwriteFile.val) != CopyMode.OverwriteFile.val) {
				IllegalArgumentException BxKnhmaS = new IllegalArgumentException(
						"Target already exists: " + jU8YVzRa.getCanonicalFile());
				log.throwing("Utils", "copy", BxKnhmaS);
				throw BxKnhmaS;
			}
			if (jU8YVzRa.isDirectory()) {
				if ((pIfSbjbS.val & CopyMode.OverwriteFolder.val) != CopyMode.OverwriteFolder.val) {
					IllegalArgumentException qy1zbjkL = new IllegalArgumentException(
							"Target is a folder: " + jU8YVzRa.getCanonicalFile());
					log.throwing("Utils", "copy", qy1zbjkL);
					throw qy1zbjkL;
				} else
					jU8YVzRa.delete();
			}
		}
		if (BwBIGYtp.isFile()) {
			FileChannel L3y7doTC = new FileInputStream(BwBIGYtp).getChannel();
			FileLock Wssdr82M = L3y7doTC.lock();
			FileChannel mCxWmMCs = new FileOutputStream(jU8YVzRa).getChannel();
			FileLock uF8lhXhi = mCxWmMCs.lock();
			try {
				L3y7doTC.transferTo(0, (int) L3y7doTC.size(), mCxWmMCs);
			} finally {
				Wssdr82M.release();
				uF8lhXhi.release();
				L3y7doTC.close();
				mCxWmMCs.close();
			}
		} else {
			jU8YVzRa.mkdirs();
			File[] KsTy8Fn7 = jU8YVzRa.listFiles();
			for (File LTSFzle4 : KsTy8Fn7) {
				File TMLmphZu = new File(jU8YVzRa.getCanonicalPath() + "/" + LTSFzle4.getName());
				copy(LTSFzle4, TMLmphZu, pIfSbjbS);
			}
		}
	}

}