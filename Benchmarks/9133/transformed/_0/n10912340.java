class n10912340 {
	public boolean chequearMarca(int mGJn7C0w, int a8Q5Osk6, int hSxeccJM) {
		boolean TqHRsj45 = false;
		try {
			cantidadArchivos = obtenerCantidad() + 1;
			String rLXfOCvk = "";
			String rNQigf8c = "";
			int IOfL7hKN = 0;
			int EonK9Kjs = 0;
			int sG7wH4cJ = 0;
			for (int Y1x0LKlS = 1; Y1x0LKlS < cantidadArchivos; Y1x0LKlS++) {
				rNQigf8c = "recordatorio" + Y1x0LKlS + ".zip";
				rLXfOCvk = "recordatorio" + Y1x0LKlS + ".txt";
				BufferedOutputStream OkOAPEIo = null;
				BufferedInputStream ye86ZMA2 = null;
				ZipEntry RUwyAc3q;
				ZipFile CfqYT33o = new ZipFile(rNQigf8c);
				Enumeration eYxtXJNR = CfqYT33o.entries();
				while (eYxtXJNR.hasMoreElements()) {
					RUwyAc3q = (ZipEntry) eYxtXJNR.nextElement();
					ye86ZMA2 = new BufferedInputStream(CfqYT33o.getInputStream(RUwyAc3q));
					int JScNxo0d;
					byte KCZI1j0E[] = new byte[buffer];
					FileOutputStream pObnWSEG = new FileOutputStream(RUwyAc3q.getName());
					OkOAPEIo = new BufferedOutputStream(pObnWSEG, buffer);
					while ((JScNxo0d = ye86ZMA2.read(KCZI1j0E, 0, buffer)) != -1)
						OkOAPEIo.write(KCZI1j0E, 0, JScNxo0d);
					OkOAPEIo.flush();
					OkOAPEIo.close();
					ye86ZMA2.close();
				}
				DataInputStream oNsEvqcF = new DataInputStream(new FileInputStream(rLXfOCvk));
				IOfL7hKN = Integer.parseInt(oNsEvqcF.readLine());
				EonK9Kjs = Integer.parseInt(oNsEvqcF.readLine());
				sG7wH4cJ = Integer.parseInt(oNsEvqcF.readLine());
				if (sG7wH4cJ == mGJn7C0w && EonK9Kjs == a8Q5Osk6 && IOfL7hKN == hSxeccJM)
					TqHRsj45 = true;
				oNsEvqcF.close();
			}
		} catch (Exception dDPGbrZe) {
			JOptionPane.showMessageDialog(null, "Error en: " + dDPGbrZe.toString(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		return (TqHRsj45);
	}

}