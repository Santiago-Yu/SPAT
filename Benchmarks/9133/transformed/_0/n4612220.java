class n4612220 {
	private void copy(File ihVOAsN8, File iO4vaRBg) throws PackageException {
		try {
			FileInputStream rUkq4Sj3 = new FileInputStream(ihVOAsN8);
			FileOutputStream n9elz27L = new FileOutputStream(iO4vaRBg);
			byte[] FaFtf3fS = new byte[1024];
			int ZD3TKQnx;
			while ((ZD3TKQnx = rUkq4Sj3.read(FaFtf3fS)) > 0)
				n9elz27L.write(FaFtf3fS, 0, ZD3TKQnx);
			rUkq4Sj3.close();
			n9elz27L.close();
		} catch (IOException QtEP07er) {
			throw new PackageException("Unable to copy " + ihVOAsN8.getPath() + " to " + iO4vaRBg.getPath() + " :: "
					+ QtEP07er.toString());
		}
	}

}