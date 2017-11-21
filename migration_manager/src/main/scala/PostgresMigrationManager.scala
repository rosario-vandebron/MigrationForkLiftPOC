import com.liyaos.forklift.slick.SlickMigrationManager
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.concurrent.Await
import scala.concurrent.duration._

trait PostgresMigrationManager extends SlickMigrationManager {
  override lazy val dbConfig = DatabaseConfig.forConfig[JdbcProfile]("migration")

  override def reset = {

    //TODO cannot be run in production

    import slick.jdbc.PostgresProfile.api._

    val dropSchemaAction = sqlu"""drop schema if exists "bigd_ev" cascade;"""
    val deleteInit = sqlu"""drop table __migrations__ ;"""

    try{
      val f = db.run(dropSchemaAction.andThen(deleteInit))
      Await.result(f, Duration.Inf)

    }finally {
      db.close()
    }

  }
}
