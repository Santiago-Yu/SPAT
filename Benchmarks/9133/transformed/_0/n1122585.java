class n1122585 {
	private String copyImageFile(String gczz9TTY, String EZmGfoEH) {
		FileOutputStream m9L8c9sy = null;
		File iJZV17EN = null;
		String vd5bZz6g;
		String eqYCttRU = "";
		byte[] xPJByC7R;
		int QesqxfOC;
		int oCt2V6Ck = 0;
		int A6gEftmq = 0;
		InputStream Y7PGzO7T = null;
		try {
			URL JXoYpJOs = new URL(gczz9TTY);
			Y7PGzO7T = JXoYpJOs.openStream();
			eqYCttRU = JXoYpJOs.getFile();
			A6gEftmq = 0;
			oCt2V6Ck = 0;
			A6gEftmq = eqYCttRU.indexOf('/', A6gEftmq + 1);
			while (A6gEftmq > -1) {
				oCt2V6Ck = A6gEftmq + 1;
				A6gEftmq = eqYCttRU.indexOf('/', A6gEftmq + 1);
			}
			eqYCttRU = EZmGfoEH + File.separator + eqYCttRU.substring(oCt2V6Ck);
			iJZV17EN = new File(eqYCttRU);
			if (iJZV17EN.exists()) {
				if (iJZV17EN.isFile()) {
					if (!iJZV17EN.canWrite()) {
						System.out.println("FileCopy: destination " + "file is unwriteable: " + eqYCttRU);
					}
					System.out.println("File " + eqYCttRU + " already exists. File will be overwritten.");
				} else {
					System.out.println("FileCopy: destination " + "is not a file: " + eqYCttRU);
				}
			} else {
				File V6tgtQLh = parent(iJZV17EN);
				if (!V6tgtQLh.exists()) {
					System.out.println("FileCopy: destination " + "directory doesn't exist: " + eqYCttRU);
				}
				if (!V6tgtQLh.canWrite()) {
					System.out.println("FileCopy: destination " + "directory is unwriteable: " + eqYCttRU);
				}
			}
			m9L8c9sy = new FileOutputStream(eqYCttRU);
			xPJByC7R = new byte[1024];
			while (true) {
				QesqxfOC = Y7PGzO7T.read(xPJByC7R);
				if (QesqxfOC == -1)
					break;
				m9L8c9sy.write(xPJByC7R, 0, QesqxfOC);
			}
		} catch (MalformedURLException QldiKyR4) {
			System.out.println("Bad URL " + gczz9TTY);
		} catch (IOException WJqabNef) {
			System.out.println(" IO error: " + WJqabNef.getMessage());
		} finally {
			if (Y7PGzO7T != null) {
				try {
					Y7PGzO7T.close();
				} catch (IOException gbwe7W8p) {
				}
			}
			if (m9L8c9sy != null) {
				try {
					m9L8c9sy.close();
				} catch (IOException R5Jt5tx7) {
				}
			}
		}
		return (eqYCttRU);
	}

}