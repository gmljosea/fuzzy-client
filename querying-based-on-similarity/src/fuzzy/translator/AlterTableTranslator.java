package fuzzy.translator;

import fuzzy.database.Connector;
import fuzzy.operations.ChangeColumnOperation;
import fuzzy.operations.Operation;
import java.sql.SQLException;

import java.util.List;
import net.sf.jsqlparser.statement.table.AlterOperation;
import net.sf.jsqlparser.statement.table.AlterTable;
import net.sf.jsqlparser.statement.table.ChangeColumn;
import net.sf.jsqlparser.statement.table.ColumnDefinition;

/**
 * A class to de-parse (that is, tranform from JSqlParser hierarchy into a string)
 * a {@link net.sf.jsqlparser.statement.create.table.CreateTable}
 */
public class AlterTableTranslator extends Translator {

    AlterTableTranslator(Connector connector, List<Operation> operations) {
        super(connector, operations);
    }

    public void translate(AlterTable alterTable)
        throws SQLException {
        String tableName = alterTable.getTable().getName();
        ChangeColumnOperation cco = new ChangeColumnOperation(connector);
        for (AlterOperation alterOperation : alterTable.getAlterOperations()) {
            switch (alterOperation.getType()) {
                case CHANGE:
                    ChangeColumn changeColumn = (ChangeColumn)alterOperation;
                    ColumnDefinition columnDefinition = changeColumn.getColumnDefinition();
                    cco.setDataType(columnDefinition.getColDataType().getDataType());
                    cco.setNewColumnName(columnDefinition.getColumnName());
                    cco.setOldColumnName(changeColumn.getColumnOld());
                    cco.setSchemaName(alterTable.getTable().getSchemaName());
                    cco.setTableName(tableName);
                    String options = "";
                    if (columnDefinition.getColumnSpecStrings() != null){
                        for (Object o : columnDefinition.getColumnSpecStrings()) {
                            options += ((String)o) + " ";
                        }
                    }
                    cco.setOptions(options);
                    operations.add(cco);
            }
        }
    }
}
