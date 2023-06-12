package com.mirea.kt.android2023;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//Загрузка данных о книгах (название книги, автор, номер стеллажа, номер полки, артикул)
// с сервера при первом запуске приложения на устройстве Android.
// После получения данных они сохраняются в базу данный SQLite.
    public class BookLoader extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "books.db";
    private static final String TABLE_NAME = "books";
    private static final String TITLE_COLUMN = "title";
    private static final String AUTHOR_COLUMN = "author";
    private static final String SHELF_COLUMN = "shelfNumber";
    private static final String SHELF_NUMBER_COLUMN = "rackNumber";
    private static final String ARTICLE_COLUMN = "vendorCode";
    private Context context;

    public BookLoader(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSQL = "CREATE TABLE " + TABLE_NAME + " (" +
                TITLE_COLUMN + " TEXT, " +
                AUTHOR_COLUMN + " TEXT, " +
                SHELF_COLUMN + " TEXT, " +
                SHELF_NUMBER_COLUMN + " INTEGER, " +
                ARTICLE_COLUMN + " TEXT)";
        db.execSQL(createTableSQL);

        // // Загружаем исходные книги с сервера
        loadInitialBooks();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Удаляем таблицу и создаем ее заново, чтобы обновить базу данных
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    private void loadInitialBooks() {
        try {
            // Make an HTTP request to the server to retrieve books data
            URL url = new URL("https://example.com/books");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            //Разобрать ответ и вставить данные в базу
            String[] booksData = response.toString().split("\n");
            SQLiteDatabase db = getWritableDatabase();
}

