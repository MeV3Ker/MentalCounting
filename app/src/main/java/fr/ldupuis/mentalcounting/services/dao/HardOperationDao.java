package fr.ldupuis.mentalcounting.services.dao;

import android.content.ContentValues;
import android.database.Cursor;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;
import fr.ldupuis.mentalcounting.models.HardOperationModel;

/**
 * Class permettant de lire et d'inscrire des données dans le BDD (Magie)
 */
public class HardOperationDao extends BaseDao<HardOperationModel>{

    public static final int FIRST = 0;
    public static final int SECOND = 0;
    public static final int THIRD = 0;
    public static final String OPERATOR = "operator";
    public static final String SECOND_OPERATOR = "operator";
    public static final String TABLE_NAME = "hard_operation";


    public HardOperationDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return "Operation";
    }

    @Override
    protected void putValues(ContentValues values, HardOperationModel entity) {
        values.put("FIRST", entity.getFirstOperationMember());
        values.put("SECOND", entity.getSecondOperationMember());
        values.put("THIRD", entity.getThirdOperationMember());
        values.put("OPERATOR", entity.getOperator());
        values.put("SECOND_OPERATOR", entity.getSecondOperator());


    }

    @Override
    protected HardOperationModel getEntity(Cursor cursor) {

        int columnIndex = cursor.getColumnIndex("FIRST");
        int first = cursor.getInt(columnIndex);

        columnIndex = cursor.getColumnIndex("SECOND");
        int second = cursor.getInt(columnIndex);

        columnIndex = cursor.getColumnIndex("THIRD");
        int third = cursor.getInt(columnIndex);

        columnIndex = cursor.getColumnIndex("OPERATOR");
        String operator = cursor.getString(columnIndex);

        columnIndex = cursor.getColumnIndex("SECOND_OPERATOR");
        String secondOperator = cursor.getString(columnIndex);

        return new HardOperationModel(first, second, third, operator, secondOperator);
    }
}
