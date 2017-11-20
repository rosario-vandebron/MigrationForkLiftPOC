import java.util.UUID

import slick.jdbc.PostgresProfile.api._
import com.liyaos.forklift.slick.DBIOMigration
import datamodel.v2.schema.tables._

object M3 {

  MyMigrations.migrations = MyMigrations.migrations :+ DBIOMigration(3)(
    DBIO.seq(
      Accounts ++= Seq(
        AccountsRow(UUID.randomUUID()),
        AccountsRow(UUID.randomUUID())
      ),
      SmartChargeLocations ++= Seq(
        SmartChargeLocationsRow(UUID.randomUUID())
      )
    ))
}
