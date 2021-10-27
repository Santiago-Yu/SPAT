class n18288470 {
	public static void unzip(String FeW46Cta, String ulmvjCFI) {
		try {
			byte[] DEOueDaB = new byte[1024];
			ZipInputStream fjN3XeFY = null;
			ZipEntry wHS3gd6p;
			fjN3XeFY = new ZipInputStream(new FileInputStream(FeW46Cta));
			wHS3gd6p = fjN3XeFY.getNextEntry();
			while (wHS3gd6p != null) {
				String saFQQnWP = wHS3gd6p.getName();
				System.out.println("entryname " + saFQQnWP);
				int rT90ZQgF;
				FileOutputStream qk8LJY9m;
				File wo65FJqh = new File(saFQQnWP);
				String kSyBPe5T = wo65FJqh.getParent();
				if (kSyBPe5T == null) {
					if (wo65FJqh.isDirectory())
						break;
				}
				qk8LJY9m = new FileOutputStream(ulmvjCFI + saFQQnWP);
				while ((rT90ZQgF = fjN3XeFY.read(DEOueDaB, 0, 1024)) > -1)
					qk8LJY9m.write(DEOueDaB, 0, rT90ZQgF);
				qk8LJY9m.close();
				fjN3XeFY.closeEntry();
				wHS3gd6p = fjN3XeFY.getNextEntry();
			}
			fjN3XeFY.close();
		} catch (Exception YlaHLjMg) {
			YlaHLjMg.printStackTrace();
		}
	}

}