import com.liyaos.forklift.slick.SlickMigrationManager
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

trait PostgresMigrationManager extends SlickMigrationManager {
  override lazy val dbConfig = DatabaseConfig.forConfig[JdbcProfile]("migration")
}
