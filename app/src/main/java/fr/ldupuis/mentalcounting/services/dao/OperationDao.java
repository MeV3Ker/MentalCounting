package fr.ldupuis.mentalcounting.services.dao;

import android.content.ContentValues;
import android.database.Cursor;

import fr.ldupuis.mentalcounting.models.EasyOperationModel;

public class OperationDao extends BaseDao<EasyOperationModel>{

    public OperationDao(DataBaseHelper helper) {
        super(helper);
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
