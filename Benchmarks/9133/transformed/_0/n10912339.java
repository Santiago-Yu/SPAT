class n10912339 {
	public int obtenerCantidad() {
		try {
			BufferedOutputStream PQSLN1ya = null;
			BufferedInputStream GLed4FUt = null;
			ZipEntry PZIe0zQl;
			ZipFile pwFD0H4k = new ZipFile("cantidadArchivos.zip");
			Enumeration MskAkzOe = pwFD0H4k.entries();
			while (MskAkzOe.hasMoreElements()) {
				PZIe0zQl = (ZipEntry) MskAkzOe.nextElement();
				GLed4FUt = new BufferedInputStream(pwFD0H4k.getInputStream(PZIe0zQl));
				int WzuwyAw3;
				byte zjLWonHa[] = new byte[buffer];
				FileOutputStream MF059Tjv = new FileOutputStream(PZIe0zQl.getName());
				PQSLN1ya = new BufferedOutputStream(MF059Tjv, buffer);
				while ((WzuwyAw3 = GLed4FUt.read(zjLWonHa, 0, buffer)) != -1)
					PQSLN1ya.write(zjLWonHa, 0, WzuwyAw3);
				PQSLN1ya.flush();
				PQSLN1ya.close();
				GLed4FUt.close();
			}
			DataInputStream B9rc6HrI = new DataInputStream(new FileInputStream("cantidadArchivos.txt"));
			int ESjlmAaA = Integer.parseInt(B9rc6HrI.readLine());
			B9rc6HrI.close();
			return (ESjlmAaA);
		} catch (Exception j9u5o08e) {
			return (0);
		}
	}

}