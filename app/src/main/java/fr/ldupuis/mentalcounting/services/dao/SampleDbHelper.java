/*package fr.ldupuis.mentalcounting.services.dao;

import android.content.Context;
import android.provider.BaseColumns;

public class SampleDbHelper extends DataBaseHelper{
    public SampleDbHelper(Context context) {
        super(context, "SampleDB", 1);
    }

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + OperationDao.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                OperationDao.FIRST_KEY + " INTEGER NOT NULL," +
                OperationDao.SECOND_KEY + " INTEGER NOT NULL," +
                OperationDao.OPERATOR_KEY + " TEXT NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS " + OperationDao.TABLE_NAME;
    }
}*/