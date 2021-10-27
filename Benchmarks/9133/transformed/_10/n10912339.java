class n10912339 {
	public int obtenerCantidad() {
		try {
			BufferedInputStream is = null;
			BufferedOutputStream dest = null;
			ZipFile zipfile = new ZipFile("cantidadArchivos.zip");
			ZipEntry entry;
			Enumeration e = zipfile.entries();
			DataInputStream input = new DataInputStream(new FileInputStream("cantidadArchivos.txt"));
			while (e.hasMoreElements()) {
				entry = (ZipEntry) e.nextElement();
				is = new BufferedInputStream(zipfile.getInputStream(entry));
				int count;
				byte data[] = new byte[buffer];
				FileOutputStream fos = new FileOutputStream(entry.getName());
				dest = new BufferedOutputStream(fos, buffer);
				while ((count = is.read(data, 0, buffer)) != -1)
					dest.write(data, 0, count);
				dest.flush();
				dest.close();
				is.close();
			}
			int a = Integer.parseInt(input.readLine());
			input.close();
			return (a);
		} catch (Exception e) {
			return (0);
		}
	}

}