import com.liyaos.forklift.slick.{APIMigration, DBIOMigration}
import database.Tables
import slick.lifted.PrimaryKey
import slick.migration.api.{PostgresDialect, TableMigration}


//object M1 {
//  MyMigrations.migrations = MyMigrations.migrations :+ DBIOMigration(1)(
//    DBIO.seq(
////      Tables.accountsTableQ.schema.create
//    ))
//}

object M1 {
  implicit val dialect = new PostgresDialect
  MyMigrations.migrations = MyMigrations.migrations :+ APIMigration(1)(
    TableMigration(Tables.accountsTableQ)
        .create
        .addColumns(_.id)
//        .addPrimaryKeys( table => PrimaryKey(table.id.toString(), Array(table.id.toNode)))
  )
}


