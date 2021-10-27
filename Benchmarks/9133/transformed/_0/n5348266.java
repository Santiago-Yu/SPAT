class n5348266 {
	public void copyFile(String etwZLOUK, String Ndu9NaT0, String zzRzFn4z, boolean nAf1vfAp) throws Exception {
		File BXVc0Bju = new File(etwZLOUK);
		File WBIfU65w = new File(Ndu9NaT0);
		if (!BXVc0Bju.exists()) {
			throw new Exception("source file (" + etwZLOUK + ") does not exist!");
		}
		if (!BXVc0Bju.isFile()) {
			throw new Exception("source file (" + etwZLOUK + ") is not a file!");
		}
		if (!BXVc0Bju.canRead()) {
			throw new Exception("source file (" + etwZLOUK + ") is not readable!");
		}
		if (WBIfU65w.exists()) {
			m_out.print("  - " + Ndu9NaT0 + " exists, removing... ");
			if (WBIfU65w.delete()) {
				m_out.println("REMOVED");
			} else {
				m_out.println("FAILED");
				throw new Exception("unable to delete existing file: " + BXVc0Bju);
			}
		}
		m_out.print("  - copying " + etwZLOUK + " to " + Ndu9NaT0 + "... ");
		if (!WBIfU65w.getParentFile().exists()) {
			if (!WBIfU65w.getParentFile().mkdirs()) {
				throw new Exception("unable to create directory: " + WBIfU65w.getParent());
			}
		}
		if (!WBIfU65w.createNewFile()) {
			throw new Exception("unable to create file: " + WBIfU65w);
		}
		FileChannel O6yD8R2Z = null;
		FileChannel UygCibQn = null;
		try {
			O6yD8R2Z = new FileInputStream(BXVc0Bju).getChannel();
			UygCibQn = new FileOutputStream(WBIfU65w).getChannel();
			UygCibQn.transferFrom(O6yD8R2Z, 0, O6yD8R2Z.size());
		} catch (FileNotFoundException v1UDl9Qk) {
			throw new Exception("unable to copy " + BXVc0Bju + " to " + WBIfU65w, v1UDl9Qk);
		} finally {
			if (O6yD8R2Z != null) {
				O6yD8R2Z.close();
			}
			if (UygCibQn != null) {
				UygCibQn.close();
			}
		}
		m_out.println("DONE");
	}

}