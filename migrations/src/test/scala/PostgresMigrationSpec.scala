import datamodel.latest.schema.tables.{Accounts, SmartChargeLocations}
import org.scalatest.{BeforeAndAfterEach, Matchers, WordSpec}
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.Await
import scala.concurrent.duration._

class PostgresMigrationSpec extends WordSpec with Matchers {

  //Add here the migration sequence you want to test
  val migrationSequence = M1;M2;M3;M4

  "PostgresMigration " should {
    "migrate the database till last schema" in {

      try {
        PostgresMigration.reset
        PostgresMigration.init
        PostgresMigration.up()

        val accF = PostgresMigration.db.run {
          Accounts.result
        }

        val sclF = PostgresMigration.db.run {
          SmartChargeLocations.result
        }

        val acc = Await.result(accF, 5.seconds)
        val scl = Await.result(sclF, 5.seconds)

        acc should have size 2
        scl should have size 1

      } finally {
        PostgresMigration.reset
        PostgresMigration.db.close()
      }

    }
  }
}



