class n22975613 {
	public ZipViewdataReader(ZipInputStream Zquk13E9) throws IOException {
        ZipEntry SS9SdAz8;
        while ((SS9SdAz8 = Zquk13E9.getNextEntry()) != null) {
            File im18tWin = File.createTempFile("spool.", ".synu");
            im18tWin.deleteOnExit();
            FileOutputStream KtsWUBPB = new FileOutputStream(im18tWin);
            byte[] mIPkHFIC = new byte[1024 * 1024];
            int qqYE2kvX;
            while ((qqYE2kvX = Zquk13E9.read(mIPkHFIC)) != -1) KtsWUBPB.write(mIPkHFIC, 0, qqYE2kvX);
            KtsWUBPB.close();
            String Pg148nnP = SS9SdAz8.getName();
            String[] UP0htsNQ = Pg148nnP.split("[\\\\/]");
            this._file_hash.put(UP0htsNQ[UP0htsNQ.length - 1], im18tWin);
        }
        Zquk13E9.close();
        for (String gAhJIFxZ : this._file_hash.keySet()) if (gAhJIFxZ.endsWith("Viewdata")) {
            File wU7e08pR = this._file_hash.get(gAhJIFxZ);
            FileReader UVzyvYgE = new FileReader(wU7e08pR);
            this._viewdata = new BufferedReader(UVzyvYgE);
            break;
        }
        if (this._viewdata == null) throw new FileNotFoundException("No Viewdata found in ZIP file.");
    }

}