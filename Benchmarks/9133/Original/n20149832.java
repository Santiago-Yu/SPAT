class n20149832{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        try {
            URL url = new URL("http://placekitten.com/g/500/250");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(5000);
            Bitmap kitten = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
            Bitmap frame = BitmapFactory.decodeResource(getResources(), R.drawable.frame500);
            Bitmap output = Bitmap.createBitmap(frame.getWidth(), frame.getHeight(), Bitmap.Config.ARGB_8888);
            output.eraseColor(Color.BLACK);
            Canvas canvas = new Canvas(output);
            canvas.drawBitmap(kitten, 125, 125, new Paint());
            canvas.drawBitmap(frame, 0, 0, new Paint());
            Paint textPaint = new Paint();
            textPaint.setColor(Color.WHITE);
            textPaint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD));
            textPaint.setTextAlign(Align.CENTER);
            textPaint.setAntiAlias(true);
            textPaint.setTextSize(36);
            canvas.drawText("Cute", output.getWidth() / 2, (output.getHeight() / 2) + 140, textPaint);
            textPaint.setTextSize(24);
            canvas.drawText("Some of us just haz it.", output.getWidth() / 2, (output.getHeight() / 2) + 180, textPaint);
            ImageView imageView = (ImageView) this.findViewById(R.id.imageView);
            imageView.setImageBitmap(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}