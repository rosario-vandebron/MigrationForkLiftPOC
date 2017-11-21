import java.util.UUID

import slick.jdbc.PostgresProfile.api._
import com.liyaos.forklift.slick.{APIMigration, DBIOMigration}
import database.Tables
import datamodel.v2.schema.tables._
import slick.migration.api.{PostgresDialect, TableMigration}

object M3 {
  implicit val dialect = new PostgresDialect
  PostgresMigration.migrations = PostgresMigration.migrations :+ APIMigration(3)(
    TableMigration(Tables.smartChargeTableQ)
      .create
      .addColumns(_.id)
    //      .addPrimaryKeys( table => PrimaryKey(table.id.toString(), Array(table.id.toNode)))
  )
}
