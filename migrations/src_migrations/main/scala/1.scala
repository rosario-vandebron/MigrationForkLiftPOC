import com.liyaos.forklift.slick.{APIMigration, DBIOMigration, SqlMigration}
import slick.jdbc.PostgresProfile.api._

object M1 {
  PostgresMigration.migrations = PostgresMigration.migrations :+ SqlMigration(1)(List(
        sqlu"""create schema if not exists "bigd_ev";"""
  ))
}




