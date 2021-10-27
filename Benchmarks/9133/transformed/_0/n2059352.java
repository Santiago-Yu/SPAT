class n2059352 {
	public static void main(String[] tdJw0lmu) {
		String Ryx3YR0h = "test_data/blobs.png";
		String klvPTXsb = "ReadWriteTest.png";
		itkImageFileReaderUC2_Pointer F6rwMEzN = itkImageFileReaderUC2.itkImageFileReaderUC2_New();
		itkImageFileWriterUC2_Pointer vcwCwi4B = itkImageFileWriterUC2.itkImageFileWriterUC2_New();
		F6rwMEzN.SetFileName(Ryx3YR0h);
		vcwCwi4B.SetFileName(klvPTXsb);
		vcwCwi4B.SetInput(F6rwMEzN.GetOutput());
		vcwCwi4B.Update();
	}

}