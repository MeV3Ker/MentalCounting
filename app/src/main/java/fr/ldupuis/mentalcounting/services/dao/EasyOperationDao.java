package fr.ldupuis.mentalcounting.services.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;

/**
 * Class permettant de lire et d'inscrire des données dans le BDD (Magie)
 */
public class EasyOperationDao extends BaseDao<EasyOperationModel>{

    public static final int FIRST = 0;
    public static final int SECOND = 0;
    public static final String OPERATOR = "operator";
    public static final String TABLE_NAME = "easy_operation";


    public EasyOperationDao(Context helper) {
        super(new SampleDbHelper(helper));
    }

    @Override
    protected String getTableName() {
        return "Operation";
    }

    @Override
    protected void putValues(ContentValues values, EasyOperationModel entity) {
        values.put("FIRST", entity.getFirstOperationMember());
        values.put("SECOND", entity.getSecondOperationMember());
        values.put("OPERATOR", entity.getOperator());


    }

    @Override
    protected EasyOperationModel getEntity(Cursor cursor) {

        int columnIndex = cursor.getColumnIndex("FIRST");
        int first = cursor.getInt(columnIndex);

        columnIndex = cursor.getColumnIndex("SECOND");
        int second = cursor.getInt(columnIndex);

        columnIndex = cursor.getColumnIndex("OPERATOR");
        String operator = cursor.getString(columnIndex);

        return new EasyOperationModel(first, second, operator);
    }
}
