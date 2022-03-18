package fr.ldupuis.mentalcounting.services.dao;

import android.content.Context;
import android.provider.BaseColumns;

/**
 * Class implémentant les opérations C et R de CRUD
 */
public class SampleDbHelper extends DataBaseHelper{
    public SampleDbHelper(Context context) {
        super(context, "SampleDB", 1);
    }

    /**
     * Opération de création dans la BDD pour les opération facile
     * @return String, code SQL de création d'une table et d'insertion de donnée (opération facile)
     */
    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + EasyOperationDao.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                EasyOperationDao.FIRST + " INTEGER NOT NULL," +
                EasyOperationDao.SECOND + " INTEGER NOT NULL," +
                EasyOperationDao.OPERATOR + " TEXT NOT NULL" +
                ")";
    }
    /* Quelque chose comme ça pour les operations difficiles

    @Override
    protected String getCreationSql() {
        return "CREATE TABLE IF NOT EXISTS " + HardOperationDao.TABLE_NAME + " (" +
                BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                HardOperationDao.FIRST + " INTEGER NOT NULL," +
                HardOperationDao.SECOND + " INTEGER NOT NULL," +
                HardOperationDao.THIRD + " INTEGER NOT NULL," +
                HardOperationDao.OPERATOR + " TEXT NOT NULL" +
                HardOperationDao.SECOND_OPERATOR + " TEXT NOT NULL" +
                ")";
    }*/

    /**
     * Opération de suppression d'une table
     * @return String. Code SQL de suppression d'une table
     */
    @Override
    protected String getDeleteSql() {
        return "DROP TABLE IF EXISTS " + EasyOperationDao.TABLE_NAME;
    }
}