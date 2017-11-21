import java.util.UUID

import slick.jdbc.PostgresProfile.api._
import com.liyaos.forklift.slick.DBIOMigration
import datamodel.v3.schema.tables._

object M4 {
  PostgresMigration.migrations = PostgresMigration.migrations :+ DBIOMigration(4)(
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
