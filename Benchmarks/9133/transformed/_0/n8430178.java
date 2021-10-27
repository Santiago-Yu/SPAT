class n8430178 {
	public static void copyFile(String GgZFVVad, String kO0SgaSq) throws IOException {
		GgZFVVad = Shell.getUtils().constructPath(GgZFVVad);
		File kQLoRhSX = new File(GgZFVVad);
		kO0SgaSq = Shell.getUtils().constructPath(kO0SgaSq);
		File a2jmLsw6 = new File(kO0SgaSq);
		FileInputStream e1cuJg1z = null;
		FileOutputStream bf6DMGO0 = null;
		byte[] XHEWdaWd;
		int lo64gSE6;
		try {
			if (!kQLoRhSX.exists() || !kQLoRhSX.isFile())
				throw new FileCopyException("cp: no such source file: " + GgZFVVad);
			if (!kQLoRhSX.canRead())
				throw new FileCopyException("cp: source file " + "is unreadable: " + GgZFVVad);
			if (a2jmLsw6.exists()) {
				if (a2jmLsw6.isFile()) {
					BufferedReader P6kQP66I = new BufferedReader(new InputStreamReader(System.in));
					String iHN5C3Qn;
					if (!a2jmLsw6.canWrite())
						throw new FileCopyException("cp: destination " + "file is unwriteable: " + kO0SgaSq);
					System.out.print("cp: file " + kO0SgaSq + " already exists. Overwrite it ? (Y/N): ");
					System.out.flush();
					iHN5C3Qn = P6kQP66I.readLine();
					if (!iHN5C3Qn.equals("Y") && !iHN5C3Qn.equals("y"))
						throw new FileCopyException("cp: copy cancelled.");
				} else
					throw new FileCopyException("cp: destination " + "is not a file: " + kO0SgaSq);
			} else {
				File Qb2s9T7a = parent(a2jmLsw6);
				if (!Qb2s9T7a.exists())
					throw new FileCopyException("cp: destination " + "directory doesn't exist: " + kO0SgaSq);
				if (!Qb2s9T7a.canWrite())
					throw new FileCopyException("cp: destination " + "directory is unwriteable: " + kO0SgaSq);
			}
			e1cuJg1z = new FileInputStream(kQLoRhSX);
			bf6DMGO0 = new FileOutputStream(a2jmLsw6);
			XHEWdaWd = new byte[1024];
			int JTv1HA0q = (new Long((kQLoRhSX.length() / 1024) / 50)).intValue();
			int slZrWNzj = 1;
			int wqfMhHGf = 0;
			System.out.print("cp: ");
			while (true) {
				if (wqfMhHGf < 50) {
					if ((slZrWNzj - 1) == JTv1HA0q && JTv1HA0q != 0) {
						System.out.print("#");
						slZrWNzj = 1;
						wqfMhHGf++;
					} else if (JTv1HA0q == 0) {
						int FrtoF0Ls = 1;
						if (slZrWNzj > 1)
							FrtoF0Ls = (50 / slZrWNzj) - 50;
						else
							FrtoF0Ls = 50 / slZrWNzj;
						for (int cPe6GDag = 0; cPe6GDag < FrtoF0Ls; cPe6GDag++)
							System.out.print("#");
						wqfMhHGf += FrtoF0Ls;
					}
				}
				lo64gSE6 = e1cuJg1z.read(XHEWdaWd);
				if (lo64gSE6 == -1)
					break;
				bf6DMGO0.write(XHEWdaWd, 0, lo64gSE6);
				slZrWNzj++;
			}
			System.out.println();
		} finally {
			if (e1cuJg1z != null)
				try {
					e1cuJg1z.close();
				} catch (IOException DTaVP9Ke) {
				}
			if (bf6DMGO0 != null)
				try {
					bf6DMGO0.close();
				} catch (IOException rOivtSSr) {
				}
		}
	}

}