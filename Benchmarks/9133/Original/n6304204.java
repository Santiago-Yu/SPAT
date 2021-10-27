class n6304204{
    public void copyURLToFile(TmpFile p_TmpFile) {
        byte[] l_Buffer;
        URLConnection l_Connection = null;
        DataInputStream l_IN = null;
        DataOutputStream l_Out = null;
        FileOutputStream l_FileOutStream = null;
        try {
            System.gc();
            if (error.compareTo(noError) == 0) {
                l_Connection = urlHome.openConnection();
                l_FileOutStream = new FileOutputStream(p_TmpFile.getAbsolutePath());
                l_Out = new DataOutputStream(l_FileOutStream);
                l_IN = new DataInputStream(l_Connection.getInputStream());
                l_Buffer = new byte[8192];
                int bytes = 0;
                while ((bytes = l_IN.read(l_Buffer)) > 0) {
                    l_Out.write(l_Buffer, 0, bytes);
                }
            }
        } catch (MalformedURLException mue) {
            error = "MalformedURLException in connecting url was " + mue.getMessage();
        } catch (IOException io) {
            error = "IOException in connecting url was " + io.getMessage();
        } catch (Exception e) {
            error = "Exception in connecting url was " + e.getMessage();
        } finally {
            try {
                l_IN.close();
                l_Out.flush();
                l_FileOutStream.flush();
                l_FileOutStream.close();
                l_Out.close();
            } catch (Exception e) {
                error = "Exception in connecting url was " + e.getMessage();
            }
        }
    }

}