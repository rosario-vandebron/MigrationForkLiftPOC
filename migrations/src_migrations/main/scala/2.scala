import slick.jdbc.PostgresProfile.api._
import com.liyaos.forklift.slick.SqlMigration

object M2 {
  MyMigrations.migrations = MyMigrations.migrations :+ SqlMigration(2)(List(
    sqlu"""ALTER TABLE accounts ADD COLUMN test2 VARCHAR""" // your sql code goes here
  ))
}
