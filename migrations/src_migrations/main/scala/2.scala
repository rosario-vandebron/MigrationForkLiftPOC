import slick.jdbc.PostgresProfile.api._
import com.liyaos.forklift.slick.{APIMigration, SqlMigration}
import database.Tables
import slick.lifted.PrimaryKey
import slick.migration.api.{PostgresDialect, TableMigration}


object M2 {
  implicit val dialect = new PostgresDialect
  PostgresMigration.migrations = PostgresMigration.migrations :+ APIMigration(2)(
    TableMigration(Tables.accountsTableQ)
      .create
      .addColumns(_.id)
    //        .addPrimaryKeys( table => PrimaryKey(table.id.toString(), Array(table.id.toNode)))
  )
}