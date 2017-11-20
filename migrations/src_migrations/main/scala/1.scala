import com.liyaos.forklift.slick.{APIMigration, DBIOMigration}
import database.Tables
import slick.migration.api.{PostgresDialect, TableMigration}


//object M1 {
//  MyMigrations.migrations = MyMigrations.migrations :+ DBIOMigration(1)(
//    DBIO.seq(
////      Tables.accountsTableQ.schema.create
//    ))
//}

object M1 {
  implicit val dialect = new PostgresDialect

  MyMigrations.migrations = MyMigrations.migrations :+ APIMigration(3)(
    TableMigration(Tables.accountsTableQ).create
      .dropColumns(_.)
    )
}


